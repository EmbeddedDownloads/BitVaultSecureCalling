package org.linphone.wallet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.linphone.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

import model.WalletDetails;
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

public class SelectWalletAdapter extends BaseAdapter {

    /**
     * Activity instance
     */
    private Activity mActivity;
    /**
     * ArrayList object
     */
    private ArrayList<WalletDetails> mWalletTypeList;
    /**
     * Debugging TAG
     */
    private String TAG = SelectWalletAdapter.class.getSimpleName();
    /**
     * LayoutInflater object
     */
    private LayoutInflater inflater;

    /**
     * @param mActivity
     * @param mWalletTypeList
     */
    public SelectWalletAdapter(Activity mActivity, ArrayList<WalletDetails> mWalletTypeList) {
        this.mActivity = mActivity;
        this.mWalletTypeList = mWalletTypeList;
        inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        /*Check ArrayList is null or not*/
        if (mWalletTypeList != null)
            return mWalletTypeList.size();
        else return 0; /*default position is zero*/
    }

    @Override
    public Object getItem(int position) {
        /*Check ArrayList is null or not*/
        if (mWalletTypeList != null)
            return mWalletTypeList.get(position);
        else return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Holder mHolder;
        View mView = view;
        if (view == null) {
            mHolder = new Holder();
            mView = inflater.inflate(R.layout.selectwallet_item_row, null);
            /*get ids of view*/
            mHolder.wallet_type = (TextView) mView.findViewById(R.id.wallet_type);
            mHolder.wallet_balance = (TextView) mView.findViewById(R.id.wallet_balance);
            mView.setTag(mHolder);
        } else {
            mHolder = (Holder) mView.getTag();
        }
        /*Handle null pointer if "walletTypeList" is null*/
        if (mWalletTypeList != null && !mWalletTypeList.isEmpty()) {
            SDKUtils.showLog(TAG, "Wallet Name " + mWalletTypeList.get(i).getWALLET_NAME().trim());
            mHolder.wallet_type.setText(mWalletTypeList.get(i).getWALLET_NAME().trim());
            mHolder.wallet_balance.setText(convertDecimalFormatPattern(Double.valueOf(mWalletTypeList.get(i).getWALLET_LAST_UPDATE_BALANCE())));
            SDKUtils.showLog(TAG, "Wallet Address--------------" + mWalletTypeList.get(i).getmKeyPair().address + " position" + i);
        } else SDKUtils.showLog(TAG, "mWalletTypeList is null");
        return mView;
    }

    public class Holder {
        TextView wallet_type, wallet_balance;
    }

    /**
     * Creates a DecimalFormat using the given pattern and the symbols
     * for the default locale. This is a convenient way to obtain a
     * DecimalFormat when internationalization is not the main concern.
     *
     * @param value the value what we want to change
     * @return formatted string value
     */
    public static String convertDecimalFormatPattern(Double value) {
        DecimalFormat df = new DecimalFormat("#0.########");
        return df.format(value);
    }
}
