package br.com.glmiyamoto.vendasdemo.model;

/**
 * Created by Gustavo on 2016/03/14.
 */
public class User {
    private int mId;
    private String mName;
    private String mEMail;

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
