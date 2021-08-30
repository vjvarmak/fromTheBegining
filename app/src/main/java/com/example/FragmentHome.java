package com.example;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.databinding.FragmentHomeBinding;
import com.example.test.databinding.MainActivityBinding;

import java.util.zip.Inflater;


public class FragmentHome extends Fragment {
    private FragmentHomeBinding fragmentHomeBinding;
    private MainActivityBinding mainActivityBinding;
    public static FragmentHome newInstance() {
        return new FragmentHome();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater ,container ,false);
        View view = fragmentHomeBinding.getRoot();
        return view;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentHomeBinding = null;
    }
}
