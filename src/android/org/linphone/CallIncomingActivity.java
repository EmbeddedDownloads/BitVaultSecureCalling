
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
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.linphone.Preferences.Preferences;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneCallParams;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCoreListenerBase;
import org.linphone.mediastream.Log;
import org.linphone.ui.LinphoneSliders.LinphoneSliderTriggered;
import org.linphone.utils.BitVaultFont;
import org.linphone.utils.CircularImageView;
import org.linphone.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import utils.SDKUtils;

public class CallIncomingActivity extends LinphoneGenericActivity implements LinphoneSliderTriggered, View.OnTouchListener {
    private static final String TAG = CallIncomingActivity.class.getSimpleName();
    private static CallIncomingActivity instance;

    private TextView name, number;
    private TextView accept_text, reject_text;
    private CircularImageView contactPicture;
    private ImageView call_img;
    BitVaultFont decline, accept;
    private LinphoneCall mCall;
    private LinphoneCoreListenerBase mListener;
    private boolean alreadyAcceptedOrDeniedCall;
    private long pressStartTime;
    private float pressedX;
    private float pressedY;
    private float dX;
    private float dY;
    private int screenWidth;
    private int screenHeight;
    private float startX;
    private float startY;
    private float targetMax;
    private float targetMin;
    private float priviousY;
    private float currentY;
    private float centerHeight;
    RelativeLayout rootLayout;
    private Context mContext;
    private int state = -1;
    private double alfa;

    public static CallIncomingActivity instance() {
        return instance;
    }

    public static boolean isInstanciated() {
        return instance != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        if (getResources().getBoolean(R.bool.orientation_portrait_only)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        setContentView(R.layout.call_incoming);

        rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);
        name = (TextView) findViewById(R.id.contact_name);
        number = (TextView) findViewById(R.id.contact_number);
        contactPicture = (CircularImageView) findViewById(R.id.contact_picture);
        call_img = (ImageView) findViewById(R.id.call_img);
        call_img.setOnTouchListener(this);
        call_img.bringToFront();

        // set this flag so this activity will stay in front of the keyguard
        int flags = WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON;
        getWindow().addFlags(flags);
        accept = (BitVaultFont) findViewById(R.id.accept);
        decline = (BitVaultFont) findViewById(R.id.decline);
        accept_text = (TextView) findViewById(R.id.accept_text);
        reject_text = (TextView) findViewById(R.id.reject_text);
        getScreenSize();
        mListener = new LinphoneCoreListenerBase() {
            @Override
            public void callState(LinphoneCore lc, LinphoneCall call, State state, String message) {
                if (call == mCall && State.CallEnd == state) {
                    finish();
                }
                if (state == State.StreamsRunning) {

                    Log.e("CallIncommingActivity - onCreate -  State.StreamsRunning - speaker = " + LinphoneManager.getLc().isSpeakerEnabled());
                    // The following should not be needed except some devices need it (e.g. Galaxy S).
                    LinphoneManager.getLc().enableSpeaker(LinphoneManager.getLc().isSpeakerEnabled());
                }
            }
        };

        super.onCreate(savedInstanceState);
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

        alreadyAcceptedOrDeniedCall = false;
        mCall = null;

        // Only one call ringing at a time is allowed
        if (LinphoneManager.getLcIfManagerNotDestroyedOrNull() != null) {
            List<LinphoneCall> calls = LinphoneUtils.getLinphoneCalls(LinphoneManager.getLc());
            for (LinphoneCall call : calls) {
                if (State.IncomingReceived == call.getState()) {
                    mCall = call;
                    break;
                }
            }
        }
        if (mCall == null) {
            //The incoming call no longer exists.
            Log.d("Couldn't find incoming call");
            finish();
            return;
        }


        LinphoneAddress address = mCall.getRemoteAddress();
        LinphoneContact contact = ContactsManager.getInstance().findContactFromAddress(address);
        if (contact != null) {
            LinphoneUtils.setImagePictureFromUri(this, contactPicture, contact.getPhotoUri(), contact.getThumbnailUri());
            name.setText(contact.getFullName());
        } else {
            name.setText(LinphoneUtils.getAddressDisplayName(address));
        }
        number.setText(LinphoneUtils.getUsernameFromAddress(address.asStringUriOnly()));
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

    /**
     * To get screen dimension.
     */
    public void getScreenSize() {

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        targetMax = screenHeight - Utils.px2dp(getResources(), 640);
        targetMin = screenHeight - Utils.px2dp(getResources(), 300);
        centerHeight = screenHeight - Utils.px2dp(getResources(), 500);
        call_img.setY(0f);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }
    private void decline() {
        if (alreadyAcceptedOrDeniedCall) {
            return;
        }
        alreadyAcceptedOrDeniedCall = true;

        LinphoneManager.getLc().terminateCall(mCall);
        finish();
    }

    private void answer() {
        if (alreadyAcceptedOrDeniedCall) {
            return;
        }
        alreadyAcceptedOrDeniedCall = true;

        LinphoneCallParams params = LinphoneManager.getLc().createCallParams(mCall);

        boolean isLowBandwidthConnection = !LinphoneUtils.isHighBandwidthConnection(LinphoneService.instance().getApplicationContext());

        if (params != null) {
            params.enableLowBandwidth(isLowBandwidthConnection);
        } else {
            Log.e("Could not create call params for call");
        }

        if (params == null || !LinphoneManager.getInstance().acceptCallWithParams(mCall, params)) {
            // the above method takes care of Samsung Galaxy S
            Toast.makeText(this, R.string.couldnt_accept_call, Toast.LENGTH_LONG).show();
        } else {
            if (!LinphoneActivity.isInstanciated()) {
                return;
            }
            LinphoneManager.getInstance().routeAudioToReceiver();
            SDKUtils.showErrorLog("DEBUG_CALL", "005");
            LinphoneActivity.instance().startIncallActivity(mCall);
            SDKUtils.showLog(CallIncomingActivity.class.getSimpleName(), "++ CallIncoming Answer ++");
            Preferences.getInstance(this).setCallIncomingCall(true);
        }
    }

    @Override
    public void onLeftHandleTriggered() {

    }

    @Override
    public void onRightHandleTriggered() {

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

    @Override
    public boolean onTouch(View view, MotionEvent event) {


        view.getParent().requestDisallowInterceptTouchEvent(true);
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                pressStartTime = System.currentTimeMillis();
                pressedX = event.getRawX();
                pressedY = event.getRawY();
                startX = view.getX();
                startY = view.getY();
                pressedY = event.getRawY();
                accept_text.setVisibility(View.GONE);
                reject_text.setVisibility(View.GONE);
                alfa = 0;
                state = -1;
                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                call_img.setY(centerHeight);
                break;

            case MotionEvent.ACTION_MOVE:
                state = -1;
                currentY = event.getRawY();
                if (event.getRawY() > targetMax && event.getRawY() < targetMin) {
                    call_img.setY(currentY + dY);
                    if (currentY < centerHeight + 50 && currentY > centerHeight - 50) {

                        alfa = 1;
                        call_img.setImageResource(R.drawable.incoming_icon);
                        state = 0;

                    } else if (currentY < centerHeight) {

                        call_img.setImageResource(R.drawable.answer);
                        state = 1;
                        alfa = .5f;
                    } else if (currentY > centerHeight) {

                        call_img.setImageResource(R.drawable.reject);
                        state = 2;
                        alfa = 1;
                        android.util.Log.d(TAG, "Button red lower");
                        android.util.Log.d(TAG, "Current y2 " + currentY + "Center Height : " + centerHeight);
                    }


                    if (currentY < priviousY && state == 1) {
                        if (alfa < 1)
                            alfa += .05;
                    } else if (currentY > priviousY && state == 1) {
                        if (alfa > 0.5)
                            alfa -= .05;
                    } else if (currentY < priviousY && state == 2) {
                        if (alfa > 0)
                            alfa -= .05;
                    } else if (currentY > priviousY && state == 2) {
                        if (alfa < 1)
                            alfa += .05;

                    }

                }
                priviousY = currentY;
                break;
            case MotionEvent.ACTION_UP:
                long pressDuration = System.currentTimeMillis() - pressStartTime;
                if (currentY - 50 <= targetMax) {
                    answer();
                } else if (currentY + 50 >= targetMin) {
                    decline();
                } else {
                    call_img.setY(75f);
                    call_img.setImageResource(R.drawable.incoming_icon);
                    accept_text.setVisibility(View.VISIBLE);
                    reject_text.setVisibility(View.VISIBLE);

                }

                break;
            default:
                return false;
        }

        return true;

    }

}