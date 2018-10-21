package org.linphone.auth;

import android.content.Intent;
import android.os.Bundle;
import com.embedded.wallet.BitVaultActivity;
import org.linphone.LinphoneLauncherActivity;
import org.linphone.Preferences.Preferences;
import org.linphone.R;
import org.linphone.iclasses.ChoiceDialogClickListener;
import org.linphone.utils.AppKeyHelper;
import org.linphone.utils.Utils;
import org.linphone.wallet.SelectWallet;
import java.util.ArrayList;
import iclasses.UserAuthenticationCallback;
import iclasses.WalletArrayCallback;
import model.WalletDetails;
import utils.SDKUtils;

public class HomeActivity extends BitVaultActivity implements UserAuthenticationCallback, WalletArrayCallback {
    private String address = "";
    private String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent receivedIntent = getIntent();
        String receivedAction = receivedIntent.getAction();
        if (receivedIntent.getStringExtra(AppKeyHelper.KEY_CALLING_ADDRESS) != null) {
            address = receivedIntent.getStringExtra(AppKeyHelper.KEY_CALLING_ADDRESS);
        } else if (receivedAction.equals(Intent.ACTION_SEND)) {
            if (receivedIntent.getStringExtra(AppKeyHelper.KEY_CALLING_ADDRESS) != null) {
                address = receivedIntent.getStringExtra(AppKeyHelper.KEY_CALLING_ADDRESS);}
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        validateUser(this, this);
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
    public void onAuthenticationSuccess() {

       /*change the preference value*/
        if (Preferences.getInstance(this) != null) {

            if (!Preferences.getInstance(this).getWalletAddress().isEmpty()) {
                if (SDKUtils.isNetworkAvailable(this)) {
                    Intent intent = new Intent(HomeActivity.this, LinphoneLauncherActivity.class);
                    intent.putExtra(AppKeyHelper.KEY_PHONE, Preferences.getInstance(this).getWalletAddress());
                    intent.putExtra(AppKeyHelper.KEY_CALLING_ADDRESS, address);
                    startActivity(intent);
                    finish();
                } else {

                    SDKUtils.showToast(this, this.getResources().getString(R.string.network_error));

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

//    fetching wallets from Db

    @Override
    public void getWallets(ArrayList<WalletDetails> mRequestedWallets) {
        for (int i = 0; i < mRequestedWallets.size(); i++) {

            if (Preferences.getInstance(HomeActivity.this).getWalletAddress().equalsIgnoreCase(mRequestedWallets.get(i).getmKeyPair().address)) {

                Intent intent = new Intent(HomeActivity.this, LinphoneLauncherActivity.class);
                intent.putExtra(AppKeyHelper.KEY_PHONE, Preferences.getInstance(this).getWalletAddress());
                intent.putExtra(AppKeyHelper.KEY_CALLING_ADDRESS, address);
                startActivity(intent);

                finish();
                break;
            } else if (i == 4) {
                startActivity(new Intent(this, SelectWallet.class));
                finish();
            }

        }
    }
}
