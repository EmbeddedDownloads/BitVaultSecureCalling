package org.linphone.utils;

import org.linphone.iclasses.ConferenceManagerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VVDN on 7/24/2017.
 */

public class AppConstants {
    public static List<Contacts> mContactsList = new ArrayList<Contacts>();
    public static boolean isAlreadyLoaded = false;
    public static boolean isContactUpdated = false;
    public static String packageName = "com.embedded.contacts";
    public static String packageClass = "com.embedded.contacts.AddContactActivity";
    public static ConferenceManagerListener mConferenceManagerListener = null;
    public static  String REGISTER_URL = "http://54.202.147.121/sip.php";
    public static String REGISTER_PASSWORD="1234";
    public static String REGISTER_IP="54.202.147.121";
    public static String BOOT_RECEIVER_PATH="/.linphonerc";
    public static String BTC_TRANSACTION_ADDRESS="msm2oDJp9fCezqg2xw3qTEFKaKZP3wszd6";
    public static String BTC_TRANSACTION_AMT="0.0001";
    public static String BTC_TRANSACTION_EXTRA_FEE="0.001";
    public static String NEW_USER_URL="https://www.linphone.org:444/upload.php";
    public static String SHARING_PICTURE_SERVER="https://www.linphone.org:444/lft.php";
}
