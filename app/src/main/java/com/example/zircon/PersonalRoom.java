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
import java.util.List;

import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.LoadMyRoomsModel;
import com.example.zircon.api.models.UserRoomModel;
import com.example.zircon.rcvadapters.ProfileImageAdapter;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    ProgressBar ProgBr,ProgBrD2,ProgBrD3,ProgBrD4,ProgBrD5,ProgBrD6,ProgBrD7;


    TextView zikr_conutTv;

    ArrayList<String> joinedUsersList;

    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    RecyclerView profile_img_recycler_view;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_room);

        ArrayList<String> usersList = getIntent().getStringArrayListExtra("usersList");

 String user_id = getIntent().getStringExtra("user_id");


        profile_img_recycler_view = findViewById(R.id.profile_img_recycler_view);


//




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


        ProgBrD2 = findViewById(R.id.progressBrD2);
        ProgBrD3 = findViewById(R.id.progressBrD3);
        ProgBrD4 = findViewById(R.id.progressBrD4);
        ProgBrD5 = findViewById(R.id.progressBrD5);
        ProgBrD6 = findViewById(R.id.progressBrD6);
        ProgBrD7 = findViewById(R.id.progressBrD7);
        statusET = findViewById(R.id.statusTv);

        titleTV.setText(getIntent().getStringExtra("title"));
        startdateET.setText(getIntent().getStringExtra("start_date"));
//        int count=Integer.parseInt(getIntent().getStringExtra("zikr_counting"))/usersList.size();

        int count=Integer.parseInt(getIntent().getStringExtra("zikr_counting"));
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

        ProgBrD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(PersonalRoom.this,ProgressBarDaily2.class);
                intent.putExtra("dayName","Wednesday");
                intent.putExtra("date",weekly[1]);
                intent.putExtra("status",status);

                startActivity(intent);
            }
        });

        ProgBrD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(PersonalRoom.this,ProgressBarDaily3.class);
                intent.putExtra("dayName","Wednesday");
                intent.putExtra("date",weekly[2]);
                intent.putExtra("status",status);

                startActivity(intent);
            }
        });
        ProgBrD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(PersonalRoom.this,ProgressBarDaily4.class);
                intent.putExtra("dayName","Wednesday");
                intent.putExtra("date",weekly[3]);
                intent.putExtra("status",status);

                startActivity(intent);
            }
        });
        ProgBrD5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(PersonalRoom.this,ProgressBarDaily5.class);
                intent.putExtra("dayName","Wednesday");
                intent.putExtra("date",weekly[4]);
                intent.putExtra("status",status);

                startActivity(intent);
            }
        });
        ProgBrD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(PersonalRoom.this,ProgressBarDaily6.class);
                intent.putExtra("dayName","Wednesday");
                intent.putExtra("date",weekly[5]);
                intent.putExtra("status",status);

                startActivity(intent);
            }
        });
        ProgBrD7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(PersonalRoom.this,ProgressBarDaily7.class);
                intent.putExtra("dayName","Wednesday");
                intent.putExtra("date",weekly[6]);
                intent.putExtra("status",status);

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

        loadUsers(user_id);

    }

    private void loadUsers(String user_id) {


        Call<List<LoadMyRoomsModel>> myRoomCall = apiInterface.loadMyRoomByTitle(titleTV.getText().toString());


        myRoomCall.enqueue(new Callback<List<LoadMyRoomsModel>>() {
            @Override
            public void onResponse(Call<List<LoadMyRoomsModel>> call, Response<List<LoadMyRoomsModel>> response) {
                if (response.isSuccessful()) {
                    List<LoadMyRoomsModel> allRooms = response.body();

                    for (LoadMyRoomsModel myRoom : allRooms) {
                        Log.d("TAG", "onResponse:" + myRoom.getNarrator());
//                        Toast.makeText(My_Rooms.this, myRoom.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                    if (allRooms.size() > 0) {
                        saveUserRoomRecord(15, allRooms, user_id);


                    } else {
                        Toast.makeText(PersonalRoom.this, "No Room Found", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(PersonalRoom.this, "Error in loading rooms", Toast.LENGTH_SHORT).show();
                }
            }




            @Override
            public void onFailure(Call<List<LoadMyRoomsModel>> call, Throwable t) {
//                        Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error "+t.getMessage());

            }
        });
    }

    private void saveUserRoomRecord(int room_id, List<LoadMyRoomsModel> allRooms, String user_id) {
        final boolean[] joined = new boolean[1];
        joinedUsersList = new ArrayList<>();
        apiInterface.getUserRoomRecord().enqueue(new Callback<List<UserRoomModel>>() {
            @Override
            public void onResponse(Call<List<UserRoomModel>> call, Response<List<UserRoomModel>> response) {

                List<UserRoomModel> modelList = response.body();
                assert modelList != null;
                for (UserRoomModel model : modelList) {
                    if (model.getRoom_id().equals(String.valueOf(room_id))) {
                        if(!model.getUser_id().equals("0")) {
                            joinedUsersList.add(model.getUser_id().trim());
                        }
                    }
                    if (model.getRoom_id().equals(String.valueOf(room_id)) && model.getUser_id().equals(user_id)) {
                        joined[0] = true;
                        break;
                    } else
                        joined[0] = false;
                }


                if (!joined[0]) {


                    apiInterface.addUserRoomRecord(room_id, user_id).enqueue(new Callback<List<Object>>() {

                        @Override
                        public void onResponse(Call<List<Object>> call, Response<List<Object>> response) {
                            Toast.makeText(PersonalRoom.this, "Joined Successfully", Toast.LENGTH_LONG).show();

                            joinedUsersList.add(user_id);

                        }

                        @Override
                        public void onFailure(Call<List<Object>> call, Throwable t) {

                        }
                    });
                }
//                        Intent personalIntent = new Intent(PersonalRoom.this, PersonalRoom.class);
//                        personalIntent.putExtra("title", allRooms.get(0).getTitle());
//                        personalIntent.putExtra("id", "15");
//                        personalIntent.putExtra("start_date", allRooms.get(0).getStart_date());
//                        personalIntent.putExtra("status", allRooms.get(0).getStatus());
//                        personalIntent.putExtra("zikr_counting", allRooms.get(0).getZikr_counting());
//                        personalIntent.putExtra("usersList", joinedUsersList);
//
//                        PersonalRoom.this.startActivity(personalIntent);

                profile_img_recycler_view.setLayoutManager(new LinearLayoutManager(PersonalRoom.this, RecyclerView.HORIZONTAL, false));
                profile_img_recycler_view.setAdapter(new ProfileImageAdapter(PersonalRoom.this, joinedUsersList));


            }

            @Override
            public void onFailure(Call<List<UserRoomModel>> call, Throwable t) {
//                                Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error Jamsa"+t.getMessage());


            }
        });
    }

}

