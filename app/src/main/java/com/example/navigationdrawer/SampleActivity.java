package com.example.navigationdrawer;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class SampleActivity extends AppCompatActivity {

    DrawerLayout myDrawer;
    ActionBarDrawerToggle NavigationBar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        myDrawer = findViewById(R.id.drawer);
        NavigationBar = new ActionBarDrawerToggle(this,myDrawer,R.string.OPEN,R.string.CLOSE);
        myDrawer.addDrawerListener(NavigationBar);
        NavigationBar.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.repo:
                    Intent repo_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/BilalJaved15/MC_NavigationDrawer"));
                    startActivity(repo_intent);
                    return true;
                case R.id.exit:
                    finish();
                    System.exit(0);
                    return true;
                case R.id.switchActivity:
                    Intent addContact = new Intent(SampleActivity.this,MainActivity.class);
                    startActivity(addContact);
                    return true;
                default:
                    return true;
            }
        });
    }
}