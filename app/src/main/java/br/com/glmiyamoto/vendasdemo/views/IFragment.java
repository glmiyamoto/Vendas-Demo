package br.com.glmiyamoto.vendasdemo.views;

import android.os.Bundle;

import br.com.glmiyamoto.vendasdemo.enums.EFragmentType;

/**
 * Created by Gustavo on 2016/03/19.
 */
public interface IFragment {
    EFragmentType getFragmentType();

    void setArguments(Bundle bundle);

    void setFragmentListener(IFragmentListener listener);

    boolean onBackPressed();
}
