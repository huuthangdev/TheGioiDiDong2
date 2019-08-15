package com.example.thegioididong.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thegioididong.Activity.BuyLapTopActivity;
import com.example.thegioididong.Model.Laptop;
import com.example.thegioididong.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.ViewHolder> {
private Context context;
private ArrayList<Laptop> listnew;

public LaptopAdapter(Context context, ArrayList<Laptop> listnew) {
        this.context = context;
        this.listnew = listnew;
        }

class ViewHolder extends RecyclerView.ViewHolder {
    TextView tensp, giasp;
    ImageView hinhsp;

    ViewHolder(@NonNull View itemView) {
        super(itemView);
        tensp = itemView.findViewById(R.id.txt_tensp);
        giasp = itemView.findViewById(R.id.txt_giasp);
        hinhsp = itemView.findViewById(R.id.img_sp);
        itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, BuyLapTopActivity.class);
            intent.putExtra("mualaptop", listnew.get(getPosition()));
            context.startActivity(intent);
        });
    }
}

    @NonNull
    @Override
    public LaptopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sp_item, parent, false);
        return new LaptopAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopAdapter.ViewHolder holder, int position) {
        Laptop mobilemodel = listnew.get(position);
        holder.tensp.setText(mobilemodel.getTenSP());
        holder.giasp.setText(mobilemodel.getGiaSP());
        Picasso.get().load(mobilemodel.getHinhSP()).into(holder.hinhsp);

    }

    @Override
    public int getItemCount() {
        return listnew.size();
    }


}

