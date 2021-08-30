package com.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test.databinding.FragmentHomeBinding;
import com.example.test.databinding.FragmentPointsBinding;


public class FragmentPoints extends Fragment {
    private FragmentPointsBinding fragmentPointsBinding;
    public static FragmentPoints newInstance() {
        return new FragmentPoints();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentPointsBinding = FragmentPointsBinding.inflate(inflater ,container ,false);
        View view = fragmentPointsBinding.getRoot();
        return view;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentPointsBinding = null;
    }
}
