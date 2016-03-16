package br.com.glmiyamoto.vendasdemo.views.navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.glmiyamoto.vendasdemo.R;

/**
 * Created by Gustavo-VAIO on 2016/03/15.
 */
public class NavigationMenuItemViewHolder {
    public final ImageView Icon;
    public final TextView Title;
    public final TextView Counter;

    public NavigationMenuItemViewHolder(View view) {
        Icon = (ImageView) view.findViewById(R.id.iv_nav_menu_item_icon);
        Title = (TextView) view.findViewById(R.id.tv_nav_menu_item_title);
        Counter = (TextView) view.findViewById(R.id.tv_nav_menu_item_counter);
    }
}
