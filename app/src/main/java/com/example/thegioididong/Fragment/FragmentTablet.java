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

import com.example.thegioididong.Adapter.TabletAdapter;
import com.example.thegioididong.Model.Tablet;
import com.example.thegioididong.R;
import com.example.thegioididong.Service.APIService;
import com.example.thegioididong.Service.Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentTablet extends Fragment {
    private RecyclerView recyclerview;
    private TabletAdapter spAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablet, container, false);
        recyclerview = view.findViewById(R.id.rv_new_sp);
        setList();
        return view;
    }

    private void setList() {
        Data data = APIService.getService();
        Call<List<Tablet>> call = data.getTablet();
        call.enqueue(new Callback<List<Tablet>>() {
            @Override
            public void onResponse(Call<List<Tablet>> call, Response<List<Tablet>> response) {
                ArrayList<Tablet> listnew = (ArrayList<Tablet>) response.body();
                spAdapter = new TabletAdapter(getActivity(), listnew);
                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                recyclerview.setLayoutManager(layoutManager);
                recyclerview.setHasFixedSize(true);
                recyclerview.setAdapter(spAdapter);
            }

            @Override
            public void onFailure(Call<List<Tablet>> call, Throwable t) {

            }
        });
    }
}
