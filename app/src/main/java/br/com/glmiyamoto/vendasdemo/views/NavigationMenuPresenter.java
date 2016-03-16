package br.com.glmiyamoto.vendasdemo.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.AdapterView;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.utils.ImageUtil;
import br.com.glmiyamoto.vendasdemo.views.navigation.NavigationMenuListAdapter;
import br.com.glmiyamoto.vendasdemo.views.navigation.NavigationMenuViewHolder;

/**
 * Created by Gustavo on 2016/03/15.
 */
public class NavigationMenuPresenter {
    public NavigationMenuViewHolder mHolder;

    public AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(final AdapterView<?> parent, final View view,
                                final int position, final long id) {

        }
    };

    public NavigationMenuPresenter(final Context context, final NavigationView view) {
        mHolder = new NavigationMenuViewHolder(view);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            final Bitmap bitmap = ImageUtil.createBluredBitmap(context, BitmapFactory.decodeResource(context.getResources(), R.drawable.photo01));
            mHolder.Header.setBackground(new BitmapDrawable(context.getResources(), bitmap));
        } else {
            mHolder.Header.setBackgroundResource(R.drawable.photo01);
        }
        mHolder.UserPhoto.setImageDrawable(ImageUtil.createRoundedBitmap(context.getResources(), R.drawable.photo01));

        final NavigationMenuListAdapter adapter = new NavigationMenuListAdapter(context);
        mHolder.MenuList.setAdapter(adapter);
        mHolder.MenuList.setOnItemClickListener(mOnItemClickListener);
    }
}
