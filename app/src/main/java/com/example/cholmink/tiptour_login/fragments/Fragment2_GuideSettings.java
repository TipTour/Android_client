package com.example.cholmink.tiptour_login.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cholmink.tiptour_login.R;
import com.example.cholmink.tiptour_login.activities.FChildActivity;

/**
 * Created by dnay2 on 2016-11-17.
 */

public class Fragment2_GuideSettings extends FChildActivity {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, container, false);
        return v;
    }
}
