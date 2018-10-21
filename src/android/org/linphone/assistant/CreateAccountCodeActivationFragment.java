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
import org.linphone.core.LinphoneAccountCreator;
import org.linphone.core.LinphoneAccountCreator.LinphoneAccountCreatorListener;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.utils.AppKeyHelper;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccountCodeActivationFragment extends Fragment implements LinphoneAccountCreatorListener {
	private String username, phone, dialcode;
	private TextView title, phonenumber;
	private EditText code;
	private boolean recoverAccount = false, linkAccount = false;
	private int code_length;
	private ImageView back;
	private Button checkAccount;
	private LinphoneAccountCreator accountCreator;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.assistant_account_creation_code_activation, container, false);

		username = getArguments().getString(AppKeyHelper.KEY_USERNAME);
		phone = getArguments().getString(AppKeyHelper.KEY_PHONE);
		dialcode = getArguments().getString(AppKeyHelper.KEY_DIALCODE);
		recoverAccount = getArguments().getBoolean(AppKeyHelper.KEY_RECOVER_ACCOUNT);
		linkAccount = getArguments().getBoolean(AppKeyHelper.KEY_LINK_ACCOUNT);

		code_length = LinphonePreferences.instance().getCodeLength();
		accountCreator = LinphoneCoreFactory.instance().createAccountCreator(LinphoneManager.getLc(), LinphonePreferences.instance().getXmlrpcUrl());
		accountCreator.setListener(this);
		accountCreator.setUsername(username);
		accountCreator.setPhoneNumber(phone, dialcode);

		back = (ImageView) view.findViewById(R.id.back);
		if (back != null)
			back.setVisibility(Button.INVISIBLE);

		title = (TextView) view.findViewById(R.id.title_account_activation);
		if (linkAccount) {
			title.setText(getString(R.string.assistant_link_account));
		} else if (recoverAccount) {
			title.setText(getString(R.string.assistant_linphone_account));
		}

		phonenumber = (TextView) view.findViewById(R.id.send_phone_number);
		phonenumber.setText(accountCreator.getPhoneNumber());

		code = (EditText) view.findViewById(R.id.assistant_code);
		code.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {}

			@Override
			public void afterTextChanged(Editable s) {
				if(s.length() == code_length){
					checkAccount.setEnabled(true);
				} else {
					checkAccount.setEnabled(false);
				}
			}
		});

		checkAccount = (Button) view.findViewById(R.id.assistant_check);
		checkAccount.setEnabled(false);
		checkAccount.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				checkAccount.setEnabled(false);
				accountCreator.setActivationCode(code.getText().toString());
				if(linkAccount){
					linkAccount();
				} else {
					activateAccount();
				}
			}
		});


		return view;
	}

	private void linkAccount(){
		accountCreator.setUsername(LinphonePreferences.instance().getAccountUsername(LinphonePreferences.instance().getDefaultAccountIndex()));
		accountCreator.setHa1(LinphonePreferences.instance().getAccountHa1(LinphonePreferences.instance().getDefaultAccountIndex()));
		accountCreator.activatePhoneNumberLink();
	}

	private void activateAccount() {
		if(accountCreator.getUsername() == null){
			accountCreator.setUsername(accountCreator.getPhoneNumber());
		}
		accountCreator.activateAccount();
	}

	@Override
	public void onAccountCreatorIsAccountUsed(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
	}

	@Override
	public void onAccountCreatorAccountCreated(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
	}

	@Override
	public void onAccountCreatorAccountActivated(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
		if (AssistantActivity.instance() == null) {
			return;
		}
		if (status.equals(LinphoneAccountCreator.RequestStatus.AccountActivated)) {
			checkAccount.setEnabled(true);
			if (accountCreator.getUsername() != null) {
				AssistantActivity.instance().linphoneLogIn(accountCreator);
				if(!recoverAccount){
					AssistantActivity.instance().isAccountVerified(accountCreator.getUsername());
				} else {
					AssistantActivity.instance().success();
				}
			} else {
				AssistantActivity.instance().linphoneLogIn(accountCreator);
				if(!recoverAccount) {
					AssistantActivity.instance().isAccountVerified(accountCreator.getPhoneNumber());
				} else {
					AssistantActivity.instance().success();
				}
			}
		} else if (status.equals(LinphoneAccountCreator.RequestStatus.Failed)) {
			Toast.makeText(getActivity(), getString(R.string.wizard_server_unavailable), Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getActivity(), getString(R.string.assistant_error_confirmation_code), Toast.LENGTH_LONG).show();
			AssistantActivity.instance().displayAssistantLinphoneLogin(phone, dialcode);
		}
	}

	@Override
	public void onAccountCreatorAccountLinkedWithPhoneNumber(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {

	}

	@Override
	public void onAccountCreatorPhoneNumberLinkActivated(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {
		if (AssistantActivity.instance() == null) {
			return;
		}
		if(status.equals(LinphoneAccountCreator.RequestStatus.Ok)){
			LinphonePreferences.instance().setLinkPopupTime("");
			AssistantActivity.instance().hideKeyboard();
			AssistantActivity.instance().success();
		}
	}

	@Override
	public void onAccountCreatorIsAccountActivated(LinphoneAccountCreator accountCreator, LinphoneAccountCreator.RequestStatus status) {

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
