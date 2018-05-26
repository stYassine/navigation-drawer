package com.example.yassine.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout main_drawable;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_drawable);

        main_drawable =(DrawerLayout) findViewById(R.id.main_drawable);
        navigationView =(NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        toolbar =(Toolbar) findViewById(R.id.main_toolbar);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this, main_drawable, toolbar, R.string.open_drawer, R.string.close_drawer);
        main_drawable.addDrawerListener(toggle);
        toggle.syncState();



    }

    @Override
    public void onBackPressed() {

        if(main_drawable.isDrawerOpen(Gravity.START)){
            main_drawable.closeDrawer(Gravity.START);
        }else{
            super.onBackPressed();
       }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.mn_inbox: showText("Inbox");
                break;
            case R.id.mn_starred: showText("Starred");
                break;
            case R.id.mn_sent: showText("Sent Mail");
                break;
            case R.id.mn_draft: showText("Drafts");
                break;
            case R.id.mn_all_mail: showText("All Mail");
                break;
            case R.id.mn_trash: showText("Trash");
                break;
            case R.id.mn_spam: showText("Spam");
                break;
        }
        main_drawable.closeDrawer(Gravity.START);
        return false;
    }


    public void showText(String title){
        Toast.makeText(this, title, Toast.LENGTH_LONG).show();
    }

}
