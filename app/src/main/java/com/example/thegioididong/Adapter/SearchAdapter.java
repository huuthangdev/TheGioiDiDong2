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

import com.example.thegioididong.Activity.BuyAllActivity;
import com.example.thegioididong.Model.All;
import com.example.thegioididong.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private Context context;
    private ArrayList<All> manglaptop;

    public SearchAdapter(Context context, ArrayList<All> manglaptop) {
        this.context = context;
        this.manglaptop = manglaptop;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        All laptop = manglaptop.get(position);
        holder.txttensp.setText(laptop.getTenSP());
        holder.txtgiasp.setText(laptop.getGiaSP());
        Picasso.get().load(laptop.getHinhSP()).into(holder.imgsp);
    }

    @Override
    public int getItemCount() {
        return manglaptop.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttensp, txtgiasp;
        ImageView imgsp;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttensp = itemView.findViewById(R.id.txt_search_tensp);
            txtgiasp = itemView.findViewById(R.id.txt_search_giasp);
            imgsp = itemView.findViewById(R.id.img_search);
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(context, BuyAllActivity.class);
                intent.putExtra("mua", manglaptop.get(getPosition()));
                context.startActivity(intent);
            });
        }
    }
}
