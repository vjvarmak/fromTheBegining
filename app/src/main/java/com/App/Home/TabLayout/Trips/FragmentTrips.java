package com.App.Home.TabLayout.Trips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.App.test.R;
import com.App.test.databinding.FragmentTripsBinding;

import java.util.ArrayList;


public class FragmentTrips extends Fragment{
    private FragmentTripsBinding fragmentTripsBinding;
    private ArrayList<TripData> tripDataArrayList;
    public static FragmentTrips newInstance() {
        return new FragmentTrips();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentTripsBinding = FragmentTripsBinding.inflate(inflater ,container,false);
        tripDataArrayList = tripData();
        TripListAdapter tripListAdapter = new TripListAdapter(tripDataArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        fragmentTripsBinding.recview.setAdapter(tripListAdapter);
        fragmentTripsBinding.recview.setLayoutManager(layoutManager);
        return fragmentTripsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private ArrayList<TripData> tripData(){
        ArrayList<TripData> tripDataArrayList = new ArrayList<>();
        tripDataArrayList.add(new TripData(R.drawable.apple,"Apple","Place"));
        tripDataArrayList.add(new TripData(R.drawable.orange, "Orange", " TripData"));
        tripDataArrayList.add(new TripData(R.drawable.cherry, "Cherry", " TripData"));
        tripDataArrayList.add(new TripData(R.drawable.banana, "Banana", " TripData"));
        tripDataArrayList.add(new TripData(R.drawable.apple, "Apple", " TripData"));
        tripDataArrayList.add(new TripData(R.drawable.kiwi, "Kiwi", " TripData"));
        tripDataArrayList.add(new TripData(R.drawable.pear, "Pear", " TripData"));
        tripDataArrayList.add(new TripData(R.drawable.strawberry, "Strawberry", " TripData"));
        tripDataArrayList.add(new TripData(R.drawable.lemon, "Lemon", " TripData"));
        tripDataArrayList.add(new TripData(R.drawable.peach, "Peach", " TripData"));
        tripDataArrayList.add(new TripData(R.drawable.apricot, "Apricot", " TripData"));
        tripDataArrayList.add(new TripData(R.drawable.mango, "Mango", "TripData"));
        return tripDataArrayList;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentTripsBinding = null;
    }
}
