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
    List<Main_recycle_model_class> content_names=new ArrayList<>();
    List<String> names=new ArrayList<>();
    List<String> drama_items=new ArrayList<>();
    Context ctx;


    public Main_scroll_adapter_class(List<Main_recycle_model_class> content_names, List<String> names, List<String> drama_items, Context ctx) {
        this.content_names = content_names;
        this.names = names;
        this.drama_items = drama_items;
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

            if(content_names.get(position).getGenres().get(0).toLowerCase().equals("action")){
                holder.textView_catry_name.setText(content_names.get(position).getGenres().get(0));
                inner_content_adapter adapter = new inner_content_adapter(names,ctx);
                holder.recyclerView.setAdapter(adapter);


            }
           else if(content_names.get(position).getGenres().get(0).toLowerCase().equals("drama")){
                holder.textView_catry_name.setText(content_names.get(position).getGenres().get(0));
                inner_content_adapter adapter = new inner_content_adapter(drama_items,ctx);
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
