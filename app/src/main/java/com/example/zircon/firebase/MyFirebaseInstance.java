package com.example.zircon.firebase;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseInstance extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
//        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("ZirconPref", )
    }
}
