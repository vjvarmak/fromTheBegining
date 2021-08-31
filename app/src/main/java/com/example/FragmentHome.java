package com.example;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.databinding.FragmentHomeBinding;
import com.example.test.databinding.MainActivityBinding;
import com.example.test.databinding.TabLayoutBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.zip.Inflater;


public class FragmentHome extends Fragment {
    private FragmentHomeBinding fragmentHomeBinding;
    private MainActivityBinding mainActivityBinding;
    private TabLayoutBinding tabLayoutBinding;

    public static FragmentHome newInstance() {
        return new FragmentHome();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater ,container ,false);
        View view = fragmentHomeBinding.getRoot();
        return view;
//        tabLayoutBinding.tabLayout.setVisibility(view.VISIBLE);
//        tabLayoutBinding.tabLayout.setupWithViewPager(mainActivityBinding.viewPager);
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        viewPagerAdapter.addFragment(new FragmentHome(),"Trips");
//        viewPagerAdapter.addFragment(new FragmentPoints(),"Points");
//        viewPagerAdapter.addFragment(new FragmentAccount(),"Account");
//        mainActivityBinding.viewPager.setAdapter(viewPagerAdapter);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentHomeBinding = null;
    }
}
