package com.example.allu.srp_psnacet.Connector;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.allu.srp_psnacet.Layout_handler.Admin_panel;
import com.example.allu.srp_psnacet.Layout_handler.Application_forms;
import com.example.allu.srp_psnacet.Layout_handler.Disability_info;
import com.example.allu.srp_psnacet.Layout_handler.Equip_info;
import com.example.allu.srp_psnacet.Layout_handler.Govt_Orders;
import com.example.allu.srp_psnacet.Layout_handler.MainActivity;
import com.example.allu.srp_psnacet.Layout_handler.Org_list;
import com.example.allu.srp_psnacet.R;

/**
 * Created by allu on 7/25/16.
 */
public class Navigation_connector {
    String Tag="Nav Connector";
    public int Id;
    public Context context;
    public Intent i;
    public Navigation_connector(int id,Context activity_context){
        this.context=activity_context;
        switch (id){
            case R.id.feeds:
                Log.d(Tag,"feeds");
                i=new Intent(context, MainActivity.class);
                break;
            case R.id.admin_panel:
                i=new Intent(context, Admin_panel.class);
                Log.d(Tag,"admin Panel");
                break;
            case R.id.forms:
                i= new Intent(context, Application_forms.class);
                Log.d(Tag,"forms");
                break;
            case R.id.go:
                i=new Intent(context, Govt_Orders.class);
                Log.d(Tag,"go");
                break;
            case R.id.equip_info:
                i=new Intent(context, Equip_info.class);
                Log.d(Tag,"eqip Info");
                break;
            case R.id.dis_info:
                i=new Intent(context, Disability_info.class);
                Log.d(Tag,"dis info");
                break;
            case R.id.org_list:
                i=new Intent(context, Org_list.class);
                Log.d(Tag,"org List");
                break;
        }

    }

    public Intent GetIntend(){
        return i;
    }
}
