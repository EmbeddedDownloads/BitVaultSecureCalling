package org.linphone;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.linphone.Preferences.Preferences;

import java.util.ArrayList;

import iclasses.WalletArrayCallback;
import model.WalletDetails;
import qrcode.QRCodeManager;

/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/
public class ScanLargeQRCodeActivity extends Activity implements View.OnClickListener {
    private RelativeLayout mHeaderLeftIconRl;
    private ImageView addressQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_largeqrcode_activity);
        initObjects();
        init();
        assignClick();
        generateQRCode();

    }

    private void assignClick() {
        mHeaderLeftIconRl.setOnClickListener(this);
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

        mHeaderLeftIconRl = (RelativeLayout) findViewById(R.id.mHeaderLeftIconRl);

        addressQrCode = (ImageView) findViewById(R.id.addressQrCode);
        //  if (Preferences.getInstance(this).getWalletAddress() != null)
        // userAddressTv.setText(Preferences.getInstance(this).getWalletAddress());
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



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mHeaderLeftIconRl:
                finish();
                break;
        }


    }}

