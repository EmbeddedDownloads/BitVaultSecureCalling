package org.linphone;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.linphone.appControl.ApplicationLifecycleHandler;
import org.linphone.core.LinphoneCore;
import org.linphone.mediastream.Log;
import org.linphone.ui.AddressAware;
import org.linphone.ui.AddressText;
import org.linphone.ui.CallButton;
import org.linphone.utils.AppConstants;
import org.linphone.utils.AppKeyHelper;
import org.linphone.utils.Utils;
import org.linphone.wallet.WalletInformation;

import qrcode.ScanQRCode;
import utils.SDKUtils;


public class DialerFragment extends Fragment implements OnClickListener, View.OnLongClickListener, View.OnTouchListener, View.OnFocusChangeListener {
    private String TAG = DialerFragment.class.getSimpleName();
    Activity mActivity;
    private static DialerFragment instance;
    private static boolean isCallTransferOngoing = false;
    private ListView contactsList;
    private AddressAware numpad;
    private AddressText mAddress;
    private CallButton mCall;
    private ImageView mAddContact;
    private Cursor searchCursor;
    private AlphabetIndexer indexer;
    private OnClickListener addContactListener, cancelListener, transferListener;
    private boolean shouldEmptyAddressField = true;
    private static final int REQUEST_SCAN_KEY = 0;
    private static final int RESULT_OK = -1;
    private static final int ADD_OK = 1;
    /**
     * EditText object reference of this xml views
     */
    private AddressText mPhoneNumberField;
    /**
     * Relative layout object reference of this xml views
     */
    private RelativeLayout  mQRButton = null, Adress_rl = null;
    private ImageView  mSecureConference, mBackBtn, softSecureCalling;
    View mView;
    private static final int DURATION = 50; // Vibrate duration
    private Vibrator mVibrator; // Vibration (haptic feedback) for dialer key presses.
    private RelativeLayout mAddContactRl;

    private String mUpper = "upper", mLower = "lower";
    private int w, mWindowWidth;
    public TextView mBSpace, mBack,  mNum;
    private RelativeLayout mChangeRl;
    private ImageView mBChange;
    private boolean isEdit = false, isEdit1 = false;
    private String sL[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
            "x", "y", "z", "ç", "à", "é", "è", "û", "î"};
    private String cL[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z", "ç", "à", "é", "è", "û", "î"};
    private String nS[] = {"!", ")", "'", "#", "3", "$", "%", "&", "8", "*",
            "?", "/", "+", "-", "9", "0", "1", "4", "@", "5", "7", "(", "2",
            "\"", "6", "_", "=", "]", "[", "<", ">", "|"};
    private TextView mB[] = new TextView[42];


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        SDKUtils.showErrorLog(TAG, "calling onCreateView function DialerFragment");
        mView = inflater.inflate(R.layout.fragment_dialpad, container, false);
        mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        Utils.hideDefaultKeyboard(mActivity);
        numpad = (AddressAware) mView.findViewById(R.id.numpad);
        if (numpad != null) {
            numpad.setAddressWidget(mAddress);
        }
        addContactListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                LinphoneActivity.instance().displayContactsForEdition(mAddress.getText().toString());
            }
        };
        cancelListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                LinphoneActivity.instance().resetClassicMenuLayoutAndGoBackToCallIfStillRunning();
            }
        };
        transferListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                LinphoneCore lc = LinphoneManager.getLc();
                if (lc.getCurrentCall() == null) {
                    return;
                }
                lc.transferCall(lc.getCurrentCall(), mAddress.getText().toString());
                isCallTransferOngoing = false;
                LinphoneActivity.instance().resetClassicMenuLayoutAndGoBackToCallIfStillRunning();
            }
        };

        resetLayout(isCallTransferOngoing);

        if (getArguments() != null) {
            shouldEmptyAddressField = false;
            String number = getArguments().getString("SipUri");
            String displayName = getArguments().getString("DisplayName");
            String photo = getArguments().getString("PhotoUri");
//			mAddress.setText(number);
            if (displayName != null) {
                mAddress.setDisplayedName(displayName);
            }
            if (photo != null) {
                mAddress.setPictureUri(Uri.parse(photo));
            }
        }

        instance = this;
        initializeViews();
        setKeys();
        setFrow();
        setSrow();
        setTrow();
        setForow();
        setClickListeners();
        addNumberFormatting();
        return mView;
    }


    /**
     * Initializes the views from XML
     */
    private void initializeViews() {
        mAddContactRl = (RelativeLayout) mView.findViewById(R.id.mAddContactRl);
        mPhoneNumberField = (AddressText) mView.findViewById(R.id.phone_number);
        mPhoneNumberField.setGravity(Gravity.CENTER);
        mPhoneNumberField.requestFocus();
        mPhoneNumberField.setTextIsSelectable(true);
        softSecureCalling = (ImageView) mView.findViewById(R.id.softSecureCalling);
        mSecureConference = (ImageView) mView.findViewById(R.id.mSecureConference);
        mBackBtn = (ImageView) mView.findViewById(R.id.mBackBtn);
        mBChange = (ImageView) mView.findViewById(R.id.xChange);
        mChangeRl= (RelativeLayout) mView.findViewById(R.id.mChangeRl);
        mBack = (TextView) mView.findViewById(R.id.xBack);
        mQRButton = (RelativeLayout) mView.findViewById(R.id.mQRButton);
        Adress_rl = (RelativeLayout) mView.findViewById(R.id.Adress_rl);
    }

    /**
     * Adds number formatting to the field
     */
    private void addNumberFormatting() {
        mPhoneNumberField.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    /**
     * Sets click listeners for the views
     */
    private void setClickListeners() {
      mAddContactRl.setOnClickListener(this);
        softSecureCalling.setOnClickListener(this);
        mSecureConference.setOnClickListener(this);
        mBackBtn.setOnClickListener(this);
        for (int i = 0; i < mB.length; i++)
            mB[i].setOnClickListener(this);
        mBack.setOnClickListener(this);
        mBack.setOnLongClickListener(this);
        mChangeRl.setOnClickListener(this);
        mQRButton.setOnClickListener(this);
        Adress_rl.setOnClickListener(this);

    }

    /*********************************************************
     * @Method Name: keyPressed
     * @Description: This method is used to get the  passed key event
     * from the .
     ***********************************************************/

    private void keyPressed(int keyCode) {
        KeyEvent event = new KeyEvent(KeyEvent.ACTION_DOWN, keyCode);
        mPhoneNumberField.onKeyDown(keyCode, event);
    }

    /**
     * Click handler for the views
     */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.mChangeRl) {

            if (mBChange.getTag().equals(mUpper)) {
                mBChange.setImageResource(R.drawable.small_char_icon);
                changeSmallLetters();
                changeSmallTags();
            } else if (mBChange.getTag().equals(mLower)) {
                mBChange.setImageResource(R.drawable.upper_char_icon1);
                changeCapitalLetters();
                changeCapitalTags();
            }
        } else {
            addText(view);
        }

        switch (view.getId()) {
            case R.id.softSecureCalling:
                if (mPhoneNumberField.getText().length() != 0) {
                    Intent intent = new Intent(getActivity(), WalletInformation.class);
                    intent.putExtra("Address", mPhoneNumberField.getText().toString());
                    intent.putExtra("DisplayName", mPhoneNumberField.getDisplayedName());
                    startActivity(intent);
                    mPhoneNumberField.setText("");
                }
                break;
            case R.id.mSecureConference:

                if (mPhoneNumberField.getText().length() != 0) {
                    Intent intent = new Intent(getActivity(), WalletInformation.class);
                    intent.putExtra("Address", mPhoneNumberField.getText().toString());
                    intent.putExtra("DisplayName", mPhoneNumberField.getDisplayedName());
                    startActivity(intent);
                    mPhoneNumberField.setText("");
                }
                break;
            case R.id.mBackBtn:

                LinphoneActivity.instance().resetClassicMenuLayoutAndGoBackToCallIfStillRunning();
                break;


            case R.id.xBack:
                mVibrator.vibrate(DURATION);
                keyPressed(KeyEvent.KEYCODE_DEL);
                break;

            case R.id.mQRButton:
                Utils.hideDefaultKeyboard(mActivity);
                LinphoneActivity.HideMenuSheet();
                startActivityForResult(new Intent(mActivity, ScanQRCode.class), REQUEST_SCAN_KEY);
                break;
            case R.id.Adress_rl:
                Utils.hideDefaultKeyboard(getActivity());
                break;
            case R.id.mAddContactRl:
                AppConstants.isContactUpdated = true;
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MAIN);
                intent.setComponent(new ComponentName(AppConstants.packageName, AppConstants.packageClass));
                try {
                    if (mPhoneNumberField.length() != 0) {
                        intent.putExtra(AppKeyHelper.KEY_CALLING_ADDRESS, mPhoneNumberField.getText().toString());
                    }
                    ApplicationLifecycleHandler.isInAddContact=false;
                    startActivityForResult(intent,ADD_OK);

                } catch (Exception e) {
                    Toast.makeText(getActivity(), "contact(s) app add activity not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(!ApplicationLifecycleHandler.isInAddContact)
            ApplicationLifecycleHandler.isInAddContact=true;

        if (resultCode == RESULT_OK) {

            String scannedResult = data.getStringExtra("data");

            mPhoneNumberField.setVisibility(View.VISIBLE);
            mPhoneNumberField.setText("");
            mPhoneNumberField.setText(scannedResult);
            mPhoneNumberField.setSelection(scannedResult.length());

        }

    }



    /**
     * @return null if not ready yet
     */

    public static DialerFragment instance() {
        return instance;
    }

    @Override
    public void onPause() {
        instance = null;
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        Utils.hideDefaultKeyboard(mActivity);
        Utils.keyboardDown(getActivity());
        instance = this;
        if (LinphoneActivity.isInstanciated()) {
            LinphoneActivity.instance().selectMenu(FragmentsAvailable.DIALER);
            LinphoneActivity.instance().updateDialerFragment(this);
            LinphoneActivity.instance().showStatusBar();
            LinphoneActivity.instance().hideTabBar(false);
        }

        LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
        if (lc == null) {
            return;
        }

        if (lc.getCallsNb() > 0) {
            softSecureCalling.setVisibility(View.GONE);
            mBackBtn.setVisibility(View.VISIBLE);
            mSecureConference.setVisibility(View.VISIBLE);
        } else {
            softSecureCalling.setVisibility(View.VISIBLE);
            mBackBtn.setVisibility(View.GONE);
            mSecureConference.setVisibility(View.GONE);
        }

        boolean isOrientationLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }


    public void resetLayout(boolean callTransfer) {
        SDKUtils.showErrorLog("DEBUG LOGS", "resetLayout : " + callTransfer);
        if (!LinphoneActivity.isInstanciated()) {
            return;
        }
        isCallTransferOngoing = LinphoneActivity.instance().isCallTransfer();
        LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
        if (lc == null) {
            return;
        }

        if (lc.getCallsNb() > 0) {

            if (isCallTransferOngoing) {

                if (mPhoneNumberField.getText().length() != 0) {
                    Intent intent = new Intent(getActivity(), WalletInformation.class);
                    intent.putExtra("Address", mPhoneNumberField.getText().toString());
                    intent.putExtra("DisplayName", mPhoneNumberField.getDisplayedName());
                    startActivity(intent);
                    mPhoneNumberField.setText("");
                }


                mCall.setExternalClickListener(transferListener);
            }
        }
    }



    public void displayTextInAddressBar(String numberOrSipAddress) {
        shouldEmptyAddressField = false;
        mAddress.setText(numberOrSipAddress);
    }

    public void newOutgoingCall(String numberOrSipAddress) {
        displayTextInAddressBar(numberOrSipAddress);
        LinphoneManager.getInstance().newOutgoingCall(mAddress);
    }

    public void newOutgoingCall(Intent intent) {
        if (intent != null && intent.getData() != null) {
            String scheme = intent.getData().getScheme();
            if (scheme.startsWith("imto")) {
                mAddress.setText("sip:" + intent.getData().getLastPathSegment());
            } else if (scheme.startsWith("call") || scheme.startsWith("sip")) {
                mAddress.setText(intent.getData().getSchemeSpecificPart());
            } else {
                Uri contactUri = intent.getData();
                String address = ContactsManager.getAddressOrNumberForAndroidContact(LinphoneService.instance().getContentResolver(), contactUri);
                if (address != null) {
                    mAddress.setText(address);
                } else {
                    Log.e("Unknown scheme: ", scheme);
                    mAddress.setText(intent.getData().getSchemeSpecificPart());
                }
            }

            mAddress.clearDisplayedName();
            intent.setData(null);

            LinphoneManager.getInstance().newOutgoingCall(mAddress);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.deleteButton: {
                mVibrator.vibrate(DURATION);
                if (mPhoneNumberField.getText() != null)
                    mPhoneNumberField.getText().clear();

                return true;
            }
            case R.id.xBack:
                mVibrator.vibrate(DURATION);
                if (mPhoneNumberField.getText() != null)
                    mPhoneNumberField.getText().clear();

                return true;

           /* case R.id.zero: {
                mVibrator.vibrate(DURATION);
                keyPressed(KeyEvent.KEYCODE_PLUS);
                return true;
            }*/
        }
        return false;
    }

    private void setKeys() {
        mWindowWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth(); // getting
        // window
        // height
        // getting ids from xml files
        mB[0] = (TextView) mView.findViewById(R.id.xA);
        mB[1] = (TextView) mView.findViewById(R.id.xB);
        mB[2] = (TextView) mView.findViewById(R.id.xC);
        mB[3] = (TextView) mView.findViewById(R.id.xD);
        mB[4] = (TextView) mView.findViewById(R.id.xE);
        mB[5] = (TextView) mView.findViewById(R.id.xF);
        mB[6] = (TextView) mView.findViewById(R.id.xG);
        mB[7] = (TextView) mView.findViewById(R.id.xH);
        mB[8] = (TextView) mView.findViewById(R.id.xI);
        mB[9] = (TextView) mView.findViewById(R.id.xJ);
        mB[10] = (TextView) mView.findViewById(R.id.xK);
        mB[11] = (TextView) mView.findViewById(R.id.xL);
        mB[12] = (TextView) mView.findViewById(R.id.xM);
        mB[13] = (TextView) mView.findViewById(R.id.xN);
        mB[14] = (TextView) mView.findViewById(R.id.xO);
        mB[15] = (TextView) mView.findViewById(R.id.xP);
        mB[16] = (TextView) mView.findViewById(R.id.xQ);
        mB[17] = (TextView) mView.findViewById(R.id.xR);
        mB[18] = (TextView) mView.findViewById(R.id.xS);
        mB[19] = (TextView) mView.findViewById(R.id.xT);
        mB[20] = (TextView) mView.findViewById(R.id.xU);
        mB[21] = (TextView) mView.findViewById(R.id.xV);
        mB[22] = (TextView) mView.findViewById(R.id.xW);
        mB[23] = (TextView) mView.findViewById(R.id.xX);
        mB[24] = (TextView) mView.findViewById(R.id.xY);
        mB[25] = (TextView) mView.findViewById(R.id.xZ);
        mB[26] = (TextView) mView.findViewById(R.id.xS1);
        mB[27] = (TextView) mView.findViewById(R.id.xS2);
        mB[28] = (TextView) mView.findViewById(R.id.xS3);
        mB[29] = (TextView) mView.findViewById(R.id.xS4);
        mB[30] = (TextView) mView.findViewById(R.id.xS5);
        mB[31] = (TextView) mView.findViewById(R.id.xS6);

        mB[32] = (TextView) mView.findViewById(R.id.x1);
        mB[33] = (TextView) mView.findViewById(R.id.x2);
        mB[34] = (TextView) mView.findViewById(R.id.x3);
        mB[35] = (TextView) mView.findViewById(R.id.x4);
        mB[36] = (TextView) mView.findViewById(R.id.x5);
        mB[37] = (TextView) mView.findViewById(R.id.x6);
        mB[38] = (TextView) mView.findViewById(R.id.x7);
        mB[39] = (TextView) mView.findViewById(R.id.x8);
        mB[40] = (TextView) mView.findViewById(R.id.x9);
        mB[41] = (TextView) mView.findViewById(R.id.x0);


    }

    private void setFrow() {
        w = (mWindowWidth / 13);
        w = w - 15;
        mB[16].setWidth(w);
        mB[22].setWidth(w + 3);
        mB[4].setWidth(w);
        mB[17].setWidth(w);
        mB[19].setWidth(w);
        mB[24].setWidth(w);
        mB[20].setWidth(w);
        mB[8].setWidth(w);
        mB[14].setWidth(w);
        mB[15].setWidth(w);
        mB[16].setHeight(50);
        mB[22].setHeight(50);
        mB[4].setHeight(50);
        mB[17].setHeight(50);
        mB[19].setHeight(50);
        mB[24].setHeight(50);
        mB[20].setHeight(50);
        mB[8].setHeight(50);
        mB[14].setHeight(50);
        mB[15].setHeight(50);

    }

    private void setSrow() {
        w = (mWindowWidth / 10);
        mB[0].setWidth(w);
        mB[18].setWidth(w);
        mB[3].setWidth(w);
        mB[5].setWidth(w);
        mB[6].setWidth(w);
        mB[7].setWidth(w);
        mB[26].setWidth(w);
        mB[9].setWidth(w);
        mB[10].setWidth(w);
        mB[11].setWidth(w);
        mB[26].setWidth(w);

        mB[0].setHeight(50);
        mB[18].setHeight(50);
        mB[3].setHeight(50);
        mB[5].setHeight(50);
        mB[6].setHeight(50);
        mB[7].setHeight(50);
        mB[9].setHeight(50);
        mB[10].setHeight(50);
        mB[11].setHeight(50);
        mB[26].setHeight(50);
    }

    private void setTrow() {
        w = (mWindowWidth / 12);
        mB[25].setWidth(w);
        mB[23].setWidth(w);
        mB[2].setWidth(w);
        mB[21].setWidth(w);
        mB[1].setWidth(w);
        mB[13].setWidth(w);
        mB[12].setWidth(w);
        mB[27].setWidth(w);
        mB[28].setWidth(w);
        mBack.setWidth(w);

        mB[25].setHeight(50);
        mB[23].setHeight(50);
        mB[2].setHeight(50);
        mB[21].setHeight(50);
        mB[1].setHeight(50);
        mB[13].setHeight(50);
        mB[12].setHeight(50);
        mB[27].setHeight(50);
        mB[28].setHeight(50);
        mBack.setHeight(50);

    }

    private void setForow() {
        w = (mWindowWidth / 10);
        mB[29].setWidth(w);
        mB[29].setHeight(50);

        mB[30].setWidth(w);
        mB[30].setHeight(50);

        mB[31].setHeight(50);
        mB[31].setWidth(w);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return true;
    }

    /**
     * addText method for adding the text in edittext
     *
     * @param v
     */
    private void addText(View v) {
        String b = "";
        b = (String) v.getTag();
        if (b != null) {
            SDKUtils.showLog("DialerFragment", " b value" + b);
            // adding text in Edittext
            mPhoneNumberField.getText().insert(mPhoneNumberField.getSelectionStart(), b);
        }
    }

    /**
     * changeSmallLetters method for change character in small letter
     */
    private void changeSmallLetters() {
        mBChange.setVisibility(Button.VISIBLE);
        for (int i = 0; i < sL.length; i++)
            mB[i].setText(sL[i]);

    }

    /**
     * changeSmallTags for converting the text into small letter
     */
    private void changeSmallTags() {
        for (int i = 0; i < sL.length; i++)
            mB[i].setTag(sL[i]);
        mBChange.setTag("lower");

    }

    /**
     * changeCapitalLetters method for change character in capital letter
     */
    private void changeCapitalLetters() {
        mBChange.setVisibility(Button.VISIBLE);
        for (int i = 0; i < cL.length; i++)
            mB[i].setText(cL[i]);
        mBChange.setTag("upper");


    }

    /**
     * changeCapitalTagsags for converting the text into capital letter
     */
    private void changeCapitalTags() {
        for (int i = 0; i < cL.length; i++)
            mB[i].setTag(cL[i]);


    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v == mPhoneNumberField && hasFocus == true) {
            isEdit = true;
            isEdit1 = false;

        } else if (v == mPhoneNumberField && hasFocus == true) {
            isEdit = false;
            isEdit1 = true;

        }
    }
}
