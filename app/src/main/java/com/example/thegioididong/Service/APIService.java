package com.example.thegioididong.Service;

public class APIService {

    public static Data getService() {
        String base_url = "https://huuthangphim.000webhostapp.com/Server/";
        return RetrofitClient.getClient(base_url).create(Data.class);
    }
}


