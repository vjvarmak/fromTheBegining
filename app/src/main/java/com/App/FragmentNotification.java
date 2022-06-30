package com.App;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.App.test.databinding.FragmentHomeBinding;
import com.App.test.databinding.FragmentNotificationBinding;


public class FragmentNotification extends Fragment {
    private FragmentNotificationBinding fragmentNotificationBinding;
    public static FragmentNotification newInstance() {
        return new FragmentNotification();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentNotificationBinding = FragmentNotificationBinding.inflate(inflater ,container ,false);
        View view = fragmentNotificationBinding.getRoot();
        return view;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentNotificationBinding = null;
    }
}
