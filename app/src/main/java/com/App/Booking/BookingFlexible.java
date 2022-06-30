package com.App.Booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.App.test.R;
import com.App.test.databinding.BookingFlexibleBinding;
import com.App.test.databinding.BookingViewBinding;

public class BookingFlexible extends Fragment {

    public static BookingFlexible newInstance(){return new BookingFlexible();}

    private BookingFlexibleBinding bookingFlexibleBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bookingFlexibleBinding =BookingFlexibleBinding.inflate(inflater,container,false);
        return bookingFlexibleBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().findViewById(R.id.bookingtop).setVisibility(View.VISIBLE);
    }
}
