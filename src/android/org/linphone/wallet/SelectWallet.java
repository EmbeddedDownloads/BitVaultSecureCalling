package org.linphone.wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.linphone.LinphoneLauncherActivity;
import org.linphone.Preferences.Preferences;
import org.linphone.R;
import org.linphone.iclasses.HeaderViewClickListener;
import org.linphone.utils.HeaderViewManager;

import java.util.ArrayList;

import bitmanagers.BitVaultWalletManager;
import commons.SecureSDKException;
import iclasses.WalletArrayCallback;
import model.WalletDetails;

/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/
public class SelectWallet extends Activity implements WalletArrayCallback {
    /**
     * Debugging TAG to debug this class
     */
    private String TAG = SelectWallet.class.getSimpleName();
    /**
     * Activity reference of this class to pass it to the other classes
     */
    private Activity mActivity;
    /**
     * Listview object for this class
     */
    private ListView wallet_type_list;
    /**
     * SelectWalletAdapter object  reference of the class
     */
    private SelectWalletAdapter mSelectWalletAdapter;
    /**
     * ArrayList object reference of the class
     */
    private ArrayList<WalletDetails> wallet_List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectwallet);
        initializeView();
        manageHeader();
        assignClick();
    }

    /*****************************************************************
     * Function Name -initializeView
     * Description - this function initialize the views which are included in this layout
     ******************************************************************/
    private void initializeView() {
        mActivity = SelectWallet.this;
        wallet_List = new ArrayList<WalletDetails>();
        wallet_type_list = (ListView) findViewById(R.id.wallet_type_list);
        if (BitVaultWalletManager.getWalletInstance() != null) {
            try {
                BitVaultWalletManager.getWalletInstance().getWallets(this);
            } catch (SecureSDKException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (Preferences.getInstance(this) != null)
//            if (Preferences.getInstance(this).getWalletAddress() != null) {
//                Intent intent = new Intent(SelectWallet.this, LinphoneLauncherActivity.class);
//                intent.putExtra("Phone", Preferences.getInstance(this).getWalletAddress());
//                startActivity(intent);
//            }
    }

    /*****************************************************************
     * Function Name -manageHeader
     * Description - This manage the header of current Screen
     ******************************************************************/
    private void manageHeader() {
        HeaderViewManager.getInstance().InitializeHeaderView(mActivity, null, true, headerViewClickListener());
        HeaderViewManager.getInstance().setHeading(mActivity, true, getResources().getString(R.string.select_wallet));
        HeaderViewManager.getInstance().setLeftSideHeaderView(true, false, "d", "");
        HeaderViewManager.getInstance().setRightSideHeaderView(false, false, 0, "");
    }

    /***********************************************************************
     * Function Name - headerViewClickListener
     * Description- This function will return the header views click listener
     *
     * @return HeaderViewClickListener
     ***********************************************************************/
    private HeaderViewClickListener headerViewClickListener() {
        HeaderViewClickListener mClickListener = new HeaderViewClickListener() {
            @Override
            public void onClickOfHeaderLeftView() {
                onBackPressed();
            }

            @Override
            public void onClickOfHeaderRightView() {
            }
        };
        return mClickListener;
    }

    /*********************************************************
     * @Method Name: assignClicks
     * @Description: This method is used to assign the reference to
     * the user clicks
     ***********************************************************/
    private void assignClick() {
        wallet_type_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*check the size of wallet list*/
                if (wallet_List.size() >= i) {
//                    Preferences.getInstance(SelectWallet.this).setWalletAddress(wallet_List.get(i).getmKeyPair().address);
//                    Preferences.getInstance(SelectWallet.this).setTransactionWalletAddress(wallet_List.get(i).getmKeyPair().address);
//                    Preferences.getInstance(SelectWallet.this).setWalletName(wallet_List.get(i).getWALLET_NAME());
                }
                //Preferences.getInstance(SelectWallet.this).setWalletAddress(wallet_List.get(i).getmKeyPair().publicKey+"");
                Intent intent = new Intent(SelectWallet.this, LinphoneLauncherActivity.class);
                android.util.Log.d("DEBUG TAG","assignClick  wallet_List.get(i).getmKeyPair().address called: "+ wallet_List.get(i).getmKeyPair().address);
                intent.putExtra("Phone", wallet_List.get(i).getmKeyPair().address);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getWallets(ArrayList<WalletDetails> mRequestedWallets) {
        wallet_List = mRequestedWallets;
        mSelectWalletAdapter = new SelectWalletAdapter(mActivity, mRequestedWallets);
        wallet_type_list.setAdapter(mSelectWalletAdapter);
    }


}
