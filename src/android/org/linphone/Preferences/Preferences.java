package org.linphone.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import org.linphone.utils.AppKeyHelper;

import utils.SDKUtils;

/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/
public class Preferences {

    // Shared Preferences
    private SharedPreferences pref;
    // Editor for Shared preferences
    private SharedPreferences.Editor editor;
    // Context
    private Context mContext;
    // make private static instance of Session manager class
    private static Preferences mPreferences;


    /*******************************************************************
     * getInstance method is used to initialize SessionManager singleton
     * instance
     *
     * @param context context instance
     * @return Singleton session manager instance
     *******************************************************************/
    public static Preferences getInstance(Context context) {
        if (mPreferences == null) {
            mPreferences = new Preferences(context);
        }
        return mPreferences;
    }

    private Preferences(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(PreferenceHelper.PREFERENCE_NAME,
                PreferenceHelper.PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setInitialStart() {
        editor.putBoolean(PreferenceHelper.INITIAL_START, true);
        editor.commit();
    }

    public boolean getInitialStart() {
        return pref.getBoolean(PreferenceHelper.INITIAL_START, false);
    }

    /*********************************************************
     * Function Name : setWalletAddress
     * Description : this function will store the WalletAddress
     *
     * @param walletAddress
     ***********************************************************/
    public void setWalletAddress(String walletAddress) {
        editor.putString(PreferenceHelper.WALLET_ADDRESS, walletAddress);
        editor.commit();
    }

    /****************************************************************
     * Function Name : getWalletAddress
     * Description : this function will return the WalletAddress
     *
     * @return
     ****************************************************************/
    public String getWalletAddress() {
        return pref.getString(PreferenceHelper.WALLET_ADDRESS, "");
    }

    /*********************************************************
     * Function Name : setWalletPosition
     * Description : this function will store the WalletPosition
     *
     * @param walletPositoin
     ***********************************************************/
    public void setWalletPosition(int walletPositoin) {
        try {
            walletPositoin = walletPositoin + 1;
            editor.putInt(PreferenceHelper.WALLET_POSITION, walletPositoin);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /****************************************************************
     * Function Name : getWalletPosition
     * Description : this function will return the WalletPosition
     *
     * @return
     ****************************************************************/
    public int getWalletPosition() {
        return pref.getInt(PreferenceHelper.WALLET_POSITION, 0);
    }

    /*********************************************************
     * Function Name : setTransactionWalletAddress
     * Description : this function will store the TransactionWalletAddress
     *
     * @param walletAddress
     ***********************************************************/
    public void setTransactionWalletAddress(String walletAddress) {
        editor.putString(PreferenceHelper.TRANSACTION_WALLET_ADDRESS, walletAddress);
        editor.commit();
    }

    /****************************************************************
     * Function Name : getTransactionWalletAddress
     * Description : this function will return the TransactionWalletAddress
     *
     * @return
     ****************************************************************/
    public String getTransactionWalletAddress() {
        return pref.getString(PreferenceHelper.TRANSACTION_WALLET_ADDRESS, "");
    }

    /*********************************************************
     * Function Name : setCasetWalletNamellTransactionStatus
     * Description : this function will store the WalletName
     *
     * @param walletName
     ***********************************************************/
    public void setWalletName(String walletName) {
        editor.putString(PreferenceHelper.WALLET_NAME, walletName);
        editor.commit();
    }

    /****************************************************************
     * Function Name : getWalletName
     * Description : this function will return the WalletName
     *
     * @return
     ****************************************************************/
    public String getWalletName() {
        return pref.getString(PreferenceHelper.WALLET_NAME, "");
    }

    /*********************************************************
     * Function Name : setCallTransactionStatus
     * Description : this function will store the CallTransactionStatus
     *
     * @param status
     ***********************************************************/
    public void setCallTransactionStatus(String status) {
        editor.putString(PreferenceHelper.CALL_TRANSACTION_STATUS, status);
        editor.commit();
    }

    /****************************************************************
     * Function Name : getCallTransactionStatus
     * Description : this function will return the CallTransactionStatus
     *
     * @return
     ****************************************************************/
    public String getCallTransactionStatus() {
        return pref.getString(PreferenceHelper.CALL_TRANSACTION_STATUS, "true");
    }

    /*********************************************************
     * Function Name : setCallIncomingCall
     * Description : this function will store the CallIncomingCall Flag
     *
     * @param status
     ***********************************************************/
    public void setCallIncomingCall(boolean status) {
        SDKUtils.showLog(Preferences.class.getSimpleName(), "++ setCallIncomingCall ++");
        editor.putBoolean(PreferenceHelper.CALL_INCOMING, status);
        editor.commit();
    }

    /****************************************************************
     * Function Name : isCallIncoming
     * Description : this function will return the CallIncoming Flag
     *
     * @return
     ****************************************************************/
    public boolean isCallIncoming() {
        return pref.getBoolean(PreferenceHelper.CALL_INCOMING, false);
    }

    /*********************************************************
     * Function Name : setCallOutgoingCall
     * Description : this function will store the CallOutgoingCall Flag
     *
     * @param status
     ***********************************************************/
    public void setCallOutgoingCall(boolean status) {
        editor.putBoolean(PreferenceHelper.CALL_OUTGOING, status);
        editor.commit();
    }

    /****************************************************************
     * Function Name : isCallOutgoing
     * Description : this function will return the CallOutgoing Flag
     *
     * @return
     ****************************************************************/
    public boolean isCallOutgoing() {
        return pref.getBoolean(PreferenceHelper.CALL_OUTGOING, false);
    }
}
