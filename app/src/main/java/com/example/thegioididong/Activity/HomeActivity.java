package com.example.thegioididong.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.thegioididong.Adapter.MainViewPagerAdapter;
import com.example.thegioididong.Fragment.FragmentLaptop;
import com.example.thegioididong.Fragment.FragmentMobile;
import com.example.thegioididong.Fragment.FragmentNew;
import com.example.thegioididong.Fragment.FragmentTablet;
import com.example.thegioididong.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout maintablayout;
    ViewPager mainviewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        maintablayout = findViewById(R.id.main_tablayout);
        mainviewpager = findViewById(R.id.main_viewpager);
        toolbar = findViewById(R.id.main_toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SearchActivity.class));
            }
        });
        setPagerAdapter();
    }

    private void setPagerAdapter() {
        MainViewPagerAdapter pagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new FragmentNew(), "Nổi bật");
        pagerAdapter.addFragment(new FragmentMobile(), "Điện thoại");
        pagerAdapter.addFragment(new FragmentLaptop(), "Laptop");
        pagerAdapter.addFragment(new FragmentTablet(), "Tablet");
        mainviewpager.setAdapter(pagerAdapter);
        mainviewpager.setOffscreenPageLimit(4);
        mainviewpager.setCurrentItem(0);
        maintablayout.setupWithViewPager(mainviewpager);
        Objects.requireNonNull(maintablayout.getTabAt(0)).setIcon(R.drawable.ic_new);
        Objects.requireNonNull(maintablayout.getTabAt(1)).setIcon(R.drawable.ic_mobile);
        Objects.requireNonNull(maintablayout.getTabAt(2)).setIcon(R.drawable.ic_laptop);
        Objects.requireNonNull(maintablayout.getTabAt(3)).setIcon(R.drawable.ic_tablet);
    }
}
