package br.com.glmiyamoto.vendasdemo.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v8.renderscript.*;

/**
 * Created by Gustavo-VAIO on 2016/03/15.
 */
public final class ImageUtil {

    private static final float BLUR_BITMAP_SCALE = 0.4f;
    private static final float BLUR_RADIUS = 7.5f;

    private ImageUtil() {
        // Avoid intance
    }

    public static Bitmap createBluredBitmap(Context context, Bitmap image) {
        int width = Math.round(image.getWidth() * BLUR_BITMAP_SCALE);
        int height = Math.round(image.getHeight() * BLUR_BITMAP_SCALE);

        Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, height, false);
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);

        RenderScript rs = RenderScript.create(context);
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
        Allocation tmpOut = Allocation.createFromBitmap(rs, outputBitmap);
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);

        return outputBitmap;
    }

    public static Bitmap createLetterBitmap(final Context context, final String name) {
        final int width = (int) Util.dpToPx(context, 129);
        final int height = (int) Util.dpToPx(context, 129);

        final Bitmap dst = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(dst);

        final Paint bgPaint = new Paint();
        bgPaint.setColor(ColorGenerator.SALES.getRandomColor());
        canvas.drawRect(0, 0, width, height, bgPaint);

        final Paint letterPaint = new Paint();
        letterPaint.setColor(Color.WHITE);
        letterPaint.setAntiAlias(true);
        letterPaint.setFakeBoldText(true);
        letterPaint.setStyle(Paint.Style.FILL);
        letterPaint.setTypeface(Typeface.DEFAULT);
        letterPaint.setTextAlign(Paint.Align.CENTER);
        letterPaint.setTextSize((int) (width * 0.6));
        canvas.drawText(name, width / 2, height / 2 - ((letterPaint.descent() + letterPaint.ascent()) / 2), letterPaint);

        return dst;//bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
    }

    public static Drawable createRoundedBitmap(final Resources res, final int imageId) {
        final Bitmap src = BitmapFactory.decodeResource(res, imageId);
        return createRoundedBitmap(res, src);
    }

    public static Drawable createRoundedBitmap(final Resources res, final Bitmap src) {
        final Bitmap dst;

        if (src.getWidth() >= src.getHeight()){
            dst = Bitmap.createBitmap(src, src.getWidth()/2 - src.getHeight()/2, 0, src.getHeight(), src.getHeight()
            );
        }else{
            dst = Bitmap.createBitmap(src, 0, src.getHeight()/2 - src.getWidth()/2, src.getWidth(), src.getWidth()
            );
        }
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(res, dst);
        roundedBitmapDrawable.setCornerRadius(dst.getWidth() / 2);
        roundedBitmapDrawable.setAntiAlias(true);
        return roundedBitmapDrawable;
    }
}
