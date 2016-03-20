package br.com.glmiyamoto.vendasdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.glmiyamoto.vendasdemo.enums.EFragmentCallback;
import br.com.glmiyamoto.vendasdemo.enums.EFragmentType;
import br.com.glmiyamoto.vendasdemo.enums.EMenuItem;
import br.com.glmiyamoto.vendasdemo.views.IFragment;
import br.com.glmiyamoto.vendasdemo.views.IFragmentListener;
import br.com.glmiyamoto.vendasdemo.views.messages.MessagesFragment;
import br.com.glmiyamoto.vendasdemo.views.navigation.NavigationMenuPresenter;
import br.com.glmiyamoto.vendasdemo.views.navigation.OnNavigationMenuItemClickListener;

public class MainActivity extends AppCompatActivity implements IFragmentListener {

    private NavigationMenuPresenter mNavMenuPresenter;

    private IFragment mCurrentFragment;

    private Handler mHandler = new Handler();

    private OnNavigationMenuItemClickListener mNavMenuItemClickListener = new OnNavigationMenuItemClickListener() {
        @Override
        public void OnNavigationMenuItemClick(final EMenuItem item) {
            switch (item) {
                case MY_SALES:
                    callFragmentByType(EFragmentType.MY_SALES, null);
                    break;
                case MESSAGES:
                    final Bundle args = new Bundle();
                    args.putInt(MessagesFragment.ARG_COLUMN_COUNT, 4);
                    callFragmentByType(EFragmentType.MESSAGES, args);
                    break;
                default:
                    break;
            }

            final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawer.closeDrawer(GravityCompat.START);
                    }
                }, 400);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavMenuPresenter = new NavigationMenuPresenter(this, navigationView);
        mNavMenuPresenter.setOnNavigationMenuItemClickListener(mNavMenuItemClickListener);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mCurrentFragment == null) {
            callFragmentByType(EFragmentType.MY_PROFILE, null);
        }
    }

    @Override
    public void onAttachFragment(final Fragment fragment) {
        super.onAttachFragment(fragment);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (fragment instanceof IFragment) {
            final EFragmentType type = ((IFragment) fragment).getFragmentType();
            switch (type) {
                case MY_PROFILE:
                    toolbar.setTitle(R.string.my_profile_title);
                    break;
                case MY_SALES:
                    toolbar.setTitle(R.string.my_sales_title);
                    break;
                case MESSAGES:
                    toolbar.setTitle(R.string.messages_title);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (mCurrentFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void callFragmentByType(final EFragmentType fragmentsType, final Bundle bundle) {
        if (mCurrentFragment != null && mCurrentFragment.getFragmentType() == fragmentsType) {
            return;
        }

        IFragment fragment = (IFragment) this.getSupportFragmentManager().findFragmentByTag(fragmentsType.getTag());
        try {
            if (fragment == null) {
                // Get fragment new instance
                fragment = (IFragment) fragmentsType.getFragmentClass().newInstance();
            }
            fragment.setFragmentListener(this);

            if (bundle != null) {
                fragment.setArguments(bundle);
            }

            this.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, (Fragment) fragment).commit();
            mCurrentFragment = fragment;
        } catch (InstantiationException e) {
            // Ignore
        } catch (IllegalAccessException e) {
            // Ignore
        }
    }

    @Override
    public void onFragmentCallBack(final EFragmentCallback callback, final EFragmentType type, final Bundle bundle) {
        switch (callback) {
            case BACK:
                callFragmentByType(EFragmentType.MY_PROFILE, null);
                break;
            default:
                break;
        }
    }
}
