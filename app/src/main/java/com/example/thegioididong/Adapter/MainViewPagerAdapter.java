package com.example.thegioididong.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> listfragment = new ArrayList<>();
    private ArrayList<String> listtitle = new ArrayList<>();

    public MainViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }

    public void addFragment(Fragment fragment, String title){
        listfragment.add(fragment);
        listtitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listtitle.get(position);
    }
}
