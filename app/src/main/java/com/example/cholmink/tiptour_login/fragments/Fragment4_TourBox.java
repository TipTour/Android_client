package com.example.cholmink.tiptour_login.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.cholmink.tiptour_login.R;
import com.example.cholmink.tiptour_login.activities.FChildActivity;
import com.example.cholmink.tiptour_login.adapters.TourBoxAdapter;
import com.example.cholmink.tiptour_login.data.TourBoxItem;

import java.util.ArrayList;

/**
 * Created by dnay2 on 2016-11-17.
 */

public class Fragment4_TourBox extends FChildActivity {

    ArrayList<TourBoxItem> items = new ArrayList<>();
    TourBoxAdapter adapter;
    ListView tourbox;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tourbox, container, false);
        for(int i = 0; i<20 ; i++) items.add(new TourBoxItem());

        tourbox = (ListView) v.findViewById(R.id.tourbox);
        adapter = new TourBoxAdapter(items, getActivity());
        tourbox.setAdapter(adapter);
        return v;
    }
}
