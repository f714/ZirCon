package com.example.zircon.Fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentThirdAdapter extends FragmentPagerAdapter {
    public FragmentThirdAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public FragmentThirdAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new TodayFragment();
            case 1: return new UpcommingFragment();
            case 2:return new Closed();
            default:return new TodayFragment();
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
            title= "Today";
        }
        else if(position==1)
        {
            title= "Upcoming";
        }
        else if (position==2)
        {
            title="Closed";
        }
        return title;
    }
}
