package com.App.Home.TabLayout.Points;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.App.test.R;
import com.App.test.databinding.FragmentPointsBinding;

import java.util.ArrayList;


public class FragmentPoints extends Fragment {
    private FragmentPointsBinding fragmentPointsBinding;
    private ArrayList<Points> pointsArrayList;

    public static FragmentPoints newInstance() {
        return new FragmentPoints();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentPointsBinding = FragmentPointsBinding.inflate(inflater, container, false);

        pointsArrayList = getPointsData();
        PointsAdapter pointsAdapter = new PointsAdapter(getActivity(), pointsArrayList);
        fragmentPointsBinding.gridView.setAdapter(pointsAdapter);
//     fragmentPointsBinding.gridView.setVisibility(View.GONE);

        fragmentPointsBinding.listView.setAdapter(pointsAdapter);
        fragmentPointsBinding.listView.setVisibility(View.VISIBLE);
        fragmentPointsBinding.switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentPointsBinding.listView.getVisibility() == getView().VISIBLE) {
                    fragmentPointsBinding.listView.setVisibility(View.GONE);
                    fragmentPointsBinding.gridView.setVisibility(View.VISIBLE);
                } else {
                    fragmentPointsBinding.gridView.setVisibility(View.GONE);
                    fragmentPointsBinding.listView.setVisibility(View.VISIBLE);
                }
            }

        });

        return fragmentPointsBinding.getRoot();
    }


    private ArrayList<Points> getPointsData() {
        ArrayList<Points> pointsArrayList = new ArrayList<>();
        pointsArrayList.add(new Points(R.drawable.apricot, "Apricot", "1000 Points"));
        pointsArrayList.add(new Points(R.drawable.orange, "Orange", "2000 Points"));
        pointsArrayList.add(new Points(R.drawable.cherry, "Cherry", "3000 Points"));
        pointsArrayList.add(new Points(R.drawable.banana, "Banana", "4000 Points"));
        pointsArrayList.add(new Points(R.drawable.apple, "Apple", "5000 Points"));
        pointsArrayList.add(new Points(R.drawable.kiwi, "Kiwi", "6000 Points"));
        pointsArrayList.add(new Points(R.drawable.pear, "Pear", "7000 Points"));
        pointsArrayList.add(new Points(R.drawable.strawberry, "Strawberry", "8000 Points"));
        pointsArrayList.add(new Points(R.drawable.lemon, "Lemon", "9000 Points"));
        pointsArrayList.add(new Points(R.drawable.peach, "Peach", "10000 Points"));
        pointsArrayList.add(new Points(R.drawable.apricot, "Apricot", "11000 Points"));
        pointsArrayList.add(new Points(R.drawable.mango, "Mango", "12000 Points"));
        return pointsArrayList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentPointsBinding = null;
    }
}
