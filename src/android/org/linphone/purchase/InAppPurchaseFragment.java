package org.linphone.purchase;

import java.util.Locale;

import org.linphone.LinphoneManager;
import org.linphone.LinphonePreferences;
import org.linphone.R;
import org.linphone.core.LinphoneProxyConfig;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class InAppPurchaseFragment extends Fragment implements View.OnClickListener {
	private LinearLayout usernameLayout;
	private EditText username, email;
	private TextView errorMessage;

	private boolean usernameOk = false, emailOk = false;
	private String defaultUsername, defaultEmail;
	private Button buyItemButton, recoverAccountButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
						 Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);

		View view = inflater.inflate(R.layout.in_app_store, container, false);

		String id = getArguments().getString("item_id");
		Purchasable item = InAppPurchaseActivity.instance().getPurchasedItem(id);
		buyItemButton = (Button) view.findViewById(R.id.inapp_button);

		displayBuySubscriptionButton(item);

		defaultEmail = InAppPurchaseActivity.instance().getGmailAccount();
		defaultUsername = LinphonePreferences.instance().getAccountUsername(LinphonePreferences.instance().getDefaultAccountIndex());

		usernameLayout = (LinearLayout) view.findViewById(R.id.username_layout);
		username = (EditText) view.findViewById(R.id.username);
		if(!getResources().getBoolean(R.bool.hide_username_in_inapp)){
			usernameLayout.setVisibility(View.VISIBLE);
			username.setText(LinphonePreferences.instance().getAccountUsername(LinphonePreferences.instance().getDefaultAccountIndex()));

			addUsernameHandler(username, errorMessage);
		} else {
			if(defaultUsername != null){
				usernameLayout.setVisibility(View.GONE);
				usernameOk = true;
			}
		}

		email = (EditText) view.findViewById(R.id.email);
		if(defaultEmail != null){
			email.setText(defaultEmail);
			emailOk = true;
		}

		buyItemButton.setEnabled(emailOk && usernameOk);
		errorMessage = (TextView) view.findViewById(R.id.username_error);

		return view;
	}

	private void addUsernameHandler(final EditText field, final TextView errorMessage) {
		field.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {

			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			public void onTextChanged(CharSequence s, int start, int count, int after) {
				usernameOk = false;
				String username = s.toString();
				if (isUsernameCorrect(username)) {
					usernameOk = true;
					errorMessage.setText("");
				} else {
					errorMessage.setText(R.string.wizard_username_incorrect);
				}
				if (buyItemButton != null) buyItemButton.setEnabled(usernameOk);
				if (recoverAccountButton != null) recoverAccountButton.setEnabled(usernameOk);
			}
		});
	}

	private boolean isUsernameCorrect(String username) {
		LinphoneProxyConfig lpc = LinphoneManager.getLc().createProxyConfig();
		return lpc.isPhoneNumber(username);
	}

	private void displayBuySubscriptionButton(Purchasable item) {
		buyItemButton.setText("Buy account (" + item.getPrice() + ")");
		buyItemButton.setTag(item);
		buyItemButton.setOnClickListener(this);
		buyItemButton.setEnabled(usernameOk && emailOk);
	}

	@Override
	public void onClick(View v) {
		Purchasable item = (Purchasable) v.getTag();
		if (v.equals(recoverAccountButton)) {
			//TODO
		} else {
			InAppPurchaseActivity.instance().buyInapp(getUsername(), item);
		}
	}

	private String getUsername() {
		String username = this.username.getText().toString();
		LinphoneProxyConfig lpc = LinphoneManager.getLc().createProxyConfig();
		username = lpc.normalizePhoneNumber(username);
		return username.toLowerCase(Locale.getDefault());
	}
}