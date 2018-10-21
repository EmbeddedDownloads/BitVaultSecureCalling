package org.linphone.utils;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import org.linphone.iclasses.OnProfileLoadListener;


public class ProfileLoader implements LoaderManager.LoaderCallbacks<Cursor>{

    private AppCompatActivity appCompatActivity;
    private OnProfileLoadListener listener;

    public ProfileLoader(AppCompatActivity appCompatActivity, OnProfileLoadListener listener){
        this.listener=listener;
        this.appCompatActivity = appCompatActivity;
        appCompatActivity.getSupportLoaderManager().restartLoader(0,null,this);
    }

    public Loader<Cursor> onCreateLoader(int id, Bundle arguments) {
        return new CursorLoader(appCompatActivity,
                Uri.withAppendedPath( ContactsContract.Profile.CONTENT_URI,ContactsContract.Contacts.Data.CONTENT_DIRECTORY),
                null, null, null, null);
    }
    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {

        listener.onProfileLoadComplete(cursor);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

}
