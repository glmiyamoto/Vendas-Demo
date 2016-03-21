package br.com.glmiyamoto.vendasdemo.utils;

import android.content.Context;

/**
 * Created by Gustavo on 2016/03/15.
 */
public final class Util {

    private Util() {
        // Avoid instance
    }

    /**
     * Convert pixel value to dp
     * @param context
     * @param px
     * @return
     */
    public static float pxToDp(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    /**
     * Convert dp value to pixel
     * @param context
     * @param dp
     * @return
     */
    public static float dpToPx(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
