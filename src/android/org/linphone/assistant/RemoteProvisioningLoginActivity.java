package org.linphone.assistant;
/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/
import org.linphone.LinphoneManager;
import org.linphone.LinphonePreferences;
import org.linphone.R;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCoreListenerBase;
import org.linphone.utils.AppKeyHelper;
import org.linphone.xmlrpc.XmlRpcHelper;
import org.linphone.xmlrpc.XmlRpcListenerBase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RemoteProvisioningLoginActivity extends Activity implements OnClickListener {
	private EditText login, password, domain;
	private Button connect;
	private LinphoneCoreListenerBase mListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.assistant_remote_provisioning_login);
		
		login = (EditText) findViewById(R.id.assistant_username);
		password = (EditText) findViewById(R.id.assistant_password);
		domain = (EditText) findViewById(R.id.assistant_domain);

		connect = (Button) findViewById(R.id.assistant_connect);
		connect.setOnClickListener(this);

		String defaultDomain = getIntent().getStringExtra(AppKeyHelper.KEY_DOMAIN);
		if (defaultDomain != null) {
			domain.setText(defaultDomain);
			domain.setEnabled(false);
		}

		mListener = new LinphoneCoreListenerBase(){
			@Override
			public void configuringStatus(LinphoneCore lc, final LinphoneCore.RemoteProvisioningState state, String message) {
				if (state == LinphoneCore.RemoteProvisioningState.ConfiguringSuccessful) {
					//TODO
				} else if (state == LinphoneCore.RemoteProvisioningState.ConfiguringFailed) {
					Toast.makeText(RemoteProvisioningLoginActivity.this, R.string.remote_provisioning_failure, Toast.LENGTH_LONG).show();
				}
			}
		};
	}
	
	private void cancelWizard(boolean bypassCheck) {
		if (bypassCheck || getResources().getBoolean(R.bool.allow_cancel_remote_provisioning_login_activity)) {
			LinphonePreferences.instance().disableProvisioningLoginView();
			setResult(bypassCheck ? Activity.RESULT_OK : Activity.RESULT_CANCELED);
			finish();
		}
	}
	
	private boolean storeAccount(String username, String password, String domain) {
		XmlRpcHelper xmlRpcHelper = new XmlRpcHelper();
		xmlRpcHelper.getRemoteProvisioningFilenameAsync(new XmlRpcListenerBase() {
			@Override
			public void onRemoteProvisioningFilenameSent(String result) {
				LinphonePreferences.instance().setRemoteProvisioningUrl(result);
				LinphoneManager.getInstance().restartLinphoneCore();
			}
		}, username.toString(), password.toString(), domain.toString());

		LinphonePreferences.instance().firstLaunchSuccessful();
		setResult(Activity.RESULT_OK);
		finish();
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
		if (lc != null) {
			lc.addListener(mListener);
		}
	}

	@Override
	protected void onPause() {
		LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
		if (lc != null) {
			lc.removeListener(mListener);
		}
		super.onPause();
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		
		if (id == R.id.cancel) {
			cancelWizard(false);
		}
		if (id == R.id.assistant_connect){
			storeAccount(login.getText().toString(), password.getText().toString(), domain.getText().toString());
		}
	}

	@Override
	public void onBackPressed() {
		cancelWizard(false);
	}
}
