package com.example.thegioididong.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.thegioididong.Adapter.MobileAdapter;
import com.example.thegioididong.Model.Mobile;
import com.example.thegioididong.R;
import com.example.thegioididong.Service.APIService;
import com.example.thegioididong.Service.Data;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMobile extends Fragment {
    private RecyclerView recyclerview;
    private MobileAdapter spAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mobile, container, false);
        recyclerview = view.findViewById(R.id.rv_new_sp);
        setList();
        return view;
    }

    private void setList() {
        Data data = APIService.getService();
        Call<List<Mobile>> call = data.getMobile();
        call.enqueue(new Callback<List<Mobile>>() {
            @Override
            public void onResponse(Call<List<Mobile>> call, Response<List<Mobile>> response) {
                ArrayList<Mobile> listnew = (ArrayList<Mobile>) response.body();
                spAdapter = new MobileAdapter(getActivity(), listnew);
                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                recyclerview.setLayoutManager(layoutManager);
                recyclerview.setHasFixedSize(true);
                recyclerview.setAdapter(spAdapter);
            }

            @Override
            public void onFailure(Call<List<Mobile>> call, Throwable t) {

            }
        });
    }
}
