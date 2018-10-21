
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
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCallParams;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCoreException;
import org.linphone.mediastream.Log;


/**
 * Handle call updating, reinvites.*
 */
public class CallManager {

	private static CallManager instance;
	
	private CallManager() {}
	public static final synchronized CallManager getInstance() {
		if (instance == null) instance = new CallManager();
		return instance;
	}
	
	private BandwidthManager bm() {
		return BandwidthManager.getInstance();
	}
	

	
	
	public void inviteAddress(LinphoneAddress lAddress, boolean videoEnabled, boolean lowBandwidth) throws LinphoneCoreException {
		LinphoneCore lc = LinphoneManager.getLc();
        LinphoneCallParams params = lc.createCallParams(null);
		bm().updateWithProfileSettings(lc, params);

		if (videoEnabled && params.getVideoEnabled()) {
			params.setVideoEnabled(true);
		} else {
			params.setVideoEnabled(false);
		}
		
		if (lowBandwidth) {
			params.enableLowBandwidth(true);
		}

		lc.inviteAddressWithParams(lAddress, params);
	}

	/**
	 * Add video to a currently running voice only call.
	 * No re-invite is sent if the current call is already video
	 * or if the bandwidth settings are too low.
	 * @return if updateCall called
	 */
	boolean reinviteWithVideo() {
		LinphoneCore lc =  LinphoneManager.getLc();
		LinphoneCall lCall = lc.getCurrentCall();
		if (lCall == null) {
			Log.e("Trying to reinviteWithVideo while not in call: doing nothing");
			return false;
		}
		LinphoneCallParams params = lc.createCallParams(lCall);

		if (params.getVideoEnabled()) return false;
		

		// Check if video possible regarding bandwidth limitations
		bm().updateWithProfileSettings(lc, params);

		// Abort if not enough bandwidth...
		if (!params.getVideoEnabled()) {
			return false;
		}

		// Not yet in video call: try to re-invite with video
		lc.updateCall(lCall, params);
		return true;
	}


	
	/**
	 * Re-invite with parameters updated from profile.
	 */
	void reinvite() {
		LinphoneCore lc = LinphoneManager.getLc();
		LinphoneCall lCall = lc.getCurrentCall();
		if (lCall == null) {
			Log.e("Trying to reinvite while not in call: doing nothing");
			return;
		}
		LinphoneCallParams params = lc.createCallParams(lCall);
		bm().updateWithProfileSettings(lc, params);
		lc.updateCall(lCall, params);
	}

	/**
	 * Change the preferred video size used by linphone core. (impact landscape/portrait buffer).
	 * Update current call, without reinvite.
	 * The camera will be restarted when mediastreamer chain is recreated and setParameters is called.
	 */
	public void updateCall() {
		LinphoneCore lc = LinphoneManager.getLc();
		LinphoneCall lCall = lc.getCurrentCall();
		if (lCall == null) {
			Log.e("Trying to updateCall while not in call: doing nothing");
			return;
		}
		LinphoneCallParams params = lc.createCallParams(lCall);
		bm().updateWithProfileSettings(lc, params);
		lc.updateCall(lCall, null);
	}
	
}
