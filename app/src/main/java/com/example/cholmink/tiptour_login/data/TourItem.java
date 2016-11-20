package com.example.cholmink.tiptour_login.data;

/**
 * Created by dnay2 on 2016-11-18.
 */

public class TourItem {

    private String name;
    private String detail;

    public TourItem(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }
}
