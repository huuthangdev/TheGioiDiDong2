package com.example.thegioididong.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.thegioididong.Adapter.AdsAdapter;
import com.example.thegioididong.Model.QuangCao;
import com.example.thegioididong.R;
import com.example.thegioididong.Service.APIService;
import com.example.thegioididong.Service.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentAds extends Fragment {
    private View view;
    private ViewPager adsviewpager;
    private AdsAdapter adsAdapter;
    private CircleIndicator adsindicator;
    private Runnable runnable;
    private Handler handler;
    private int currentitem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ads, container, false);
        init();
        setBanner();
        return view;
    }

    private void setBanner() {
        Data data = APIService.getService();
        Call<List<QuangCao>> call = data.getBanner();
        call.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                ArrayList<QuangCao> banners = (ArrayList<QuangCao>) response.body();
                adsAdapter = new AdsAdapter(getActivity(), banners);
                adsviewpager.setAdapter(adsAdapter);
                adsindicator.setViewPager(adsviewpager);
                handler = new Handler();
                runnable = () -> {
                    currentitem = adsviewpager.getCurrentItem();
                    currentitem++;
                    if (currentitem>= Objects.requireNonNull(adsviewpager.getAdapter()).getCount()){
                        currentitem = 0;
                    }
                    adsviewpager.setCurrentItem(currentitem, true);
                    handler.postDelayed(runnable,5000);
                };
                handler.postDelayed(runnable,7000);
            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {

            }
        });
    }

    private void init() {
        adsviewpager = view.findViewById(R.id.ads_viewpager);
        adsindicator = view.findViewById(R.id.ads_indicator);
    }
}
