package org.linphone.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import org.linphone.R;
import org.linphone.iclasses.AppHelper;
import org.linphone.iclasses.ChoiceDialogClickListener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.SDKUtils;


/**
 * Utils of this application use static methods of application.
 */
public class Utils {
    private static final String TAG = Utils.class.getSimpleName();

    private static String MOBILE = "Mobile";
    private static String HOME = "Home";
    private static String WORK = "Work";
    private static String MAIN = "Main";
    private static String CUSTOM = "Custom";


    /**
     * Power manager object reference
     */
    private static PowerManager.WakeLock mWakeLock;
    /**
     * Object instance of progress bar
     */
    private static ProgressDialog mProgressDialog;

    /**
     * Wifi manager object reference
     */
    private static WifiManager wifi;

    /**
     * Show debug Message into logcat
     *
     * @param TAG
     * @param msg
     */
    public static void showLog(String TAG, String msg) {
        if (AppHelper.ISDEBUGGING) {
            Log.d(TAG, msg);
        }
    }

    /**
     * Show debug Error Message into logcat
     *
     * @param TAG
     * @param msg
     */
    public static void showErrorLog(String TAG, String msg) {
        if (AppHelper.ISDEBUGGING) {
            Log.e(TAG, msg);
        }
    }

    /**
     * Show debug information Message into logcat
     *
     * @param TAG
     * @param msg
     */
    public static void showInfoLog(String TAG, String msg) {
        if (AppHelper.ISDEBUGGING) {
            Log.i(TAG, msg);
        }
    }

    /**
     * Show debug warning message into logcat
     *
     * @param TAG
     * @param msg
     */
    public static void showWarningLog(String TAG, String msg) {
        if (AppHelper.ISDEBUGGING) {
            Log.w(TAG, msg);
        }
    }

    /**
     * Show Toast
     *
     * @param mActivity
     * @param msg
     */
    public static void showToast(final Activity mActivity, final String msg) {
        try {
            if (mActivity != null && msg != null && msg.length() > 0) {
                mActivity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT)
                                .show();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**************************************************************
     * @param activity
     * @return
     * @Method Name: isOnline
     * @Description: Check device have internet connection or not
     ***************************************************************/
    public static boolean isOnline(Activity activity) {
        try {
            ConnectivityManager conMgr = (ConnectivityManager) activity
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            // ARE WE CONNECTED TO THE NET
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /******************************************************************
     * @param mActivity
     * @return
     * @Description: Verify whether mobile data is enabled or not
     * @Method Name: isMobileDataEnabled
     *****************************************************************/
    public static boolean isMobileDataEnabled(Activity mActivity) {
        boolean mobileDataEnabled = false; // Assume disabled
        ConnectivityManager cm = (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            Class cmClass = Class.forName(cm.getClass().getName());
            Method method = cmClass.getDeclaredMethod("getMobileDataEnabled");
            method.setAccessible(true); // Make the method callable
            // get the setting for "mobile data"
            mobileDataEnabled = (Boolean) method.invoke(cm);
        } catch (Exception e) {
            // Some problem accessible private API
        }
        return mobileDataEnabled;
    }

    /**
     * Down Keyboard
     *
     * @param mActivity
     */
    public static void keyboardDown(Activity mActivity) {
        SDKUtils.showLog(TAG, "keyboardDown");
        try {
            InputMethodManager inputManager = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(mActivity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            SDKUtils.showLog(TAG, e.toString());
        }
    }

    /**
     * Request for keep the screen on while application is running
     *
     * @param mActivity
     */
    public static void keepScreenOn(Activity mActivity) {


        final PowerManager pm = (PowerManager) mActivity.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
        mWakeLock.acquire();
    }

    /**
     * Make the screen off
     *
     * @param mActivity
     */
    public static void keepScreenOff(Activity mActivity) {
        if (mWakeLock != null) {
            mWakeLock.release();
        }
    }

    /**
     * Multiple choice dialog
     *
     * @param mActivity
     * @param msg
     * @param positiveButtonText
     * @param negativeButtonText
     * @param mChoiceDialogClickListener
     */
    public static void showDialogWithOptions(Activity mActivity, String msg,
                                             String positiveButtonText, String negativeButtonText, String title,
                                             final ChoiceDialogClickListener mChoiceDialogClickListener) {
        if (mActivity != null && !mActivity.isFinishing()) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    mActivity);

            alertDialogBuilder.setMessage(msg);
            alertDialogBuilder.setTitle(title);
            alertDialogBuilder.setPositiveButton(positiveButtonText,
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            mChoiceDialogClickListener.onClickOfPositive();
                        }
                    });
            alertDialogBuilder.setNegativeButton(negativeButtonText,
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int arg1) {
                            dialog.dismiss();
                            mChoiceDialogClickListener.onClickOfNegative();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }



    /**
     * Show simple alert message to user
     *
     * @param mActivity
     * @param mTitle
     */

    public static void showAlert(Activity mActivity, String mTitle,
                                 String mMsg, String mButtonTxt) {
        try {
            final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(mActivity);
            alertBuilder.setTitle(mTitle);
            alertBuilder.setMessage(mMsg);
            alertBuilder.setCancelable(false);
            alertBuilder.setPositiveButton(mActivity.getResources().getString(R.string.ok),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertBuilder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***********************************************************
     * @param data
     * @return
     * @Method Name: byteArrayToString
     * @Description: This method is used to get convert the data
     * from byte array to string
     **********************************************************/
    public static String byteArrayToString(byte[] data) {
        Utils.showLog(TAG, "mData _______" + Arrays.toString(data));
        String response = Arrays.toString(data);
        //  Utils.showLog(TAG,"response ___in __byteArrayToString__"+response);
        String[] byteValues = response.substring(1, response.length() - 1).split(",");
        byte[] bytes = new byte[byteValues.length];

        for (int i = 0, len = bytes.length; i < len; i++) {
            bytes[i] = Byte.parseByte(byteValues[i].trim());
        }
        String str = new String(bytes);
        Utils.showLog(TAG, "str _______" + str);
        return str;
    }

    public static boolean isWhiteSpace(String mString) {
        boolean isWhiteSpace = false;
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(mString);
        isWhiteSpace = matcher.find();
        return isWhiteSpace;
    }

    public static boolean validateIPAddress(String mIPAddress) {
        boolean isIPValidated = false;
        final Pattern IP_ADDRESS
                = Pattern.compile(
                "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4]"
                        + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]"
                        + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
                        + "|[1-9][0-9]|[0-9]))");
        Matcher matcher = IP_ADDRESS.matcher(mIPAddress);
        if (matcher.matches()) {
            // ip is correct
            isIPValidated = true;
        } else {
            isIPValidated = false;
        }
        return isIPValidated;
    }

    /********************************************************
     * @param s
     * @Method Name: hexStringToByteArray
     * @Method Name: Convert hex string to byte array
     ********************************************************/
    public static byte[] hexStringToByteArray(String s) {
        byte[] data = null;
        try {
            int len = s.length();
            data = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
                        .digit(s.charAt(i + 1), 16));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Method to snackbar in the application
     *
     * @param mView    -- parent layout
     * @param message  -- message to be displayed
     * @param duration -- durattion of the snackbar
     */
    public static void showSnakbar(View mView, String message, int duration) {
        try {
            if (mView != null) {
                Snackbar.make(mView, message, duration).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hideDefaultKeyboard(Activity mActivity) {
        SDKUtils.showErrorLog(TAG,"calling function");
        mActivity.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    /**
     * To prevent duplicate form list
     *
     * @param list
     * @param phone
     * @return
     */
    private static boolean isNumberExist(List<Mobile> list, String phone) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumber().equalsIgnoreCase(phone) || list.get(i).getNumber().endsWith(phone)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get color code from position for background
     * @param context
     * @param pos
     * @return
     */
    public static int getColorCode(Context context,int pos){
        if (pos == 0) {
            return ContextCompat.getColor(context, R.color.green);
        } else if (pos == 1) {
            return ContextCompat.getColor(context, R.color.magenta);
        } else if (pos == 2) {
            return ContextCompat.getColor(context, R.color.red);
        } else if (pos == 3) {
            return ContextCompat.getColor(context, R.color.blue);
        } else if (pos == 4) {
            return ContextCompat.getColor(context, R.color.CYAN);
        } else {
            return ContextCompat.getColor(context, R.color.purple);
        }
    }


    /**
     * Get list of all numbers of a particular contacts
     * @param context
     * @param contactId
     * @return
     */
    public static ArrayList<Mobile> getMobileList(Context context, String contactId){

        Cursor pCursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                new String[]{contactId}, null);
        ArrayList<Mobile> mobileList = new ArrayList<Mobile>();

        assert pCursor != null;
        while (pCursor.moveToNext()) {
            int phoneType = pCursor.getInt(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
            String phoneNo = pCursor.getString(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).trim();
            phoneNo = phoneNo.replaceAll(" ", "");
            phoneNo = phoneNo.replaceAll("-", "");
            switch (phoneType) {
                case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                    if (!isNumberExist(mobileList, phoneNo)) {
                        mobileList.add(new Mobile(phoneNo, Utils.MOBILE));
                    }
                    break;
                case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                    if (!isNumberExist(mobileList, phoneNo)) {
                        mobileList.add(new Mobile(phoneNo, Utils.HOME));
                    }
                    break;
                case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                    if (!isNumberExist(mobileList, phoneNo)) {
                        mobileList.add(new Mobile(phoneNo, Utils.WORK));
                    }
                    break;
                case ContactsContract.CommonDataKinds.Phone.TYPE_MAIN:
                    if (!isNumberExist(mobileList, phoneNo)) {
                        mobileList.add(new Mobile(phoneNo, Utils.MAIN));
                    }
                    break;
                default:
                    if (!isNumberExist(mobileList, phoneNo)) {
                        mobileList.add(new Mobile(phoneNo, Utils.CUSTOM));
                    }
                    break;
            }
        }
        pCursor.close();

        return mobileList;

    }

    /**
     * Set All user profile contact data to object
     *
     * @param contact
     * @param pCursor
     */
    public static void setContactData(Contacts contact, Cursor pCursor) {


        ArrayList<Mobile> mobileList = new ArrayList<Mobile>();
        ArrayList<PublicKey> keyList = new ArrayList<PublicKey>();

        while (pCursor.moveToNext()) {
            String mimeType = pCursor.getString(pCursor.getColumnIndex("mimetype"));
            if (mimeType != null) {
                if (mimeType.contains("phone")) {
                    int phoneType = pCursor.getInt(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
                    String phoneNo = pCursor.getString(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).trim();
                    phoneNo = phoneNo.replaceAll(" ", "");
                    phoneNo = phoneNo.replaceAll("-", "");
                    switch (phoneType) {
                        case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                            if (!isNumberExist(mobileList, phoneNo)) {
                                mobileList.add(new Mobile(phoneNo, Utils.MOBILE));
                            }
                            break;
                        case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                            if (!isNumberExist(mobileList, phoneNo)) {
                                mobileList.add(new Mobile(phoneNo, Utils.HOME));
                            }
                            break;
                        case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                            if (!isNumberExist(mobileList, phoneNo)) {
                                mobileList.add(new Mobile(phoneNo, Utils.WORK));
                            }
                            break;
                        case ContactsContract.CommonDataKinds.Phone.TYPE_MAIN:
                            if (!isNumberExist(mobileList, phoneNo)) {
                                mobileList.add(new Mobile(phoneNo, Utils.MAIN));
                            }
                            break;
                        default:
                            if (!isNumberExist(mobileList, phoneNo)) {
                                mobileList.add(new Mobile(phoneNo, Utils.CUSTOM));
                            }
                            break;
                    }
                } else if (mimeType.contains("address")) {
                    int keyType = pCursor.getInt(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.SipAddress.TYPE));
                    String publicKey = pCursor.getString(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.SipAddress.SIP_ADDRESS));
                    switch (keyType) {
                        case ContactsContract.CommonDataKinds.SipAddress.TYPE_HOME:
                        case ContactsContract.CommonDataKinds.SipAddress.TYPE_WORK:
                        case ContactsContract.CommonDataKinds.SipAddress.TYPE_OTHER:
                            break;
                        default:
                            keyList.add(new PublicKey(publicKey));
                            break;
                    }
                }
            }
        }
        contact.setListPublicKey(keyList);
        contact.setListNumber(mobileList);

    }

    /**
     * getSessionId function for encryption
     * @param context
     * @return
     */
    public static String getSessionId(Context context) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < 64){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, 64);
    }

    /**
     * TO convert pixel to dp
     *
     * @param resource
     * @param px
     * @return
     */
    public static float px2dp(Resources resource, float px) {
        return (float) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, resource.getDisplayMetrics());
    }
    /**
     * Multiple User choice dialog
     *
     * @param mActivity
     * @param msg
     * @param positiveButtonText
     * @param navgitaveButtonText
     */
    public static void showChoiceDialog(Activity mActivity, String msg,
                                        String positiveButtonText, String navgitaveButtonText,
                                        final ChoiceDialogClickListener mChoiceDialogClickListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mActivity);
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setPositiveButton(positiveButtonText,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if (mChoiceDialogClickListener != null) {
                            mChoiceDialogClickListener.onClickOfPositive();
                        }

                    }
                });
        alertDialogBuilder.setNegativeButton(navgitaveButtonText,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if (mChoiceDialogClickListener != null) {
                            mChoiceDialogClickListener.onClickOfNegative();
                        }

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}