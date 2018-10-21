package org.linphone.appControl;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import org.linphone.auth.HomeActivity;
import org.linphone.utils.AppKeyHelper;

import utils.SDKUtils;

/**
 * Created by VVDN on 10/6/2017.

 /**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/

public class ApplicationLifecycleHandler implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    private static final String TAG = ApplicationLifecycleHandler.class.getSimpleName();
    public static boolean isInBackground = false;
    public static boolean isInAddContact = true;

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

        isInBackground = false;
    }

    @Override
    public void onActivityStarted(Activity activity) {
        SDKUtils.showLog("DATA ", " ApplicationLifecycleHandler onActivityStarted:");
    }

    @Override
    public void onActivityResumed(Activity activity) {
       // isInAddContact=true;
        if (isInBackground) {
            Intent intent = new Intent(activity, AuthActivity.class);
            intent.putExtra(AppKeyHelper.KEY_CURRENT_ACTIVITY,HomeActivity.class.getSimpleName());
            activity.startActivity(intent);
            isInBackground = false;


        }


    }


    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        isInBackground = false;
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override
    public void onLowMemory() {
    }

    @Override
    public void onTrimMemory(int i) {
        if (i == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {

            if(isInAddContact) {
                isInBackground = true;
            }

        }
    }
}
