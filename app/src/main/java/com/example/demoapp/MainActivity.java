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
                   List<String> names=new ArrayList<>();
                   for (Main_recycle_model_class ls: response.body()){
                       try {
                           if(ls.getGenres().get(0).toLowerCase().equals("action")){
                               action_items.add(ls.getImage().getMedium());
                           }
                           if (ls.getGenres().get(0).toLowerCase().equals("drama")){
                               drama_items.add(ls.getImage().getMedium());
                           }
                       }catch (Exception e){

                       }
                   }
                   Main_scroll_adapter_class adapter = new Main_scroll_adapter_class(response.body(),action_items,drama_items,MainActivity.this);
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