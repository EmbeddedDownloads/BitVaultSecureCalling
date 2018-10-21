package org.linphone.contactsmanager;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

import org.linphone.utils.AppConstants;

import utils.SDKUtils;

/**
 * Created by vandana on 7/31/2017.
 */

public class MyObserver extends ContentObserver {
  //  Context mContext;

    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public MyObserver(Handler handler)
    {
        super(handler);
    }

    @Override
    public void onChange(boolean selfChange) {

        super.onChange(selfChange);
        SDKUtils.showErrorLog("MyObserver", "~~~~~~" + selfChange);
       // ShowToast("Settings change detected");
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {

        super.onChange(selfChange, uri);
        AppConstants.isContactUpdated=true;
        SDKUtils.showErrorLog("MyObserver ", "~~~~~~" + selfChange);
      //  ShowToast("Settings change detected");

    }

    /*private void ShowToast(String strMensaje) {
        Toast toast1 = Toast.makeText(mContext, strMensaje, Toast.LENGTH_SHORT);
        toast1.show();
    }*/
}
