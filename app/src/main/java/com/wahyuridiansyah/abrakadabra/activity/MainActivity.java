package com.wahyuridiansyah.abrakadabra.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.wahyuridiansyah.abrakadabra.App;
import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.fragment.belajar;
import com.wahyuridiansyah.abrakadabra.fragment.pengenalan;
import com.wahyuridiansyah.abrakadabra.fragment.praktik;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    //DrawerLayout drawer;
    //NavigationView navigationView;
    FragmentManager fragmentManager;
    Fragment fragment = null;
    BottomBar bottomBar;


    public static Context getmContext() {
        return mContext;
    }

    public static Context mContext;



    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // toolbar = (Toolbar) findViewById(R.id.toolbar)
        setSupportActionBar(toolbar);

        App.setMainContext(this);
        Log.e("errorcontext_Main",String.valueOf(App.getMainContext()));

//        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

//        navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
            bottomBar=(BottomBar)findViewById(R.id.bottombar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId==R.id.tab_home){
                    fragment=new pengenalan();
                    callFragment(fragment);
                } else if (tabId == R.id.tab_latihan) {
                    fragment=new belajar();
                    callFragment(fragment);
                }else if (tabId==R.id.tab_materi){
                    fragment= new praktik();
                    callFragment(fragment);
                }
            }
        });
        fragmentManager = getFragmentManager();

        // tampilan default awal ketika aplikasii dijalankan
        if (savedInstanceState == null) {
            fragment = new pengenalan();
            callFragment(fragment);
        }

    }

//    @Override
//    public void onBackPressed() {
//        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }



//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//
//        // Untuk memanggil layout dari menu yang dipilih
//        if (id == R.id.nav_pengenalan) {
//            fragment = new pengenalan();
//            callFragment(fragment);
//        } else if (id == R.id.nav_belajar) {
//            fragment = new belajar();
//            callFragment(fragment);
//        } else if (id == R.id.nav_praktik) {
//            fragment = new praktik();
//            callFragment(fragment);
//        } else if (id == R.id.nav_tentangkami) {
//            fragment = new about_us();
//            callFragment(fragment);
//        }
//
//        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    // untuk mengganti isi kontainer menu yang dipiih
    private void callFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
        .remove(fragment)
        .replace(R.id.frame_container, fragment)
        .commit();
    }

}