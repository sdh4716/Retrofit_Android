package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private PhoneAdapter phoneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager manager
                = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);

        PhoneService phoneService = Retrofit2Client.getInstance().getPhoneService();
        Call<List<Phone>> call = phoneService.findAll();

        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                List<Phone> phoneList = response.body();
                phoneAdapter = new PhoneAdapter(phoneList);
                recyclerView.setAdapter(phoneAdapter);
                Log.d("data","onResponse: 응답 받은 데이터 :" +phoneList);
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {

            }
        });

    }
}