package com.example.thegioididong.Service;

import com.example.thegioididong.Model.All;
import com.example.thegioididong.Model.Laptop;
import com.example.thegioididong.Model.Mobile;
import com.example.thegioididong.Model.QuangCao;
import com.example.thegioididong.Model.Tablet;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Data {
    @GET("quangcao.php")
    Call<List<QuangCao>> getBanner();
    @GET("mobile.php")
    Call<List<Mobile>> getMobile();
    @GET("laptop.php")
    Call<List<Laptop>> getLaptop();
    @GET("tablet.php")
    Call<List<Tablet>> getTablet();
    @FormUrlEncoded
    @POST("search.php")
    Call<List<All>> Search(@Field("tukhoa") String tukhoa);
}
