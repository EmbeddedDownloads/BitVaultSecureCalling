package org.linphone.wallet;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import org.linphone.LinphoneManager;
import org.linphone.Preferences.Preferences;
import org.linphone.R;
import org.linphone.iclasses.HeaderViewClickListener;
import org.linphone.utils.AppKeyHelper;
import org.linphone.utils.HeaderViewManager;
import org.linphone.utils.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bitmanagers.BitVaultWalletManager;
import commons.GlobalKeys;
import commons.SecureSDKException;
import iclasses.TransactionBuilder;
import iclasses.WalletArrayCallback;
import model.WalletDetails;
import utils.SDKUtils;
import valle.btc.BTCUtils;


/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/
public class WalletInformation extends Activity implements View.OnClickListener, WalletArrayCallback, TransactionBuilder {
    private String TAG = WalletInformation.class.getSimpleName();
    /**
     * Activity instance
     */
    private Activity mActivity;
    /**
     * RelativeLayout layout objects of this class
     */
    private RelativeLayout next_button, loader_view;
    /**
     * Spinner object of the class
     */
    private Spinner wallet_type;
    /**
     * BitVaultWalletManager object reference of the class
     */
    private BitVaultWalletManager mBitVaultWalletManager = null;

    private String address = "", DisplayName = "";
    /**
     * ArrayList layout objects of this class
     */
    private ArrayList<WalletDetails> mWalletList = new ArrayList<WalletDetails>();

    private int i = 0;
    private String mPhotoUri="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walletinformation);
        initObjects();
        getIntentData();
        initializeView();
        manageHeader();
        assignclicks();
        SDKUtils.showLog(WalletInformation.class.getSimpleName(), "getCallTransactionStatus :" + Preferences.getInstance(WalletInformation.this).getCallTransactionStatus());
        if (Preferences.getInstance(WalletInformation.this).getCallTransactionStatus().equals("false")) {
            callChargesBitCoinTransaction();
        } else {
            loader_view.setVisibility(View.GONE);
        }

    }

    /***
     * Initialize Objects of this class
     */
    public void initObjects() {
        mBitVaultWalletManager = new BitVaultWalletManager();
    }

    /*****************************************************************
     * Function Name -getIntentData
     * Description - this function for getting the intent data
     ******************************************************************/
    private void getIntentData() {
        /*Check null pointer*/
        if (getIntent().hasExtra(AppKeyHelper.KEY_ADDRESS)) {
            address = getIntent().getStringExtra(AppKeyHelper.KEY_ADDRESS);
        }
        if(getIntent().hasExtra(AppKeyHelper.KEY_CALLING_ADDRESS))
        {
            address=getIntent().getStringExtra(AppKeyHelper.KEY_CALLING_ADDRESS);
        }
        /*Check null pointer*/
        if (getIntent().hasExtra(this.getResources().getString(R.string.intent_name))) {
            DisplayName = getIntent().getStringExtra(this.getResources().getString(R.string.intent_name));
            SDKUtils.showErrorLog(WalletInformation.class.getSimpleName(), "DisplayName--------" + DisplayName);
        }
        if(getIntent().hasExtra(AppKeyHelper.KEY_PHOTO_URI) && getIntent().getStringExtra(AppKeyHelper.KEY_PHOTO_URI)!=null)
        {
            mPhotoUri=getIntent().getStringExtra(AppKeyHelper.KEY_PHOTO_URI);
        }
    }

    @Override
    public void onBackPressed() {
        if(getIntent().hasExtra(AppKeyHelper.KEY_CALLING_ADDRESS)) {
            //backpress blocked
        }
        else{
            super.onBackPressed();
        }
    }

    /*****************************************************************
     * Function Name -initializeView
     * Description - this function initialize the views which are included in this layout
     ******************************************************************/
    private void initializeView() {
        mActivity = WalletInformation.this;
        next_button = (RelativeLayout) findViewById(R.id.next_button);
        loader_view = (RelativeLayout) findViewById(R.id.loader_view);
        loader_view.setClickable(true);
        wallet_type = (Spinner) findViewById(R.id.wallet_type);
        /*Call get wallet form Secure SDK*/
        if (mBitVaultWalletManager != null) {
            try {
                mBitVaultWalletManager.getWallets(this);
            } catch (SecureSDKException e) {
                e.printStackTrace();
            }
        }
    }

    /*****************************************************************
     * Function Name -manageHeader
     * Description - This manage the header of current Screen
     ******************************************************************/
    private void manageHeader() {
        HeaderViewManager.getInstance().InitializeHeaderView(mActivity, null, true, headerViewClickListener());
        HeaderViewManager.getInstance().setHeading(mActivity, true, getResources().getString(R.string.information));
        HeaderViewManager.getInstance().setLeftSideHeaderView(true, false, getString(R.string.back_icon), "");
        HeaderViewManager.getInstance().setRightSideHeaderView(false, false, 0, "");
    }

    /***********************************************************************
     * Function Name - headerViewClickListener
     * Description- This function will return the header views click listener
     *
     * @return HeaderViewClickListener
     ***********************************************************************/
    private HeaderViewClickListener headerViewClickListener() {
        HeaderViewClickListener mClickListener = new HeaderViewClickListener() {
            @Override
            public void onClickOfHeaderLeftView() {

                onBackPressed();
            }

            @Override
            public void onClickOfHeaderRightView() {
            }
        };
        return mClickListener;
    }

    /*****************************************************************
     * Function Name -assignclicks
     * Description - This Function is used to assign and manage clicks on the clickable view
     ******************************************************************/
    private void assignclicks() {
        next_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next_button:
                SDKUtils.showErrorLog(WalletInformation.class.getSimpleName(), "tap on next button");
                if (!convertDecimalFormatPattern(Double.valueOf(mWalletList.get(wallet_type.getSelectedItemPosition()).getWALLET_LAST_UPDATE_BALANCE())).equals("0")) {
                    Preferences.getInstance(WalletInformation.this).setTransactionWalletAddress(mWalletList.get(wallet_type.getSelectedItemPosition()).getmKeyPair().address);
                    Preferences.getInstance(WalletInformation.this).setWalletPosition(wallet_type.getSelectedItemPosition());
                    Preferences.getInstance(WalletInformation.this).setWalletName(mWalletList.get(wallet_type.getSelectedItemPosition()).getWALLET_NAME());

                    if(DisplayName==null || DisplayName.equalsIgnoreCase(""))
                    {
                        LinphoneManager.getInstance().newOutgoingCall(address, address,mPhotoUri);
                    }
                    else {
                        LinphoneManager.getInstance().newOutgoingCall(address, DisplayName,mPhotoUri);
                    }
                    finish();
                } else {
                    SDKUtils.showErrorLog(WalletInformation.class.getSimpleName(), "enter in else condition");
                    SDKUtils.showErrorLog(WalletInformation.class.getSimpleName(), "NULL");
                    Utils.showSnakbar(view, "Insufficient balance", Snackbar.LENGTH_SHORT);
                }
                break;
        }
    }

    /*********************************************************
     * @param mRequestedWallets
     * @Method Name: addWalletData
     * @Description: This method is used for set data in spinner
     ************************************************************/
    private void addWalletData(ArrayList<WalletDetails> mRequestedWallets) {
        mWalletList = mRequestedWallets;
        List<String> contactTypeList = new ArrayList<String>();
        /*Add item in wallet spinner list*/
        for (int i = 0; i < mRequestedWallets.size(); i++) {
            contactTypeList.add(mRequestedWallets.get(i).getWALLET_NAME() + " " + "-" + " " + convertDecimalFormatPattern(Double.valueOf(mRequestedWallets.get(i).getWALLET_LAST_UPDATE_BALANCE())) + " " + getString(R.string.btc));
        }
        ArrayAdapter<String> spinnerOwnerType = new ArrayAdapter<String>(this, R.layout.spinner_item_row, contactTypeList);
        spinnerOwnerType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wallet_type.setAdapter(spinnerOwnerType);
        /*Check for show the selected wallet initially*/
        for (int i = 0; i < mRequestedWallets.size(); i++) {
            if (mRequestedWallets.get(i).getmKeyPair().address.equals(Preferences.getInstance(mActivity).getTransactionWalletAddress())) {
                wallet_type.setSelection(i);
            }
        }
    }

    @Override
    public void getWallets(ArrayList<WalletDetails> mRequestedWallets) {
        addWalletData(mRequestedWallets);
    }

    /**
     * callChargesBitCoinTransaction method for deducting the charges of call
     */
    public void callChargesBitCoinTransaction() {
        Preferences.getInstance(WalletInformation.this).setCallTransactionStatus("false");
        i = i + 1;
        if (BitVaultWalletManager.getWalletInstance() != null) {
            SDKUtils.showLog("createBitCoinTransaction", " enter in createBitCoinTransaction function");
            BitVaultWalletManager.getWalletInstance().sendBitCoins(Preferences.getInstance(WalletInformation.this).getWalletPosition(), "msm2oDJp9fCezqg2xw3qTEFKaKZP3wszd6", BTCUtils.parseValue("0.0001"),
                    BTCUtils.parseValue("0.0001"), this);
        }
    }


    @Override
    public void RequestedTransaction(String mTransaction) {
        SDKUtils.showLog("RequestedTransaction________", "" + mTransaction);
    }

    @Override
    public void TransactionId(String mTxId) {
        SDKUtils.showLog("TransactionId_________", "" + mTxId);
        Preferences.getInstance(WalletInformation.this).setCallTransactionStatus("true");
        loader_view.setVisibility(View.GONE);

    }

    @Override
    public void TransactionFailed(String error) {
//        if (i == 3) {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    loader_view.setVisibility(View.GONE);
//                }
//            });
//        } else {
//            callChargesBitCoinTransaction();
//        }
        SDKUtils.showLog("TransactionFailed_____", "" + error);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loader_view.setVisibility(View.GONE);
            }
        });
    }

    /**
     * Creates a DecimalFormat using the given pattern and the symbols
     * for the default locale. This is a convenient way to obtain a
     * DecimalFormat when internationalization is not the main concern.
     *
     * @param value the value what we want to change
     * @return formatted string value
     */
    public static String convertDecimalFormatPattern(Double value) {
        DecimalFormat df = new DecimalFormat("#0.########");
        return df.format(value);
    }
}
