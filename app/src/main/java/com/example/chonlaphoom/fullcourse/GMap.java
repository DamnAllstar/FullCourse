package com.example.chonlaphoom.fullcourse;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class GMap extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    int type =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            type = extras.getInt("type");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapacc);
        setUpMapIfNeeded(type);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded(type);
    }
    private void setUpMapIfNeeded(int t) {
    // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
    // Try to obtain the map from the SupportMapFragment.

            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                          .getMap();
                // Check if we were succ

                //mMap.setMyLocationEnabled(true);essful in obtaining the map.

            if (mMap != null) {
                if(t ==0)
                    setUpMapGPS();
                else
                   setUpMap();
            }
        }
    }

        /**
         * This is where we can add markers or lines, add listeners or move the camera. In this case, we
         * just add a marker near Africa.
         * <p/>
         * This should only be called once and when we are sure that {@link #mMap} is not null.
         */
        private void setUpMapGPS() {

            LocationManager locationmanager = (LocationManager) getSystemService(LOCATION_SERVICE);
            Criteria cr = new Criteria();
            String provider = locationmanager.getBestProvider(cr, true);
            Location location = locationmanager.getLastKnownLocation(provider);
            double lat=18.769289;
            double lng=98.976250;
            int avail=0;

            GPSTracker gps = new GPSTracker(this);
            if(gps.canGetLocation()){
                lat=gps.getLatitude();
                lng=gps.getLongitude();
                avail =1;
            }
            LatLng Input = new LatLng(lat, lng);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Input, 5));

            double[][] AR = new double[2][2];
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                AR = (double[][]) extras.getSerializable("list");
            }

            //mMap.setMyLocationEnabled(true);
            if(avail ==0)
            {
                mMap.addMarker(new MarkerOptions()
                        .title("Noplace")
                        .snippet("FUCK YOU 2 <3.")
                        .position(Input));
            }
            else {
                mMap.addMarker(new MarkerOptions()
                        .title("This place")
                        .snippet("FUCK YOU <3." + Input)
                        .position(Input));
                for(int x=0;x<AR.length;x++) {
                        LatLng Inp = new LatLng(AR[x][0],AR[x][1]);
                        mMap.addMarker(new MarkerOptions()
                                .title("other place")
                                .snippet("FUCK YOU <3." + x)
                                .position(Inp));
                        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));

                }
            }
        }


        private void setUpMap() {
            int a;
            a=0;
            double lat=18.769289;
            double lng=98.976250;
            String  title="No place";
            String  detail="S'th worng with database";
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                lat = extras.getDouble("Lat");
                lng = extras.getDouble("Lng");
                title = extras.getString("title");
                detail = extras.getString("detail");
            }

            LatLng Input = new LatLng(lat, lng);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Input, 5));

            mMap.addMarker(new MarkerOptions()
                    .title(title)
                    .snippet(detail)
                    .position(Input));

        }
    }
