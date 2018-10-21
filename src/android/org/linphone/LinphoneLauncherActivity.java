/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/
package org.linphone;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.linphone.utils.AppKeyHelper;
import org.linphone.Preferences.Preferences;
import org.linphone.assistant.RemoteProvisioningActivity;
import org.linphone.mediastream.Version;

import commons.GlobalKeys;
import utils.SDKUtils;

import static android.content.Intent.ACTION_MAIN;


public class LinphoneLauncherActivity extends Activity {

    private Handler mHandler;
    private ServiceWaitThread mServiceThread;
    private ProgressBar pb;
    private TextView loadingTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getBoolean(R.bool.orientation_portrait_only)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        setContentView(R.layout.launch_screen);
        init();

    }

    public void init() {
        pb = (ProgressBar) findViewById(R.id.progress_bar);
        loadingTV = (TextView) findViewById(R.id.loading_tv);
        mHandler = new Handler();

        if (SDKUtils.isNetworkAvailable(this)) {
            Preferences.getInstance(this).setWalletAddress(getIntent().getStringExtra("Phone"));
            Preferences.getInstance(this).setTransactionWalletAddress(getIntent().getStringExtra("Phone"));
            if (LinphoneService.isReady()) {
                onServiceReady();
            } else {
                // start linphone as background
                pb.setVisibility(View.VISIBLE);
                loadingTV.setVisibility(View.VISIBLE);
                startService(new Intent(ACTION_MAIN).setClass(this, LinphoneService.class));
                mServiceThread = new ServiceWaitThread();
                mServiceThread.start();
            }
        } else {
            pb.setVisibility(View.GONE);
            loadingTV.setVisibility(View.GONE);
            SDKUtils.showToast(this, this.getResources().getString(R.string.network_error));
            finish();
        }

    }

    protected void onServiceReady() {
        final Class<? extends Activity> classToStart;

            classToStart = LinphoneActivity.class;


        // We need LinphoneService to start bluetoothManager
        if (Version.sdkAboveOrEqual(Version.API11_HONEYCOMB_30)) {
            BluetoothManager.getInstance().initBluetooth();
        }

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent newIntent = new Intent(LinphoneLauncherActivity.this, classToStart);
                String msgShared = null;
                if (getIntent() != null) {
                    String action = getIntent().getAction();
                    String type = getIntent().getType();
                    newIntent.setData(getIntent().getData());
                    if (getIntent().getStringExtra(AppKeyHelper.KEY_CALLING_ADDRESS) != null && !getIntent().getStringExtra(AppKeyHelper.KEY_CALLING_ADDRESS).isEmpty()) {
                        newIntent.putExtra(AppKeyHelper.KEY_CALLING_ADDRESS, getIntent().getStringExtra(AppKeyHelper.KEY_CALLING_ADDRESS));
                    }
                    if (Intent.ACTION_SEND.equals(action) && type != null) {
                        if ("text/plain".equals(type) && getIntent().getStringExtra(Intent.EXTRA_TEXT) != null) {
                            msgShared = getIntent().getStringExtra(Intent.EXTRA_TEXT);
                            newIntent.putExtra(AppKeyHelper.KEY_MSG_SHARING, msgShared);
                        }
                    }
                }

                startActivity(newIntent);
                if (classToStart == LinphoneActivity.class && LinphoneActivity.isInstanciated() && msgShared != null) {
                    LinphoneActivity.instance().displayChat(null, msgShared);
                }
                finish();
            }
        }, 1000);
    }


    private class ServiceWaitThread extends Thread {
        public void run() {
            while (!LinphoneService.isReady()) {
                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException("waiting thread sleep() has been interrupted");
                }
            }
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onServiceReady();
                }
            });
            mServiceThread = null;
        }
    }
}


