package com.example.zircon;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.zircon.Fragments.FragmentFrouthAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.person,
            R.drawable.home,
            R.drawable.rooms
    };

    String username;
    String email;
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        tabLayout = findViewById(R.id.tab3);
        viewPager = findViewById(R.id.view3);
        viewPager.setAdapter(new FragmentFrouthAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(1);
        user_id = getIntent().getStringExtra("user_id");
        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
//        Toast.makeText(getApplicationContext(), user_id + "Home", Toast.LENGTH_SHORT).show();
        tabLayout.setupWithViewPager(viewPager);

    }

    public void setTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }
}