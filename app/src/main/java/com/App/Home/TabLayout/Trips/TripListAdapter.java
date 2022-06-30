package com.App.Home.TabLayout.Trips;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.App.test.R;

import java.util.ArrayList;

public class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.viewHolder> {

    ArrayList<TripData> tripDataArrayList;

    public TripListAdapter(ArrayList<TripData> tripDataArrayList) {
        this.tripDataArrayList = tripDataArrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_recyclerview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    holder.imageView.setImageResource(tripDataArrayList.get(position).getImageView());
    holder.name.setText(tripDataArrayList.get(position).getName());
    holder.place.setText((tripDataArrayList.get(position).getPlace()));
    }

    @Override
    public int getItemCount() {
        return tripDataArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,place;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tripImg);
            name =itemView.findViewById(R.id.tripNameTv);
            place = itemView.findViewById(R.id.placeTv);
        }
    }
}
