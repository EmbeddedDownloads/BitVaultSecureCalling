package org.linphone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.linphone.core.LinphoneCoreListenerBase;
import org.linphone.ui.AddressText;
import org.linphone.utils.AppKeyHelper;

import commons.GlobalKeys;

/**
 * Created by vvdn on 10/31/2017.
 */

public class DirectCallActivity extends AppCompatActivity {
    LinphoneCoreListenerBase mListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            LinphoneManager.AddressType addressType=new AddressText(this, null);
            addressType.setText(getIntent().getStringExtra(AppKeyHelper.KEY_CALLING_ADDRESS));
            LinphoneManager.getInstance().newOutgoingCall(addressType);
        finish();

        }
}
