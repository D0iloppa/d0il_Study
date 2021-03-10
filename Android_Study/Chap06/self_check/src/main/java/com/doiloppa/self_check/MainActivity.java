package com.doiloppa.self_check;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView txtResult;
    RadioButton rdo_Date,rdo_Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chronometer = findViewById(R.id.chrono);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        rdo_Date = findViewById(R.id.rdoDate);
        rdo_Time = findViewById(R.id.rdoTime);
        txtResult = findViewById(R.id.txtResult);
        LinearLayout layout = findViewById(R.id.layout);
        txtResult = findViewById(R.id.txtResult);

        rdo_Date.setVisibility(View.INVISIBLE);
        rdo_Time.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);

        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                rdo_Date.setVisibility(View.VISIBLE);
                rdo_Time.setVisibility(View.VISIBLE);
            }
        });

        rdo_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        rdo_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });

        layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                txtResult.setText(datePicker.getYear()+"년 " + (datePicker.getMonth()+1) + "월 " +
                        datePicker.getDayOfMonth()+"일 "+timePicker.getCurrentHour() + "시 "+
                        timePicker.getCurrentMinute() + "분 예약됨");

                return false;
            }
        });

    }
}