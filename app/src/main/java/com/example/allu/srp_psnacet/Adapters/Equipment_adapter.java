package com.example.allu.srp_psnacet.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.allu.srp_psnacet.Dataclasses.Equip_class;
import com.example.allu.srp_psnacet.R;

import java.util.ArrayList;

/**
 * Created by allu on 8/31/16.
 */
public class Equipment_adapter extends RecyclerView.Adapter<Equipment_layout> {


    Context tContext;
    ArrayList<Equip_class> tEquipArray;
    String Tag="Equipment Adapter";


    public Equipment_adapter(Context context, ArrayList<Equip_class> tEquipArray){
        this.tContext=context;
        this.tEquipArray=tEquipArray;

    }

    @Override
    public Equipment_layout onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(tContext).inflate(R.layout.adapter_equip,parent,false);
        Equipment_layout equipment_layout=new Equipment_layout(v);
        return equipment_layout;
    }

    @Override
    public void onBindViewHolder(Equipment_layout holder, int position) {
        Equip_class tEquip=tEquipArray.get(position);
        holder.heading.setText(tEquip.Name);
        holder.type.setText(tEquip.Types);
        holder.desc.setText(tEquip.Desc);
        Log.d(Tag,"Adapter set");
    }

    @Override
    public int getItemCount() {
        return tEquipArray.size();
    }
}


class Equipment_layout extends RecyclerView.ViewHolder{
    TextView heading,type,desc;
    ImageView feed_pro_pic;
    public Equipment_layout(View itemView) {
        super(itemView);
        heading=(TextView)itemView.findViewById(R.id.equip_heading);
        type=(TextView)itemView.findViewById(R.id.equip_type);
        desc=(TextView)itemView.findViewById(R.id.equip_desc);
        feed_pro_pic=(ImageView)itemView.findViewById(R.id.equip_img);
    }
}