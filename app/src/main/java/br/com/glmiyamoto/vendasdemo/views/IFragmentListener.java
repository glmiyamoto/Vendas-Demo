package br.com.glmiyamoto.vendasdemo.views;

import android.os.Bundle;

import br.com.glmiyamoto.vendasdemo.enums.EFragmentCallback;
import br.com.glmiyamoto.vendasdemo.enums.EFragmentType;

/**
 * Created by Gustavo on 2016/03/19.
 */
public interface IFragmentListener {
    void onFragmentCallBack(final EFragmentCallback callback, final EFragmentType type, final Bundle bundle);
}
