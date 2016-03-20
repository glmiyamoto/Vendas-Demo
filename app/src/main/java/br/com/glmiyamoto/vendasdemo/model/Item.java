package br.com.glmiyamoto.vendasdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Gustavo on 2016/03/14.
 */
public class Item implements Parcelable {
    private int mId;
    private String mName;
    private float mValue;
    private Date mRegisteredDate;
    private boolean mAlert;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeInt(mId);
        out.writeString(mName);
        out.writeFloat(mValue);
        out.writeValue(mRegisteredDate);
        out.writeInt(mAlert ? 1 : 0);
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        public Item createFromParcel(final Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(final int size) {
            return new Item[size];
        }
    };

    private Item(final Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mValue = in.readFloat();
        mRegisteredDate = (Date) in.readValue(Date.class.getClassLoader());
        mAlert = in.readInt() == 1;
    }

    public Item(){

    }

    public Item(final int id, final String name, final float value, final Date registeredDate,
                final boolean alert) {
        mId = id;
        mName = name;
        mValue = value;
        mRegisteredDate = registeredDate;
        mAlert = alert;
    }

    public int getId() {
        return mId;
    }

    public void setId(final int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(final String name) {
        mName = name;
    }

    public float getValue() {
        return mValue;
    }

    public void setValue(final float value) {
        mValue = value;
    }

    public Date getRegisteredDate() {
        return mRegisteredDate;
    }

    public void setRegisteredDate(final Date registeredDate) {
        mRegisteredDate = registeredDate;
    }

    public boolean isAlert() {
        return mAlert;
    }

    public void setAlert(final boolean alert) {
        mAlert = alert;
    }
}
