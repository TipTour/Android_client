package com.example.cholmink.tiptour_login;


import com.example.cholmink.tiptour_login.data.Content;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkService {
    @Headers("Content-Type:application/json")
    @POST("/contents")
    Call<Content> newContent(@Body Content content);
    @Headers("Content-Type:application/json")
    @POST("/thumbnails")
    Call<Content> newThumbnail(@Body Content loggingin);

}
