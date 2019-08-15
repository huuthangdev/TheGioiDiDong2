package com.example.thegioididong.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    static Retrofit getClient(String base_url){
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(20000, TimeUnit.MILLISECONDS)
                .writeTimeout(20000, TimeUnit.MILLISECONDS)
                .connectTimeout(20000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                .build();

        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder()
                .baseUrl(base_url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
