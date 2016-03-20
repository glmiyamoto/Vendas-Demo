package br.com.glmiyamoto.vendasdemo.views.main;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import br.com.glmiyamoto.vendasdemo.MainActivity;
import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.controllers.UserController;
import br.com.glmiyamoto.vendasdemo.enums.EFragmentType;
import br.com.glmiyamoto.vendasdemo.model.User;
import br.com.glmiyamoto.vendasdemo.views.navigation.NavigationMenuPresenter;
import br.com.glmiyamoto.vendasdemo.views.navigation.OnNavigationMenuItemClickListener;

/**
 * Created by Gustavo on 2016/03/20.
 */
public class MainActivityPresenter {

    private MainActivity mActivity;

    private NavigationMenuPresenter mNavMenuPresenter;

    private final ViewHolder mHolder;
    private final User mUser;

    public MainActivityPresenter(final MainActivity activity, final OnNavigationMenuItemClickListener navMenuItemClickListener) {
        mActivity = activity;
        mHolder = new ViewHolder(mActivity);
        mUser = UserController.getInstance().getAppUser();

        // Setting the action bar
        mActivity.setSupportActionBar(mHolder.mToolbar);

        // Setting the drawer
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(mActivity, mHolder.mDrawer,
                mHolder.mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mHolder.mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        // Setting the navigation menu
        mNavMenuPresenter = new NavigationMenuPresenter(mActivity, mHolder.mNavView, mUser);
        mNavMenuPresenter.setOnNavigationMenuItemClickListener(navMenuItemClickListener);
    }

    /**
     * Return if the drawer is open
     * @return
     */
    public boolean isDrawerOpen() {
        return mHolder.mDrawer.isDrawerOpen(GravityCompat.START);
    }

    /**
     * Close drawer
     */
    public void closeDrawer() {
        mHolder.mDrawer.closeDrawer(GravityCompat.START);
    }

    /**
     * Update toolbar content by fragment type
     * @param type Fragment type
     */
    public void setToolbar(EFragmentType type) {
        switch (type) {
            case MY_PROFILE:
                mHolder.mToolbar.setTitle(R.string.my_profile_title);
                break;
            case MY_SALES:
                mHolder.mToolbar.setTitle(R.string.my_sales_title);
                break;
            case MESSAGES:
                mHolder.mToolbar.setTitle(R.string.messages_title);
                break;
            default:
                break;
        }
    }

    public User getUser() {
        return mUser;
    }

    public class ViewHolder {
        public final Toolbar mToolbar;
        public final DrawerLayout mDrawer;
        public final NavigationView mNavView;

        public ViewHolder(final Activity activity) {
            mToolbar = (Toolbar) activity.findViewById(R.id.toolbar);
            mDrawer = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
            mNavView = (NavigationView) activity.findViewById(R.id.nav_view);
        }
    }
}
