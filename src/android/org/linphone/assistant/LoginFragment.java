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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.linphone.Preferences.Preferences;
import org.linphone.R;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneAddress.TransportType;
import org.linphone.iclasses.WebAPIResponseListener;
import org.linphone.register.RegisterAPI;
import org.linphone.utils.AppConstants;

import utils.SDKUtils;


public class LoginFragment extends Fragment implements OnClickListener, TextWatcher {
    private EditText login, password, domain;
    private RadioGroup transports;
    private Button apply;
    ProgressBar progressBar;
    TextView regProgressText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assistant_login, container, false);

        login = (EditText) view.findViewById(R.id.assistant_username);
        login.addTextChangedListener(this);
        transports = (RadioGroup) view.findViewById(R.id.assistant_transports);
        apply = (Button) view.findViewById(R.id.assistant_apply);
        progressBar=(ProgressBar) view.findViewById(R.id.progress_bar);
        regProgressText=(TextView) view.findViewById(R.id.reg_progress_text);
        apply.setEnabled(false);
        apply.setOnClickListener(this);

           if(SDKUtils.isNetworkAvailable(getContext()))
           {
               WebAPIResponseListener webAPIResponseListener=new WebAPIResponseListener() {
                   @Override
                   public void onSuccessOfResponse(String arguments) {
                       progressBar.setVisibility(View.GONE);
                       regProgressText.setVisibility(View.GONE);
                   }

                   @Override
                   public void onFailOfResponse(String arguments) {
                       Toast.makeText(getActivity(),getActivity().getResources().getString(R.string.network_error),Toast.LENGTH_SHORT).show();
                       progressBar.setVisibility(View.GONE);
                       regProgressText.setVisibility(View.GONE);
                       getActivity().finish();

                   }
               };
               progressBar.setVisibility(View.VISIBLE);
               regProgressText.setVisibility(View.VISIBLE);
               RegisterAPI registerAPI = new RegisterAPI();
               registerAPI.registerUserOnSip(getContext(),Preferences.getInstance(getActivity()).getWalletAddress(),webAPIResponseListener);
           }
           else{
               progressBar.setVisibility(View.GONE);
               regProgressText.setVisibility(View.GONE);
               getActivity().finish();
           }
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.assistant_apply) {
            if (login.getText() == null || login.length() == 0) /*|| password.getText() == null || password.length() == 0 || domain.getText() == null || domain.length() == 0*/ {
                Toast.makeText(getActivity(), getString(R.string.first_launch_no_login_password), Toast.LENGTH_LONG).show();
                return;
            }

            TransportType transport;
            if (transports.getCheckedRadioButtonId() == R.id.transport_udp) {
                transport = TransportType.LinphoneTransportUdp;

            } else {
                if (transports.getCheckedRadioButtonId() == R.id.transport_tcp) {
                    transport = TransportType.LinphoneTransportTcp;
                } else {
                    transport = TransportType.LinphoneTransportTls;
                }
            }

            AssistantActivity.instance().genericLogIn(login.getText().toString(), AppConstants.REGISTER_PASSWORD, null, AppConstants.REGISTER_IP, TransportType.LinphoneTransportTcp);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        apply.setEnabled(!login.getText().toString().isEmpty() );
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
