package br.com.glmiyamoto.vendasdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gustavo on 2016/03/14.
 */
public class User implements Parcelable {
    private int mId;
    private String mName;
    private String mEMail;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeInt(mId);
        out.writeString(mName);
        out.writeString(mEMail);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(final Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mEMail = in.readString();
    }

    public User() {

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
}
