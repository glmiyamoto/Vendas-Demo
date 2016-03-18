package br.com.glmiyamoto.vendasdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gustavo on 2016/03/14.
 */
public class Message implements Parcelable {
    private int mId;
    private int mOrigUserId;
    private int mDestUserId;
    private String mText;
    private boolean mAlert;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeInt(mId);
        out.writeInt(mOrigUserId);
        out.writeInt(mDestUserId);
        out.writeString(mText);
        out.writeInt(mAlert ? 1 : 0);
    }

    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    private Message(final Parcel in) {
        mId = in.readInt();
        mOrigUserId = in.readInt();
        mDestUserId = in.readInt();
        mText = in.readString();
        mAlert = in.readInt() == 1;
    }

    public Message() {
    }

    public int getId() {
        return mId;
    }

    public void setId(final int id) {
        mId = id;
    }

    public int getOrigUserId() {
        return mOrigUserId;
    }

    public void setOrigUserId(final int origUserId) {
        mOrigUserId = origUserId;
    }

    public int getDestUserId() {
        return mDestUserId;
    }

    public void setDestUserId(final int destUserId) {
        mDestUserId = destUserId;
    }

    public String getText() {
        return mText;
    }

    public void setText(final String text) {
        mText = text;
    }

    public boolean isAlert() {
        return mAlert;
    }

    public void setAlert(final boolean alert) {
        mAlert = alert;
    }
}
