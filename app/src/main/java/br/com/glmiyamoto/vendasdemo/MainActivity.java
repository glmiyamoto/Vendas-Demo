package br.com.glmiyamoto.vendasdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import br.com.glmiyamoto.vendasdemo.enums.EFragmentCallback;
import br.com.glmiyamoto.vendasdemo.enums.EFragmentType;
import br.com.glmiyamoto.vendasdemo.enums.EMenuItem;
import br.com.glmiyamoto.vendasdemo.views.IFragment;
import br.com.glmiyamoto.vendasdemo.views.IFragmentListener;
import br.com.glmiyamoto.vendasdemo.views.main.MainActivityPresenter;
import br.com.glmiyamoto.vendasdemo.views.messages.MessagesFragment;
import br.com.glmiyamoto.vendasdemo.views.navigation.OnNavigationMenuItemClickListener;

public class MainActivity extends AppCompatActivity implements IFragmentListener {

    private static final int DRAWER_CLOSE_DELAY = 400;

    private MainActivityPresenter mPresenter;
    private IFragment mCurrentFragment;
    private Handler mHandler = new Handler();

    private OnNavigationMenuItemClickListener mNavMenuItemClickListener = new OnNavigationMenuItemClickListener() {
        @Override
        public void OnNavigationMenuItemClick(final EMenuItem item) {
            final Bundle args = new Bundle();
            args.putParcelable(MessagesFragment.ARG_USER, mPresenter.getUser());
            switch (item) {
                case MY_SALES:
                    callFragmentByType(EFragmentType.MY_SALES, args);
                    break;
                case MESSAGES:
                    args.putInt(MessagesFragment.ARG_COLUMN_COUNT, 4);
                    callFragmentByType(EFragmentType.MESSAGES, args);
                    break;
                default:
                    break;
            }

            // Close drawer with delay
            if (mPresenter.isDrawerOpen()) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.closeDrawer();
                    }
                }, DRAWER_CLOSE_DELAY);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a presenter and initialize view
        mPresenter = new MainActivityPresenter(this, mNavMenuItemClickListener);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // If no one fragment was loaded, call MyProfileFragment
        if (mCurrentFragment == null) {
            final Bundle args = new Bundle();
            args.putParcelable(MessagesFragment.ARG_USER, mPresenter.getUser());
            callFragmentByType(EFragmentType.MY_PROFILE, args);
        }
    }

    @Override
    public void onAttachFragment(final Fragment fragment) {
        super.onAttachFragment(fragment);

        // Update toolbar title
        if (fragment instanceof IFragment) {
            final EFragmentType type = ((IFragment) fragment).getFragmentType();
            mPresenter.setToolbar(type);
        }
    }

    @Override
    public void onBackPressed() {
        if (mPresenter.isDrawerOpen()) {
            mPresenter.closeDrawer();
        } else if (mCurrentFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /**
     * Call fragment by fragment type
     * @param fragmentsType
     * @param bundle
     */
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
            // Set fragment listener
            fragment.setFragmentListener(this);

            // Set fragment arguments
            if (bundle != null) {
                fragment.setArguments(bundle);
            }

            // Replace to new fragment
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
                final Bundle args = new Bundle();
                args.putParcelable(MessagesFragment.ARG_USER, mPresenter.getUser());
                callFragmentByType(EFragmentType.MY_PROFILE, args);
                break;
            default:
                break;
        }
    }
}
