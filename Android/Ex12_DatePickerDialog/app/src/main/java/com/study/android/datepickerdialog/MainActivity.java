package com.study.android.datepickerdialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
    }

    public void onBtn1Clicked(View v) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                AlertDialog.THEME_HOLO_DARK, //시계테마를 변경 할 수 있는 부분
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int month, int dayOfMonth) {
                        textView1.setText(dayOfMonth + "/" + (month + 1) +"/" + year);
                    }
                }, mYear,mMonth,mDay);
        datePickerDialog.show();
    }

    public void onBtn2Clicked(View v) {
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        textView1.setText(hourOfDay + ":" + minute);

                    }
                },mHour,mMinute,false);
        timePickerDialog.show();
    }
}



//        AlertDialog.THEME_HOLO_LIGHT
//        AlertDialog.THEME_HOLO_DARK
//        AlertDialog.THEME_DEVICE_DEFAULT_LIGHT
//        AlertDialog.THEME_DEVICE_DEFAULT_DARK
//        AlertDialog.THEME_TRADITIONAL
