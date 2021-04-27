package com.example.mainactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class ControlCarActivity extends AppCompatActivity {

    private Button forwardButton;
    private Button backwardButton;
    private Button leftButton;
    private Button rightButton;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        setTitle("Control Car");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_car);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_mainMenu:
                        Intent intent1 = new Intent(ControlCarActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav_connectCar:
                        Intent intent2 = new Intent(ControlCarActivity.this, ConnectCarActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_controlCar:
                        break;

                    case R.id.nav_settings:
                        Intent intent3 = new Intent(ControlCarActivity.this, SettingsActivity.class);
                        startActivity(intent3);
                        break;
                }

                return false;
            }
        });

        drawer = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
}