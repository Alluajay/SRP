package com.example.allu.srp_psnacet.Layout_handler;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.allu.srp_psnacet.Adapters.Disability_adapter;
import com.example.allu.srp_psnacet.Adapters.Feed_adapter;
import com.example.allu.srp_psnacet.Connector.Navigation_connector;
import com.example.allu.srp_psnacet.Dataclasses.Dis_class;
import com.example.allu.srp_psnacet.Dataclasses.Feed_class;
import com.example.allu.srp_psnacet.Interfaces.Feed_click_interface;
import com.example.allu.srp_psnacet.R;

import java.util.ArrayList;

public class Disability_info extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public RecyclerView DisList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disability_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DisList=(RecyclerView)findViewById(R.id.dis_list);

        Disability_adapter adapter=new Disability_adapter(this,getArray());

        DisList.setLayoutManager(new GridLayoutManager(this,1));
        DisList.setItemAnimator(new DefaultItemAnimator());
        DisList.setHasFixedSize(true);
        DisList.setAdapter(adapter);
        //feed trail ends


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
    public ArrayList<Dis_class> getArray(){
        ArrayList<Dis_class> DisArray = new ArrayList<>();

        Dis_class disClass1=new Dis_class("AMPUTATION ", "An amputation is the surgical removal of part of the body, usually an arm or leg.The most common reason for amputation is a loss of blood supply to the affected limb , which accounts for 70% of lower limb amputations. Trauma is the most common reason for upper limb amputation, which accounts for 57%.","lower limb amputation,upper limb amputation","The limb has been affected by gangrene (when the body's tissue begins to die as a result of loss of blood supply)\n" +
                "The limb poses a life-threatening danger to the person's health, for example because it has been affected by cancer or a serious infection\n" +
                "The limb has experienced serious trauma, such as a crush or blast wound\n" +
                "People with either type 1 diabetes or type 2 diabetes are particularly at risk and are 15 times more likely to need an amputation \n" +
                "The high blood glucose levels in diabetes can damage blood vessels, leading to a restriction in blood supply.\n" +
                "More than half of all amputations are performed in people aged 70 or over and men are twice as likely to need an amputation as women.","abdominal pain,swelling\n" +
                "back pain,bloody stool,blurred vision\n" +
                "chest pain,fatigue,nausea\n" +
                "leg pain,fever,diarrhea.","Prosthetics\n" +
                "\n" +
                "After the amputation, it may be possible to fit a prosthetic (artificial) limb onto the remaining stump. Prosthetic limbs have become increasingly sophisticated and can reproduce many functions of the hands, arms and legs.\n" +
                "For example, many people who have had the foot and lower section of the leg from beneath the knee removed (transtibial amputation) can walk or ride a bike using a prosthetic limb.\n" +
                "However, adjusting to life with a prosthetic limb requires an extensive course of physiotherapy and rehabilitation. Also, it takes a lot more physical energy to use a prosthetic limb as your  body has to compensate for the missing muscle and bone. This is why frail people or those with a serious health condition, such as heart disease, may not be suitable for a prosthetic limb.\n");
        DisArray.add(disClass1);

        Dis_class dis_class=new Dis_class("BLINDNESS"," Blindness can be temporary or permanent. Damage to any portion of the eye, the optic nerve, or the area of the brain responsible for vision can lead to blindness. There are numerous (actually, innumerable) causes of blindness. The current politically correct terms for blindness include visually handicapped and visually challenged.\n",
                "night blindness,color blindness","Accidents or injuries to the surface of the eye (such as chemical burns or sports injuries)\n" +
                "Diabetes\n" +
                "Glaucoma\n" +
                "Macular degeneration\n" +
                "With cataracts, vision may be cloudy or fuzzy, and bright light may cause glare\n" +
                "With diabetes, vision may be blurred, there may be shadows or missing areas of vision, and difficulty seeing at night\n" +
                "With glaucoma, there may be tunnel vision and missing areas of vision\n" +
                "With macular degeneration, the side vision is normal but the central vision is slowly lost\n" +
                "Blocked blood vessels\n" +
                "Complications of premature birth (retrolental fibroplasia)\n" +
                "Complications of eye surgery\n" +
                "Lazy eye\n" +
                "Optic neuritis\n" +
                "Stroke\n" +
                "Retinitis pigmentosa\n" +
                "Tumors such as retinoblastoma and optic glioma","constant eye rubbing.\n" +
                "an extreme sensitivity to light.\n" +
                "poor focusing.\n" +
                "chronic eye redness.\n" +
                "chronic tearing from their eyes.\n" +
                "a white instead of a black pupil.\n" +
                "poor visual tracking, or trouble following an object with their eyes.",
                "1. What you eat matters for your eye health.\n" +
                        "\"you aim to get nutrients from food\"\n" +
                        "vitamin A found in bright yellow and orange vegetables\n" +
                        "strawberries\n" +
                        "cold water fish\n" +
                        "2. You can help preserve your eyesight by protecting your eyes from the sun.\n" +
                        "sunscreen and sunglasses these two are safeguards for your eye.\n" +
                        "3.Working on a computer all day can give you dry eyes. \n" +
                        "when we do things up close, we don’t blink as much ,\n" +
                        "The breakdown of the oily and mucous layers of the eyes keeps tears from evaporating, and the eye compensates by producing more water\n" +
                        "4.Diabetes is the top cause of blindness.\n" +
                        "Controlling blood sugar, blood pressure, and cholesterol can prevent the disease");
        DisArray.add(dis_class);


        return DisArray;
    }
}
