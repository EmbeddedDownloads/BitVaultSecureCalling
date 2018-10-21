package org.linphone.xmlrpc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.linphone.Preferences.Preferences;
import org.linphone.R;
import org.linphone.iclasses.HeaderViewClickListener;
import org.linphone.utils.HeaderViewManager;
import org.linphone.wallet.TxtLargeQRCodeActivity;

import bitmanagers.BitVaultWalletManager;
import commons.SecureSDKException;
import iclasses.TransactionBuilder;
import qrcode.QRCodeManager;
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
public class CallingStatus extends Activity implements TransactionBuilder {
    /**
     * Debugging TAG to debug this class
     */
    private String TAG = CallingStatus.class.getSimpleName();
    /**
     * Activity reference of this class to pass it to the other classes
     */
    private Activity mActivity;
    /**
     * RelativeLayout layout objects of this class
     */
    private RelativeLayout done_button = null, loader_view = null, tranx_fail_view = null;
    /**
     * TextView objects of this class
     */
    private TextView transaction_id_value, walletInfo, fail_done;
    /**
     * ImageView objects of this class
     */
    private ImageView transactionIdQrCode;
    private String txtId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callingstatus);
        SDKUtils.showLog("DEBUG_CALL_AMOUNT", "CallingStatus OnCreate");

        callChargesBitCoinTransaction();
        initializeView();
        manageHeader();
    }

    /*****************************************************************
     * Function Name -initializeView
     * Description - this function initialize the views which are included in this layout
     ******************************************************************/
    private void initializeView() {
        mActivity = this;
        done_button = (RelativeLayout) findViewById(R.id.done_button);
        loader_view = (RelativeLayout) findViewById(R.id.loader_view);
        loader_view.setClickable(true);
        tranx_fail_view = (RelativeLayout) findViewById(R.id.tranx_fail_view);
        fail_done = (TextView) findViewById(R.id.fail_done);
        transaction_id_value = (TextView) findViewById(R.id.transaction_id_value);
        walletInfo = (TextView) findViewById(R.id.walletInfo);
        transactionIdQrCode = (ImageView) findViewById(R.id.transactionIdQrCode);
        walletInfo.setText(Preferences.getInstance(mActivity).getWalletName());
        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallingStatus.this.finish();
            }
        });
        fail_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        transactionIdQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallingStatus.this, TxtLargeQRCodeActivity.class);
                intent.putExtra("txtID", txtId);
                startActivity(intent);
            }
        });
    }

    /*****************************************************************
     * Function Name -manageHeader
     * Description - This manage the header of current Screen
     ******************************************************************/
    private void manageHeader() {
        HeaderViewManager.getInstance().InitializeHeaderView(mActivity, null, true, headerViewClickListener());
        HeaderViewManager.getInstance().setHeading(mActivity, true, getResources().getString(R.string.status));
        HeaderViewManager.getInstance().setLeftSideHeaderView(false, false, "d", "");
        HeaderViewManager.getInstance().setRightSideHeaderView(false, false, 0, "");
    }

    /***********************************************************************
     * Function Name - headerViewClickListener
     * Description- This function will return the header views click listener
     *
     * @return HeaderViewClickListener type
     ***********************************************************************/
    private HeaderViewClickListener headerViewClickListener() {
        HeaderViewClickListener mClickListener = new HeaderViewClickListener() {
            @Override
            public void onClickOfHeaderLeftView() {
//                onBackPressed();
//                AppDialogUtlis.callDetailDialog(mActivity, saveDetailOnClickListener());

            }

            @Override
            public void onClickOfHeaderRightView() {
            }
        };
        return mClickListener;
    }

    /**
     * callChargesBitCoinTransaction method for deducting the charges of call
     */
    public void callChargesBitCoinTransaction() {
        String mAddress = "";
        SDKUtils.showLog(TAG, "callChargesBitCoinTransaction");
        SDKUtils.showLog(TAG, "getCallTransactionStatus :" + Preferences.getInstance(CallingStatus.this).getCallTransactionStatus());
        if (BitVaultWalletManager.getWalletInstance() != null) {
            SDKUtils.showLog("createBitCoinTransaction", " enter in createBitCoinTransaction function");
            try {
                mAddress = BitVaultWalletManager.getWalletInstance().getWalletAddress(2);
            } catch (SecureSDKException e) {
                e.printStackTrace();
            }
            SDKUtils.showLog(TAG, "------Wallet Address position--------" + Preferences.getInstance(CallingStatus.this).getWalletPosition());
            BitVaultWalletManager.getWalletInstance().sendBitCoins(Preferences.getInstance(CallingStatus.this).getWalletPosition(), mAddress, BTCUtils.parseValue("0.00001"),
                    BTCUtils.parseValue("0.0001"), this);
        }
    }

    @Override
    public void RequestedTransaction(String mTransaction) {

    }

    @Override
    public void TransactionId(String mTxId) {
        Preferences.getInstance(CallingStatus.this).setCallTransactionStatus("true");
        txtId = mTxId;
        if (mTxId != null)
            transaction_id_value.setText(mTxId);
        generateQRCode(mTxId);
        loader_view.setVisibility(View.GONE);
    }

    @Override
    public void TransactionFailed(String error) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Preferences.getInstance(CallingStatus.this).setCallTransactionStatus("false");
                tranx_fail_view.setVisibility(View.VISIBLE);
                loader_view.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    /**
     * generateQRCode method for generate QR code of transaction id
     *
     * @param mTxId
     */
    public void generateQRCode(String mTxId) {
        Bitmap bitmap = new QRCodeManager().showQRCodePopupForAddress(mTxId);
        if (transactionIdQrCode != null && bitmap != null) {
            transactionIdQrCode.setImageBitmap(bitmap);
        }
    }
}
