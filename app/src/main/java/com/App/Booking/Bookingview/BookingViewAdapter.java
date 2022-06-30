package com.App.Booking.Bookingview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.App.test.R;

import java.util.ArrayList;

public class BookingViewAdapter extends RecyclerView.Adapter<BookingViewAdapter.BookingViewHolder> {
    Context context;
    ArrayList<BookingViewData> bookingViewDataArrayList;

    public BookingViewAdapter(Context context, ArrayList<BookingViewData> bookingViewDataArrayList) {
        this.context = context;
        this.bookingViewDataArrayList = bookingViewDataArrayList;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list,parent,false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        BookingViewData bookingData = bookingViewDataArrayList.get(position);
        holder.userID.setText(bookingData.getUserId());
        holder.id.setText(bookingData.getId());
        holder.title.setText(bookingData.getTitle());
        holder.body.setText(bookingData.getBody());
    }

    @Override
    public int getItemCount() {
        return bookingViewDataArrayList.size();
    }

    public class BookingViewHolder extends RecyclerView.ViewHolder {
        TextView userID;
        TextView id;
        TextView title;
        TextView body;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            userID = itemView.findViewById(R.id.userId);
            id = itemView.findViewById(R.id.Id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);

        }
    }
}
