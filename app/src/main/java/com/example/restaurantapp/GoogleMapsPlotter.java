package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

public class GoogleMapsPlotter extends FragmentActivity implements OnMapReadyCallback {

    public static final String CORD_KEY = "CordKey";

    SupportMapFragment supportMapFragment;
    GoogleMap mMap;
    Intent intent;
    double[] varCords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps_plotter);
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        supportMapFragment.getMapAsync((OnMapReadyCallback) this);
        intent = getIntent();
        varCords = intent.getDoubleArrayExtra(CORD_KEY);
    }
    //18.5204 , 73.8567
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng varPointer = new LatLng(varCords[0] , varCords[1]);
        mMap.addMarker(new
                MarkerOptions().position(varPointer).title("LatiLong"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(varPointer));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}