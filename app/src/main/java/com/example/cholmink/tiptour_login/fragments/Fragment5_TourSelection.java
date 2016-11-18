package com.example.cholmink.tiptour_login.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.cholmink.tiptour_login.R;
import com.example.cholmink.tiptour_login.activities.FChildActivity;
import com.skp.Tmap.TMapView;

/**
 * Created by dnay2 on 2016-11-17.
 */

public class Fragment5_TourSelection extends FChildActivity {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tourselection, container, false);

        TMapView tMapView = new TMapView(getActivity().getApplicationContext());
        tMapView.setSKPMapApiKey("52141bc0-08fa-3309-af84-0cfc120c0101");
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setIconVisibility(true);
        tMapView.setZoomLevel(7);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setCompassMode(true);
        tMapView.setTrackingMode(true);
        RelativeLayout main=(RelativeLayout)v.findViewById(R.id.relative_map);
        main.addView(tMapView);
        return v;
    }

}
