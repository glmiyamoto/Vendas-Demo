package br.com.glmiyamoto.vendasdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gustavo on 2016/03/14.
 */
public class Message implements Parcelable {
    private int mId;
    private User mDestUser;
    private boolean mAlert;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeInt(mId);
        out.writeValue(mDestUser);
        out.writeInt(mAlert ? 1 : 0);
    }

    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        public Message createFromParcel(final Parcel in) {
            return new Message(in);
        }

        public Message[] newArray(final int size) {
            return new Message[size];
        }
    };

    private Message(final Parcel in) {
        mId = in.readInt();
        mDestUser = (User) in.readValue(User.class.getClassLoader());
        mAlert = in.readInt() == 1;
    }

    public Message() {
    }

    public Message(final int id, final User destUser, final boolean alert) {
        mId = id;
        mDestUser = destUser;
        mAlert = alert;
    }

    public int getId() {
        return mId;
    }

    public void setId(final int id) {
        mId = id;
    }

    public User getDestUser() {
        return mDestUser;
    }

    public void setDestUser(final User destUser) {
        mDestUser = destUser;
    }

    public boolean isAlert() {
        return mAlert;
    }

    public void setAlert(final boolean alert) {
        mAlert = alert;
    }
}
