package com.example.thegioididong.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thegioididong.R;

public class FragmentReply extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reply, container, false);
        TextView txt_datmua = view.findViewById(R.id.txt_datmua);
        TextView txt_khieunai = view.findViewById(R.id.txt_khieunai);
        txt_datmua.setOnClickListener(this);
        txt_khieunai.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_datmua:
                Uri uri = Uri.parse("tel:18001060");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
                break;
            case R.id.txt_khieunai:
                Uri uri2 = Uri.parse("tel:18001062");
                Intent intent2 = new Intent(Intent.ACTION_DIAL,uri2);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
