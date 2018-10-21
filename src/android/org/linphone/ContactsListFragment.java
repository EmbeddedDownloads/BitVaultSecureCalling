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


import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dhruvvaishnav.sectionindexrecyclerviewlib.IndicatorScrollRecyclerView;

import org.linphone.appControl.ApplicationLifecycleHandler;
import org.linphone.adapter.ContactListAdapter;
import org.linphone.contactsmanager.ContactManager;
import org.linphone.contactsmanager.MyObserver;
import org.linphone.utils.AppConstants;
import org.linphone.utils.AppKeyHelper;
import org.linphone.utils.Contacts;
import org.linphone.utils.Utils;

import java.util.List;

import utils.SDKUtils;


public class ContactsListFragment extends Fragment implements OnClickListener, OnItemClickListener, ContactsUpdatedListener {
    public static final int DELETE_CONTACT_CODE = 201;
    public static final int ADD_PROFILE_CODE = 601;
    public static final int UPDATE_CONTACT_CODE = 401;
    public static final int ADD_CONTACT_CODE = 301;
    public static ContactsListFragment mContactsListFragmentInstance = null;
    String TAG = ContactsListFragment.class.getSimpleName();
    TextView contactsFetchTxt;
    ContactListAdapter contactListAdapter;
    IndicatorScrollRecyclerView recyclerView;
    MyObserver myObserver;
    private Activity mActivity;
    private TextView noSipContact;
    private ImageView allContacts, linphoneContacts, newContact, edit, selectAll, deselectAll, delete, cancel, add_contact;
    private LinearLayout myProfileLL;
    private String sipAddressToAdd;
    private String contactID;
    private ImageView clearSearchField;
    private EditText searchField;
    private ProgressBar contactsFetchInProgress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        View view = inflater.inflate(R.layout.contacts_list, container, false);
        mContactsListFragmentInstance = this;
        myObserver = new MyObserver(new Handler());
        getActivity().getApplicationContext().getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI,
                false,
                myObserver);

        if (getArguments() != null) {
            sipAddressToAdd = getArguments().getString(AppKeyHelper.KEY_SIP_ADDRESS);

        }

        recyclerView = (IndicatorScrollRecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        noSipContact = (TextView) view.findViewById(R.id.noSipContact);

        allContacts = (ImageView) view.findViewById(R.id.all_contacts);
        allContacts.setOnClickListener(this);

        linphoneContacts = (ImageView) view.findViewById(R.id.linphone_contacts);
        linphoneContacts.setOnClickListener(this);

        newContact = (ImageView) view.findViewById(R.id.newContact);
        newContact.setOnClickListener(this);
        newContact.setEnabled(LinphoneManager.getLc().getCallsNb() == 0);

        linphoneContacts.setEnabled(!allContacts.isEnabled());

        selectAll = (ImageView) view.findViewById(R.id.select_all);
        selectAll.setOnClickListener(this);

        deselectAll = (ImageView) view.findViewById(R.id.deselect_all);
        deselectAll.setOnClickListener(this);

        delete = (ImageView) view.findViewById(R.id.delete);
        delete.setOnClickListener(this);

        cancel = (ImageView) view.findViewById(R.id.cancel);
        cancel.setOnClickListener(this);

        edit = (ImageView) view.findViewById(R.id.edit);
        edit.setOnClickListener(this);

        add_contact = (ImageView) view.findViewById(R.id.add_contact);
        add_contact.setOnClickListener(this);

        clearSearchField = (ImageView) view.findViewById(R.id.clearSearchField);
        clearSearchField.setOnClickListener(this);

        myProfileLL = (LinearLayout) view.findViewById(R.id.myProfileLL);
        myProfileLL.setOnClickListener(this);

        searchField = (EditText) view.findViewById(R.id.searchField);

        contactsFetchInProgress = (ProgressBar) view.findViewById(R.id.contactsFetchInProgress);
        contactsFetchInProgress.setVisibility(View.VISIBLE);
        contactsFetchTxt = (TextView) view.findViewById(R.id.contactsFetchtxt);
        contactsFetchTxt.setVisibility(View.VISIBLE);
        //  loadProfile();
        if (AppConstants.mContactsList != null && AppConstants.mContactsList.size() > 0) {
            ContactsLoading(AppConstants.mContactsList);
        } else {
            new ContactManager(getActivity());
        }

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().getContentResolver().unregisterContentObserver(myObserver);
    }

    public void ContactsLoading(List<Contacts> mContacts) {
        if (!mContacts.isEmpty() && AppConstants.mContactsList.isEmpty()) {
            AppConstants.isAlreadyLoaded = true;
            hideProgressBar(mContacts);
        } else {
            hideProgressBar(mContacts);

        }
    }

    private void hideProgressBar(final List<Contacts> mContacts) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    contactsFetchTxt.setVisibility(View.GONE);
                    if (mContacts.isEmpty()) {
                        contactsFetchInProgress.setVisibility(View.GONE);


                        contactsFetchInProgress.setVisibility(View.VISIBLE);
                        contactsFetchTxt.setVisibility(View.VISIBLE);
                        contactListAdapter = new ContactListAdapter(getActivity(), ContactsListFragment.this, AppConstants.mContactsList);
                        recyclerView.setAdapter(contactListAdapter);
                        contactListAdapter.notifyDataSetChanged();
                    } else {
                        noSipContact.setVisibility(View.GONE);
                        lazyLoading(mContacts);
                    }

                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.newContact) {

            LinphoneActivity.instance().addContact(null, sipAddressToAdd);
        } else if (id == R.id.clearSearchField) {
            searchField.setText("");
        }
        if (id == R.id.add_contact) {

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            intent.setComponent(new ComponentName(AppConstants.packageName, AppConstants.packageClass));
            try {
                ApplicationLifecycleHandler.isInAddContact = false;
                startActivityForResult(intent, ADD_CONTACT_CODE);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }


    private void lazyLoading(List<Contacts> mList) {
        int mSizeOfList = mList.size();
        if (mSizeOfList != 0) {
            if (mSizeOfList > 0) {
                noSipContact.setVisibility(View.GONE);
                contactsFetchInProgress.setVisibility(View.GONE);
                contactsFetchTxt.setVisibility(View.GONE);
                noSipContact.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            } else {
                noSipContact.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                contactsFetchInProgress.setVisibility(View.GONE);


            }


            contactListAdapter = new ContactListAdapter(getActivity(), ContactsListFragment.this, AppConstants.mContactsList);
            recyclerView.setAdapter(contactListAdapter);
            contactListAdapter.notifyDataSetChanged();
            contactsFetchInProgress.setVisibility(View.GONE);
            contactsFetchTxt.setVisibility(View.GONE);
        }
    }

    /**
     * Update color code
     *
     * @param position
     * @param colorPos
     */
    public void updateList(int position, int colorPos) {
        if (AppConstants.mContactsList != null && AppConstants.mContactsList.size() > 0)
            AppConstants.mContactsList.get(position).setColorPos(colorPos);
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int i, long id) {
        if (AppConstants.mContactsList != null && !AppConstants.mContactsList.isEmpty()) {
            i = i - 1;
            Contacts contacts = AppConstants.mContactsList.get(i);
            Intent intent = new Intent(getActivity(), ContactViewActivity.class);
            intent.putExtra(getResources().getString(R.string.intent_contact_id), contacts.getContactId());
            intent.putExtra(getResources().getString(R.string.intent_name), contacts.getName());
            SDKUtils.showLog(TAG, contacts.getContactId());
            if (!(contacts.getPhotoUri() != null && contacts.getPhotoUri().length() > 0)) {
                intent.putExtra(getResources().getString(R.string.intent_color), contacts.getColorPos());
            } else if (contacts.getPhotoUri() != null) {
                intent.putExtra(getResources().getString(R.string.intent_image), contacts.getPhotoUri());
            } else {
                intent.putExtra(getResources().getString(R.string.intent_color), contacts.getColorPos());
            }
            startActivityForResult(intent, DELETE_CONTACT_CODE);

        }
    }


    @Override
    public void onResume() {
        super.onResume();
        if (AppConstants.isContactUpdated) {
            new ContactManager(getActivity());
            lazyLoading(AppConstants.mContactsList);
            AppConstants.isContactUpdated = false;
        }
        Utils.hideDefaultKeyboard(mActivity);
    }


    @Override
    public void onPause() {
        ContactsManager.removeContactsListener(this);
        super.onPause();
    }

    @Override
    public void onContactsUpdated() {
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (!ApplicationLifecycleHandler.isInAddContact)
            ApplicationLifecycleHandler.isInAddContact = true;
        String s = mActivity.getIntent().getStringExtra("201");

        switch (requestCode) {
            case DELETE_CONTACT_CODE:
                if (data != null) {
                    String id = data.getStringExtra(getResources().getString(R.string.intent_contact_id));
                    if (AppConstants.mContactsList != null && !AppConstants.mContactsList.isEmpty()) {
                        for (int i = 0; i < AppConstants.mContactsList.size(); i++) {
                            Contacts contacts = AppConstants.mContactsList.get(i);
                            if (contacts.getContactId().equals(id)) {
                                AppConstants.mContactsList.remove(i);

                                contactListAdapter = new ContactListAdapter(getActivity(), ContactsListFragment.this, AppConstants.mContactsList);
                                recyclerView.setAdapter(contactListAdapter);
                                contactListAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                }
                //   loadProfile();
                break;
            case ADD_CONTACT_CODE:

                if (data != null && data.hasExtra(getResources().getString(R.string.intent_code))) {
                    if (data.getIntExtra(getResources().getString(R.string.intent_code), 0) == ADD_PROFILE_CODE) {
                        //    loadProfile();
                        viewProfile();
                    } else if (data.getIntExtra(getResources().getString(R.string.intent_code), 0) == ADD_CONTACT_CODE) {
                        contactID = data.getStringExtra(getResources().getString(R.string.intent_contact_id));

                    } else if (data.getIntExtra(getResources().getString(R.string.intent_code), 0) == UPDATE_CONTACT_CODE) {
                        contactID = data.getStringExtra(getResources().getString(R.string.intent_contact_id));

                    }
                }
                break;
            default:
                if (data != null) {
                    contactID = data.getStringExtra(getResources().getString(R.string.intent_contact_id));
                }
                break;
        }
    }

    private void viewProfile() {
        Intent intent = new Intent(getActivity(), ContactViewActivity.class);
        intent.putExtra(AppKeyHelper.KEY_TITLE, getResources().getString(R.string.my_profile));
        startActivityForResult(intent, DELETE_CONTACT_CODE);
    }
}
