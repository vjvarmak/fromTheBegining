package com.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test.databinding.FragmentAccountBinding;
import com.example.test.databinding.FragmentTripsBinding;


public class FragmentTrips extends Fragment {
    private FragmentTripsBinding fragmentTripsBinding;
    public static FragmentTrips newInstance() {
        return new FragmentTrips();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentTripsBinding = FragmentTripsBinding.inflate(inflater ,container,false);
        return fragmentTripsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // fragmentTripsBinding = null;
    }
}
