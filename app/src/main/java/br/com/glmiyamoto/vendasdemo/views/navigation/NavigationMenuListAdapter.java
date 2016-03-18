package br.com.glmiyamoto.vendasdemo.views.navigation;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.enums.MenuItem;

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

        final MenuItem item = getItem(position);

        View view = convertView;
        final NavigationMenuItemViewHolder holder;
        if (view == null) {
            view = mInflater.inflate(R.layout.nav_menu_item, parent, false);

            holder = new NavigationMenuItemViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (NavigationMenuItemViewHolder) view.getTag();
        }

        // Set values in UI
        holder.Icon.setImageResource(item.getIconResId());
        holder.Title.setText(item.getTitleResId());
        if (item.getCounter() == null) {
            holder.Counter.setVisibility(View.INVISIBLE);
        } else {
            holder.Counter.setText(item.getCounter());
            holder.Counter.setVisibility(View.VISIBLE);
        }
        if (item.isEnabled()) {
            final TypedValue outValue = new TypedValue();
            mContext.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
            view.setBackgroundResource(outValue.resourceId);
            view.setEnabled(true);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorItemLineAlt));
            view.setEnabled(false);
        }

        return view;
    }

    @Override
    public int getCount() {
        return MenuItem.values().length;
    }

    @Override
    public MenuItem getItem(int position) {
        return MenuItem.values()[position];
    }

    @Override
    public long getItemId(int position) {
        return MenuItem.values()[position].ordinal();
    }
}
