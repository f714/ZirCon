package com.example.zircon.Fragments;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentFrouthAdapter extends FragmentPagerAdapter {
    public FragmentFrouthAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public FragmentFrouthAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new ProfileFragment();
            case 1:return new HomeFragment();
            case 2:return new RoomsFragment();
            default:return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position) {

        String title=null;
        if (position==0)
        {
            title= "Profile";
        }
        else if(position==1)
        {
            title= "Home";
        }
        else if(position==2)
        {
            title= "My Rooms";
        }
        return title;
    }
}
