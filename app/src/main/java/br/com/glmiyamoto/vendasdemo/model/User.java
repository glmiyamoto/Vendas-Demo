package br.com.glmiyamoto.vendasdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Gustavo on 2016/03/14.
 */
public class User implements Parcelable {
    private int mId;
    private String mName;
    private String mEMail;
    private String mPhotoPath;
    private float mBalance;
    private List<Item> mSales;
    private List<Message> mMessages;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeInt(mId);
        out.writeString(mName);
        out.writeString(mEMail);
        out.writeString(mPhotoPath);
        out.writeFloat(mBalance);
        out.writeList(mSales);
        out.writeList(mMessages);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(final Parcel in) {
            return new User(in);
        }

        public User[] newArray(final int size) {
            return new User[size];
        }
    };

    private User(final Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mEMail = in.readString();
        mPhotoPath = in.readString();
        mBalance = in.readFloat();
        mSales = in.readArrayList(Item.class.getClassLoader());
        mMessages = in.readArrayList(Message.class.getClassLoader());
    }

    public User() {

    }

    public User(final int id, final String name, final String EMail, final String photoPath) {
        mId = id;
        mName = name;
        mEMail = EMail;
        mPhotoPath = photoPath;
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

    public String getEMail() {
        return mEMail;
    }

    public void setEMail(final String eMail) {
        mEMail = eMail;
    }

    public String getPhotoPath() {
        return mPhotoPath;
    }

    public void setPhotoPath(final String photoPath) {
        mPhotoPath = photoPath;
    }

    public float getBalance() {
        return mBalance;
    }

    public void setBalance(final float balance) {
        mBalance = balance;
    }

    public List<Item> getSales() {
        return mSales;
    }

    public void setSales(final List<Item> sales) {
        mSales = sales;
    }

    public List<Message> getMessages() {
        return mMessages;
    }

    public void setMessages(final List<Message> messages) {
        mMessages = messages;
    }
}
