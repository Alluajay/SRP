package com.example.allu.srp_psnacet.Layout_handler;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.allu.srp_psnacet.Adapters.Org_adapter;
import com.example.allu.srp_psnacet.Connector.Navigation_connector;
import com.example.allu.srp_psnacet.Dataclasses.Org_class;
import com.example.allu.srp_psnacet.R;

import java.util.ArrayList;

public class Org_list extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView Org_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Org_list=(RecyclerView)findViewById(R.id.Org_list);
        Org_list.setHasFixedSize(true);
        Org_list.setLayoutManager(new GridLayoutManager(this,1));
        Org_list.setItemAnimator(new DefaultItemAnimator());


        Org_adapter org_adapter=new Org_adapter(this,getArray());

        Org_list.setAdapter(org_adapter);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Navigation_connector navigation_connector=new Navigation_connector(id,this);
        Intent i=navigation_connector.GetIntend();
        startActivity(i);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public ArrayList<Org_class> getArray(){
        ArrayList<Org_class> orgArray=new ArrayList<>();

        Org_class org_class=new Org_class("Alpha", "Alpha to Omega Learning Centre\r\n16, Valliammal Street,\r\n", "chennai", "This is a non profitable organisation which helps physically chalenged students to learn in their natural environment", "", 446443090, 44616257, "krishenterprises@gems.vsnl.net.in");
        Org_class org_class1=new Org_class( "Helen keller service society for the disabled", "Helen Keller Service Society for the Disabled\r\nVizhiyagam, Viswanathapuram,\r\n", "madurai", "This is a non?profit, charitable, voluntary organization established in the year 1979. The organization implements service projects for the welfare of the disabled in Tamil Nadu, founded by Dr. G Thiruvasagam for the service of people in the field of welfare of the disabled in rural areas.\r\n", "", 452641446, 452640735, "hkssd@md3.vsnl.net.in");
        Org_class org_class2=new Org_class( "Amar Seva Sangam", "Amar Seva Sangam\r\nSulochana Gardens, Post Box No. 001, Tenkasi Road,\r\nAyikudi", "Dindigul", "Physically challenged children from the age of five to seventeen are provided with free shelter, food, clothing, medical aid and appliances at our Home so that they can pursue their education at our School without any financial worry. If they opt for higher education outside the campus, they are also provided free transport. The children are also given special coaching.\r\n", "",448274035, 8240402, "amarseva@md3.vsnl.net.in");

        orgArray.add(org_class);
        orgArray.add(org_class1);
        orgArray.add(org_class2);
        return orgArray;
    }
}
