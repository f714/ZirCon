package com.example.zircon;

import static android.content.ContentValues.TAG;

import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.example.zircon.rcvadapters.ProfileImageAdapter;
import io.paperdb.Paper;
import org.jetbrains.annotations.NotNull;

public class PersonalRoom extends AppCompatActivity {


    private int nCounter = 0;
    Button counter;
    TextView tx;
    TextView titleTV;
    TextView startdateET;
    TextView statusET;

    CardView dailyCV, weeklyCV, monthlyCV;

    ProgressBar progressBp, progB;


    ImageView imageV;

    TextView completeTv, pendingTv, cProgress;
    ProgressBar ProgBr;

    TextView zikr_conutTv;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_room);

        ArrayList<String> usersList = getIntent().getStringArrayListExtra("usersList");

        RecyclerView profile_img_recycler_view = findViewById(R.id.profile_img_recycler_view);
        profile_img_recycler_view.setAdapter(new ProfileImageAdapter(PersonalRoom.this, usersList));
        profile_img_recycler_view.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        Paper.init(PersonalRoom.this);
        String image = Paper.book().read("img", "");
        Log.d(TAG, "onCreate: " + image);
        if (image != null && !image.equals("") && !image.equals("null")) {
            ImageView mimage = findViewById(R.id.mimageV);
            Glide
                    .with(this)
                    .load(image)
                    .centerCrop()
                    .into(mimage);
        }

        counter = findViewById(R.id.counterBtn);
        tx = findViewById(R.id.tx);

        titleTV = findViewById(R.id.titleTV);
        startdateET = findViewById(R.id.startdateET);

        zikr_conutTv = findViewById(R.id.zikr_countTV);
        completeTv = findViewById(R.id.completeTV);
        pendingTv = findViewById(R.id.pendingTv);


        dailyCV = findViewById(R.id.dailyCV);
        weeklyCV = findViewById(R.id.weeklyCv);
        monthlyCV = findViewById(R.id.monthlyCv);

        progressBp = findViewById(R.id.progressPb);
        cProgress = findViewById(R.id.cProgress);

        String status = getIntent().getStringExtra("status");
        ProgBr = findViewById(R.id.ProgB);
        statusET = findViewById(R.id.statusTv);

        titleTV.setText(getIntent().getStringExtra("title"));
        startdateET.setText(getIntent().getStringExtra("start_date"));
        int count=Integer.parseInt(getIntent().getStringExtra("zikr_counting"))/usersList.size();
        zikr_conutTv.setText(count+"");


        statusET.setText(status);
        if (status != null) {
            if (status.equals("One Time")) {
                dailyCV.setVisibility(View.GONE);
                weeklyCV.setVisibility(View.GONE);
                monthlyCV.setVisibility(View.GONE);
            }

            if (status.equals("Daily")) {
                dailyCV.setVisibility(View.VISIBLE);
                weeklyCV.setVisibility(View.GONE);
                monthlyCV.setVisibility(View.GONE);
            }
            if (status.equals("Weekly")) {
                dailyCV.setVisibility(View.GONE);
                weeklyCV.setVisibility(View.VISIBLE);
                monthlyCV.setVisibility(View.GONE);
            }
            if (status.equals("Monthly")) {
                dailyCV.setVisibility(View.GONE);
                weeklyCV.setVisibility(View.GONE);
                monthlyCV.setVisibility(View.VISIBLE);
            }

        } else {
            dailyCV.setVisibility(View.GONE);
            weeklyCV.setVisibility(View.GONE);
            monthlyCV.setVisibility(View.GONE);
        }
        Log.d(TAG, "onCreate:titlee" + getIntent().getStringExtra("title"));

        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();

        int myInt = preferences.getInt(getIntent().getStringExtra("title"), 0);

        tx.setText(Integer.toString(myInt));

        nCounter = myInt;


        String[] weekly = new String[7];
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        String[] dayOfWeek = new String[7];
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < 7; i++) {
            Date dt = calendar.getTime();
            // now format it using SimpleDateFormat
            String val = df.format(dt);
            weekly[i] = val;

            calendar.add(Calendar.DAY_OF_WEEK, 1);
        }

        ProgBr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PersonalRoom.this, ProgressTarget.class);
                intent.putExtra("dayName", "Wednesday");
                intent.putExtra("date", weekly[0]);
                intent.putExtra("status", status);

                startActivity(intent);
            }
        });

        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nCounter++;
                tx.setText(Integer.toString(nCounter));
                Double count = Double.parseDouble(getIntent().getStringExtra("zikr_counting"));
                Double div = nCounter / count;

                Double completePercentage = div * 100;
                String fVal = String.format("%.2f", completePercentage);
                int pVal = (int) completePercentage.intValue();
                completeTv.setText(fVal + "% ");
                pendingTv.setText(" " + String.format("%.2f", 100 - completePercentage) + "%");
                progressBp.setProgress(pVal);
                cProgress.setText(fVal + "%");

                editor.putInt(getIntent().getStringExtra("title"), nCounter);
//                editor.putString("user", getIntent().getStringExtra("title"));
                editor.apply();

            }
        });

    }
}

