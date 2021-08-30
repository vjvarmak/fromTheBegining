package com.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test.databinding.FragmentBookingBinding;
import com.example.test.databinding.FragmentHomeBinding;


public class FragmentBooking extends Fragment {
    private FragmentBookingBinding fragmentBookingBinding;
    public static FragmentBooking newInstance() {
        return new FragmentBooking();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentBookingBinding = FragmentBookingBinding.inflate(inflater ,container ,false);
        View view = fragmentBookingBinding.getRoot();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentBookingBinding = null;
    }
}
