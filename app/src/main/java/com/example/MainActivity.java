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


public class MainActivity extends AppCompatActivity {
private MainActivityBinding mainActivityBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = MainActivityBinding.inflate(getLayoutInflater());
        View view = mainActivityBinding.getRoot();
        setContentView(view);
        mainActivityBinding.topPanel.setText("Dashboard");

        ViewPager viewPager = mainActivityBinding.viewPager;

        mainActivityBinding.tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new FragmentHome(),"Trips");
        viewPagerAdapter.addFragment(new FragmentPoints(),"Points");
        viewPagerAdapter.addFragment(new FragmentAccount(),"Account");
        viewPager.setAdapter(viewPagerAdapter);


        mainActivityBinding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment =null;

                switch (item.getItemId()){

                    case R.id.home:
                    selectedFragment = new FragmentHome();
                    mainActivityBinding.topPanel.setText("Dashboard");
                    break;

                    case R.id.resorts:
                        selectedFragment = new FragmentResort();
                        mainActivityBinding.topPanel.setText("Resorts");
                        break;

                    case R.id.booking:
                        selectedFragment = new FragmentBooking();
                        mainActivityBinding.topPanel.setText("Booking");
                        break;

                    case R.id.notification:
                        selectedFragment = new FragmentNotification();
                        mainActivityBinding.topPanel.setText("Notification");
                        break;

                    case R.id.settings:
                        selectedFragment = new FragmentSettings();
                        mainActivityBinding.topPanel.setText("Settings");
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedFragment).commit();
                return true;
            }
        });
    }
}
