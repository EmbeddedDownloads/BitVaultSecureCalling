package org.linphone.utils;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created Dheeraj Banal root on 15/6/17.
 * version 1.0.0
 * Contains data about mobile number and its type
 */

public class Mobile implements Parcelable {
    public static final Creator<Mobile> CREATOR = new Creator<Mobile>() {
        @Override
        public Mobile createFromParcel(Parcel in) {
            return new Mobile(in);
        }

        @Override
        public Mobile[] newArray(int size) {
            return new Mobile[size];
        }
    };

    private String number;
    private String numberType;

    public Mobile() {

    }

    public Mobile(String number, String numberType) {
        this.number = number;
        this.numberType = numberType;
    }

    protected Mobile(Parcel in) {
        number = in.readString();
        numberType = in.readString();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumberType() {
        return numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(number);
        parcel.writeString(numberType);
    }
}