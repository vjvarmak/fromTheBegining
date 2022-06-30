package com.App.Booking.Bookingview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.util.Pair;

import com.App.test.R;
import com.App.test.databinding.BookingViewBinding;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;

public class BookingViewController {
    Context context;

//    com.google.android.material.datepicker.MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker()
//            .setTheme(R.style.CustomThemeOverlay_MaterialCalendar_Fullscreen)
//            .setTitleText("Select dates");
//
//    MaterialDatePicker materialDatePicker = builder.build();
//
//            materialDatePicker.show(getActivity().getSupportFragmentManager(), "RangePicker");
//
//            materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
//        @Override
//        public void onPositiveButtonClick(Pair<Long, Long> selection) {
//            Long first = selection.first;
//            Long last = selection.second;
//
//            String FirstDate=new SimpleDateFormat("MM/ d/ yyyy").format(first+oneDay);
//            bookingViewBinding.editTextDate.setText(""+FirstDate);
//
//            String EndDate=new SimpleDateFormat("MM/ d/ yyyy").format(last+oneDay);
//            bookingViewBinding.editTextDate2.setText(""+EndDate);
//
//            MaterialDatePicker<Pair<Long, Long>> picker = builder.build();
//        }});
//
//    private void showBasicDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("My Title");
//        builder.setMessage("Hai How Are You");
//
//        View view = LayoutInflater.from(this.context).inflate(R.layout.dialog_custom,null);
//        builder.setView(view);
//
//
//        Button button = view.findViewById(R.id.button);
//
//        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                // logic should be here
//                dialogInterface.dismiss();
//            }c
//        });
//
//        builder.setPositiveButton(getResources().getString(R.string.bt_login), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getContext(),"Login Clicked",Toast.LENGTH_LONG).show();
//                dialogInterface.dismiss();
//            }
//        });
//
//        builder.setNegativeButton("Bad", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Log.v("Dialog","Bad");
//                dialog.cancel();
//            }
//        }).setNeutralButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Log.v("Dialog","Ok");
//                dialog.cancel();
//            }
//        });

//        builder.setPositiveButton("Good", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Log.v("Dialog","Good");
//                dialog.cancel();
//            }
//        }).setNegativeButton("Bad", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Log.v("Dialog","Bad");
//                dialog.cancel();
//            }
//        }).setNeutralButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Log.v("Dialog","Ok");
//                dialog.cancel();
//            }
//        });

//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }

    public void bookingDialog(String title, String message, Context context, String spinnerItem, String FirstDate, String EndDate) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_custom, null);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setText(title);
        TextView tvBody = view.findViewById(R.id.tvBody);
        tvBody.setText(message);
        builder.setView(view);
        builder.setPositiveButton(context.getString(R.string.bt_login), (dialogInterface, i) -> {
            Toast.makeText(context, "Login Clicked", Toast.LENGTH_LONG).show();
            dialogInterface.dismiss();
            confirmationDialog(context, FirstDate, EndDate, spinnerItem);
        });
        builder.setNegativeButton("Back", (dialog, which) -> {
            Log.v("Dialog", "Bad");
            dialog.cancel();
        }).setNeutralButton("Ok", (dialog, which) -> {
            Log.v("Dialog", "Ok");
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void confirmationDialog(Context context, String FirstDate, String EndDate, String spinnerItem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_confirmation, null);
        TextView tvTitleConfirm = view.findViewById(R.id.tvTitleConfirm);
        tvTitleConfirm.setText("Your trip is confirm at " + spinnerItem);
        TextView tvBodyConfirm = view.findViewById(R.id.tvBodyConfirm);
        tvBodyConfirm.setText(FirstDate + " From " + EndDate);
        builder.setView(view);
        builder.setPositiveButton(context.getResources().getString(R.string.bt_login), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Ok", Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
