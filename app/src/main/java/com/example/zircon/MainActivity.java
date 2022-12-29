package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.zircon.Fragments.FragmentsAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
     TabLayout tab;
     ViewPager viewPager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance().subscribeToTopic("notification");

        tab=findViewById(R.id.tab);
        viewPager=findViewById(R.id.View);
        viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(viewPager);
    }
}