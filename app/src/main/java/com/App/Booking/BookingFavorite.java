package com.App.Booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.App.test.R;
import com.App.test.databinding.BookingFavoriteBinding;

public class BookingFavorite extends Fragment {

    public static BookingFavorite getInstance() {
        return new BookingFavorite();
    }

    private BookingFavoriteBinding bookingFavoriteBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bookingFavoriteBinding = BookingFavoriteBinding.inflate(inflater, container, false);
        return bookingFavoriteBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().findViewById(R.id.bookingtop).setVisibility(View.GONE);
    }
}