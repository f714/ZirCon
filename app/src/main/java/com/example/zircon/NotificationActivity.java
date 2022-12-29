package com.example.zircon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.rcvadapters.NotificationAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotificationActivity extends BaseActivity {

    NotificationModel notificationModel;
    ApiInterface apiInterface;

    ArrayList<NotificationModel> array = new ArrayList<>();
    RecyclerView rv;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        String user_id= getIntent().getStringExtra("user_id");

        rv = (RecyclerView) findViewById(R.id.noti_rv);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        editor.putBoolean("check",false).apply();

        executor.execute(() -> {

            rootRef.getReference().child("notification").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot datas : dataSnapshot.getChildren()) {
                        notificationModel = datas.getValue(NotificationModel.class);
                        if (notificationModel!=null){
                            array.add(notificationModel);
                        }
                    }

                    rv.setLayoutManager(new LinearLayoutManager(NotificationActivity.this,LinearLayoutManager.VERTICAL,true));
                    NotificationAdapter adapter = new NotificationAdapter(NotificationActivity.this, array,user_id,apiInterface);
                    rv.setAdapter(adapter);
//                    for (DataSnapshot datas : dataSnapshot) {
//                        notificationModel = datas.getValue(NotificationModel.class);
//                        if (notificationModel!=null){
//                            array.add(notificationModel);
//                        }
//                    }

                    runOnUiThread(() -> {

                        // binding.progressLinear.setVisibility(View.GONE);
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

//                        if (notificationModel!= null){
////                            byte[] decodedString = Base64.decode(appointmentModel.getImage(), Base64.DEFAULT);
////                            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
////                            Glide.with(ViewAppointmentActivity.this).load(decodedByte).into(binding.profileIv);
//
////                            notificationModel.setNotification(notificationModel.getNotification());
//
//
//
//                        }
//                        else {
//                            Toast.makeText(NotificationActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
//                        }
                    });

                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    runOnUiThread(() -> {

//                        binding.progressLinear.setVisibility(View.GONE);
//                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        Toast.makeText(NotificationActivity.this, databaseError + "", Toast.LENGTH_SHORT).show();

                    });
                }
            });

        });
    }
}