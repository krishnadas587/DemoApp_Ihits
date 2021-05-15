package com.example.demoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class inner_content_adapter extends RecyclerView.Adapter<inner_content_adapter.Viewholder> {
    List<String> image_names=new ArrayList<>();
    Context ctx;

    public inner_content_adapter(List<String> image_names, Context ctx) {
        this.image_names = image_names;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public inner_content_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(ctx).inflate(R.layout.home_screen_recycle_inner_horizontal,null,false);
        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull inner_content_adapter.Viewholder holder, int position) {

        System.out.println("medium"+image_names.get(position));
        Glide.with(ctx).load(image_names.get(position)).into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"clicked"+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return image_names.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView img;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imageviews);

        }
    }
}
