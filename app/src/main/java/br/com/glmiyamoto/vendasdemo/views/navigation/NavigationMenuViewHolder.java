package br.com.glmiyamoto.vendasdemo.views.navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import br.com.glmiyamoto.vendasdemo.R;

/**
 * Created by Gustavo on 2016/03/15.
 */
public class NavigationMenuViewHolder {
    public final LinearLayout Header;
    public final ImageView UserPhoto;
    public final TextView UserName;
    public final TextView UserEMail;
    public final ListView MenuList;

    public NavigationMenuViewHolder(final View view) {
        Header = (LinearLayout) view.findViewById(R.id.ll_nav_header);
        UserPhoto = (ImageView) view.findViewById(R.id.iv_nav_user_photo);
        UserName = (TextView) view.findViewById(R.id.tv_nav_user_name);
        UserEMail = (TextView) view.findViewById(R.id.tv_nav_user_email);
        MenuList = (ListView) view.findViewById(R.id.lv_nav_menu);
    }
}
