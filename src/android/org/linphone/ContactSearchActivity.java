package org.linphone;

/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.linphone.adapter.ContactsSearchAdapter;
import org.linphone.contactsmanager.ContactManager;
import org.linphone.utils.AppConstants;
import org.linphone.utils.BitVaultFont;
import org.linphone.utils.Contacts;
import org.linphone.utils.PublicKey;
import org.linphone.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import utils.SDKUtils;

import static org.linphone.ContactsListFragment.DELETE_CONTACT_CODE;


@SuppressWarnings("JavaDoc")
public class ContactSearchActivity extends AppCompatActivity implements View.OnClickListener/*,OnContactsReadListener*/ {


    private EditText searchEdt;

    private ContactsSearchAdapter adapter;
    private List<Contacts> mainContactList = new ArrayList<Contacts>();
    private List<Contacts> tempContactsList = new ArrayList<Contacts>();
    private List<PublicKey> publicKeyList = new ArrayList<PublicKey>();
    private HashMap<String, String> mPublicKeyArrayList = new HashMap<String, String>();

    private ListView searchListView;
    private TextView nocontactTxt;
    public ProgressBar contactsInProgress;
    private String value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchListView = (ListView) findViewById(R.id.id_search_listview);
        searchEdt = (EditText) findViewById(R.id.id_search_edt);
        searchEdt.setClickable(false);
        nocontactTxt = (TextView) findViewById(R.id.nocontactsTxt);
        contactsInProgress = (ProgressBar) findViewById(R.id.contactsInProgress);
        contactsInProgress.getIndeterminateDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        mainContactList = AppConstants.mContactsList;
        BitVaultFont backTxt = (BitVaultFont) findViewById(R.id.id_search_back_txt);
        final BitVaultFont closeTxt = (BitVaultFont) findViewById(R.id.id_search_close_txt);
        backTxt.setOnClickListener(this);
        closeTxt.setOnClickListener(this);
        initializeChecker();
        contactsInProgress.setVisibility(View.VISIBLE);
        if (mainContactList != null && mainContactList.size() > 0) {
            contactsInProgress.setVisibility(View.GONE);
            tempContactsList.addAll(mainContactList);
            adapter = new ContactsSearchAdapter(this, tempContactsList);
            searchListView.setAdapter(adapter);
        } else {
            contactsInProgress.setVisibility(View.GONE);
            nocontactTxt.setVisibility(View.VISIBLE);
        }

        searchEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (searchEdt.getText().toString().length() > 0) {
                    value = (searchEdt.getText().toString()).replaceAll("\\s", "");
                    filterContact(value);

                    closeTxt.setVisibility(View.VISIBLE);
                } else {
                    if (mainContactList.size() == 0) {
                        nocontactTxt.setVisibility(View.VISIBLE);
                        contactsInProgress.setVisibility(View.GONE);
                        searchListView.setVisibility(View.GONE);
                    } else {
                        tempContactsList.clear();
                        tempContactsList.addAll(mainContactList);
                        adapter.notifyDataSetChanged();
                        nocontactTxt.setVisibility(View.GONE);
                        searchListView.setVisibility(View.VISIBLE);
                    }
                    closeTxt.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(ContactSearchActivity.this, ContactViewActivity.class);
                Contacts contacts = tempContactsList.get(i);
                intent.putExtra(getResources().getString(R.string.intent_name), contacts.getName());
                intent.putExtra(getResources().getString(R.string.intent_contact_id), contacts.getContactId());
                if (!(contacts.getPhotoUri() != null && contacts.getPhotoUri().length() > 0)) {
                    intent.putExtra(getResources().getString(R.string.intent_color), contacts.getColorPos());
                } else if (contacts.getPhotoUri() != null) {
                    intent.putExtra(getResources().getString(R.string.intent_image), contacts.getPhotoUri());
                } else {
                    intent.putExtra(getResources().getString(R.string.intent_color), contacts.getColorPos());
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivityForResult(intent, DELETE_CONTACT_CODE);
                finish();
            }
        });

    }


    private void initializeChecker() {
        Timer mTimer = new Timer();
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (AppConstants.mContactsList != null && !AppConstants.mContactsList.isEmpty()
                        && AppConstants.mContactsList.size() > 0) {
                    cancel();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            contactsInProgress.setVisibility(View.GONE);
                            nocontactTxt.setVisibility(View.GONE);
                            searchEdt.setClickable(true);
                        }
                    });

                }
            }
        }, 10, 500);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Utils.hideDefaultKeyboard(this);
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Search form list
     *
     * @param keyword
     */
    private void filterContact(String keyword) {
        if (keyword != null) {

            if (mainContactList.size() > 0 && !mainContactList.isEmpty()) {
                tempContactsList.clear();

                for (int i = 0; i < mainContactList.size(); i++) {

                    if (mainContactList.get(i).getName().toLowerCase().contains(keyword.toLowerCase().trim())) {
                        tempContactsList.add(mainContactList.get(i));
                    } else {

                        publicKeyList = (ContactManager.getKeyList(this, mainContactList.get(i).getContactId(), mainContactList.get(i).getName()));
                        for (int j = 0; j < publicKeyList.size(); j++) {
                            final PublicKey key = publicKeyList.get(j);
                           mPublicKeyArrayList.put(key.getPublicKey(), mainContactList.get(i).getName());

                            if (key.getPublicKey().toLowerCase().contains(keyword.toLowerCase().trim())) {
                                tempContactsList.add(mainContactList.get(i));
                                break;
                            }
                        }

                    }

                }


                if (tempContactsList.size() == 0) {
                    nocontactTxt.setVisibility(View.VISIBLE);
                    contactsInProgress.setVisibility(View.GONE);
                    searchListView.setVisibility(View.GONE);
                } else {
                    nocontactTxt.setVisibility(View.GONE);
                    searchListView.setVisibility(View.VISIBLE);
                }
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case DELETE_CONTACT_CODE:
                if (data != null) {
                    String id = data.getStringExtra(getResources().getString(R.string.intent_contact_id));
                    for (int i = 0; i < mainContactList.size(); i++) {
                        if (mainContactList.get(i).getContactId().equals(id)) {
                            mainContactList.remove(i);
                            tempContactsList.remove(i);
                            AppConstants.mContactsList.remove(i);
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
                break;
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_search_back_txt:

                hideDefaultKeyboard();
                break;

            case R.id.id_search_close_txt:
                searchEdt.setText("");
                if (mainContactList.size() == 0) {
                    nocontactTxt.setVisibility(View.VISIBLE);
                    contactsInProgress.setVisibility(View.GONE);
                    searchListView.setVisibility(View.GONE);
                } else {
                    adapter.addList(mainContactList);
                    nocontactTxt.setVisibility(View.GONE);
                    searchListView.setVisibility(View.VISIBLE);
                }
                findViewById(R.id.id_search_close_txt).setVisibility(View.GONE);
                break;
        }
    }


    private void hideDefaultKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isAcceptingText()) {
            Utils.keyboardDown(this);
            finish();
        } else {
            finish();
        }
    }


}
