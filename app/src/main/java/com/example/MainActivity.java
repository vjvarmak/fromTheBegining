package com.example;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.test.R;
import com.example.test.databinding.MainActivityBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.test.databinding.TabLayoutBinding;


public class MainActivity extends AppCompatActivity {
private MainActivityBinding mainActivityBinding;
private TabLayoutBinding tabLayoutBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = MainActivityBinding.inflate(getLayoutInflater());
        View view = mainActivityBinding.getRoot();
        setContentView(view);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentHome());
//        tabLayoutBinding.topPanel.setText("Dashboard");

        mainActivityBinding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment =null;

                switch (item.getItemId()){

                    case R.id.home:
                    selectedFragment = new FragmentHome();
                    tabLayoutBinding.topPanel.setText("Dashboard");
                    break;

                    case R.id.resorts:
                        selectedFragment = new FragmentResort();
                        tabLayoutBinding.topPanel.setText("Resorts");
                        break;

                    case R.id.booking:
                        selectedFragment = new FragmentBooking();
                        tabLayoutBinding.topPanel.setText("Booking");
                        break;

                    case R.id.notification:
                        selectedFragment = new FragmentNotification();
                        tabLayoutBinding.topPanel.setText("Notification");
                        break;

                    case R.id.settings:
                        selectedFragment = new FragmentSettings();
                        tabLayoutBinding.topPanel.setText("Settings");
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedFragment).commit();
                return true;
            }
        });
    }
}
