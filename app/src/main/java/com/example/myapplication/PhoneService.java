package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PhoneService {
    @GET("list")
    Call<List<Phone>> findAll();

    @POST("insert")
    Call<Phone> save(@Body Phone phoneDto);

}
