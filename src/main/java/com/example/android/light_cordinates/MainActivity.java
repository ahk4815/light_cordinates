package com.example.android.light_cordinates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Location loc;
    public static coordinates co;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LocationManager lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        final coordinates coOff=new coordinates();
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION)==0)
        {
            String prov=LocationManager.NETWORK_PROVIDER;
            lm.requestLocationUpdates(prov,0,0,new locationListen());
            loc = lm.getLastKnownLocation(prov);
            if(loc!=null) {
                coOff.setlng(loc.getLongitude());
                coOff.setlat(loc.getLatitude());


            }
            else{

            }

        }
        else
        {}
         Toast.makeText(MainActivity.this, "lat :" + coOff.getlat()+"\n long:"+coOff.getlng(), Toast.LENGTH_LONG).show();

    }
    private class locationListen implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            if(location!=null){
                co.setlat(location.getLatitude());
                co.setlng(location.getLongitude());
                //Toast.makeText(getApplicationContext(), "location " + co.getlat(), Toast.LENGTH_LONG);
                Log.d("Listener called","YES");
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

}
