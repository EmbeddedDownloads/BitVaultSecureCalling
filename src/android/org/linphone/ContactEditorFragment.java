package org.linphone;
/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.ContactsContract.DisplayPhoto;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import org.linphone.controls.HeaderControl;
import org.linphone.iclasses.HeaderViewClickListener;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.Version;
import org.linphone.utils.BitVaultFont;
import org.linphone.utils.ContactModel;
import org.linphone.utils.PublicDataModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import qrcode.ScanQRCode;
import utils.SDKUtils;


public class ContactEditorFragment extends Activity implements HeaderViewClickListener, AdapterView.OnItemSelectedListener, OnClickListener {
    String TAG = ContactEditorFragment.class.getSimpleName();
    /**
     * Header view controller
     */
    private HeaderControl mHeaderControl = null;

    /**
     * Spinner object of the class
     */
    private Spinner contact_type, phone_type, email_type;
    /**
     * RelativeLayout layout objects of this class
     */
    RelativeLayout save_button;

    /**
     * RESULT_USER_IMG int object
     */
    private int RESULT_USER_IMG = 1;

    private View view;
    private ImageView cancel, deleteContact, ok;
    private ImageView addNumber, addSipAddress, contactPicture;
    private LinearLayout/* phoneNumbersSection,*/sipAddressesSection;
    private EditText phoneNumbersSection;
    private EditText publickeySelection;
    private Spinner phone_type_tile;
    private EditText firstName, lastName, organization;
    private LayoutInflater inflater;
    private RelativeLayout publicKeyBlock, mHeaderLeftIconRl, mBarCodeRL;
    private List<String> contactTypeList;
    private static final int ADD_PHOTO = 1337;
    private static final int PHOTO_SIZE = 128;
    private LinearLayout container, containerPublicKey;
    private boolean isNewContact;
    private LinphoneContact contact;
    private EditText phone_numbers_et;
    private List<LinphoneNumberOrAddress> numbersAndAddresses;
    private int firstSipAddressIndex = -1;
    private LinearLayout sipAddresses, numbers;
    private String newSipOrNumberToAdd;
    private Uri pickedPhotoForContactUri;
    private byte[] photoToAdd;
    private ArrayList<ContactModel> mAddViewDataList;
    private ArrayList<PublicDataModel> mAddViewPublicList;
    private TextWatcher textWatcherForPhoneNumber, textWatcherForPublicKey;
    private EditText publickeyTileEt;
    private RelativeLayout mQRCodeScannarView;
    private String address = "";
    private static final int REQUEST_SCAN_KEY = 0;
    private static final int RESULT_OK = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontact);

        initializeView();
        // manageHeaderOfScreen();
        addContactTypeData();
        addPhoneTypeData();
        assignClick();

        // Hack to display keyboard when touching focused edittext on Nexus One
        if (Version.sdkStrictlyBelow(Version.API11_HONEYCOMB_30)) {
            lastName.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    InputMethodManager imm = (InputMethodManager) LinphoneActivity.instance().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                }
            });
        }
        lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (lastName.getText().length() > 0 || firstName.getText().length() > 0) {
                    save_button.setEnabled(true);

                } else {
                    save_button.setEnabled(false);

                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (firstName.getText().length() > 0 || lastName.getText().length() > 0) {
                    //ok.setEnabled(true);
                    save_button.setEnabled(true);
                } else {
//					ok.setEnabled(false);
                    save_button.setEnabled(false);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        textWatcherForPhoneNumber = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                SDKUtils.showLog("ContactEditorFragment", "beforeTextChanged function ");

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SDKUtils.showLog("ContactEditorFragment", "onTextChanged count______ " + count);

               /* if (count == 0) {
                    SDKUtils.showLog("ContactEditorFragment","removeLastAddedView"+count);
                    removeLastAddedView();

                }*/

            }

            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();
                SDKUtils.showLog("ContactEditorFragment", "afterTextChanged function " + value.length());

                if (value.length() == 1) {
                    addView();
                /*} else if (value.length() == 0) {
                    SDKUtils.showLog("ContactEditorFragment","removeLastAddedView"+value.length());
                    removeLastAddedView();*/
                } else {
                    SDKUtils.showLog("ContactEditorFragment", "value.length() is not 0 or 1, value is:" + value.length());
                }
            }
        };

        phoneNumbersSection.addTextChangedListener(textWatcherForPhoneNumber);


        if (contact != null) {
            LinphoneUtils.setImagePictureFromUri(this, contactPicture, contact.getPhotoUri(), contact.getThumbnailUri());
        } else {
            contactPicture.setImageBitmap(ContactsManager.getInstance().getDefaultAvatarBitmap());
        }

        contactPicture.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImage();
                LinphoneActivity.instance().checkAndRequestCameraPermission();
            }
        });
        numbersAndAddresses = new ArrayList<LinphoneNumberOrAddress>();


        textWatcherForPublicKey = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();
                SDKUtils.showLog("ContactEditorFragment", "afterTextChanged function " + value.length());

                if (value.length() == 1) {
                    addViewDataInPublicKey();

                }

            }
        };
        publickeySelection.addTextChangedListener(textWatcherForPublicKey);

    }

    private void addViewDataInPublicKey() {
        LayoutInflater mlayoutInflater = (LayoutInflater)
                getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (mAddViewPublicList == null)
            mAddViewPublicList = new ArrayList<PublicDataModel>();
        PublicDataModel publicDataModel = new PublicDataModel();
        final View publicNewView = mlayoutInflater.inflate(R.layout.addpublickeytile, null);
        publicNewView.setId(View.generateViewId());
        publicDataModel.setPublicKeyEditNewRowView(publicNewView);


        SDKUtils.showLog("Contact ", "id  of newView added" + publicNewView.getId());
        publickeyTileEt = (EditText) publicNewView.findViewById(R.id.publickeyTileEt);
        publickeyTileEt.setId(View.generateViewId());
        publicDataModel.setNewPublicEt(publickeyTileEt);

        publickeyTileEt.addTextChangedListener(textWatcherForPublicKey);


        mQRCodeScannarView = (RelativeLayout) publicNewView.findViewById(R.id.mQRCodeScannarView);
        mQRCodeScannarView.setId(View.generateViewId());
        publicDataModel.setNewBarCodeScan(mQRCodeScannarView);

        final BitVaultFont cross_icon = (BitVaultFont) publicNewView.findViewById(R.id.cross_icon);

        cross_icon.setId(View.generateViewId());
        publicDataModel.setRemoveViewTv(cross_icon);

        mAddViewPublicList.add(publicDataModel);
        cross_icon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                removeViewPublicKey(v.getId());
            }
        });

        containerPublicKey.addView(publicNewView);
    }


    private void addView() {
        LayoutInflater layoutInflater =
                (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (mAddViewDataList == null) {
            mAddViewDataList = new ArrayList<ContactModel>();
        }
        ContactModel contactModel = new ContactModel();

        final View newView = layoutInflater.inflate(R.layout.add_more_phone_tile, null);
        newView.setId(View.generateViewId());
        contactModel.setContactEditNewRowView(newView);


        phone_numbers_et = (EditText) newView.findViewById(R.id.phone_numbers_et);
        phone_numbers_et.setId(View.generateViewId());
        contactModel.setNewPhoneEt(phone_numbers_et);
        phone_numbers_et.addTextChangedListener(textWatcherForPhoneNumber);
//        SDKUtils.showLog("Contact ", "id  of phone number" + phone_numbers_et.getId());

        phone_type_tile = (Spinner) newView.findViewById(R.id.phone_type_tile);
        phone_type_tile.setId(View.generateViewId());
        contactModel.setNewDataTypeSp(phone_type_tile);
        SDKUtils.showLog("Contact ", "id  of spinner number" + phone_type_tile.getId());


        final BitVaultFont cross_img = (BitVaultFont) newView.findViewById(R.id.cross_img);

        addPhoneTypeDataTile();
        cross_img.setId(View.generateViewId());
        contactModel.setRemoveViewTv(cross_img);
        SDKUtils.showLog("Contact ", "id  of remove view" + cross_img.getId());
        mAddViewDataList.add(contactModel);

        cross_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                removeView(v.getId());
            }
        });

        container.addView(newView);
    }


    private void removeView(int id) {
        if (mAddViewDataList != null && mAddViewDataList.size() > 0) {

            for (int i = 0; i < mAddViewDataList.size(); i++) {
                if (mAddViewDataList.get(i).getRemoveViewTv().getId() == id) {
                    container.removeView(mAddViewDataList.get(i).getContactEditNewRowView());
                    mAddViewDataList.remove(i);
                    break;
                }
            }
        }
    }

    private void removeViewPublicKey(int id) {
        if (mAddViewPublicList != null && mAddViewPublicList.size() > 0) {

            for (int i = 0; i < mAddViewPublicList.size(); i++) {
                if (mAddViewPublicList.get(i).getRemoveViewTv().getId() == id) {
                    containerPublicKey.removeView(mAddViewPublicList.get(i).getPublicKeyEditNewRowView());
                    mAddViewPublicList.remove(i);
                    break;
                }
            }
        }
    }

    private void removeLastAddedView() {
        SDKUtils.showLog("ContactEditorFragment", "removeLastAddedView() called");

        if (mAddViewDataList != null && mAddViewDataList.size() > 0) {
//                ((LinearLayout) newView.getParent()).removeView(newView);
            container.removeView(mAddViewDataList.get(mAddViewDataList.size() - 1).getContactEditNewRowView());
            mAddViewDataList.remove(mAddViewDataList.size() - 1);
        }
    }


    private void assignClick() {
        contact_type.setOnItemSelectedListener(this);
        mHeaderLeftIconRl.setOnClickListener(this);
        phoneNumbersSection.setOnClickListener(this);
        mBarCodeRL.setOnClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();

        if (LinphoneActivity.isInstanciated()) {
            LinphoneActivity.instance().hideTabBar(false);
        }

        // Force hide keyboard
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    public void onPause() {
        // Force hide keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = getCurrentFocus();
        if (imm != null && view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        super.onPause();
    }

    private void pickImage() {
        pickedPhotoForContactUri = null;
        final List<Intent> cameraIntents = new ArrayList<Intent>();
        final Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File(Environment.getExternalStorageDirectory(), getString(R.string.temp_photo_name));
        pickedPhotoForContactUri = Uri.fromFile(file);
        captureIntent.putExtra("outputX", PHOTO_SIZE);
        captureIntent.putExtra("outputY", PHOTO_SIZE);
        captureIntent.putExtra("aspectX", 0);
        captureIntent.putExtra("aspectY", 0);
        captureIntent.putExtra("scale", true);
        captureIntent.putExtra("return-data", false);
        captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, pickedPhotoForContactUri);
        cameraIntents.add(captureIntent);

        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);

        final Intent chooserIntent = Intent.createChooser(galleryIntent, getString(R.string.image_picker_title));
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, cameraIntents.toArray(new Parcelable[]{}));

        startActivityForResult(chooserIntent, ADD_PHOTO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_PHOTO && resultCode == Activity.RESULT_OK) {
            if (data != null && data.getExtras() != null && data.getExtras().get("data") != null) {
                Bitmap bm = (Bitmap) data.getExtras().get("data");
                editContactPicture(null, bm);
            } else if (data != null && data.getData() != null) {
                Uri selectedImageUri = data.getData();
                try {
                    Bitmap selectedImage = MediaStore.Images.Media.getBitmap(LinphoneManager.getInstance().getContext().getContentResolver(), selectedImageUri);
                    selectedImage = Bitmap.createScaledBitmap(selectedImage, PHOTO_SIZE, PHOTO_SIZE, false);
                    editContactPicture(null, selectedImage);
                } catch (IOException e) {
                    Log.e(e);
                }
            } else if (pickedPhotoForContactUri != null) {
                String filePath = pickedPhotoForContactUri.getPath();
                editContactPicture(filePath, null);
            } else {
                File file = new File(Environment.getExternalStorageDirectory(), getString(R.string.temp_photo_name));
                if (file.exists()) {
                    pickedPhotoForContactUri = Uri.fromFile(file);
                    String filePath = pickedPhotoForContactUri.getPath();
                    editContactPicture(filePath, null);
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

        SDKUtils.showLog("DialerFragment_", "-----onActivityResultcalled");
        if (resultCode == RESULT_OK) {

            String scannedResult = data.getStringExtra("data");
            SDKUtils.showLog("", "-----scannedResult---" + scannedResult);
            publickeySelection.setVisibility(View.VISIBLE);
            publickeySelection.setText("");
            publickeySelection.setText(scannedResult);

        }
    }

    private void editContactPicture(String filePath, Bitmap image) {
        if (image == null) {
            image = BitmapFactory.decodeFile(filePath);
        }

        Bitmap scaledPhoto;
        int size = getThumbnailSize();
        if (size > 0) {
            scaledPhoto = Bitmap.createScaledBitmap(image, size, size, false);
        } else {
            scaledPhoto = Bitmap.createBitmap(image);
        }
        image.recycle();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        scaledPhoto.compress(Bitmap.CompressFormat.PNG, 0, stream);
        contactPicture.setImageBitmap(scaledPhoto);
        photoToAdd = stream.toByteArray();
    }

    private int getThumbnailSize() {
        int value = -1;
        Cursor c = LinphoneActivity.instance().getContentResolver().query(DisplayPhoto.CONTENT_MAX_DIMENSIONS_URI, new String[]{DisplayPhoto.THUMBNAIL_MAX_DIM}, null, null, null);
        try {
            c.moveToFirst();
            value = c.getInt(0);
        } catch (Exception e) {
            Log.e(e);
        }
        return value;
    }


    private View displayNumberOrAddress(final LinearLayout controls, String numberOrAddress, boolean isSIP) {
        return displayNumberOrAddress(controls, numberOrAddress, isSIP, false);
    }

    @SuppressLint("InflateParams")
    private View displayNumberOrAddress(final LinearLayout controls, String numberOrAddress, boolean isSIP, boolean forceAddNumber) {
        String displayNumberOrAddress = numberOrAddress;
        if (isSIP) {
            if (firstSipAddressIndex == -1) {
                firstSipAddressIndex = controls.getChildCount();
            }
            displayNumberOrAddress = LinphoneUtils.getDisplayableUsernameFromAddress(numberOrAddress);
        }


        LinphoneNumberOrAddress tempNounoa;
        if (forceAddNumber) {
            tempNounoa = new LinphoneNumberOrAddress(null, isSIP);
        } else {
            if (isNewContact || newSipOrNumberToAdd != null) {
                tempNounoa = new LinphoneNumberOrAddress(numberOrAddress, isSIP);
            } else {
                tempNounoa = new LinphoneNumberOrAddress(null, isSIP, numberOrAddress);
            }
        }
        final LinphoneNumberOrAddress nounoa = tempNounoa;
        numbersAndAddresses.add(nounoa);

        final View view = inflater.inflate(R.layout.contact_edit_row, null);

        final EditText noa = (EditText) view.findViewById(R.id.numoraddr);
        if (!isSIP) {
            noa.setInputType(InputType.TYPE_CLASS_PHONE);
        }
        noa.setText(displayNumberOrAddress);
        noa.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                nounoa.setValue(noa.getText().toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        if (forceAddNumber) {
            nounoa.setValue(noa.getText().toString());
        }

        ImageView delete = (ImageView) view.findViewById(R.id.delete_field);
        if ((getResources().getBoolean(R.bool.allow_only_one_phone_number) && !isSIP) || (getResources().getBoolean(R.bool.allow_only_one_sip_address) && isSIP)) {
            delete.setVisibility(View.GONE);
        }
        delete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contact != null) {
                    contact.removeNumberOrAddress(nounoa);
                }
                numbersAndAddresses.remove(nounoa);
                view.setVisibility(View.GONE);

            }
        });
        return view;
    }

    @SuppressLint("InflateParams")
    private void addEmptyRowToAllowNewNumberOrAddress(final LinearLayout controls, final boolean isSip) {
        final View view = inflater.inflate(R.layout.contact_edit_row, null);
        final LinphoneNumberOrAddress nounoa = new LinphoneNumberOrAddress(null, isSip);

        final EditText noa = (EditText) view.findViewById(R.id.numoraddr);
        numbersAndAddresses.add(nounoa);
        noa.setHint(isSip ? getString(R.string.sip_address) : getString(R.string.phone_number));
        if (!isSip) {
            noa.setInputType(InputType.TYPE_CLASS_PHONE);
        }
        noa.requestFocus();
        noa.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                nounoa.setValue(noa.getText().toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        final ImageView delete = (ImageView) view.findViewById(R.id.delete_field);
        if ((getResources().getBoolean(R.bool.allow_only_one_phone_number) && !isSip) || (getResources().getBoolean(R.bool.allow_only_one_sip_address) && isSip)) {
            delete.setVisibility(View.GONE);
        }
        delete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersAndAddresses.remove(nounoa);
                view.setVisibility(View.GONE);
            }
        });

        controls.addView(view);
    }


    /*****************************************************************
     * Function Name -initializeView
     * Description - this function initialize the views which are included in this layout
     ******************************************************************/
    private void initializeView() {

        mBarCodeRL = (RelativeLayout) findViewById(R.id.mBarCodeRL);
        container = (LinearLayout) findViewById(R.id.container);
        containerPublicKey = (LinearLayout) findViewById(R.id.containerPublicKey);
        phoneNumbersSection = (EditText) findViewById(R.id.phone_numbers);
        publickeySelection = (EditText) findViewById(R.id.public_key);
        lastName = (EditText) findViewById(R.id.contactLastName);
        firstName = (EditText) findViewById(R.id.contactFirstName);
        contactPicture = (ImageView) findViewById(R.id.contact_picture);
        contact_type = (Spinner) findViewById(R.id.contact_type);
        phone_type = (Spinner) findViewById(R.id.phone_type);
        save_button = (RelativeLayout) findViewById(R.id.save_button);
        publicKeyBlock = (RelativeLayout) findViewById(R.id.publicKeyBlock);
        mHeaderLeftIconRl = (RelativeLayout) findViewById(R.id.mHeaderLeftIconRl);
    }


    /*********************************************************
     * @Method Name: addPhoneTypeData
     * @Description: This method is used for set data in spinner
     ***********************************************************/
    private void addPhoneTypeData() {
        List<String> contactTypeList = new ArrayList<String>();
        contactTypeList.add(getString(R.string.mobile));
        contactTypeList.add(getString(R.string.home));
        //  contactTypeList.add(getString(R.string.secure));
        ArrayAdapter<String> spinnerOwnerType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, contactTypeList);
        //ArrayAdapter<String> spinnerOwnerType = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, contactTypeList);
        spinnerOwnerType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phone_type.setAdapter(spinnerOwnerType);


    }

    /*********************************************************
     * @Method Name: addPhoneTypeData
     * @Description: This method is used for set data in spinner
     ***********************************************************/
    private void addPhoneTypeDataTile() {
        List<String> contactTypeList = new ArrayList<String>();
        contactTypeList.add(getString(R.string.mobile));
        contactTypeList.add(getString(R.string.home));
        //  contactTypeList.add(getString(R.string.secure));
        ArrayAdapter<String> spinnerOwnerType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, contactTypeList);
        //ArrayAdapter<String> spinnerOwnerType = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, contactTypeList);
        spinnerOwnerType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        phone_type_tile.setAdapter(spinnerOwnerType);


    }


    /*********************************************************
     * @Method Name: addContactTypeData
     * @Description: This method is used for set data in spinner
     ***********************************************************/
    private void addContactTypeData() {
        contactTypeList = new ArrayList<String>();
        contactTypeList.add(getString(R.string.secure_contact));
        contactTypeList.add(getString(R.string.contact));
        ArrayAdapter<String> spinnerOwnerType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, contactTypeList);
        spinnerOwnerType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        contact_type.setAdapter(spinnerOwnerType);
        //hideShowPrivateKey();

    }


    /**
     * @Method Name: hideShowPrivateKey
     * @Description: This method is used for visiblity for private key
     */
    private void hideShowPrivateKey() {

        if (publicKeyBlock.getVisibility() == View.VISIBLE) {
            publicKeyBlock.setVisibility(View.GONE);
        }

    }

    /*******************************************************************************
     * Function name - manageHeaderOfScreen
     * Description - manage header of this screen
     ******************************************************************************/
    public void manageHeaderOfScreen() {

        mHeaderControl = new HeaderControl(null, view, this);
        mHeaderControl.setCenterTextHeader(true, getResources().
                getString(R.string.newContact));
        mHeaderControl.setRightControlsOnHeader(false, false, 0, "");
        mHeaderControl.setLeftControlsOnHeader(true, false, 0, "");

    }


    @Override
    public void onClickOfHeaderLeftView() {

    }

    @Override
    public void onClickOfHeaderRightView() {

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
     /*  // String pos = contactTypeList.get(position);
        long pos=parent.getItemIdAtPosition(position);

        */

        String value = contact_type.getSelectedItem().toString();
        if (value.equals("Contact")) {
            hideShowPrivateKey();
        }

        // Toast.makeText(this, contact_type.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.i("pos______", "Nothing ");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.mHeaderLeftIconRl:
                onBackPressed();
                break;
            case R.id.mBarCodeRL:
                startActivityForResult(new Intent(this, ScanQRCode.class), REQUEST_SCAN_KEY);
                break;

        }
    }


}