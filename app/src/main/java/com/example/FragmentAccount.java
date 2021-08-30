package com.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test.databinding.FragmentAccountBinding;
import com.example.test.databinding.FragmentHomeBinding;


public class FragmentAccount extends Fragment {
    private FragmentAccountBinding fragmentAccountBinding;
    public static FragmentAccount newInstance() {
        return new FragmentAccount();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentAccountBinding = FragmentAccountBinding.inflate(inflater ,container ,false);
        View view = fragmentAccountBinding.getRoot();
        return view;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentAccountBinding = null;
    }
}
