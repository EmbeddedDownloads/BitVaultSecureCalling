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

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.linphone.LinphoneManager;
import org.linphone.LinphonePreferences;
import org.linphone.R;
import org.linphone.core.LinphoneAccountCreator;
import org.linphone.core.LinphoneAccountCreator.LinphoneAccountCreatorListener;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.utils.AppKeyHelper;

public class CreateAccountActivationFragment extends Fragment implements OnClickListener, LinphoneAccountCreatorListener {
	private String username, password;
	private Button checkAccount;
	private TextView email;
	private LinphoneAccountCreator accountCreator;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.assistant_account_creation_email_activation, container, false);
		accountCreator = LinphoneCoreFactory.instance().createAccountCreator(LinphoneManager.getLc()
				, LinphonePreferences.instance().getXmlrpcUrl());
		accountCreator.setListener(this);

		username = getArguments().getString(AppKeyHelper.KEY_USERNAME);
		password = getArguments().getString(AppKeyHelper.KEY_PASSWORD);

		accountCreator.setUsername(username);
		accountCreator.setPassword(password);

		email = (TextView) view.findViewById(R.id.send_email);
		email.setText(getArguments().getString(AppKeyHelper.KEY_EMAIL));

		checkAccount = (Button) view.findViewById(R.id.assistant_check);
		checkAccount.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id == R.id.assistant_check) {
			checkAccount.setEnabled(false);
			accountCreator.isAccountActivated();
		}
	}

	@Override
	public void onAccountCreatorIsAccountUsed(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
	}

	@Override
	public void onAccountCreatorAccountCreated(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
	}

	@Override
	public void onAccountCreatorAccountActivated(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
	}

	@Override
	public void onAccountCreatorAccountLinkedWithPhoneNumber(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
	}

	@Override
	public void onAccountCreatorPhoneNumberLinkActivated(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
	}

	@Override
	public void onAccountCreatorIsAccountActivated(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
		if (AssistantActivity.instance() == null) {
			return;
		}
		if (status.equals(LinphoneAccountCreator.RequestStatus.AccountNotActivated)) {
			Toast.makeText(getActivity(), getString(R.string.assistant_account_not_validated), Toast.LENGTH_LONG).show();
		} else if (status.equals(LinphoneAccountCreator.RequestStatus.AccountActivated)) {
			AssistantActivity.instance().linphoneLogIn(accountCreator);
			AssistantActivity.instance().isAccountVerified(username);
		} else {
			Toast.makeText(getActivity(), getString(R.string.wizard_server_unavailable), Toast.LENGTH_LONG).show();
		}
		checkAccount.setEnabled(true);
	}

	@Override
	public void onAccountCreatorPhoneAccountRecovered(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
	}

	@Override
	public void onAccountCreatorIsAccountLinked(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
	}

	@Override
	public void onAccountCreatorIsPhoneNumberUsed(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
	}

	@Override
	public void onAccountCreatorPasswordUpdated(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {

	}
}
