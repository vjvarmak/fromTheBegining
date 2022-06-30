package com.App.Home.TabLayout.Points;

import android.content.Context;
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

public class PointsHolderAdapter extends ArrayAdapter<Points> {

    private ArrayList<Points> pointsArrayList;

    static class PointsViewHolder{
        ImageView pointsImgView;
        TextView pointsNameTV;
        TextView pointsTV;
    }

    public PointsHolderAdapter(@NonNull Context context,ArrayList<Points> pointsArrayList ) {
        super(context, R.layout.points_listview);
        this.pointsArrayList =pointsArrayList;

    }

    @Nullable
    @Override
    public Points getItem(int position) {
        return pointsArrayList.get(position);
    }

    @Override
    public int getCount() {
        return pointsArrayList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        PointsViewHolder pointsViewHolder;
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.points_listview,parent,false);
            pointsViewHolder = new PointsViewHolder();
            ImageView pointsImgView = view.findViewById(R.id.pointsImg);
            TextView pointsNameTV = view.findViewById(R.id.pointsNameTv);
            TextView pointsTV = view.findViewById(R.id.pointsTv);
            view.setTag(pointsViewHolder);
        }
        else{
            pointsViewHolder = (PointsViewHolder) view.getTag();
        }
            Points points = getItem(position);
            pointsViewHolder.pointsImgView.setImageResource(points.getPointImg());
            pointsViewHolder.pointsNameTV.setText(points.getPointName());
            pointsViewHolder.pointsTV.setText(points.getPoints());
        return view;
    }
}
