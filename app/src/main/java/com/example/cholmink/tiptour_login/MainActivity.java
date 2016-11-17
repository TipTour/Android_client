package com.example.cholmink.tiptour_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.skp.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TMapView tMapView = new TMapView(this);
        tMapView.setSKPMapApiKey("52141bc0-08fa-3309-af84-0cfc120c0101");
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setIconVisibility(true);
        tMapView.setZoomLevel(7);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setCompassMode(true);
        tMapView.setTrackingMode(true);
        RelativeLayout main=(RelativeLayout)findViewById(R.id.relative_map);
        main.addView(tMapView);
    }
}
