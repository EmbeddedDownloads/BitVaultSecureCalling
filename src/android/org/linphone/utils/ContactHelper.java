package org.linphone.utils;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.provider.ContactsContract;

import java.util.ArrayList;

import utils.SDKUtils;
public class ContactHelper {

    private static final String TAG = ContactHelper.class.getCanonicalName();

    /**
     * Delete contact from provider
     * @param contactHelper
     * @param id
     */
    public static void deleteContact(ContentResolver contactHelper, String id) {

        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
        String[] args = new String[]{id};

        ops.add(ContentProviderOperation.newDelete(ContactsContract.RawContacts.CONTENT_URI)
                .withSelection(ContactsContract.RawContacts.CONTACT_ID + "=?", args).build());
        try {
            contactHelper.applyBatch(ContactsContract.AUTHORITY, ops);
        } catch (RemoteException e) {
            SDKUtils.showLog(TAG, e.toString());
        }
        catch (OperationApplicationException e){
            SDKUtils.showLog(TAG, e.toString());
        }
    }

    /**
     * Delete profile from provider
     * @param contentResolver
     */
    public static void deleteProfile(ContentResolver contentResolver) {
        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

        ops.add(ContentProviderOperation.newDelete(ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI).build());
        try {
            contentResolver.applyBatch(ContactsContract.AUTHORITY, ops);
        } catch (RemoteException e) {
            SDKUtils.showLog(TAG, e.toString());
        }
        catch (OperationApplicationException e){
            SDKUtils.showLog(TAG, e.toString());
        }
    }





}