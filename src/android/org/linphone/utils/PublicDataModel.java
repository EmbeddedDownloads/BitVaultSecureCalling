package org.linphone.utils;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by vandana on 6/1/2017.
 */

public class PublicDataModel {


    private View publicKeyEditNewRowView;
    private EditText newPublicEt;

    public RelativeLayout getNewBarCodeScan() {
        return newBarCodeScan;
    }

    public void setNewBarCodeScan(RelativeLayout newBarCodeScan) {
        this.newBarCodeScan = newBarCodeScan;
    }

    private RelativeLayout newBarCodeScan;

    private TextView removeViewTv;

    public View getPublicKeyEditNewRowView() {
        return publicKeyEditNewRowView;
    }

    public void setPublicKeyEditNewRowView(View publicKeyEditNewRowView) {
        this.publicKeyEditNewRowView = publicKeyEditNewRowView;
    }

    public EditText getNewPublicEt() {
        return newPublicEt;
    }

    public void setNewPublicEt(EditText newPublicEt) {
        this.newPublicEt = newPublicEt;
    }

    public TextView getRemoveViewTv() {
        return removeViewTv;
    }

    public void setRemoveViewTv(TextView removeViewTv) {
        this.removeViewTv = removeViewTv;
    }
}