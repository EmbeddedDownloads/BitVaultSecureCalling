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
import android.os.Handler;
import android.os.Looper;

public class UIThreadDispatcher {
	private static Handler mHandler = new Handler(Looper.getMainLooper());
	
	public static void dispatch(Runnable r) {
		mHandler.post(r);
	}
}
