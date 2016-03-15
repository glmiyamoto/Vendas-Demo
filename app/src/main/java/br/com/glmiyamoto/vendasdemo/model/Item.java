package br.com.glmiyamoto.vendasdemo.model;

import java.util.Date;

/**
 * Created by Gustavo-VAIO on 2016/03/14.
 */
public class Item {
    private int mId;
    private String mName;
    private float mValue;
    private Date mRegisteredDate;
    private boolean mFlag;

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

    public boolean isFlag() {
        return mFlag;
    }

    public void setFlag(final boolean flag) {
        mFlag = flag;
    }
}
