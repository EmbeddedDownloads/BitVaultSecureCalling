package org.linphone.utils;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by vandana on 6/1/2017.
 */

public class ContactModel {
//    private int IdOfView_ContactEditNewRow;
//    private int IdOfEditText_newPhone;
//    private int IdOfSpinner_newDataType;

    private View contactEditNewRowView;
    private EditText newPhoneEt;
    private Spinner newDataTypeSp;
    private TextView removeViewTv;

    public TextView getRemoveViewTv() {
        return removeViewTv;
    }

    public void setRemoveViewTv(TextView removeViewTv) {
        this.removeViewTv = removeViewTv;
    }

    public View getContactEditNewRowView() {
        return contactEditNewRowView;
    }

    public void setContactEditNewRowView(View contactEditNewRowView) {
        this.contactEditNewRowView = contactEditNewRowView;
    }

    public EditText getNewPhoneEt() {
        return newPhoneEt;
    }

    public void setNewPhoneEt(EditText newPhoneEt) {
        this.newPhoneEt = newPhoneEt;
    }

    public Spinner getNewDataTypeSp() {
        return newDataTypeSp;
    }

    public void setNewDataTypeSp(Spinner newDataTypeSp) {
        this.newDataTypeSp = newDataTypeSp;
    }
//    public int getIdOfView_ContactEditNewRow() {
//        return IdOfView_ContactEditNewRow;
//    }
//
//    public void setIdOfView_ContactEditNewRow(int idOfView_ContactEditNewRow) {
//        IdOfView_ContactEditNewRow = idOfView_ContactEditNewRow;
//    }
//
//    public int getIdOfEditText_newPhone() {
//        return IdOfEditText_newPhone;
//    }
//
//    public void setIdOfEditText_newPhone(int idOfEditText_newPhone) {
//        IdOfEditText_newPhone = idOfEditText_newPhone;
//    }
//
//    public int getIdOfSpinner_newDataType() {
//        return IdOfSpinner_newDataType;
//    }
//
//    public void setIdOfSpinner_newDataType(int idOfSpinner_newDataType) {
//        IdOfSpinner_newDataType = idOfSpinner_newDataType;
//    }
}