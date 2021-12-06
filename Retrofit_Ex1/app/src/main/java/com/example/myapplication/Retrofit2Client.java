package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2Client {
    private static Retrofit2Client instance;
    private PhoneService phoneService;

    public Retrofit2Client(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.55.37")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        phoneService = retrofit.create(PhoneService.class);
    }

    public static Retrofit2Client getInstance(){
        if(instance == null){
            instance = new Retrofit2Client();
        }
        return instance;
    }
    public PhoneService getPhoneService(){
        return phoneService;
    }
}
