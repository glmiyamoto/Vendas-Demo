package br.com.glmiyamoto.vendasdemo.utils;

import android.content.Context;

/**
 * Created by Gustavo-VAIO on 2016/03/15.
 */
public final class Util {

    private Util() {
        // Avoid instance
    }

    public static float pxToDp(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float dpToPx(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
