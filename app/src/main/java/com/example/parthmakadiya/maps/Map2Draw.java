package com.example.parthmakadiya.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class Map2Draw extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private  LatLng src ;
    private LatLng des ;
    private static final LatLng hcr1 = new LatLng(23.521442, 72.451417);//6
    private static final LatLng nb1 = new LatLng(23.527030, 72.459117);//3
    double aa,bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2_draw);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String long1 = bundle.getString("long1");
        String lat1 = bundle.getString("lat1");
        String long2 = bundle.getString("long2");
        String lat2 = bundle.getString("lat2");
        double l1=Double.parseDouble(long1);
        double lo1=Double.parseDouble(lat1);
        double l2=Double.parseDouble(long2);
        double lo2=Double.parseDouble(lat2);
        src= new LatLng(l1, lo1);//1
        des= new LatLng(l2, lo2);//1
        aa=l1;
        bb=lo1;
    }

    private Marker mcr1;
    private Marker mes1;

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

        mMap.addMarker(new MarkerOptions().position(src).title("Source Here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(src));
        LatLng position = new LatLng(aa, bb);
        Polyline line = null;
        mMap.addPolyline(new PolylineOptions().add(
                hcr1,
                new LatLng(23.521918, 72.451733),
                new LatLng(23.520629, 72.455509),
                new LatLng(23.520580, 72.456089),
                new LatLng(23.520837, 72.456365),
                new LatLng(23.526810, 72.459679),

                nb1
        ).width(10));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(nb1)      // Sets the center of the map to Mountain View
                .zoom(16)                   // Sets the zoom
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mMap.setMinZoomPreference(15);
    }
}
