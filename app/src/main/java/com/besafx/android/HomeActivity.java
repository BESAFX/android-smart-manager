package com.besafx.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jakewharton.processphoenix.ProcessPhoenix;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        SettingsFragment.OnFragmentInteractionListener,
        DashboardFragment.OnFragmentInteractionListener,
        CompanyFragment.OnFragmentInteractionListener,
        RegionFragment.OnFragmentInteractionListener,
        BranchFragment.OnFragmentInteractionListener,
        DepartmentFragment.OnFragmentInteractionListener,
        PersonFragment.OnFragmentInteractionListener,
        TeamFragment.OnFragmentInteractionListener {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        //Load default fragment
        loadInitialFragment(savedInstanceState);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuItem menuItem = navigationView.getMenu().findItem(R.id.nav_region);
                if(menuItem.isChecked()){
                    Intent intent = new Intent(getApplicationContext(), RegionCreateUpdateActivity.class);
                    startActivity(intent);
                }
            }
        });

        ((TextView) navigationView.getHeaderView(0).findViewById(R.id.person_name)).setText(LoginActivity.me.getShortName());
        ((TextView) navigationView.getHeaderView(0).findViewById(R.id.person_role)).setText(LoginActivity.me.getQualification());


    }

    private void loadInitialFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Fragment fragment = null;
            Class dashboardFragmentClass = DashboardFragment.class;
            try {
                fragment = (Fragment) dashboardFragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            setTitle(getResources().getString(R.string.action_settings));
            fab.setVisibility(View.INVISIBLE);
            Fragment fragment = null;
            Class settingsFragmentClass = SettingsFragment.class;
            try {
                fragment = (Fragment) settingsFragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            return true;
        } else if (id == R.id.action_logout) {
            //Clear login data
            SharedPreferences sp = getSharedPreferences("Data", MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.putString("email", null);
            ed.putString("password", null);
            ed.commit();

            ProcessPhoenix.triggerRebirth(getApplicationContext());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;
        if (id == R.id.nav_company) {
            setTitle(getResources().getString(R.string.menu_item_company));
            fab.setVisibility(View.INVISIBLE);
            fragmentClass = CompanyFragment.class;
        } else if (id == R.id.nav_region) {
            setTitle(getResources().getString(R.string.menu_item_region));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
            fragmentClass = RegionFragment.class;
        } else if (id == R.id.nav_branch) {
            setTitle(getResources().getString(R.string.menu_item_branch));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
            fragmentClass = BranchFragment.class;
        } else if (id == R.id.nav_department) {
            setTitle(getResources().getString(R.string.menu_item_department));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
            fragmentClass = DepartmentFragment.class;
        } else if (id == R.id.nav_person) {
            setTitle(getResources().getString(R.string.menu_item_person));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
            fragmentClass = PersonFragment.class;
        } else if (id == R.id.nav_team) {
            setTitle(getResources().getString(R.string.menu_item_team));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
            fragmentClass = TeamFragment.class;
        } else if (id == R.id.nav_pending_outgoing_tasks) {
            setTitle(getResources().getString(R.string.menu_item_task_outgoing));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
        } else if (id == R.id.nav_auto_outgoing_tasks) {
            setTitle(getResources().getString(R.string.menu_item_task_outgoing));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
        } else if (id == R.id.nav_archive_outgoing_tasks) {
            setTitle(getResources().getString(R.string.menu_item_task_outgoing));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
        } else if (id == R.id.nav_pending_incoming_tasks) {
            setTitle(getResources().getString(R.string.menu_item_task_incoming));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
        } else if (id == R.id.nav_auto_incoming_tasks) {
            setTitle(getResources().getString(R.string.menu_item_task_incoming));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
        } else if (id == R.id.nav_archive_incoming_tasks) {
            setTitle(getResources().getString(R.string.menu_item_task_incoming));
            fab.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_add);
        } else if (id == R.id.nav_ticket) {
            setTitle(getResources().getString(R.string.menu_item_ticket));
            fab.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_notice) {
            setTitle(getResources().getString(R.string.menu_item_notice));
            fab.setVisibility(View.VISIBLE);
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
