package com.example.demoapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_config {
    private static final String BASE_URL="https://api.tvmaze.com";
    private static Retrofit_config mretro;
    private Retrofit retrofit;
    OkHttpClient okHttpClient;



    private Retrofit_config(){
        okHttpClient=new OkHttpClient();
        okHttpClient.setReadTimeout(15, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(15,TimeUnit.SECONDS);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        builder.client(new okhttp3.OkHttpClient());
        retrofit= builder.build();

    }



    public static synchronized  Retrofit_config getInstance(){

        if (mretro==null){
            mretro=new Retrofit_config();
        }
        return mretro;
    }


    public Home_screen_API_interface getApi(){
        return retrofit.create(Home_screen_API_interface.class);
    }


}
