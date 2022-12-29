package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.zircon.Fragments.FragmentsAdapter;
import com.example.zircon.Fragments.FragmentsSecondAdapter;
import com.google.android.material.tabs.TabLayout;

public class Tracker extends AppCompatActivity {
    TabLayout tab;
    ViewPager viewPager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        tab=findViewById(R.id.tab2);
        viewPager=findViewById(R.id.view2);
        viewPager.setAdapter(new FragmentsSecondAdapter((getSupportFragmentManager())));
        tab.setupWithViewPager(viewPager);
    }
}