package com.realmucho.prokatproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.realmucho.prokatproject.Fragments.AboutFragment;
import com.realmucho.prokatproject.Fragments.ConditionsFragment;
import com.realmucho.prokatproject.Fragments.FeedBackFragment;
import com.realmucho.prokatproject.Fragments.MainFragment;
import com.realmucho.prokatproject.Fragments.NewOfFragment;
import com.realmucho.prokatproject.Fragments.TopOfFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SearchView search;
    private FloatingActionButton add;
    private Fragment mainFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainFragment = new MainFragment();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.root, mainFragment).commit();
        search = (SearchView) findViewById(R.id.search);

        add = (FloatingActionButton) findViewById(R.id.fab);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                Intent intent;
                switch (id) {
                    case R.id.fab:
                        intent = new Intent(MainActivity.this, AddActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        int id = item.getItemId();

        switch (id) {

            case R.id.main:
                fragment = new MainFragment();
                search.setVisibility(View.VISIBLE);
                search.setQuery("", false);
                if (!search.isIconified()) {
                    search.setIconified(true);
                }
                add.setVisibility(View.VISIBLE);

                break;
            case R.id.topof:
                fragment = new TopOfFragment();
                search.setVisibility(View.VISIBLE);
                search.setQuery("", false);
                add.setVisibility(View.GONE);
                if (!search.isIconified()) {
                    search.setIconified(true);
                }
                break;
            case R.id.newof:
                fragment = new NewOfFragment();
                search.setVisibility(View.VISIBLE);
                search.setQuery("", false);
                add.setVisibility(View.GONE);
                if (!search.isIconified()) {
                    search.setIconified(true);
                }
                break;
            case R.id.about:
                fragment = new AboutFragment();
                search.setVisibility(View.GONE);
                add.setVisibility(View.GONE);

                break;
            case R.id.conditions:
                fragment = new ConditionsFragment();
                search.setVisibility(View.GONE);
                add.setVisibility(View.GONE);
                break;
            case R.id.feedback:
                fragment = new FeedBackFragment();
                search.setVisibility(View.GONE);
                add.setVisibility(View.GONE);
                break;

        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.root, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
