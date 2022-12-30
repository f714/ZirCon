package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class ProgressBarDaily2 extends AppCompatActivity {


    TextView dayNameTV, dateTV,statusTV;

    String dayname,date;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_daily2);

        dayname=getIntent().getStringExtra("dayName");
        date=getIntent().getStringExtra("date");

        dayNameTV=findViewById(R.id.day1);
        dateTV=findViewById(R.id.date1);

        dateTV.setText(date);
        dayNameTV.setText(dayname);

        statusTV=findViewById(R.id.statusTB);

        statusTV.setText(getIntent().getStringExtra("status"));

    }
}