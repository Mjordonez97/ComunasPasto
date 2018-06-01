package com.example.sistemas.pokeapp01;

import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.sistemas.DatosColombia.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaComuna extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String text_comuna;

    private LatLng sydney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_comuna);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        text_comuna = getIntent().getExtras().getString("texto_comuna");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        if(text_comuna.equals("COMUNA 1")) {
            sydney = new LatLng(1.2108176, -77.2834013);
        }
        else if(text_comuna.equals("COMUNA 2")) {
            sydney = new LatLng(1.2021938, -77.275477);
        }
        else if(text_comuna.equals("COMUNA 3")) {
            sydney = new LatLng(1.04151 ,  -77.15097);
        }
        else if(text_comuna.equals("COMUNA 4")) {
            sydney = new LatLng(1.20196 , -77.270834);
        }
        else if(text_comuna.equals("COMUNA 5")) {
            sydney = new LatLng(  1.2  , -77.28335);
        }
        else if(text_comuna.equals("COMUNA 6")) {
            sydney = new LatLng(1.212668 , -77.28569);
        }
        else if(text_comuna.equals("COMUNA 7")) {
            sydney = new LatLng(1.218159 ,  -77.285118);
        }
        else if(text_comuna.equals("COMUNA 8")) {
            sydney = new LatLng(1.224014  ,   -77.287842);
        }
        else if(text_comuna.equals("COMUNA 9")) {
            sydney = new LatLng(1.224014 , -77.291689);
        }
        else if(text_comuna.equals("COMUNA 10")) {
            sydney = new LatLng(1.232096 , -77.272261);
        }
        else if(text_comuna.equals("COMUNA 11")) {
            sydney = new LatLng(1.215939 , -77.273214 );
        }
        else if(text_comuna.equals("COMUNA 12")) {
            sydney = new LatLng(1.214512, -77.267447);
        }
        else if(text_comuna.equals("BUESAQUILLO")) {
            sydney = new LatLng(1.21081, -77.24011 );
        }
        else if(text_comuna.equals("CABRERA")) {
            sydney = new LatLng(1.23304257 , -77.21641959);
        }
        else if(text_comuna.equals("CATAMBUCO")) {
            sydney = new LatLng(1.1674  , -77.29071);
        }
        else if(text_comuna.equals("EL SOCORRO")) {
            sydney = new LatLng(1.18268 , -77.14797);
        }
        else if(text_comuna.equals("ENCANO")) {
            sydney = new LatLng(1.161666 ,  -77.155987);
        }
        else if(text_comuna.equals("GENOY")) {
            sydney = new LatLng(1.267454 ,  -77.335825);
        }
        else if(text_comuna.equals("GUALMATAN")) {
            sydney = new LatLng(0.919645 , -77.567138);
        }
        else if(text_comuna.equals("JAMONDINO")) {
            sydney = new LatLng(1.17867  , -77.25312);
        }
        else if(text_comuna.equals("JONGOVITO")) {
            sydney = new LatLng(1.18487 , -77.28805);
        }
        else if(text_comuna.equals("LA CALDERA")) {
            sydney = new LatLng(1.6331  , -77.1266);
        }
        else if(text_comuna.equals("LA LAGUNA")) {
            sydney = new LatLng(1.204162  , -77.210117);
        }
        else if(text_comuna.equals("MAPACHICO")) {
            sydney = new LatLng(1.2545497  , -77.3009832);
        }
        else if(text_comuna.equals("MOCONDINO")) {
            sydney = new LatLng(1.1833499  , -77.284243);
        }
        else if(text_comuna.equals("MORASURCO")) {
            sydney = new LatLng(1.231463  , -77.284243);
        }
        else if(text_comuna.equals("OBONUCO")) {
            sydney = new LatLng(1.2035376  , -77.2923401);
        }
        else if(text_comuna.equals("SAN FERNANDO")) {
            sydney = new LatLng(1.20332   , -77.22509);
        }
        else if(text_comuna.equals("SANTA BARBARA")) {
            sydney = new LatLng(1.2009609  , -77.2736648);
        }

        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        float zoomleve =15000;

        //zoom
        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(sydney,20 );
        googleMap.animateCamera(cameraUpdate);
    }
}
