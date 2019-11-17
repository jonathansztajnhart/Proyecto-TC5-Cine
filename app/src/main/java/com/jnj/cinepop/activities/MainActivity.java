package com.jnj.cinepop.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.jnj.cinepop.DBAccess.DBFunctionManager;
import com.jnj.cinepop.DBAccess.DBMovieManager;
import com.jnj.cinepop.DBAccess.DatabaseHelper;
import com.jnj.cinepop.R;
import com.jnj.cinepop.models.MovieModel;
import com.jnj.cinepop.utils.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DatabaseHelper db;
    private DBMovieManager movieManagerDB;
    private DBFunctionManager functionManagerDB;
    private NavigationView navigationView;
    private TextView loginTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        String email = getFromSharedPreferences("email");
        if(isLogged(email)){
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
        }

        db = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase dbSql = db.getReadableDatabase();
        db.uploadTables(dbSql);
        movieManagerDB = new DBMovieManager();
        movieManagerDB.loadMovies(getApplicationContext());
        functionManagerDB = new DBFunctionManager();
        functionManagerDB.loadFunctions(getApplicationContext());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        loginTxt = findViewById(R.id.txtLogin);

        String email = getFromSharedPreferences("email");
        String nombre = getFromSharedPreferences("nombre");
        String apellido = getFromSharedPreferences("apellido");

        if(isLogged(email)){
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
            loginTxt.setText(nombre + " " + apellido);
        } else {
            setOnClickToLogin();
        }

        ArrayList<MovieModel> lstMovies = movieManagerDB.getAllActiveMovies(getApplicationContext());

        RecyclerView myrv = findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstMovies);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);

        return true;
    }

    private void setOnClickToLogin() {
        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private String getFromSharedPreferences(String key){
        String username = null;
        try {
            SharedPreferences sharedPref = getSharedPreferences("session_login", Context.MODE_PRIVATE);
            String defaultValue = "";
            username = sharedPref.getString(key, defaultValue);
        }
        catch (Exception e) {

        }
        return username;
    }

    private boolean isLogged(String email){
        return email != null && !email.equals("");
    }

    private void logout(){
        SharedPreferences sharedPref = getSharedPreferences("session_login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.commit();
        loginTxt.setText(R.string.nav_header_login);
        navigationView.getMenu().findItem(R.id.nav_logout).setVisible(false);
        setOnClickToLogin();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_tickets) {

        } else if (id == R.id.nav_mapa) {

        } else if (id == R.id.nav_logout) {
            logout();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
