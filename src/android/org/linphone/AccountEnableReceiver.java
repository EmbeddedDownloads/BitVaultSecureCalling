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
import android.util.Log;


public class AccountEnableReceiver extends BroadcastReceiver {
	private static final String FIELD_ID = "id";
	private static final String FIELD_ACTIVE = "active";

	@Override
	public void onReceive(Context context, Intent intent) {
		int prefsAccountIndex = (int)(long)intent.getLongExtra(FIELD_ID, -1);
		boolean enable = intent.getBooleanExtra(FIELD_ACTIVE, true);
		if (prefsAccountIndex < 0 || prefsAccountIndex >= LinphonePreferences.instance().getAccountCount())
			return;
		LinphonePreferences.instance().setAccountEnabled(prefsAccountIndex, enable);
	}
}

