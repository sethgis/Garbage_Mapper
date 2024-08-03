package com.example.empty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button hybridMapBtn, terrainMapBtn, satelliteMapBtn, add_1, add_5;

//    private FloatingActionButton add_1,add_2,add_3,add_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize our buttons
        hybridMapBtn = findViewById(R.id.idBtnHybridMap);
        terrainMapBtn = findViewById(R.id.idBtnTerrainMap);
        satelliteMapBtn = findViewById(R.id.idBtnSatelliteMap);
        add_1 = findViewById(R.id.add1);
//        add_5 = findViewById(R.id.add5);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // adding on click listener for our hybrid map button.
        hybridMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        // adding on click listener for our terrain map button.
        terrainMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });
        // adding on click listener for our satellite map button.
        satelliteMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        add_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, Secondfragment.class);
                startActivity(intent);
//                setContentView(R.layout.fragment_second);
            }
        });
//        add_5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MapsActivity.this, polygon_mapping.class);
//                startActivity(intent);
////                setContentView(R.layout.fragment_second);
//            }
//        });


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
//        MarkerOptions options = new MarkerOptions().position(latLng).title("Your Location");
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
//        googleMap.addMarker(options);

        mMap.getUiSettings().isMapToolbarEnabled();
        mMap.getUiSettings().isScrollGesturesEnabled();
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
//        mMap.getUiSettings().getMyLocation(true);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Clicked location");
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20));
                markerOptions.position(latLng);
                googleMap.getMyLocation();
                googleMap.clear();
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20));
                googleMap.addMarker(markerOptions);


            }



        });

    }


}
