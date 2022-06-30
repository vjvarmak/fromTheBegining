package com.App.Booking.Bookingview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import com.App.Booking.FragmentBooking;
import com.App.test.R;
import com.App.test.databinding.BookingViewBinding;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;

public class BookingView extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    public static BookingView newInstance() {
        return new BookingView();
    }

    private BookingViewBinding bookingViewBinding;
    private final int oneDay = 86400000;
    public long first = 0, last = 0;
    private String title = "";
    String message = "";
    String FirstDate;
    String EndDate;
    long total = 0;
    TextView tvPoints, tvCash;
    BookingViewController bookingViewController = new BookingViewController();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().findViewById(R.id.bookingtop).setVisibility(View.VISIBLE);
    }

    private void showBasicDialog() {
        bookingViewController.bookingDialog(title, message, getActivity(), bookingViewBinding.spinner2.getSelectedItem().toString(), FirstDate, EndDate);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_custom, null);
//        TextView tvTitle = view.findViewById(R.id.tvTitle);
//        tvTitle.setText(title);
//        TextView tvBody = view.findViewById(R.id.tvBody);
//        tvBody.setText(message);
//        builder.setView(view);
// builder.setPositiveButton(getResources().getString(R.string.bt_login), (dialogInterface, i) -> {
//
//
//            Toast.makeText(getActivity(), "Login Clicked", Toast.LENGTH_LONG).show();
//     confirmationDialog();
//            dialogInterface.dismiss();
//        });builder.setNegativeButton("Back", (dialog, which) -> {
//            Log.v("Dialog", "Bad");
//            dialog.cancel();
//        }).setNeutralButton("Ok", (dialog, which) -> {
//            Log.v("Dialog", "Ok");
//            dialog.cancel();
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bookingViewBinding = BookingViewBinding.inflate(inflater, container, false);
        String[] places = {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.booking_list, R.id.tv_booking_list, places);
        bookingViewBinding.spinner2.setAdapter(adapter);
        bookingViewBinding.spinner2.setOnItemSelectedListener(this);
        tvPoints = getActivity().findViewById(R.id.pointsTv);
        tvCash = getActivity().findViewById(R.id.cashTv);

        bookingViewBinding.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker()
                        .setTheme(R.style.CustomThemeOverlay_MaterialCalendar_Fullscreen)
                        .setTitleText("Select dates");
                MaterialDatePicker<Pair<Long, Long>> materialDatePicker = builder.build();
                materialDatePicker.show(requireActivity().getSupportFragmentManager(), "RangePicker");
                materialDatePicker.addOnPositiveButtonClickListener((MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>) selection -> {
                    first = selection.first;
                    last = selection.second;
                    FirstDate = new SimpleDateFormat("MM/ d/ yyyy").format(first + oneDay);
                    bookingViewBinding.textView2.setText("" + FirstDate);
                    EndDate = new SimpleDateFormat("MM/ d/ yyyy").format(last + oneDay);
                    bookingViewBinding.textView3.setText("" + EndDate);
                    MaterialDatePicker<Pair<Long, Long>> picker = builder.build();
                });
            }
        });
        bookingViewBinding.textView2.setOnClickListener(view -> {
            MaterialDatePicker<Pair<Long, Long>> materialDatePicker = MaterialDatePicker.Builder.dateRangePicker()
                    .setTheme(R.style.CustomThemeOverlay_MaterialCalendar_Fullscreen)
                    .setTitleText("Select dates").build();
            materialDatePicker.show(requireActivity().getSupportFragmentManager(), "RangePicker");
            materialDatePicker.addOnPositiveButtonClickListener(selection -> {
                first = selection.first;
                last = selection.second;
                FirstDate = new SimpleDateFormat("MM/ d/ yyyy").format(first + oneDay);
                bookingViewBinding.textView2.setText("" + FirstDate);
                EndDate = new SimpleDateFormat("MM/ d/ yyyy").format(last + oneDay);
                bookingViewBinding.textView3.setText("" + EndDate);
            });
        });

        bookingViewBinding.radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.pointsRb: {

                    try {
                        total = ((last - first) / oneDay) * 100;
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Please Select Date", Toast.LENGTH_SHORT).show();
                    }
                    title = "The Total Points " + FragmentBooking.points;
                    message = "Total Points Cost Used " + total;
                    if (FragmentBooking.points < total)
                        Toast.makeText(getActivity(), "Please Add More Points", Toast.LENGTH_LONG).show();
                    else tvPoints.setText("" + (FragmentBooking.points - total));
                }
                break;
                case R.id.cashRb: {

                    try {
                        total = ((last - first) / oneDay) * 50;
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Please Select Date", Toast.LENGTH_SHORT).show();
                    }
                    title = "The Total Points " + FragmentBooking.cash;
                    message = "Total Points Cost Used " + total;
                    if (FragmentBooking.cash < total)
                        Toast.makeText(getActivity(), "Please Add More Cash You Need More To Book" + (total - FragmentBooking.cash), Toast.LENGTH_LONG).show();
                    else tvCash.setText("" + (FragmentBooking.cash - total));
                    //  bookingViewBinding.pointsTv.setText(points-=total);
                }
                break;
                case R.id.cash_pointRb: {

                    try {
                        total = ((last - first) / oneDay) * 150;
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Please Select Date", Toast.LENGTH_SHORT).show();
                    }
                    title = "The Total Points and Cash " + (FragmentBooking.cash + FragmentBooking.points);
                    message = "Total Points Cost Used " + total;
                    if (FragmentBooking.cash < total)
                        Toast.makeText(getActivity(), "Please Add More Points", Toast.LENGTH_LONG).show();
                    else {
                        tvPoints.setText("" + (FragmentBooking.points - (total / 2)));
                        tvPoints.setText("" + (FragmentBooking.cash - (total / 2)));
                    }
                }
                break;
                default:
                    break;
            }
        });

        bookingViewBinding.btnSearch.setOnClickListener(view -> {
            if (bookingViewBinding.textView2.length() > 0) {
                if (FragmentBooking.points > total) showBasicDialog();
                else
                    Toast.makeText(getActivity(), "Please Add More Points", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getActivity(), "Please Select The Date", Toast.LENGTH_SHORT).show();
        });
        return bookingViewBinding.getRoot();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View view) {
    }

}
