package com.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test.databinding.FragmentHomeBinding;
import com.example.test.databinding.FragmentResortsBinding;


public class FragmentResort extends Fragment {
    private FragmentResortsBinding fragmentResortsBinding;
    public static FragmentResort newInstance() {
        return new FragmentResort();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentResortsBinding = FragmentResortsBinding.inflate(inflater ,container ,false);
        View view = fragmentResortsBinding.getRoot();
        return view;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentResortsBinding = null;
    }
}
