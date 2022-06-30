package com.App.Booking;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.App.Booking.Bookingview.BookingView;
import com.App.test.databinding.FragmentBookingBinding;

import org.w3c.dom.Text;


public class FragmentBooking extends Fragment {
    private FragmentBookingBinding fragmentBookingBinding;

    public static int points = 3000;
    public static int cash = 600;

    public static FragmentBooking newInstance() {
        return new FragmentBooking();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentBookingBinding = FragmentBookingBinding.inflate(inflater, container, false);

        return fragmentBookingBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getActivity().getSupportFragmentManager());
        viewPageAdapter.addFragment(BookingView.newInstance(), "Booking");
        viewPageAdapter.addFragment(BookingFlexible.newInstance(), "FlexibleBooking");
        viewPageAdapter.addFragment(BookingFavorite.getInstance(), "Favorite");
        fragmentBookingBinding.viewPagerBooking.setAdapter(viewPageAdapter);
        fragmentBookingBinding.tablayoutBooking.setupWithViewPager(fragmentBookingBinding.viewPagerBooking);

        fragmentBookingBinding.bookingtop.pointsTv.setText("" + points);
        fragmentBookingBinding.bookingtop.cashTv.setText(cash + "$");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentBookingBinding = null;
    }

}
