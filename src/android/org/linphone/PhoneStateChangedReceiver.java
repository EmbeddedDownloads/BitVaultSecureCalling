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
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;


public class PhoneStateChangedReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		final String extraState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

		if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(extraState)) {
			LinphoneManager.setGsmIdle(false);
			if (!LinphoneManager.isInstanciated())
				return;
			LinphoneManager.getLc().pauseAllCalls();
        } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(extraState)) {
        	LinphoneManager.setGsmIdle(true);
        }
	}
}
