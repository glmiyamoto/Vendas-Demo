package br.com.glmiyamoto.vendasdemo.views.navigation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
                final EMenuItem selectedItem = mAdapter.getItem(position);
                mListener.OnNavigationMenuItemClick(selectedItem);
            }
        }
    };

    public NavigationMenuPresenter(final Context context, final NavigationView view) {
        final ViewHolder mHolder = new ViewHolder(view);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            final Bitmap bitmap = ImageUtil.createBluredBitmap(context, BitmapFactory.decodeResource(context.getResources(), R.drawable.photo01));
            mHolder.mHeaderView.setBackground(new BitmapDrawable(context.getResources(), bitmap));
        } else {
            mHolder.mHeaderView.setBackgroundResource(R.drawable.photo01);
        }
        mHolder.mUserPhotoView.setImageDrawable(ImageUtil.createRoundedBitmap(context.getResources(), R.drawable.photo01));

        mAdapter = new NavigationMenuListAdapter(context);
        mHolder.mMenuListView.setAdapter(mAdapter);
        mHolder.mMenuListView.setOnItemClickListener(mOnItemClickListener);
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
