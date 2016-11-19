package com.example.cholmink.tiptour_login.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.cholmink.tiptour_login.R;
import com.example.cholmink.tiptour_login.activities.FChildActivity;
import com.example.cholmink.tiptour_login.data.StaticData;
import com.skp.Tmap.TMapView;

/**
 * Created by dnay2 on 2016-11-17.
 */

public class Fragment5_TourSelection extends FChildActivity {

    private StaticData mData = StaticData.getInstance();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tourselection, container, false);
        TMapView tMapView = null;
        try {
            tMapView = new TMapView(mData.get);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if(tMapView != null){
            tMapView.setSKPMapApiKey("52141bc0-08fa-3309-af84-0cfc120c0101");
            tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
            tMapView.setIconVisibility(true);
            tMapView.setZoomLevel(7);
            tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
            tMapView.setCompassMode(true);
            tMapView.setTrackingMode(true);
            ((RelativeLayout) v.findViewById(R.id.relative_map)).addView(tMapView);
        }

        return v;
    }

}
