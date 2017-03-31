package com.wahyuridiansyah.abrakadabra;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getFragmentManager();

        // tampilan default awal ketika aplikasii dijalankan
        if (savedInstanceState == null) {
            fragment = new pengenalan();
            callFragment(fragment);
        }

    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        // Untuk memanggil layout dari menu yang dipilih
        if (id == R.id.nav_pengenalan) {
            fragment = new pengenalan();
            callFragment(fragment);
        } else if (id == R.id.nav_belajar) {
            fragment = new belajar();
            callFragment(fragment);
        } else if (id == R.id.nav_praktik) {
            fragment = new praktik();
            callFragment(fragment);
        } else if (id == R.id.nav_pengaturan) {
            fragment = new pengaturan();
            callFragment(fragment);
        } else if (id == R.id.nav_tentangkami) {
            startActivity(new Intent(MainActivity.this, about_us.class));
            finish();
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // untuk mengganti isi kontainer menu yang dipiih
    private void callFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
        .remove(fragment)
        .replace(R.id.frame_container, fragment)
        .commit();
    }

}