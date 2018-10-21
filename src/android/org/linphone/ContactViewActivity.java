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
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.linphone.appControl.ApplicationLifecycleHandler;
import org.linphone.adapter.PublicKeyViewAdapter;
import org.linphone.contactsmanager.ContactManager;
import org.linphone.iclasses.OnDeleteDialogListener;
import org.linphone.iclasses.OnProfileLoadListener;
import org.linphone.utils.AppConstants;
import org.linphone.utils.BitVaultFont;
import org.linphone.utils.ContactHelper;
import org.linphone.utils.Contacts;
import org.linphone.utils.ProfileLoader;
import org.linphone.utils.Utils;

import utils.SDKUtils;

import static org.linphone.ContactsListFragment.DELETE_CONTACT_CODE;
import static org.linphone.ContactsListFragment.UPDATE_CONTACT_CODE;


public class ContactViewActivity extends AppCompatActivity implements OnDeleteDialogListener,OnProfileLoadListener {

    private static final String TAG = ContactViewActivity.class.getCanonicalName();
    private ImageView contactImageView;
    private BitVaultFont contactTxt;
    private RecyclerView mobileRecyclerView;
    private RecyclerView publicKeyRecyclerView;
    private CollapsingToolbarLayout collapseLayout;
    private AppBarLayout layout;
    private Contacts contacts;
    public Activity mActivity;
    private String userName="";
    private String photoUri="";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mActivity=this;
        setContentView(R.layout.contact_view_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        contactImageView = (ImageView) findViewById(R.id.contactImg);
        contactTxt = (BitVaultFont) findViewById(R.id.contactTxt);
        mobileRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewMobile);
        publicKeyRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewPublicKey);
        mobileRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        publicKeyRecyclerView.setLayoutManager(new LinearLayoutManager (this,LinearLayoutManager.VERTICAL,false));

        collapseLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        layout = (AppBarLayout) findViewById(R.id.appBarLayout);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getDataFromIntent(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_action_edit_function:
                Intent launchIntent = this.getPackageManager().getLaunchIntentForPackage(AppConstants.packageName);
                String mContactID=contacts.getContactId();
                if (launchIntent != null) {
                    Intent intent = new Intent(getString(R.string.package_name));
                    intent.putExtra(getResources().getString(R.string.intent_contact_id),contacts.getContactId());
                    if(contacts.getPhotoUri()==null){
                        intent.putExtra(getResources().getString(R.string.intent_color),contacts.getColorPos());
                    }
                    if (getIntent().hasExtra(getResources().getString(R.string.intent_title)) &&
                            getIntent().getStringExtra(getResources().getString(R.string.intent_title))
                                    .equalsIgnoreCase(getResources().getString(R.string.my_profile))) {
                        intent.putExtra(getResources().getString(R.string.intent_title),
                                getResources().getString(R.string.my_profile));
                    }
                    else{
                        intent.putExtra(getResources().getString(R.string.intent_contact_id), contacts.getContactId());
                    }

                    intent.putExtra(getResources().getString(R.string.intent_edit),getResources().getString(R.string.intent_edit));
                    ApplicationLifecycleHandler.isInAddContact=false;
                    startActivityForResult(intent, UPDATE_CONTACT_CODE);
                }
                else{
                    Toast.makeText(mActivity,"contact application package not found", Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.id_action_delete:
                new DeleteContactDialog(this, this).show();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(!ApplicationLifecycleHandler.isInAddContact)
            ApplicationLifecycleHandler.isInAddContact=true;

        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case UPDATE_CONTACT_CODE:
                if (data != null) {
                    getDataFromIntent(data);
                }
                break;}

    }

    /**
     * load user profile
     */
    private void loadProfile(){
        Cursor pCursor = getContentResolver().query(ContactsContract.Profile.CONTENT_URI, null, null, null, null);

        assert pCursor != null;
        pCursor.moveToFirst();
        if (pCursor.getCount() > 0) {

            String name = pCursor.getString(pCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            contacts.setName(name);
            collapseLayout.setTitle(contacts.getName());
            String uri = pCursor.getString(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));

            contacts.setPhotoUri(uri);
            if (uri != null && uri.length() > 0) {
                contactImageView.setVisibility(View.VISIBLE);
                contactTxt.setVisibility(View.GONE);
                contactImageView.setImageURI(Uri.parse(uri));
            } else {
                contacts.setColorPos(5);
                layout.setBackgroundColor(Utils.getColorCode(this, 5));
            }
            pCursor.close();

            new ProfileLoader(this,this);
        }
    }

    /**
     * Display data from intent
     */
    private void getDataFromIntent(Intent intent) {
        contacts = new Contacts();

        if(intent.hasExtra(this.getResources().getString(R.string.intent_name)))
        {
            userName=intent.getStringExtra(this.getResources().getString(R.string.intent_name));
        }
        if (intent.hasExtra(getResources().getString(R.string.intent_title)) &&
                intent.getStringExtra(getResources().getString(R.string.intent_title))
                        .equalsIgnoreCase(getResources().getString(R.string.my_profile))) {
            loadProfile();
        } else {
            String contactId = intent.getStringExtra(getResources().getString(R.string.intent_contact_id));
            contacts.setContactId(contactId);
            if(intent.hasExtra(getResources().getString(R.string.intent_color))){
                contacts.setColorPos(intent.getIntExtra(getResources().getString(R.string.intent_color),0));
            }
            loadContact();
        }

    }




    private void loadContact() {

        Cursor pCursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null,
                ContactsContract.Contacts._ID + " = ?",
                new String[]{contacts.getContactId()}, null);

        assert pCursor != null;
        pCursor.moveToFirst();
        if (pCursor.getCount() > 0) {
            String name = pCursor.getString(pCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            contacts.setName(name);
            collapseLayout.setTitle(contacts.getName());
            String uri = pCursor.getString(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));

            contacts.setPhotoUri(uri);
            photoUri=uri;
            if (uri != null && uri.length() > 0) {
                contactImageView.setVisibility(View.VISIBLE);
                contactTxt.setVisibility(View.GONE);
                contactImageView.setImageURI(Uri.parse(uri));
            } else {
                layout.setBackgroundColor(Utils.getColorCode(this, contacts.getColorPos()));
                contactImageView.setVisibility(View.GONE);
                contactTxt.setVisibility(View.VISIBLE);
            }
            pCursor.close();
        }
        contacts.setListNumber(Utils.getMobileList(this, contacts.getContactId()));
        contacts.setListPublicKey(ContactManager.getKeyList(this, contacts.getContactId(),contacts.getName()));
        if (contacts.getListPublicKey().size() == 0)
            contacts.setSecure(false);
        else
            contacts.setSecure(true);
        PublicKeyViewAdapter mPublicKeyViewAdapter=new PublicKeyViewAdapter(this, contacts.getListPublicKey(),userName,photoUri);
        publicKeyRecyclerView.setAdapter(mPublicKeyViewAdapter);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.height=(int) ((getResources().getDimension(R.dimen.height_of_tile)))* contacts.getListPublicKey().size();
        SDKUtils.showLog(TAG,"---------params height-------"+params.height);

        publicKeyRecyclerView.setLayoutParams(params);

    }
    @Override
    public void onDialogButtonPress(boolean isDelete) {
        if (isDelete) {
            Intent intent = new Intent();
            if (getIntent().hasExtra(getResources().getString(R.string.intent_title)) &&
                    getIntent().getStringExtra(getResources().getString(R.string.intent_title))
                            .equalsIgnoreCase(getResources().getString(R.string.my_profile))) {
                ContactHelper.deleteProfile(getContentResolver());
            } else {
                ContactHelper.deleteContact(getContentResolver(), contacts.getContactId());
                intent.putExtra(getResources().getString(R.string.intent_contact_id), contacts.getContactId());
                intent.putExtra(getResources().getString(R.string.intent_delete), 0);
            }
            setResult(DELETE_CONTACT_CODE, intent);
            finish();
        }
    }

    @Override
    public void onProfileLoadComplete(Cursor cursor) {
        Utils.setContactData(contacts, cursor);
        cursor.close();
        PublicKeyViewAdapter mPublicKeyViewAdapter=new PublicKeyViewAdapter(this, contacts.getListPublicKey(),userName,photoUri);
        publicKeyRecyclerView.setAdapter(mPublicKeyViewAdapter);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.height=(int) ((getResources().getDimension(R.dimen.height_of_tile)))* contacts.getListPublicKey().size();
        SDKUtils.showLog(TAG,"---------params height-------"+params.height);

        publicKeyRecyclerView.setLayoutParams(params);
    }
}
