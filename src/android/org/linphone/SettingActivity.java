package org.linphone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.linphone.Preferences.Preferences;
import org.linphone.assistant.AssistantActivity;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.mediastream.Log;
import org.linphone.utils.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bitmanagers.BitVaultWalletManager;
import commons.SecureSDKException;
import iclasses.WalletArrayCallback;
import model.WalletDetails;
import qrcode.QRCodeManager;
import utils.SDKUtils;

/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/

public class SettingActivity extends Activity implements View.OnClickListener, WalletArrayCallback {
    private RelativeLayout mHeaderLeftIconRl;
    public static RelativeLayout loader_view;
    private TextView userAddressTv;
    private Spinner walletAddressSpinner;
    private TextView userStatusTv;
    private ImageView addressQrCode;
    private ArrayList<WalletDetails> mWalletList = new ArrayList<WalletDetails>();
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        initObjects();
        init();
        assignClick();
        generateQRCode();
        LinphoneProxyConfig proxy = LinphoneManager.getLc().getDefaultProxyConfig();
        setStatus(proxy.getState());
    }

    /***
     * Initialize Objects of this class
     */
    private void initObjects() {
    }

    /*****************************************************************
     * Function Name -init
     * Description - this function initialize the views which are included in this layout
     ******************************************************************/
    private void init() {
        mWalletList = new ArrayList<WalletDetails>();
        mHeaderLeftIconRl = (RelativeLayout) findViewById(R.id.mHeaderLeftIconRl);
        loader_view = (RelativeLayout) findViewById(R.id.loader_view);
        userAddressTv = (TextView) findViewById(R.id.userAddressTv);
        userStatusTv = (TextView) findViewById(R.id.userStatusTv);
        walletAddressSpinner = (Spinner) findViewById(R.id.walletAddressSpinner);
        addressQrCode = (ImageView) findViewById(R.id.addressQrCode);

        if (Preferences.getInstance(this).getWalletAddress() != null)
            userAddressTv.setText(Preferences.getInstance(this).getWalletAddress());
    }

    /*********************************************************
     * @Method Name: assignClick
     * @Description: This method is used to assign the reference to
     * the user clicks
     ***********************************************************/
    private void assignClick() {
        mHeaderLeftIconRl.setOnClickListener(this);
        addressQrCode.setOnClickListener(this);
        walletAddressSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                loader_view.setVisibility(View.VISIBLE);
                i = i + 1;
                if (i > 1) {
                    SDKUtils.showLog(SettingActivity.class.getSimpleName(), "++ position " + position);
                    SDKUtils.showLog(SettingActivity.class.getSimpleName(), "++ i " + i);
                    Preferences.getInstance(SettingActivity.this).setWalletAddress(mWalletList.get(walletAddressSpinner.getSelectedItemPosition()).getmKeyPair().address);
                    Preferences.getInstance(SettingActivity.this).setTransactionWalletAddress(mWalletList.get(walletAddressSpinner.getSelectedItemPosition()).getmKeyPair().address);
                    Preferences.getInstance(SettingActivity.this).setWalletPosition(walletAddressSpinner.getSelectedItemPosition());
                    startActivity(new Intent().setClass(SettingActivity.this, AssistantActivity.class));
                    finish();
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    /**
     * setStatus method is setting the registration state
     *
     * @param state
     */
    private void setStatus(LinphoneCore.RegistrationState state) {
        try {
            if (state == LinphoneCore.RegistrationState.RegistrationOk) {
                userStatusTv.setText(getResources().getString(R.string.online));
                userStatusTv.setTextColor(getResources().getColor(R.color.colorL));
            } else if (state == LinphoneCore.RegistrationState.RegistrationProgress) {
                userStatusTv.setText(getResources().getString(R.string.in_progress));
                userStatusTv.setTextColor(getResources().getColor(R.color.yellow));
            } else if (state == LinphoneCore.RegistrationState.RegistrationFailed) {
                userStatusTv.setText(getResources().getString(R.string.offline));
                userStatusTv.setTextColor(getResources().getColor(R.color.red));
            } else {
                userStatusTv.setText(getResources().getString(R.string.offline));
                userStatusTv.setTextColor(getResources().getColor(R.color.red));
            }
        } catch (Exception e) {
            Log.e(e);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mHeaderLeftIconRl:
                finish();
                break;
            case R.id.addressQrCode:
                Intent intent=new Intent(SettingActivity.this,ScanLargeQRCodeActivity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
          /*Call get wallet form Secure SDK*/
        if (BitVaultWalletManager.getWalletInstance() != null) {
            try {
                BitVaultWalletManager.getWalletInstance().getWallets(this);
            } catch (SecureSDKException e) {
                e.printStackTrace();
            }
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
        if (mRequestedWallets != null)
            for (int i = 0; i < mRequestedWallets.size(); i++) {
                SDKUtils.showLog("Debug", "----mRequestedWallets-----" + mRequestedWallets.get(i).getWALLET_LAST_UPDATE_BALANCE());
                contactTypeList.add(mRequestedWallets.get(i).getWALLET_NAME() + " " + "-" + " " + convertDecimalFormatPattern(Double.valueOf(mRequestedWallets.get(i).getWALLET_LAST_UPDATE_BALANCE())) + " " + getString(R.string.btc));
            }
        ArrayAdapter<String> spinnerOwnerType = new ArrayAdapter<String>(this, R.layout.spinner_item_row, contactTypeList);
        spinnerOwnerType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        walletAddressSpinner.setAdapter(spinnerOwnerType);
        /*Check for show the selected wallet initially*/
        if (mRequestedWallets != null) {
            for (int i = 0; i < mRequestedWallets.size(); i++) {
                if (mRequestedWallets.get(i).getmKeyPair().address.equals(Preferences.getInstance(this).getWalletAddress())) {
                    walletAddressSpinner.setSelection(i);
                }
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        i=0;
    }

    @Override
    public void getWallets(ArrayList<WalletDetails> mRequestedWallets) {
        addWalletData(mRequestedWallets);
    }

    /**
     * generateQRCode method for generate QR code of transaction id
     */
    public void generateQRCode() {
        Bitmap bitmap = new QRCodeManager().showQRCodePopupForAddress(Preferences.getInstance(this).getWalletAddress());
        if (addressQrCode != null && bitmap != null) {
            addressQrCode.setImageBitmap(bitmap);
        }
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
