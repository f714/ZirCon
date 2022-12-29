package com.example.zircon.Fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentsSecondAdapter extends FragmentPagerAdapter {
    public FragmentsSecondAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public FragmentsSecondAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new IndiviualRoom();
            case 1:return new ComunnityRoom();
            default:return new IndiviualRoom();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    public CharSequence getPageTitle(int position) {

        String title=null;
        if (position==0)
        {
            title= "Individual";
        }
        else if(position==1)
        {
            title= "Community";
        }
        return title;
    }
}
