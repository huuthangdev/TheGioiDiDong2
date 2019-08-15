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

import com.example.thegioididong.Activity.BuyMobileActivity;
import com.example.thegioididong.Model.Mobile;
import com.example.thegioididong.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.ViewHolder> {
private Context context;
private ArrayList<Mobile> listnew;

public MobileAdapter(Context context, ArrayList<Mobile> listnew) {
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
            Intent intent = new Intent(context, BuyMobileActivity.class);
            intent.putExtra("muadienthoai", listnew.get(getPosition()));
            context.startActivity(intent);
        });
    }
}

    @NonNull
    @Override
    public MobileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sp_item, parent, false);
        return new MobileAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MobileAdapter.ViewHolder holder, int position) {
        Mobile mobilemodel = listnew.get(position);
        holder.tensp.setText(mobilemodel.getTenSP());
        holder.giasp.setText(mobilemodel.getGiaSP());
        Picasso.get().load(mobilemodel.getHinhSP()).into(holder.hinhsp);
    }

    @Override
    public int getItemCount() {
        return listnew.size();
    }


}

