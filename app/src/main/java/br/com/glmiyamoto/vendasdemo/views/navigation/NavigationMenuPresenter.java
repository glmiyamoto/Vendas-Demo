package br.com.glmiyamoto.vendasdemo.views.navigation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.enums.EMenuItem;
import br.com.glmiyamoto.vendasdemo.model.User;
import br.com.glmiyamoto.vendasdemo.utils.ImageUtil;

/**
 * Created by Gustavo on 2016/03/15.
 */
public class NavigationMenuPresenter {
    private NavigationMenuListAdapter mAdapter;

    private OnNavigationMenuItemClickListener mListener;

    public AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(final AdapterView<?> parent, final View view,
                                final int position, final long id) {
            if (mListener != null) {
                // Callback the selected menu item
                final EMenuItem selectedItem = mAdapter.getItem(position);
                mListener.OnNavigationMenuItemClick(selectedItem);
            }
        }
    };

    public NavigationMenuPresenter(final Context context, final NavigationView view, final User user) {
        final ViewHolder mHolder = new ViewHolder(view);

        // Set user photo (Background)
        setHeaderBackground(context, mHolder.mHeaderView, user);

        // Set user photo
        ImageUtil.setRoundedPhotoByUser(context, mHolder.mUserPhotoView, user);

        // Set the user name
        mHolder.mUserNameView.setText(user.getName());

        // Set the user e-mail
        mHolder.mUserEMailView.setText(user.getEMail());

        // Set the navigation menu item list
        mAdapter = new NavigationMenuListAdapter(context, user);
        mHolder.mMenuListView.setAdapter(mAdapter);
        mHolder.mMenuListView.setOnItemClickListener(mOnItemClickListener);
    }

    public static void setHeaderBackground(final Context context, final View view, final User user) {
        if (user.getPhotoPath() != null) {
            // Get header size and rate
            final Point point = new Point(
                    context.getResources().getDimensionPixelSize(R.dimen.nav_header_width),
                    context.getResources().getDimensionPixelSize(R.dimen.nav_header_height));
            final int imgSize = point.x > point.y ? point.x : point.y;
            final float xRate = (float) point.x / (float) imgSize;
            final float yRate = (float) point.y / (float) imgSize;

            // Blur user photo
            final Bitmap bitmap = ImageUtil.createBlurredBitmap(context,
                    BitmapFactory.decodeResource(context.getResources(), R.drawable.photo01));

            // Create empty bitmap
            final Bitmap dst = Bitmap.createBitmap((int) (bitmap.getWidth() * xRate),
                    (int) (bitmap.getHeight() * yRate), Bitmap.Config.ARGB_8888);
            // Draw cropped bitmap to empty bitmap
            final Canvas canvas = new Canvas(dst);
            canvas.drawBitmap(bitmap, new Rect((bitmap.getWidth() - dst.getWidth()) / 2,
                    (bitmap.getHeight() - dst.getHeight()) / 2,
                    (bitmap.getWidth() - dst.getWidth()) / 2 + dst.getWidth(),
                    (bitmap.getHeight() - dst.getHeight()) / 2 + dst.getHeight()),
                    new Rect(0, 0, dst.getWidth(), dst.getHeight()), null);

            // Set bitmap to Header background
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                view.setBackground(new BitmapDrawable(context.getResources(), dst));
            } else {
                view.setBackgroundResource(R.drawable.photo01);
            }
        }
    }

    public void setOnNavigationMenuItemClickListener(OnNavigationMenuItemClickListener listener) {
        mListener = listener;
    }

    public class ViewHolder {
        public final View mView;
        public final LinearLayout mHeaderView;
        public final ImageView mUserPhotoView;
        public final TextView mUserNameView;
        public final TextView mUserEMailView;
        public final ListView mMenuListView;

        public ViewHolder(final View view) {
            mView = view;
            mHeaderView = (LinearLayout) view.findViewById(R.id.ll_nav_header);
            mUserPhotoView = (ImageView) view.findViewById(R.id.iv_nav_user_photo);
            mUserNameView = (TextView) view.findViewById(R.id.tv_nav_user_name);
            mUserEMailView = (TextView) view.findViewById(R.id.tv_nav_user_email);
            mMenuListView = (ListView) view.findViewById(R.id.lv_nav_menu);
        }
    }
}
