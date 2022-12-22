package com.iamwithinyou.reterofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.iamwithinyou.reterofitapp.adapter.CountryAdapter;
import com.iamwithinyou.reterofitapp.model.CountryModel;
import com.iamwithinyou.reterofitapp.model.Result;
import com.iamwithinyou.reterofitapp.service.GetCountryNameService;
import com.iamwithinyou.reterofitapp.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;

    ArrayList<CountryModel> countries; // TODO well it's working now !

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }

    private Object getCountries() {
        GetCountryNameService getCountryNameService =
                RetrofitInstance.getService();
        Call<Result> calls = getCountryNameService.getResult();

        calls.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call,
                                   Response<Result> response) {
                Result result = response.body();
                if (result != null && result.getResult() != null) {
                    countries = (ArrayList<CountryModel>) result.getResult();
//                    for (CountryModel c : countries) {
//                        Log.i("TAG", " " + c.getName());
//                    }
                    ViewData();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        return countries;
    }

    private void ViewData() {
        recyclerView = findViewById(R.id.recyclerView);
        countryAdapter = new CountryAdapter(countries);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(countryAdapter);
    }

}