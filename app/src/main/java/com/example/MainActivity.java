package com.example;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.test.R;
import com.example.test.databinding.MainActivityBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private MainActivityBinding mainActivityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = MainActivityBinding.inflate(getLayoutInflater());
        View view = mainActivityBinding.getRoot();
        setContentView(view);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragmentHome()).commitAllowingStateLoss();
        setTitle("Dashboard");

//        tabLayoutBinding.topPanel.setText("Dashboard");


        mainActivityBinding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId()) {

                    case R.id.home:
                        selectedFragment = FragmentHome.newInstance();
                        setTitle("Dashboard");
                        break;

                    case R.id.resorts:
                        selectedFragment = FragmentResort.newInstance();
                        setTitle("Resorts");
                        break;

                    case R.id.booking:
                        selectedFragment = FragmentBooking.newInstance();
                        setTitle("Booking");
                        break;

                    case R.id.notification:
                        selectedFragment = FragmentNotification.newInstance();
                        setTitle("Notification");
                        break;

                    case R.id.settings:
                        selectedFragment = FragmentSettings.newInstance();
                        setTitle("Settings");
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commitAllowingStateLoss();
                return true;
            }
        });
    }

    private void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
