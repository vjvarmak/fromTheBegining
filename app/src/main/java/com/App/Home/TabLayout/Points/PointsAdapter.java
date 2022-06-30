package com.App.Home.TabLayout.Points;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.App.test.R;

import java.util.ArrayList;

public class PointsAdapter extends ArrayAdapter<Points> {
    Activity context;
    private ArrayList<Points> pointsArrayList;

    public PointsAdapter(@NonNull Activity context, ArrayList<Points> pointsArrayList) {
        super(context, R.layout.points_listview);
        this.context =context;
        this.pointsArrayList =pointsArrayList;
    }

    @Override
    public int getCount() {
        return pointsArrayList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.points_listview,null,false);
        ImageView pointsImgView = view.findViewById(R.id.pointsImg);
        TextView pointsNameTV = view.findViewById(R.id.pointsNameTv);
        TextView pointsTV= view.findViewById(R.id.pointsTv);
        Points points = pointsArrayList.get(position);
        pointsImgView.setImageResource(points.getPointImg());
        pointsNameTV.setText(points.getPointName());
        pointsTV.setText(points.getPoints());
        return view;
    }
}
