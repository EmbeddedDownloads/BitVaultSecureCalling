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
import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.linphone.Preferences.PreferenceHelper;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCoreListenerBase;
import org.linphone.core.Reason;
import org.linphone.mediastream.Log;
import org.linphone.utils.AppKeyHelper;
import org.linphone.utils.BitVaultFont;
import org.linphone.utils.CircularImageView;

import java.util.ArrayList;
import java.util.List;

import commons.GlobalKeys;
import utils.SDKUtils;

public class CallOutgoingActivity extends LinphoneGenericActivity implements OnClickListener {
    private static CallOutgoingActivity instance;

    private TextView name, number;
    private CircularImageView contactPicture;
    private ImageView hangUp;
    private RelativeLayout speaker, micro;
    private BitVaultFont micro1, speaker1;
    private LinphoneCall mCall;
    private LinphoneCoreListenerBase mListener;
    private boolean isMicMuted, isSpeakerEnabled;

    public static CallOutgoingActivity instance() {
        return instance;
    }

    public static boolean isInstanciated() {
        return instance != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getBoolean(R.bool.orientation_portrait_only)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.call_outgoing);

        name = (TextView) findViewById(R.id.contact_name);
        number = (TextView) findViewById(R.id.contact_number);
        contactPicture = (CircularImageView) findViewById(R.id.contact_picture);

        isMicMuted = false;
        isSpeakerEnabled = false;
        micro1 = (BitVaultFont) findViewById(R.id.micro1);
        micro = (RelativeLayout) findViewById(R.id.micro);
        micro.setOnClickListener(this);
        speaker1 = (BitVaultFont) findViewById(R.id.speaker1);
        speaker = (RelativeLayout) findViewById(R.id.speaker);
        speaker.setOnClickListener(this);

        // set this flag so this activity will stay in front of the keyguard
        int flags = WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON;
        getWindow().addFlags(flags);

        hangUp = (ImageView) findViewById(R.id.outgoing_hang_up);
        hangUp.setOnClickListener(this);

        mListener = new LinphoneCoreListenerBase() {
            @Override
            public void callState(LinphoneCore lc, LinphoneCall call, State state, String message) {
                if (call == mCall && State.Connected == state) {
                    if (!LinphoneActivity.isInstanciated()) {
                        return;
                    }
                    LinphoneActivity.instance().startIncallActivity(mCall);
                    finish();
                    return;
                } else if (state == State.Error) {
                    // Convert LinphoneCore message for internalization
                    if (message != null && call.getErrorInfo().getReason() == Reason.Declined) {
                        displayCustomToast(getString(R.string.error_call_declined), Toast.LENGTH_SHORT);
                    } else if (message != null && call.getErrorInfo().getReason() == Reason.NotFound) {
                        displayCustomToast(getString(R.string.error_incorrect_publice_key), Toast.LENGTH_SHORT);
                    } else if (message != null && call.getErrorInfo().getReason() == Reason.Media) {
                        displayCustomToast(getString(R.string.error_incompatible_media), Toast.LENGTH_SHORT);
                    } else if (message != null && call.getErrorInfo().getReason() == Reason.Busy) {
                        displayCustomToast(getString(R.string.error_user_busy), Toast.LENGTH_SHORT);
                    } else if (message != null) {
                        displayCustomToast(getString(R.string.error_unknown) + " - " + message, Toast.LENGTH_SHORT);
                    }
                }

                if (LinphoneManager.getLc().getCallsNb() == 0) {
                    finish();
                    return;
                }
            }
        };
        instance = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        instance = this;
        LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
        if (lc != null) {
            lc.addListener(mListener);
        }

        mCall = null;

        // Only one call ringing at a time is allowed
        if (LinphoneManager.getLcIfManagerNotDestroyedOrNull() != null) {
            List<LinphoneCall> calls = LinphoneUtils.getLinphoneCalls(LinphoneManager.getLc());
            for (LinphoneCall call : calls) {
                State cstate = call.getState();
                if (State.OutgoingInit == cstate || State.OutgoingProgress == cstate
                        || State.OutgoingRinging == cstate || State.OutgoingEarlyMedia == cstate) {
                    mCall = call;
                    break;
                }
                if (State.StreamsRunning == cstate) {
                    if (!LinphoneActivity.isInstanciated()) {
                        return;
                    }
                    SDKUtils.showLog(CallOutgoingActivity.class.getSimpleName(), "inOnresume start in call activity");
                    SDKUtils.showErrorLog("DEBUG_CALL", "007");
                    LinphoneActivity.instance().startIncallActivity(mCall);
                    finish();
                    return;
                }
            }
        }
        if (mCall == null) {
            Log.e("Couldn't find outgoing call");
            finish();
            return;
        }

        LinphoneAddress address = mCall.getRemoteAddress();
        LinphoneContact contact = ContactsManager.getInstance().findContactFromAddress(address);
        if (contact != null) {
            if(getIntent().hasExtra(AppKeyHelper.KEY_PHOTO_URI) && getIntent().getStringExtra(AppKeyHelper.KEY_PHOTO_URI)!=null && !getIntent().getStringExtra(AppKeyHelper.KEY_PHOTO_URI).isEmpty())
            {
                contactPicture.setImageURI(Uri.parse(getIntent().getStringExtra(AppKeyHelper.KEY_PHOTO_URI)));
            }
            else {
                LinphoneUtils.setImagePictureFromUri(this, contactPicture, contact.getPhotoUri(), contact.getThumbnailUri());
            }
            name.setText(contact.getFullName());
        } else {
            name.setText(LinphoneUtils.getAddressDisplayName(address));
        }
        number.setText(address.asStringUriOnly());
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkAndRequestCallPermissions();
    }

    @Override
    protected void onPause() {
        LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
        if (lc != null) {
            lc.removeListener(mListener);
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }

    @Override
    public void onBackPressed() {

    }



    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.micro) {
            isMicMuted = !isMicMuted;
            if (isMicMuted) {
                micro1.setBackground(getResources().getDrawable(R.drawable.icon_background));
                micro1.setTextColor(getResources().getColor(R.color.headerColor));
            } else {
                micro1.setBackground(null);
                micro1.setTextColor(getResources().getColor(R.color.colorH));
            }
            LinphoneManager.getLc().muteMic(isMicMuted);
        }
        if (id == R.id.speaker) {
            isSpeakerEnabled = !isSpeakerEnabled;
            if (isSpeakerEnabled) {
                speaker1.setBackground(getResources().getDrawable(R.drawable.icon_background));
                speaker1.setTextColor(getResources().getColor(R.color.headerColor));
            } else {
                speaker1.setBackground(null);
                speaker1.setTextColor(getResources().getColor(R.color.colorH));
            }
            LinphoneManager.getLc().enableSpeaker(isSpeakerEnabled);
        }
        if (id == R.id.outgoing_hang_up) {
            decline();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (LinphoneUtils.onKeyVolumeAdjust(keyCode)) return true;
        if (LinphoneUtils.onKeyBackGoHome(this, keyCode, event)) return true;
        return super.onKeyDown(keyCode, event);
    }

    public void displayCustomToast(final String message, final int duration) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toastRoot));

        TextView toastText = (TextView) layout.findViewById(R.id.toastMessage);
        toastText.setText(message);

        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
        toast.show();
    }

    private void decline() {
        LinphoneManager.getLc().terminateCall(mCall);
        finish();
    }


    private void checkAndRequestCallPermissions() {
        ArrayList<String> permissionsList = new ArrayList<String>();

        int recordAudio = getPackageManager().checkPermission(Manifest.permission.RECORD_AUDIO, getPackageName());
        Log.i("[Permission] Record audio permission is " + (recordAudio == PackageManager.PERMISSION_GRANTED ? "granted" : "denied"));
        int camera = getPackageManager().checkPermission(Manifest.permission.CAMERA, getPackageName());
        Log.i("[Permission] Camera permission is " + (camera == PackageManager.PERMISSION_GRANTED ? "granted" : "denied"));

        if (recordAudio != PackageManager.PERMISSION_GRANTED) {
            if (LinphonePreferences.instance().firstTimeAskingForPermission(Manifest.permission.RECORD_AUDIO) || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)) {
                Log.i("[Permission] Asking for record audio");
                permissionsList.add(Manifest.permission.RECORD_AUDIO);
            }
        }
        if (LinphonePreferences.instance().shouldInitiateVideoCall() || LinphonePreferences.instance().shouldAutomaticallyAcceptVideoRequests()) {
            if (camera != PackageManager.PERMISSION_GRANTED) {
                if (LinphonePreferences.instance().firstTimeAskingForPermission(Manifest.permission.CAMERA) || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                    Log.i("[Permission] Asking for camera");
                    permissionsList.add(Manifest.permission.CAMERA);
                }
            }
        }

        if (permissionsList.size() > 0) {
            String[] permissions = new String[permissionsList.size()];
            permissions = permissionsList.toArray(permissions);
            ActivityCompat.requestPermissions(this, permissions, 0);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (int i = 0; i < permissions.length; i++) {
            Log.i("[Permission] " + permissions[i] + " is " + (grantResults[i] == PackageManager.PERMISSION_GRANTED ? "granted" : "denied"));
        }
    }
}
