package com.example.parthmakadiya.maps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, android.view.View.OnClickListener {

    Spinner dMenu;
    public GoogleMap mMap;
    double aa, bb;
    Intent snd;
    String flag11;
    private Circle mCircle[] = new Circle[15];
    int distance = 100;
    List<LatLng> points = new ArrayList<LatLng>();
    double pointX[] = new double[]{23.526279, 23.524211, 23.527030, 23.527967, 23.529453, 23.521442, 23.521683, 23.521537, 23.527849, 23.529039,23.525820};
    double pointY[] = new double[]{72.455247, 72.454999, 72.459117, 72.457830, 72.458127, 72.451417, 72.454909, 72.456471, 72.459817, 72.455303,72.458438};

    private static final LatLng cr1 = new LatLng(23.526279, 72.455247);//1
    private static final LatLng es1 = new LatLng(23.524211, 72.454999);//2
    private static final LatLng nb1 = new LatLng(23.527030, 72.459117);//3
    private static final LatLng memc1 = new LatLng(23.527967, 72.457830);//4
    private static final LatLng cnt1 = new LatLng(23.529453, 72.458127);//5
    private static final LatLng hcr1 = new LatLng(23.521442, 72.451417);//6
    private static final LatLng ghtl = new LatLng(23.521683, 72.454909);//7
    private static final LatLng staff = new LatLng(23.521537, 72.456471);//8
    private static final LatLng bsp = new LatLng(23.527849, 72.459817);//9
    private static final LatLng uni = new LatLng(23.529039, 72.455303);//10
    private static final LatLng mtech = new LatLng(23.525820, 72.458438);//11

    //Added experiment
    private LocationManager locationMangaer = null;
    private android.location.LocationListener locationListener = null;

    private Button btnGetLocation = null;
    private Button btnGeo = null;
    private Button btnReach = null;
    private Button cont = null;

    private static final String TAG = "Debug";
    private boolean flag = false;
    private String array_spinner[];
    String array[] = new String[]{"cr1", "es1", "nb1", "memc1", "cnt1", "hcr1", "ghtl", "staff", "bsp", "uni","mtech"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        array_spinner = new String[12];
        array_spinner[0] = "Choose One Dept.";
        array_spinner[1] = "CE-IT";
        array_spinner[2] = "ME-MC";
        array_spinner[3] = "University";
        array_spinner[4] = "Main Building";
        array_spinner[5] = "Canteen";
        array_spinner[6] = "Info.Center";
        array_spinner[7] = "BSc-BPharm";
        array_spinner[8] = "BS Politech.";
        array_spinner[9] = "Mtech";
        array_spinner[10] = "BS Polytechnic";
        array_spinner[11] = "UMA Hostel";

        dMenu = (Spinner) findViewById(R.id.pspinner);
        btnReach = (Button) findViewById(R.id.btnReach);
        cont = (Button) findViewById(R.id.cont);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, array_spinner);
        dMenu.setAdapter(adapter);
        cont.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent i = new Intent(MapsActivity.this, ContactUs.class);
                startActivity(i);
            }
        });
        btnReach.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String strUri = "http://maps.google.com/maps?q=loc:23.5291744,72.4531605 (" + "Ganpat University" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

                startActivity(intent);

            }
        });
        dMenu.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {

                String name = dMenu.getSelectedItem().toString();
                if (name != "Choose One Dept.") {
                    drawline(name);
                } else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast toast = Toast.makeText(MapsActivity.this, "Hello CLicked Done", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        //for Button Geolocate
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
        btnGetLocation = (Button) findViewById(R.id.btnGeo);
        btnGetLocation.setOnClickListener(this);

        locationMangaer = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

    }

    //end of oncreate
    private void drawMarkerWithCircle(double x, double y, String name, int i) {
        String n = name;
        LatLng position = new LatLng(x, y);
        int xx = i;
        double radiusInMeters = 60.0;
        int strokeColor = 0x0106000d; //red outline
        //int shadeColor = 0x44ff0000; //opaque red fill
        // CircleOptions circleOptions = new CircleOptions().center(position).radius(radiusInMeters).fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(8);
        CircleOptions circleOptions = new CircleOptions().center(position).radius(radiusInMeters).strokeColor(strokeColor).strokeWidth(8);
        mCircle[xx] = mMap.addCircle(circleOptions);

    }

    private void drawline(String X) {
        btnGetLocation.performClick();
        //aa,bb
        LatLng position = new LatLng(aa, bb);
        Polyline line = null;
        if (X == "CE-IT") {
            /*snd=new Intent(MapsActivity.this,Map2Draw.class);
            Bundle bundle = new Bundle();
            bundle.putString("long1","23.521918");
            bundle.putString("lat1","72.451733");
            bundle.putString("long2","23.526810");
            bundle.putString("lat2","72.459679");
            snd.putExtras(bundle);
            startActivity(snd);
            */
            mMap.clear();

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);  // error 2  Cannot resolve method
            line = mMap.addPolyline(new PolylineOptions().add(
                    hcr1,
                    new LatLng(23.521918, 72.451733),
                    new LatLng(23.520629, 72.455509),
                    new LatLng(23.520580, 72.456089),
                    new LatLng(23.520837, 72.456365),
                    new LatLng(23.526810, 72.459679),

                    nb1
            ).width(10)
                    .color(Color.BLACK));
        } else if (X == "ME-MC") {
            mMap.clear();

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);  // error 2  Cannot resolve method
            line = mMap.addPolyline(new PolylineOptions().add( nb1,
            new LatLng(23.527152, 72.458568),
            new LatLng(23.527842, 72.458943),
            new LatLng(23.527978, 72.458565),
            new LatLng(23.528283, 72.458673),
            memc1).width(10)
                    .color(Color.BLACK));
        }
        else if (X == "University") {
            mMap.clear();

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);  // error 2  Cannot resolve method
            line = mMap.addPolyline(new PolylineOptions().add(
                    nb1,
                    new LatLng(23.527193, 72.458582),
            new LatLng(23.528706, 72.459451),
            new LatLng(23.530562, 72.455480),
            new LatLng(23.529600, 72.454905),
            new LatLng(23.529326, 72.455439),
            uni
                    ).width(10)
                    .color(Color.BLACK));
        }
        else if (X == "Mtech") {
            mMap.clear();

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);  // error 2  Cannot resolve method
            line = mMap.addPolyline(new PolylineOptions().add( nb1,
                    new LatLng(23.527209, 72.458604),
            new LatLng(23.526560, 72.458261),
            new LatLng(23.526086, 72.459236),
            new LatLng(23.525167, 72.458688),
            new LatLng(23.525405, 72.458148),
            mtech

            ).width(10)
                    .color(Color.BLACK));
        }

        else if (X == "UMA Hostel") {
            mMap.clear();

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);  // error 2  Cannot resolve method

            line = mMap.addPolyline(new PolylineOptions().add( nb1,
                    new LatLng(23.527152, 72.458568),
            new LatLng(23.526585, 72.458281),
            new LatLng(23.526103, 72.459261),
            new LatLng(23.520596, 72.456166),
            new LatLng(23.520587, 72.455671),
            new LatLng(23.521914, 72.451792),
            hcr1
                    ).width(10)
                    .color(Color.BLACK));
        }


    }


    @Override
    public void onClick(android.view.View v) {
        flag = displayGpsStatus();
        if (flag) {
            locationListener = new MapsActivity.MyLocationListener();


            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationMangaer.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);

        } else {
            alertbox("Gps Status!!", "Your GPS is: OFF");
        }

    }

    /*----Method to Check GPS is enable or disable ----- */
    private Boolean displayGpsStatus() {
        ContentResolver contentResolver = getBaseContext()
                .getContentResolver();
        boolean gpsStatus = Settings.Secure
                .isLocationProviderEnabled(contentResolver,
                        LocationManager.GPS_PROVIDER);
        if (gpsStatus) {
            return true;

        } else {
            return false;
        }
    }

    /*----------Method to create an AlertBox ------------- */
    public void alertbox(String title, String mymessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your Device's GPS is Disable")
                .setCancelable(false)
                .setTitle("** Gps Status **")
                .setPositiveButton("Gps On",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // finish the current activity
                                // AlertBoxAdvance.this.finish();
                                Intent myIntent = new Intent(
                                        Settings.ACTION_SECURITY_SETTINGS);
                                startActivity(myIntent);
                                dialog.cancel();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // cancel the dialog box
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
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
    private Marker mhcr1;
    private Marker mghtl;
    private Marker mstaff;
    private Marker mbsp;
    private Marker muni;
    private Marker mmtec;

    private Marker loc;


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng tt2 = new LatLng(23.527048, 72.459055);
        for (int i = 0; i < array.length; i++) {
            drawMarkerWithCircle(pointX[i], pointY[i], array[i], i);
        }

//new building upar 23.526880, 72.458582         niche  23.527236, 72.459710
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(cr1)      // Sets the center of the map to Mountain View
                .zoom(16)                   // Sets the zoom
                .bearing(150)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mMap.setMinZoomPreference(15);

        LatLng pickupLatLng = new LatLng(23.528863, 72.461582);
        LatLng destinationLatLng = new LatLng(23.522135, 72.449437);
        LatLngBounds bounds = LatLngBounds.builder().include(pickupLatLng).include(destinationLatLng).build();


        BitmapDrawable bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.demo);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 45, 64, false);

        // Add a marker in Sydney and move the camera
        mcr1 = mMap.addMarker(new MarkerOptions()
                .position(cr1)
                .title("Cricket ground"));
        //mcr1.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.demo));
        mcr1.setTag(0);

        mes1 = mMap.addMarker(new MarkerOptions()
                .position(es1)
                .title("English School"));
        mes1.setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mes1.setTag(0);
        mnb1 = mMap.addMarker(new MarkerOptions()
                .position(nb1)
                .title("New Building"));
        mnb1.setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mnb1.setTag(0);
        mcnt1 = mMap.addMarker(new MarkerOptions()
                .position(cnt1)
                .title("Canteen")

        );
        mcnt1.setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mcnt1.setTag(0);
        mmemc1 = mMap.addMarker(new MarkerOptions()
                .position(memc1)
                .title("Memc Dept."));
        mmemc1.setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mmemc1.setTag(0);
        mhcr1 = mMap.addMarker(new MarkerOptions()
                .position(hcr1)
                .title("Hacker Here"));
        mhcr1.showInfoWindow();
        mhcr1.setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mhcr1.setTag(0);
        mghtl = mMap.addMarker(new MarkerOptions()
                .position(ghtl)
                .title("Girls Hostel !! "));
        mghtl.setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mghtl.setTag(0);
        mstaff = mMap.addMarker(new MarkerOptions()
                .position(staff)
                .title("staff quarters"));
        mstaff.setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mstaff.setTag(0);
        mbsp = mMap.addMarker(new MarkerOptions()
                .position(bsp)
                .title("B.S. Patel Polytechnic"));
        mbsp.setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mbsp.setTag(0);
        muni = mMap.addMarker(new MarkerOptions()
                .position(uni)
                .title("University Building"));
        muni.setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        muni.setTag(0);
        mmtec = mMap.addMarker(new MarkerOptions()
                .position(mtech)
                .title("MTech Building"));
        mmtec.setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        mmtec.setTag(0);


        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cr1));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));


    }


    public boolean onMarkerClick(final Marker marker) {

        // Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();
        Intent intent = new Intent(this, View.class);
        Bundle bundle = new Bundle();
        String getrec = marker.getTitle().toString();
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


    /*----------Listener class to get coordinates ------------- */
    private class MyLocationListener implements android.location.LocationListener {

        public void alertbox(String title, String Desc, double x) {
            flag11=title;
            AlertDialog.Builder builder = new AlertDialog.Builder(MapsActivity.this);
            builder.setMessage(title)
                    .setCancelable(false)
                    .setTitle(Desc)
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                    .setNegativeButton("Stop Popup",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // cancel the dialog box
                                    if (ActivityCompat.checkSelfPermission(MapsActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapsActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                        // TODO: Consider calling
                                        //    ActivityCompat#requestPermissions
                                        // here to request the missing permissions, and then overriding
                                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                        //                                          int[] grantResults)
                                        // to handle the case where the user grants the permission. See the documentation
                                        // for ActivityCompat#requestPermissions for more details.
                                        return;
                                    }
                                    locationMangaer.removeUpdates(locationListener);
                                    locationMangaer = null;
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        @Override
        public void onLocationChanged(Location loc) {
            double lat=loc.getLatitude();
            double lon=loc.getLongitude();

            float[] distance = new float[2];
            /*
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "log"+loc+"lat"+lat, Toast.LENGTH_SHORT);
            toast.show();
            Toast.makeText(getBaseContext(),"Location changed : Lat: " +
                            loc.getLatitude()+ " Lng: " + loc.getLongitude(),
                    Toast.LENGTH_SHORT).show();
            */
            String longitude = "Longitude: " +loc.getLongitude();
            String latitude = "Latitude: " +loc.getLatitude();
            aa=(double)loc.getLongitude();
            bb=(double)loc.getLatitude();
            LatLng latLng = new LatLng(loc.getLatitude(), loc.getLongitude());
            //Toast.makeText(MapsActivity.this,"lat "+latitude+" long "+longitude,Toast.LENGTH_SHORT).show();
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("My Location");
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.b));
            //adding marker to the map

            mMap.addMarker(markerOptions);

            for(int i=0;i<array.length;i++){
                Location.distanceBetween( bb,aa,mCircle[i].getCenter().latitude, mCircle[i].getCenter().longitude, distance);

                if( distance[0] > mCircle[i].getRadius()){
                    //nothing we dont want this to check distance of other building from the location.

                } else {
                    Toast.makeText(getBaseContext(), "Inside, distance from center: " + distance[0] + " radius: " + mCircle[i].getRadius() , Toast.LENGTH_LONG).show();
                    if(flag11!="Inside Building "+array[i]) {
                        alertbox("Inside Building " + array[i], "You are in " + array[i], distance[0]);
                    }
                }
            }
            //opening position with some zoom level in the map
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f));


    /*----------to get City-Name from coordinates ------------- */
            String s = longitude+"\n"+latitude +
                    "\n\nMy Currrent City is: ";
         //   Toast.makeText(MapsActivity.this,s,Toast.LENGTH_SHORT).show();

        }



        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStatusChanged(String provider,
                                    int status, Bundle extras) {
            // TODO Auto-generated method stub
        }
    }

}
