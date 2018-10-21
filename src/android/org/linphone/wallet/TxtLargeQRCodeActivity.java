package org.linphone.wallet;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.linphone.R;

import qrcode.QRCodeManager;
import utils.SDKUtils;


/**
 *
 */

public class TxtLargeQRCodeActivity extends Activity implements View.OnClickListener{
    String TAG=TxtLargeQRCodeActivity.class.getSimpleName();
    private RelativeLayout mHeaderLeftIconRl;
    private ImageView addressQrCode;
    private String mTxtId="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.txt_largeqrcode);
        Bundle bundle=getIntent().getExtras();
        if(bundle == null) {
            mTxtId= null;
        } else{
            mTxtId=bundle.getString("txtID");
            SDKUtils.showErrorLog(TAG,"----mTxtId---"+mTxtId);
        }
        initObjects();
        init();
        assignClick();

        generateQRCode(mTxtId);

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

    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mHeaderLeftIconRl:
                finish();
                break;
    }


}
    /**
     * generateQRCode method for generate QR code of transaction id
     *
     * @param mTxId
     */
    public void generateQRCode(String mTxId) {
        Bitmap bitmap = new QRCodeManager().showQRCodePopupForAddress(mTxId);
        if (addressQrCode != null && bitmap != null) {
            addressQrCode.setImageBitmap(bitmap);
        }
    }
}
