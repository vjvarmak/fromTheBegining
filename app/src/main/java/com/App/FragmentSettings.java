package com.App;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.App.test.databinding.FragmentHomeBinding;
import com.App.test.databinding.FragmentSettingsBinding;


public class FragmentSettings extends Fragment {
    private FragmentSettingsBinding fragmentSettingsBinding;
    public static FragmentSettings newInstance() {
        return new FragmentSettings();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater ,container ,false);
        return fragmentSettingsBinding.getRoot();

    }
}
