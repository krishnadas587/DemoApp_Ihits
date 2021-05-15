package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView Home_screen_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Home_screen_recycle=findViewById(R.id.Main_vertical_scroll);
        load_content(Home_screen_recycle);

    }
    void load_content(RecyclerView recyclerView){


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        Call<List<Main_recycle_model_class>> read_data=Retrofit_config.getInstance().getApi().getitems_by_names();
        read_data.enqueue(new Callback<List<Main_recycle_model_class>>() {
            @Override
            public void onResponse(Call<List<Main_recycle_model_class>> call, Response<List<Main_recycle_model_class>> response) {
               if(response.isSuccessful()&&!response.body().isEmpty()){
                   System.out.println("yess");
                   List<String> action_items=new ArrayList<>();
                   List<String> drama_items=new ArrayList<>();
                   List<String> horror_items=new ArrayList<>();
                   List<String> Anime_items=new ArrayList<>();
                   List<String> Comedy_items=new ArrayList<>();
                   List<String> Adventure_items=new ArrayList<>();
                   List<String> Music_items=new ArrayList<>();
                   List<String> crime_items=new ArrayList<>();
                   List<String> Romance_items=new ArrayList<>();
                   List<String> war_items=new ArrayList<>();
                   List<String> names=new ArrayList<>();
                   for (Main_recycle_model_class ls: response.body()){
                       try {
                           if(!names.contains(ls.getGenres().get(0))){
                               names.add(ls.getGenres().get(0));

                           }


                       }catch (Exception e){

                       }
                   }

                   for (String nn:names){
                       System.out.println(nn);
                       for (Main_recycle_model_class lss :response.body()){
                           try {
                               if(lss.getGenres().get(0).toLowerCase().equals("action")){
                                   action_items.add(lss.getImage().getMedium());
                               }
                               if (lss.getGenres().get(0).toLowerCase().equals("drama")){
                                   drama_items.add(lss.getImage().getMedium());
                               }
                               if (lss.getGenres().get(0).toLowerCase().equals("horror")){
                                   horror_items.add(lss.getImage().getMedium());
                               }
                               if (lss.getGenres().get(0).toLowerCase().equals("anime")){
                                   Anime_items.add(lss.getImage().getMedium());
                               }
                               if (lss.getGenres().get(0).toLowerCase().equals("comedy")){
                                   Comedy_items.add(lss.getImage().getMedium());
                               }
                               if (lss.getGenres().get(0).toLowerCase().equals("adventure")){
                                   Adventure_items.add(lss.getImage().getMedium());
                               }
                               if (lss.getGenres().get(0).toLowerCase().equals("music")){
                                   Music_items.add(lss.getImage().getMedium());
                               }
                               if (lss.getGenres().get(0).toLowerCase().equals("crime")){
                                   crime_items.add(lss.getImage().getMedium());
                               }
                               if (lss.getGenres().get(0).toLowerCase().equals("romance")){
                                   Romance_items.add(lss.getImage().getMedium());
                               }
                               if (lss.getGenres().get(0).toLowerCase().equals("war")){
                                   war_items.add(lss.getImage().getMedium());
                               }
                           }catch (Exception ee){

                           }


                       }

                   }


                   Main_scroll_adapter_class adapter = new Main_scroll_adapter_class(names,action_items,drama_items,horror_items,Anime_items,Comedy_items,Adventure_items,Music_items,crime_items,Romance_items,war_items,MainActivity.this);
                   recyclerView.setAdapter(adapter);
               }

            }

            @Override
            public void onFailure(Call<List<Main_recycle_model_class>> call, Throwable t) {
                System.out.println("Nooo");
            }
        });




    }
}