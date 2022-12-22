package com.iamwithinyou.reterofitapp.service;

import com.iamwithinyou.reterofitapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryNameService {
    // Retrofit interface
    @GET("countries")
    Call<Result> getResult();
}
