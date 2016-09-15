package com.example.allu.srp_psnacet.Layout_handler;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.allu.srp_psnacet.Adapters.Feed_adapter;
import com.example.allu.srp_psnacet.Connector.Navigation_connector;
import com.example.allu.srp_psnacet.Dataclasses.Feed_class;
import com.example.allu.srp_psnacet.Interfaces.Feed_click_interface;
import com.example.allu.srp_psnacet.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Context context;
    Button SOS;
    int flag = 0, flag1 = 0, flag2 = 0;
    RecyclerView Feed_list;
    String Tag="Mainactivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this.getApplicationContext();
        SOS = (Button) findViewById(R.id.SOS);

        //feed trail starts
        Feed_list=(RecyclerView)findViewById(R.id.feed_list);

        ArrayList<Feed_class> feed_array=new ArrayList<>();
         Feed_class feedClass=new Feed_class("Karun","Paralysis","I am a java programmer looking forward to start a coaching center in Dindigul.I need support both financially and physically to set up the institution","",871237123);
         Feed_class feedClass1=new Feed_class("Mani","Blind","Greetings to all.Iam Mani and i am blind.I am good at singing so if there is any chance of shoowing my talent please contact me ","",23432435);
         Feed_class feedClass2=new Feed_class("Naren","Deaf","I am good at cooking. if i get a cooking job it will be very helpful","",4321231);
        feed_array.add(feedClass);
        feed_array.add(feedClass1);
        feed_array.add(feedClass2);
        Feed_click_interface clickInterface=new Feed_click_interface() {
            @Override
            public void FeedClicked(int position, Feed_class feedclass) {
                Intent i=new Intent(MainActivity.this,Detailed_activity.class);
                Bundle extras=new Bundle();
                extras.putParcelable("com.package.Feed_class",feedclass);
                i.putExtras(extras);
                Log.d(Tag,"feed "+position+" clicked");
                startActivity(i);
            }
        };

        Feed_adapter adapter=new Feed_adapter(this,feed_array,clickInterface);

        Feed_list.setLayoutManager(new GridLayoutManager(this,1));
        Feed_list.setItemAnimator(new DefaultItemAnimator());
        Feed_list.setHasFixedSize(true);
        Feed_list.setAdapter(adapter);
        //feed trail ends

        SOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 Uri callUri = Uri.parse("tel://108");
                 Intent callIntent = new Intent(Intent.ACTION_DIAL, callUri);
                 callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                 Log.d("call", "done");
                 startActivity(callIntent);
                 **/
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage("1234", null, "alert", null, null);
                Log.d("message", "sent");
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        if (flag == 2 && flag1 == 1 && flag2 == 2) {
            Uri callUri = Uri.parse("tel://108");
            Intent callIntent = new Intent(Intent.ACTION_CALL, callUri);
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_USER_ACTION);
            flag = 0;
            flag1 = 0;
            flag2 = 0;
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return true;
            }
            startActivity(callIntent);
        }
        if(flag==2){
            flag1=1;
            Log.d("flag1",flag1+"");


        }
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO
                    flag++;
                    if(flag==3){
                        flag=0;
                    }
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    if(flag1==1){
                        flag2++;
                    }if(flag2==3){
                        flag1=0;
                    }

                    //TODO
                }
                return true;

            default:
                return super.dispatchKeyEvent(event);
        }
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
}
