package com.example.demoapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Home_screen_API_interface {

    @GET("/shows")
    Call<List<Main_recycle_model_class>> getitems_by_names();
}
