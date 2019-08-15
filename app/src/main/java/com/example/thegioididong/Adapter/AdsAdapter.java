package com.example.thegioididong.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.thegioididong.Model.QuangCao;
import com.example.thegioididong.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdsAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<QuangCao> listquangcao;

    public AdsAdapter(Context context, ArrayList<QuangCao> listquangcao) {
        this.context = context;
        this.listquangcao = listquangcao;
    }

    @Override
    public int getCount() {
        return listquangcao.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.ads_item, null);
        ImageView imgads = view.findViewById(R.id.hinhbanner);
        Picasso.get().load(listquangcao.get(position).getHinhQuangCao()).into(imgads);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
