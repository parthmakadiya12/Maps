package com.example.parthmakadiya.maps;

import android.content.Intent;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {
   Button btnGeo=null ;
    public GoogleMap mMap;
    private static final LatLng cr1 = new LatLng(23.525979, 72.455205);
    private static final LatLng es1 = new LatLng(23.524041, 72.454904);
    private static final LatLng nb1 = new LatLng(23.527030, 72.459117);
    private static final LatLng memc1 = new LatLng(23.527967, 72.457830);
    private static final LatLng cnt1 = new LatLng(23.529453, 72.458127);
    private static final LatLng hcr1 = new LatLng(23.521442, 72.451417);
    private static final LatLng ghtl = new LatLng(23.521683, 72.454909);
    private static final LatLng staff = new LatLng(23.521683, 72.454909);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for Button Geolocate


        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnGeo=(Button)findViewById(R.id.btnGeo);
        btnGeo.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent i = new Intent(MapsActivity.this , Geolocate.class);
                startActivity(i);
            }
        });
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

    private Marker mcr1;
    private Marker mes1;
    private Marker mnb1;
    private Marker mcnt1;
    private Marker mmemc1;
    private  Marker mhcr1;
    private  Marker mghtl;
    private  Marker mstaff;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        mcr1 = mMap.addMarker(new MarkerOptions()
                .position(cr1)
                .title("Cricket ground"));
        mcr1.setTag(0);

        mes1 = mMap.addMarker(new MarkerOptions()
                .position(es1)
                .title("English School"));
        mes1.setTag(0);
        mnb1 = mMap.addMarker(new MarkerOptions()
                .position(nb1)
                .title("New Building"));
        mnb1.setTag(0);
        mcnt1 = mMap.addMarker(new MarkerOptions()
                .position(cnt1)
                .title("Canteen here"));
        mcnt1.setTag(0);
        mmemc1 = mMap.addMarker(new MarkerOptions()
                .position(memc1)
                .title("Memc Dept. Here"));
        mmemc1.setTag(0);
        mhcr1 = mMap.addMarker(new MarkerOptions()
                .position(hcr1)
                .title("Hacker Here"));
        mhcr1.showInfoWindow();
        mhcr1.setTag(0);
        mghtl = mMap.addMarker(new MarkerOptions()
                .position(ghtl)
                .title("Girls Hostel !! "));
        mghtl.setTag(0);
        mstaff = mMap.addMarker(new MarkerOptions()
                .position(staff)
                .title("staff quarters"));
        mstaff.setTag(0);

        mMap.setOnMarkerClickListener(this);
         mMap.moveCamera(CameraUpdateFactory.newLatLng(hcr1));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );
    }

    public boolean onMarkerClick(final Marker marker) {

        // Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();
        Intent intent = new Intent(this, View.class);
        Bundle bundle = new Bundle();
        String getrec=marker.getTitle().toString();
        bundle.putString("stuff", getrec);
        intent.putExtras(bundle);
        startActivity(intent);
        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();

        }
        return false;
    }

}
