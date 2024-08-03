package com.example.empty;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.List;



public class polygon_mapping extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    Button hybridMapBtn, terrainMapBtn, satelliteMapBtn,draw,delete,submit, push;
    Polygon polygon = null;
    List<LatLng> latLngList = new ArrayList<>();

    List<Marker> markerList =  new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.polygon_mapping);

        // initialize our buttons
        hybridMapBtn = findViewById(R.id.idBtnHybridMap);
        terrainMapBtn = findViewById(R.id.idBtnTerrainMap);
        satelliteMapBtn = findViewById(R.id.idBtnSatelliteMap);
        draw = findViewById(R.id.draw);
        delete = findViewById(R.id.delete);
        submit = findViewById(R.id.submit);
        push = findViewById(R.id.end);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        // adding on click listener for our hybrid map button.
        hybridMapBtn.setOnClickListener(v -> mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID));

        // adding on click listener for our terrain map button.
        terrainMapBtn.setOnClickListener(v -> mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN));
        // adding on click listener for our satellite map button.
        satelliteMapBtn.setOnClickListener(v -> mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE));

        submit.setOnClickListener(v -> {
            if (polygon == null) return;

            if (polygon.getStrokeColor() != Color.BLUE) {
                polygon.setStrokeColor(Color.BLUE);
            } else {
//                    polygon.setFillColor(Color.BLUE);
                polygon.setStrokeColor(Color.RED);
            }
        });

        draw.setOnClickListener(v -> {
//            Bundle bundle = getIntent().getExtras();
            if (polygon != null){
                polygon.remove();
            }
            PolygonOptions polygonOptions = new PolygonOptions().addAll(latLngList).clickable(true);
            polygon = mMap.addPolygon(polygonOptions);
            polygon.setStrokeColor(Color.BLUE);
            polygon.setFillColor(Color.BLUE);
            if (polygon.getFillColor() != Color.BLUE) {
                polygon.setFillColor(Color.BLUE);
            }
//
        });
        delete.setOnClickListener(v -> {
            if (polygon != null){
                polygon.remove();
            }
            for (Marker marker : markerList) marker.remove();
            latLngList.clear();
            markerList.clear();

//
        });

//        push.setOnClickListener(v -> {
////            List<LatLng> latLngList = new ArrayList<LatLng>();
////            Intent intent=getIntent();
//
////            MyDBHandler handler = new MyDBHandler(polygon_mapping.this);
////            handler.addemp("","","",latLngList.toString());
//            Intent intent=new Intent(polygon_mapping.this, MapsActivity.class);
//            Bundle record_bundle = intent.getExtras();
//            assert record_bundle != null;
//            record_bundle.putString("location", latLngList.toString());
//            startActivity(intent);
////            Intent intent=getIntent();
//
//
////            d6 = ward_edit.getText().toString();
////            handler.addemp(d1,d2,d3,d4,d5,d6);
////            MyDBHandler handler=new MyDBHandler(polygon_mapping.this);
//
//
//
//        });
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(polygon_mapping.this, MapsActivity.class);
                startActivity(intent);
//                setContentView(R.layout.fragment_second);
            }
        });


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().isMapToolbarEnabled();
        mMap.getUiSettings().isScrollGesturesEnabled();
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setOnMapClickListener(latLng -> {

            MarkerOptions markerOptions = new MarkerOptions().position(latLng);
            Marker marker = mMap.addMarker(markerOptions);

            latLngList.add(latLng);
            markerList.add(marker);


        });

    }


}
