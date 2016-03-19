package br.com.glmiyamoto.vendasdemo.enums;

import android.support.v4.app.Fragment;

import br.com.glmiyamoto.vendasdemo.utils.AppConsts;
import br.com.glmiyamoto.vendasdemo.views.messages.MessagesFragment;
import br.com.glmiyamoto.vendasdemo.views.profiles.MyProfileFragment;
import br.com.glmiyamoto.vendasdemo.views.sales.MySalesFragment;

/**
 * Created by Gustavo-VAIO on 2016/03/19.
 */
public enum EFragmentType {
    MY_PROFILE(AppConsts.FRAGMENT_MY_PROFILE_TAG, MyProfileFragment.class),
    MY_SALES(AppConsts.FRAGMENT_MY_SALES_TAG, MySalesFragment.class),
    MESSAGES(AppConsts.FRAGMENT_MESSAGES_TAG, MessagesFragment.class);

    private String mTag;
    private Class<? extends Fragment> mFragmentClass;

    EFragmentType(final String tag, final Class<? extends Fragment> fragmentClass) {
        this.mTag = tag;
        this.mFragmentClass = fragmentClass;
    }

    public String getTag() {
        return mTag;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return mFragmentClass;
    }

    public static EFragmentType getTypeByTag(final String tag) {
        for (final EFragmentType type : EFragmentType.values()) {
            if (type.getTag().equalsIgnoreCase(tag)) {
                return type;
            }
        }
        return null;
    }
}
