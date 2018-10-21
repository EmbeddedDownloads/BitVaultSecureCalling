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
import android.os.Bundle;

public class LinphoneGenericActivity extends Activity {
private  String TAG= LinphoneGenericActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*After a crash, Android restart the last Activity so we need to check
        * if all dependencies are load
        */
        if (!LinphoneManager.isInstanciated()) {
            finish();
            startActivity(getIntent().setClass(this, LinphoneLauncherActivity.class));
            return;
        }


    }


}
