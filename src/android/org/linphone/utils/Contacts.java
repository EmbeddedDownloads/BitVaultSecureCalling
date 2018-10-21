package org.linphone.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;



public class Contacts implements Parcelable, Comparable {

    public static final Creator<Contacts> CREATOR = new Creator<Contacts>() {
        @Override
        public Contacts createFromParcel(Parcel in) {
            return new Contacts(in);
        }

        @Override
        public Contacts[] newArray(int size) {
            return new Contacts[size];
        }
    };
    public static int SECURE = 1;
    public static int UN_SECURE = 0;
    private String name;
    private String contactId;
    private long lastUpdateTime;
    private int colorPos;
    private ArrayList<Mobile> listNumber = new ArrayList<Mobile>();
    private ArrayList<PublicKey> listPublicKey = new ArrayList<PublicKey>();
    private boolean isSecure;
    private String photoUri = "";

    public Contacts() {

    }

    protected Contacts(Parcel in) {
        name = in.readString();
        isSecure = in.readByte() != 0;
        photoUri = in.readString();
        contactId = in.readString();
        lastUpdateTime = in.readLong();
        colorPos = in.readInt();
        listNumber = in.readArrayList(Mobile.class.getClassLoader());
        listPublicKey = in.readArrayList(PublicKey.class.getClassLoader());
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public int getColorPos() {
        return colorPos;
    }

    public void setColorPos(int colorPos) {
        this.colorPos = colorPos;
    }

    public ArrayList<PublicKey> getListPublicKey() {
        return listPublicKey;
    }

    public void setListPublicKey(ArrayList<PublicKey> listPublicKey) {
        this.listPublicKey = listPublicKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        this.name = name;
    }

    public ArrayList<Mobile> getListNumber() {
        return listNumber;
    }

    public void setListNumber(ArrayList<Mobile> listNumber) {
        this.listNumber = listNumber;
    }

    public boolean isSecure() {
        return isSecure;
    }

    public void setSecure(boolean secure) {
        isSecure = secure;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(contactId);
        parcel.writeLong(lastUpdateTime);
        parcel.writeInt(colorPos);
        parcel.writeByte((byte) (isSecure() ? 1 : 0));
        parcel.writeString(photoUri);
        parcel.writeList(listNumber);
        parcel.writeList(listPublicKey);
    }


    @Override
    public int compareTo(@NonNull Object o) {
        return ((Contacts) o).getName().compareTo(name);
    }
}
