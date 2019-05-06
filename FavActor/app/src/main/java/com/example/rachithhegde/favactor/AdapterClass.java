package com.example.rachithhegde.favactor;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends
        RecyclerView.Adapter<AdapterClass.MyViewHolder> {

    private final Context cont;
    private List<ModelClass> favlist;

    /**
     * View holder class
     * */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView ActorName;
        public TextView MovieName;
        ImageView ActorImage;


        public MyViewHolder(View view) {
            super(view);
            ActorName = (TextView) view.findViewById(R.id.aname);
            MovieName = (TextView) view.findViewById(R.id.mname);
            ActorImage = (ImageView) view.findViewById(R.id.aimage);
        }
    }

    public AdapterClass(List<ModelClass> fav, Context applicationContext) {
        this.favlist = fav;
        this.cont = applicationContext;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ModelClass f = favlist.get(position);
        holder.ActorName.setText(f.getActorName());
        holder.MovieName.setText(f.getMovies());

        Log.d("ImageURL:",""+f.getImageUrl());


        if(f.getImageUrl()!=""&&f.getImageUrl()!=null){
            Picasso.with(cont).load(favlist.get(position).getImageUrl()).into(holder.ActorImage);

        }
        else{
            holder.ActorImage.setImageResource(R.drawable.ic_image_black_24dp);
        }


    }

    @Override
    public int getItemCount() {
        return favlist.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favrow,parent, false);
        return new MyViewHolder(v);
    }
}
