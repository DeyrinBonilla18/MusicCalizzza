package com.example.nstorflores.musicalizza;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nstorflores.musicalizza.Activities.RegisterLyricsActivity;
import com.example.nstorflores.musicalizza.Activities.SharedPrefManager;
import com.example.nstorflores.musicalizza.Activities.SignInActivity;
import com.example.nstorflores.musicalizza.fragments.AlbumsFragment;
import com.example.nstorflores.musicalizza.fragments.HomeFragment;
import com.example.nstorflores.musicalizza.fragments.LyricsFragment;
import com.example.nstorflores.musicalizza.fragments.UnverifiedLyricsFragment;
import com.tumblr.remember.Remember;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public void validarSesion(){

        if (Remember.getString("access_token", "").isEmpty()){
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);

        }
        else {
            Toast.makeText(MainActivity.this,"Conexion exitosa", Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_main);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        validarSesion();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setFragment();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(view.getContext(),RegisterLyricsActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment;
        Class fragmentClass =null;

        switch(item.getItemId()) {
            case R.id.nav_lyrics:
                fragmentClass = LyricsFragment.class;
                break;
            case R.id.nav_albums:
                fragmentClass = AlbumsFragment.class;
                break;
            case R.id.nav_artists:
                //Remember.clear();
                //backToSignInActivity();

                break;
            case R.id.nav_offline_lyrics:
                break;
            case R.id.nav_logout:
                SharedPrefManager.getInstance(this).logout();
                Remember.putString("access_token", "");
                finish();
                startActivity(new Intent(this, SignInActivity.class));
                break;
            default:
                fragmentClass = HomeFragment.class;
        }

        try {
            if(fragmentClass!=null)
            {
                fragment = (Fragment) fragmentClass.newInstance();
                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragment(){
        Fragment fragment;
        Class fragmentClass;
        fragmentClass = LyricsFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
