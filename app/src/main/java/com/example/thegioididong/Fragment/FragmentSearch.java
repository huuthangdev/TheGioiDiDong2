package com.example.thegioididong.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thegioididong.Adapter.SearchAdapter;
import com.example.thegioididong.Model.All;
import com.example.thegioididong.R;
import com.example.thegioididong.Service.APIService;
import com.example.thegioididong.Service.Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSearch extends Fragment {
    private RecyclerView recyclerView;
    private SearchAdapter searchLaptopAdapter;
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        editText = view.findViewById(R.id.edt_search);
        recyclerView = view.findViewById(R.id.rv_search);
        editText.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_DONE){
                SearchTuKhoa(editText.getText().toString());
            }
            return false;
        });
        return view;
    }

    private void SearchTuKhoa(String s){
        Data data = APIService.getService();
        Call<List<All>> call = data.Search(s);
        call.enqueue(new Callback<List<All>>() {
            @Override
            public void onResponse(Call<List<All>> call, Response<List<All>> response) {
                ArrayList<All> mang = (ArrayList<All>) response.body();
                if (mang != null){
                    if (mang.size() > 0){
                        searchLaptopAdapter = new SearchAdapter(getActivity(), mang);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(searchLaptopAdapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setVisibility(View.VISIBLE);
                    } else {
                        recyclerView.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<All>> call, Throwable t) {

            }
        });
    }
}
