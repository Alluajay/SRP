package com.example.allu.srp_psnacet.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.allu.srp_psnacet.Dataclasses.feed_class;
import com.example.allu.srp_psnacet.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by allu on 7/26/16.
 */
public class Feed_adapter extends RecyclerView.Adapter<feed_layout> {

    public Context ApplicationContext;
    public ArrayList<feed_class> Feeds;

    public Feed_adapter(Context context,ArrayList<feed_class> feed){
        this.ApplicationContext=context;
        Feeds=feed;
    }


    @Override
    public feed_layout onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ApplicationContext).inflate(R.layout.feed_layout,parent,false);
        feed_layout ls=new feed_layout(v);
        return ls;
    }

    @Override
    public void onBindViewHolder(feed_layout holder, int position) {
        feed_class fc=Feeds.get(position);
        HashMap<String,String> fv=fc.getfeed();
        holder.heading.setText(fv.get("head"));
        holder.desc.setText(fv.get("desc"));
        holder.type.setText(fv.get("type"));

        int au= Integer.parseInt(fv.get("auth"));
        if(au==0){
            //off star
        }else {
            //glow star
        }

    }

    @Override
    public int getItemCount() {
        return Feeds.size();
    }
}

class feed_layout extends RecyclerView.ViewHolder{
    TextView heading,type,desc;
    ImageView feed_pro_pic;
    public feed_layout(View itemView) {
        super(itemView);
        heading=(TextView)itemView.findViewById(R.id.feed_heading);
        type=(TextView)itemView.findViewById(R.id.feed_type);
        desc=(TextView)itemView.findViewById(R.id.feed_desc);
        feed_pro_pic=(ImageView)itemView.findViewById(R.id.feed_img);
    }
}