package com.doiloppa.location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 위험권한 설정 요청
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        },0);

        txt = findViewById(R.id.txt);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocationService();
            }
        });


    }

    private void startLocationService() {
        long time = 10000;
        float distance = 0;
        LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        try{
            String locationProvider = LocationManager.NETWORK_PROVIDER;
            Location location = locationManager.getLastKnownLocation(locationProvider);
            if(locationManager!=null){
                double latitude = location.getLatitude();
                double longtitude = location.getLongitude();
                txt.setText("최근의 내 위치 : "+latitude+", "+longtitude);
            }
            GPS_Listener gps_listener = new GPS_Listener();
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,time,distance,gps_listener);
            // 기지국 업데이트
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,time,distance,gps_listener);
        }catch (SecurityException e){

        }

    }

    class GPS_Listener implements LocationListener {

        @Override
        public void onLocationChanged(@NonNull Location location) {
            double latitude = location.getLatitude();
            double longtitude = location.getLongitude();
            txt.setText("내 위치 : "+latitude+", "+longtitude);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    }
}