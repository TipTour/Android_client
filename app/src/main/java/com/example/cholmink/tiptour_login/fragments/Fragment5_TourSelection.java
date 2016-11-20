package com.example.cholmink.tiptour_login.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
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
            tMapView = new TMapView(getContext());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if(tMapView != null){
            tMapView.setSKPMapApiKey("52141bc0-08fa-3309-af84-0cfc120c0101");
            tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
            tMapView.setIconVisibility(true);
            tMapView.setZoomLevel(7);
            tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
            tMapView.setCompassMode(false);
            tMapView.setTrackingMode(true);
            ((RelativeLayout) v.findViewById(R.id.relative_map)).addView(tMapView);
        }

        return v;
    }


    /**
     *
     * 검색을 할때 리스트가 보이게 함
     */
    private TextWatcher searchEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };



}
