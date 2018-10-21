package org.linphone.utils;

import android.os.Parcel;
import android.os.Parcelable;


public class PublicKey implements Parcelable {

    private String publicKey;

    public PublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public PublicKey() {
    }

    protected PublicKey(Parcel in) {
        publicKey = in.readString();
    }

    public static final Creator<PublicKey> CREATOR = new Creator<PublicKey>() {
        @Override
        public PublicKey createFromParcel(Parcel in) {
            return new PublicKey(in);
        }

        @Override
        public PublicKey[] newArray(int size) {
            return new PublicKey[size];
        }
    };

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(publicKey);
    }
}
