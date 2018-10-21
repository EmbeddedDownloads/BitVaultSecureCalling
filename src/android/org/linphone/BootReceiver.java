/*
BootReceiver.java
Copyright (C) 2010  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/
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
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LpConfig;
import org.linphone.mediastream.Log;
import org.linphone.utils.AppConstants;
import org.linphone.utils.AppKeyHelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equalsIgnoreCase(Intent.ACTION_SHUTDOWN)) {
			Log.w("Device is shutting down, destroying LinphoneCore to unregister");
			LinphoneManager.destroy();
		} else {
			String path = context.getFilesDir().getAbsolutePath() + AppConstants.BOOT_RECEIVER_PATH;
			LpConfig lpConfig = LinphoneCoreFactory.instance().createLpConfig(path);
			boolean autostart = lpConfig.getBool(AppKeyHelper.KEY_APP, "auto_start", false);
			if (autostart) {
				Intent lLinphoneServiceIntent = new Intent(Intent.ACTION_MAIN);
				lLinphoneServiceIntent.setClass(context, LinphoneService.class);
				context.startService(lLinphoneServiceIntent);
			}
		}
	}
}
