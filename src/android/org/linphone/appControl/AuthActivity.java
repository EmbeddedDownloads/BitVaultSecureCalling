package org.linphone.appControl;

import android.content.Intent;

import com.embedded.wallet.BitVaultActivity;

import org.linphone.LinphoneLauncherActivity;
import org.linphone.R;
import org.linphone.iclasses.ChoiceDialogClickListener;
import org.linphone.utils.AppKeyHelper;
import org.linphone.Preferences.Preferences;
import org.linphone.auth.HomeActivity;
import org.linphone.utils.Utils;
import org.linphone.wallet.SelectWallet;

import java.util.ArrayList;

import bitmanagers.BitVaultWalletManager;
import commons.SecureSDKException;
import iclasses.UserAuthenticationCallback;
import iclasses.WalletArrayCallback;
import model.WalletDetails;
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
public class AuthActivity extends BitVaultActivity implements UserAuthenticationCallback, WalletArrayCallback {
    String TAG=AuthActivity.class.getSimpleName();
    @Override
    public void onAuthenticationSuccess() {
        if(getIntent().getExtras()!=null)
        {
            if(getIntent().getStringExtra(AppKeyHelper.KEY_CURRENT_ACTIVITY).equalsIgnoreCase(HomeActivity.class.getSimpleName()))
            {
                if (Preferences.getInstance(this) != null) {

                    if (!Preferences.getInstance(this).getWalletAddress().equals("")) {

                        if (BitVaultWalletManager.getWalletInstance() != null) {
                            try {
                                BitVaultWalletManager.getWalletInstance().getWallets(this);
                            } catch (SecureSDKException e) {
                                e.printStackTrace();
                            }
                        }


                    } else {
                        startActivity(new Intent(this, SelectWallet.class));
                        finish();
                    }
                } else {
                    startActivity(new Intent(this, SelectWallet.class));
                    finish();
                }
            }
            else
            {
                finish();
            }
        }

        else{
            finish();
        }

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        manageChoiceDialog();
    }

    private void manageChoiceDialog() {
        ChoiceDialogClickListener mChoiceDialogClickListener = new ChoiceDialogClickListener() {

            @Override
            public void onClickOfPositive() {
                // TODO Auto-generated method stub
                finish();
            }

            @Override
            public void onClickOfNegative() {
                // TODO Auto-generated method stub

            }
        };
        Utils.showChoiceDialog(mActivity, getResources().getString(R.string.cancel),
                getResources().getString(R.string.yes), getResources().getString(R.string.no), mChoiceDialogClickListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        validateUser(this, this);
    }

    @Override
    public void getWallets(ArrayList<WalletDetails> mRequestedWallets) {
        for (int i=0;i<mRequestedWallets.size();i++){

            if(Preferences.getInstance(AuthActivity.this).getWalletAddress().equalsIgnoreCase(mRequestedWallets.get(i).getmKeyPair().address)){
                SDKUtils.showLog(TAG,mRequestedWallets.get(i).getmKeyPair().address+"pref wallet.."+ Preferences.getInstance(AuthActivity.this).getWalletAddress());

                Intent intent = new Intent(AuthActivity.this, LinphoneLauncherActivity.class);
                intent.putExtra(AppKeyHelper.KEY_PHONE, Preferences.getInstance(this).getWalletAddress());
                startActivity(intent);

                finish();
                break;
            }
            else if(i==4){
                startActivity(new Intent(this, SelectWallet.class));
                finish();
            }

        }
    }
}
