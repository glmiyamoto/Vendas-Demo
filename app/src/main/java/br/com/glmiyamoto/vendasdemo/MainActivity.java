package br.com.glmiyamoto.vendasdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.glmiyamoto.vendasdemo.enums.MenuItem;
import br.com.glmiyamoto.vendasdemo.views.messages.MessagesFragment;
import br.com.glmiyamoto.vendasdemo.views.navigation.NavigationMenuPresenter;
import br.com.glmiyamoto.vendasdemo.views.navigation.OnNavigationMenuItemClickListener;
import br.com.glmiyamoto.vendasdemo.views.sales.MySalesFragment;

public class MainActivity extends AppCompatActivity {

    private NavigationMenuPresenter mNavMenuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavMenuPresenter = new NavigationMenuPresenter(this, navigationView);
        mNavMenuPresenter.setOnNavigationMenuItemClickListener(new OnNavigationMenuItemClickListener() {
            @Override
            public void OnNavigationMenuItemClick(MenuItem item) {
                final Fragment newFragment;
                switch (item) {
                    case MY_SALES:
                        newFragment = new MySalesFragment();
                        break;
                    case MESSAGES:
                        newFragment = new MessagesFragment();
                        final Bundle args = new Bundle();
                        args.putInt(MessagesFragment.ARG_COLUMN_COUNT, 4);
                        newFragment.setArguments(args);
                        break;
                    default:
                        newFragment = null;
                        break;
                }

                if (newFragment != null) {
//                    final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.replace(R.id.fragment_container, newFragment);
//                    transaction.addToBackStack(null);
//                    transaction.commit();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
