package com.jnj.cinepop.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jnj.cinepop.R;

public class MapitaActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marcador;
    double lat=-34.62;
    double lng=-58.45;

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

        miUbicacion();

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

    private void agregarUbicador(double lat, double lng) {
        LatLng coordenadas=new LatLng(lat, lng);
        CameraUpdate miUbicacion=CameraUpdateFactory.newLatLngZoom(coordenadas, 16);

        if(marcador!=null)marcador.remove();

        marcador=mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title("YO")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        mMap.animateCamera(miUbicacion);
    }

    private void actualizarUbicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            agregarUbicador(lat, lng);
        }
    }

    LocationListener locListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    private void miUbicacion() {

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 15000, 0, locListener);
    }
}