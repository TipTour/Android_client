package com.example.cholmink.tiptour_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.cholmink.tiptour_login.data.TravelInfo;
import com.skp.Tmap.TMapData;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapPolyLine;
import com.skp.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {
    TravelInfo travelInfo = new TravelInfo();
    double distanceshow;
    double timeshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TMapView tMapView = new TMapView(this);
        tMapView.setSKPMapApiKey("52141bc0-08fa-3309-af84-0cfc120c0101");
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setIconVisibility(true);
        tMapView.setZoomLevel(7);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setCompassMode(true);
        tMapView.setTrackingMode(true);
        RelativeLayout main=(RelativeLayout)findViewById(R.id.relative_map);
        main.addView(tMapView);

        final TMapData tMapData = new TMapData();
        final TMapPoint startpoint = new TMapPoint(37.570841, 126.985302);
        final TMapPoint endpoint = new TMapPoint(37.670841, 126.995302);
        tMapData.findPathDataWithType(TMapData.TMapPathType.PEDESTRIAN_PATH, startpoint, endpoint, new TMapData.FindPathDataListenerCallback() {
            @Override
            public void onFindPathData(TMapPolyLine tMapPolyLine) {
                tMapView.addTMapPath(tMapPolyLine);
                double Distance = tMapPolyLine.getDistance();
                double time = Distance/1.2;
                Log.i("MyTag", "거리:"+Distance);
                Log.i("MyTag", "시간:"+time);
                travelInfo.setDistance(Distance);
                travelInfo.setTime(time);
                distanceshow = Distance;
                timeshow = time;

            }
        });
        Toast.makeText(MainActivity.this, "총 소요 거리:"+ distanceshow+ "총 소요 시간:"+timeshow, Toast.LENGTH_SHORT).show();
//        TMapPolyLine tMapPolyLine = new TMapPolyLine();
//        tMapPolyLine.setLineColor(Color.BLUE);
//        tMapPolyLine.setLineWidth(2);
//        tMapPolyLine.addLinePoint(startpoint);
//        tMapPolyLine.addLinePoint(endpoint);
//


    }
}
