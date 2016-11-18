package com.example.cholmink.tiptour_login.data;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by dnay2 on 2016-11-18.
 */

public class StaticData {

    private static StaticData instance;
    public static StaticData getInstance(){
        return instance;
    }
    static {instance = new StaticData();}

    private int width, height;

    public void setDisplayPixels(Context context){
        width = context.getResources().getDisplayMetrics().widthPixels;
        height = context.getResources().getDisplayMetrics().heightPixels;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }



    public Typeface font1;
    public Typeface font2;





}
