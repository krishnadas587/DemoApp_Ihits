package com.example.demoapp;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main_recycle_model_class {

   String name;
   List<String> genres;

   image_models image;

    public String getName() {
        return name;
    }

    public List<String> getGenres() {
        return genres;
    }

    public image_models getImage() {
        return image;
    }
}