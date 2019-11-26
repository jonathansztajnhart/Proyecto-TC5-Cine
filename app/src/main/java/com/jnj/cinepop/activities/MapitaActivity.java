package com.jnj.cinepop.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jnj.cinepop.R;

public class MapitaActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapita);

        /*barra con nombre y flechita*/
        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.title_activity_mapita));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /*hasta aca*/

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        /*if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }*/

        //mMap.setMyLocationEnabled(true);

        markedSucursales(googleMap);

        LatLng buenosAires = new LatLng(-34.62, -58.45);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(buenosAires));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(buenosAires.latitude, buenosAires.longitude), 11.0f), 1500, null);

    }

    private void markedSucursales(GoogleMap googleMap) {
        mMap = googleMap;

        final LatLng sCaballito = new LatLng(-34.6191719,-58.4402052);
        final LatLng sBelgrano = new LatLng(-34.5629477,-58.4587212);
        final LatLng sPalermo = new LatLng(-34.5809201,-58.4267193);
        final LatLng sPuertoMadero = new LatLng(-34.6128917,-58.3648533);

        mMap.addMarker(new MarkerOptions().position(sCaballito).title("Sucursal de Caballito"));
        mMap.addMarker(new MarkerOptions().position(sBelgrano).title("Sucursal de Belgrano"));
        mMap.addMarker(new MarkerOptions().position(sPalermo).title("Sucursal de Palermo"));
        mMap.addMarker(new MarkerOptions().position(sPuertoMadero).title("Sucursal de Puerto Madero"));

    }


}
