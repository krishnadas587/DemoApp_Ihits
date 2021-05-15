package com.example.demoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_scroll_adapter_class  extends RecyclerView.Adapter<Main_scroll_adapter_class.ViewHolder> {
    List<String> content_names=new ArrayList<>();
    List<String> names=new ArrayList<>();
    List<String> drama_items=new ArrayList<>();
    List<String> horror=new ArrayList<>();
    List<String> anime=new ArrayList<>();
    List<String> comedy=new ArrayList<>();
    List<String> adventure=new ArrayList<>();
    List<String> music=new ArrayList<>();
    List<String> crime=new ArrayList<>();
    List<String> romance=new ArrayList<>();
    List<String> war=new ArrayList<>();
    Context ctx;


    public Main_scroll_adapter_class(List<String> content_names, List<String> names, List<String> drama_items, List<String> horror, List<String> anime, List<String> comedy, List<String> adventure, List<String> music, List<String> crime, List<String> romance, List<String> war, Context ctx) {
        this.content_names = content_names;
        this.names = names;
        this.drama_items = drama_items;
        this.horror = horror;
        this.anime = anime;
        this.comedy = comedy;
        this.adventure = adventure;
        this.music = music;
        this.crime = crime;
        this.romance = romance;
        this.war = war;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public Main_scroll_adapter_class.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(ctx).inflate(R.layout.home_screen_recycle_layout,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Main_scroll_adapter_class.ViewHolder holder, int position) {
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(ctx, 1);


//        List<String> action_items=new ArrayList<>();
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(ctx,LinearLayoutManager.HORIZONTAL,false));
        try {

            if(content_names.get(position).toLowerCase().equals("action")){
                holder.textView_catry_name.setText(content_names.get(position));
                inner_content_adapter adapter = new inner_content_adapter(names,ctx);
                holder.recyclerView.setAdapter(adapter);


            }
           else if(content_names.get(position).toLowerCase().equals("drama")){
                holder.textView_catry_name.setText(content_names.get(position));
                inner_content_adapter adapter = new inner_content_adapter(drama_items,ctx);
                holder.recyclerView.setAdapter(adapter);

            }
            else if(content_names.get(position).toLowerCase().equals("horror")){
                holder.textView_catry_name.setText(content_names.get(position));
                inner_content_adapter adapter = new inner_content_adapter(horror,ctx);
                holder.recyclerView.setAdapter(adapter);

            }
            else if(content_names.get(position).toLowerCase().equals("anime")){
                holder.textView_catry_name.setText(content_names.get(position));
                inner_content_adapter adapter = new inner_content_adapter(anime,ctx);
                holder.recyclerView.setAdapter(adapter);

            }
            else if(content_names.get(position).toLowerCase().equals("comedy")){
                holder.textView_catry_name.setText(content_names.get(position));
                inner_content_adapter adapter = new inner_content_adapter(comedy,ctx);
                holder.recyclerView.setAdapter(adapter);

            }
            else if(content_names.get(position).toLowerCase().equals("adventure")){
                holder.textView_catry_name.setText(content_names.get(position));
                inner_content_adapter adapter = new inner_content_adapter(adventure,ctx);
                holder.recyclerView.setAdapter(adapter);

            }
            else if(content_names.get(position).toLowerCase().equals("music")){
                holder.textView_catry_name.setText(content_names.get(position));
                inner_content_adapter adapter = new inner_content_adapter(music,ctx);
                holder.recyclerView.setAdapter(adapter);

            }
            else if(content_names.get(position).toLowerCase().equals("crime")){
                holder.textView_catry_name.setText(content_names.get(position));
                inner_content_adapter adapter = new inner_content_adapter(crime,ctx);
                holder.recyclerView.setAdapter(adapter);

            }
            else if(content_names.get(position).toLowerCase().equals("romance")){
                holder.textView_catry_name.setText(content_names.get(position));
                inner_content_adapter adapter = new inner_content_adapter(romance,ctx);
                holder.recyclerView.setAdapter(adapter);

            }
            else if(content_names.get(position).toLowerCase().equals("war")){
                holder.textView_catry_name.setText(content_names.get(position));
                inner_content_adapter adapter = new inner_content_adapter(war,ctx);
                holder.recyclerView.setAdapter(adapter);

            }


        }catch (Exception e){

        }






    }

    @Override
    public int getItemCount() {
        return content_names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_catry_name;
        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_catry_name=itemView.findViewById(R.id.Movie_category_name);
            recyclerView=itemView.findViewById(R.id.inner_horizontal_scroll_recycle);

        }
    }
}
