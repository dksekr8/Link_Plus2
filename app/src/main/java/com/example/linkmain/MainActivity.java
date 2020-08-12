package com.example.linkmain;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.linkmain.ui.home.HomeFragment;
import com.example.linkmain.ui.home.HomeViewModel;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private HomeViewModel viewModel;
    private String cat_main = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
//        viewModel.category.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                viewModel.category.setValue(cat_main);
//            }
//        });
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            cat_main = null;
            //viewModel.category.setValue(null);
        } else if (id == R.id.nav_gallery) {
            cat_main = "sigong";
            //viewModel.category.setValue("sigong");
        } else if (id == R.id.nav_slideshow) {
            cat_main = "bosu";
            //viewModel.category.setValue("bosu");
        } else if (id == R.id.gonggu) {
            cat_main = "gonggu";
            //viewModel.category.setValue("gonggu");
        } else if (id == R.id.jungu) {
            cat_main = "jungu";
           // viewModel.category.setValue("jungu");
        } else if (id == R.id.car) {
            cat_main = "car";
           // viewModel.category.setValue("car");
        }

        Bundle bd = new Bundle();
        bd.putString("category", cat_main);
        Fragment homefragment = new HomeFragment();
        homefragment.setArguments(bd);

        //HomeFragment homeFragment = HomeFragment.sharecategory(category);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}