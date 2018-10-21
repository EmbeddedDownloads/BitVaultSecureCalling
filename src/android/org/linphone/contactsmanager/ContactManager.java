package org.linphone.contactsmanager;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import org.linphone.ContactsListFragment;
import org.linphone.ContactsManager;
import org.linphone.utils.AppConstants;
import org.linphone.utils.Contacts;
import org.linphone.utils.Mobile;
import org.linphone.utils.PublicKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import utils.SDKUtils;

import static org.linphone.utils.Utils.getMobileList;

/**
 * Created by vandana on 7/24/2017.
 */

public class ContactManager {
    private String TAG = ContactManager.class.getSimpleName();
    private Context mContext = null;
    public static final int TIMER__DELAY = 200;
    public static final int TIMER_PERIOD = 500;

    public ContactManager(Context mContext) {
        this.mContext = mContext;
        getSecureContacts();
    }

    public void getSecureContacts() {

        new FetchContacts().execute();
        if (ContactsListFragment.mContactsListFragmentInstance != null) {
            if (AppConstants.mContactsList != null)
                ContactsListFragment.mContactsListFragmentInstance.ContactsLoading(AppConstants.mContactsList);
        }
    }


    private class FetchContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {

            AppConstants.mContactsList = getSecureContactNames();
            verifyFragmentInstance();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }
    }

    /***
     * Used to verify whether instance is null or not
     */
    private void verifyFragmentInstance() {

        Timer mTimer = new Timer();
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (ContactsListFragment.mContactsListFragmentInstance != null) {
                    cancel();
                    if (ContactsListFragment.mContactsListFragmentInstance != null) {
                        ContactsListFragment.mContactsListFragmentInstance.ContactsLoading(AppConstants.mContactsList);
                    }
                }
            }
        }, TIMER__DELAY, TIMER_PERIOD);
    }

    /**
     * Read the name of all the contacts.
     *
     * @return a list of names.
     */
    private List<Contacts> getSecureContactNames() {
        //   checkAndRequestReadContactsPermission();
        List<Contacts> list = new ArrayList<Contacts>();
        Contacts contacts;
        // Get the ContentResolver
        ContentResolver cr = ContactsManager.getInstance().getContentResolver();
        // Get the Cursor of all the contacts
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");

        // Move the cursor to first. Also check whether the cursor is empty or not.
        if (cursor != null && cursor.moveToFirst()) {

            // Iterate through the cursor
            do {
                // Get the contacts name
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String time = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.CONTACT_LAST_UPDATED_TIMESTAMP));
                String _id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String image_uri = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
                ArrayList<PublicKey> mPublicContactsList = getKeyList(mContext, _id, name);
                if (mPublicContactsList != null && !mPublicContactsList.isEmpty()) {
                    contacts = new Contacts();
                    contacts.setContactId(_id);
                    contacts.setLastUpdateTime(Long.parseLong(time));
                    contacts.setName(name);
                    contacts.setPhotoUri(image_uri);
                    list.add(contacts);
                }

            } while (cursor.moveToNext());
        }
        // Close the curosor
        cursor.close();
        return list;
    }

    /**
     * Get list of key form content provider based on contactid
     *
     * @param context
     * @param contactId
     * @return
     */
    public static ArrayList<PublicKey> getKeyList(Context context, String contactId, String name) {
        ArrayList<PublicKey> keyList = new ArrayList<PublicKey>();
        Cursor postal = context.getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.SipAddress.CONTACT_ID + " = "
                        + contactId, null, null);

        if (postal != null) {
            List<Mobile> list = getMobileList(context, contactId);
            while (postal.moveToNext()) {
                int keyType = postal.getInt(postal.getColumnIndex(ContactsContract.CommonDataKinds.SipAddress.TYPE));
                String publicKey = postal.getString(postal.getColumnIndex(ContactsContract.CommonDataKinds.SipAddress.SIP_ADDRESS));
                switch (keyType) {
                    case ContactsContract.CommonDataKinds.SipAddress.TYPE_HOME:
                    case ContactsContract.CommonDataKinds.SipAddress.TYPE_WORK:
                    case ContactsContract.CommonDataKinds.SipAddress.TYPE_OTHER:
                        break;
                    default:
                        if (publicKey != null && publicKey.length() > 30) {
                            publicKey = publicKey.trim();
                            if (!publicKey.equals("")) {
                                if (name == null) {
                                    addKey(keyList, list, publicKey);
                                } else if (!name.contains(publicKey) && !publicKey.contains(name)) {
                                    addKey(keyList, list, publicKey);
                                }
                            }
                        }
                        break;
                }
            }
            postal.close();
        }

        return keyList;
    }

    private static void addKey(ArrayList<PublicKey> keyList, List<Mobile> list, String publicKey) {
        boolean isExist = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumber().equalsIgnoreCase(publicKey)) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            keyList.add(new PublicKey(publicKey));
        }
    }


}