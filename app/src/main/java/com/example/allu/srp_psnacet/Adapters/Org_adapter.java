package com.example.allu.srp_psnacet.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.allu.srp_psnacet.Dataclasses.Equip_class;
import com.example.allu.srp_psnacet.Dataclasses.Org_class;
import com.example.allu.srp_psnacet.R;

import java.util.ArrayList;

/**
 * Created by allu on 8/31/16.
 */
public class Org_adapter extends RecyclerView.Adapter<Org_layout>  {

    Context tContext;
    ArrayList<Org_class> tOrgArray;
    String Tag="Equipment Adapter";

    public Org_adapter(Context context,ArrayList<Org_class> org_classes){
        this.tContext=context;
        this.tOrgArray=org_classes;
    }

    @Override
    public Org_layout onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(tContext).inflate(R.layout.adapter_orglist,parent,false);
        Org_layout org_layout=new Org_layout(v);
        return org_layout;
    }

    @Override
    public void onBindViewHolder(Org_layout holder, int position) {
        Org_class org_class=tOrgArray.get(position);
        holder.heading.setText(org_class.Name);
        holder.desc.setText(org_class.Abus);
        holder.city.setText(org_class.City);

    }

    @Override
    public int getItemCount() {
        return tOrgArray.size();
    }
}

class Org_layout extends RecyclerView.ViewHolder{

    TextView heading,city,desc;
    ImageView feed_pro_pic;
    public Org_layout(View itemView) {
        super(itemView);
        heading=(TextView)itemView.findViewById(R.id.org_heading);
        city=(TextView)itemView.findViewById(R.id.org_city);
        desc=(TextView)itemView.findViewById(R.id.org_desc);
        feed_pro_pic=(ImageView)itemView.findViewById(R.id.org_img);
    }
}