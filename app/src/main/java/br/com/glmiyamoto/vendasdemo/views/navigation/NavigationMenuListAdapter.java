package br.com.glmiyamoto.vendasdemo.views.navigation;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.enums.EMenuItem;

/**
 * Created by Gustavo on 2016/03/15.
 */
public class NavigationMenuListAdapter extends BaseAdapter {

    private final Context mContext;
    private final LayoutInflater mInflater;

    public NavigationMenuListAdapter(final Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, final View convertView,
                        final ViewGroup parent) {

        final EMenuItem item = getItem(position);

        View view = convertView;
        final ViewHolder holder;
        if (view == null) {
            view = mInflater.inflate(R.layout.nav_menu_item, parent, false);

            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Set values in UI
        holder.mIconView.setImageResource(item.getIconResId());
        holder.mTitleView.setText(item.getTitleResId());
        if (item.getCounter() == null) {
            holder.mCounterView.setVisibility(View.INVISIBLE);
        } else {
            holder.mCounterView.setText(item.getCounter());
            holder.mCounterView.setVisibility(View.VISIBLE);
        }
        if (item.isEnabled()) {
            final TypedValue outValue = new TypedValue();
            mContext.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
            holder.mView.setBackgroundResource(outValue.resourceId);
            holder.mView.setEnabled(true);
        } else {
            holder.mView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorItemLineAlt));
            holder.mView.setEnabled(false);
        }

        return view;
    }

    @Override
    public int getCount() {
        return EMenuItem.values().length;
    }

    @Override
    public EMenuItem getItem(int position) {
        return EMenuItem.values()[position];
    }

    @Override
    public long getItemId(int position) {
        return EMenuItem.values()[position].ordinal();
    }

    public class ViewHolder {
        public final View mView;
        public final ImageView mIconView;
        public final TextView mTitleView;
        public final TextView mCounterView;

        public ViewHolder(View view) {
            mView = view;
            mIconView = (ImageView) view.findViewById(R.id.iv_nav_menu_item_icon);
            mTitleView = (TextView) view.findViewById(R.id.tv_nav_menu_item_title);
            mCounterView = (TextView) view.findViewById(R.id.tv_nav_menu_item_counter);
        }
    }
}
