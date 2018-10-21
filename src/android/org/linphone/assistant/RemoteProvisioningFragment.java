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

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class RemoteProvisioningFragment extends Fragment implements OnClickListener, TextWatcher{
	private EditText remoteProvisioningUrl;
	private Button apply;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.assistant_remote_provisioning, container, false);
		
		remoteProvisioningUrl = (EditText) view.findViewById(R.id.assistant_remote_provisioning_url);
		remoteProvisioningUrl.addTextChangedListener(this);
		apply = (Button) view.findViewById(R.id.assistant_apply);
		apply.setEnabled(false);
		apply.setOnClickListener(this);
		
		return view;
	}
	
	@Override
	public void onClick(View v) {
		int id = v.getId();
		
		if (id == R.id.assistant_apply) {
			String url = remoteProvisioningUrl.getText().toString();
			AssistantActivity.instance().displayRemoteProvisioningInProgressDialog();
			LinphonePreferences.instance().setRemoteProvisioningUrl(url);
			LinphoneManager.getInstance().restartLinphoneCore();
			AssistantActivity.instance().setLinphoneCoreListener();
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		apply.setEnabled(!remoteProvisioningUrl.getText().toString().isEmpty());
	}

	@Override
	public void afterTextChanged(Editable s) {

	}
}
