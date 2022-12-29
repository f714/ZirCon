package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.zircon.Fragments.FragmentFrouthAdapter;
import com.example.zircon.Fragments.ViewAllFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class View_all extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.person,
            R.drawable.rooms,
    };


    String username;
    String email;
    String id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        tabLayout=findViewById(R.id.tab2);
        viewPager=findViewById(R.id.view2);
        viewPager.setAdapter(new ViewAllFragmentAdapter(getSupportFragmentManager()));

        id=getIntent().getStringExtra("id");
        username=getIntent().getStringExtra("username");
        email=getIntent().getStringExtra("email");

        tabLayout.setupWithViewPager(viewPager);

    }

    public void setTabIcons()
    {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);

    }
}