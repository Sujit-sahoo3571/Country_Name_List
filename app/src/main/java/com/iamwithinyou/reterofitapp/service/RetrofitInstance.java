package com.iamwithinyou.reterofitapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.printful.com/";

    //singleton pattern
    public static GetCountryNameService getService() {

        // instance create for the first time
        if (retrofit == null) {
            retrofit =
                    new Retrofit.Builder().baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        }
        // already created instance .
        return retrofit.create(GetCountryNameService.class);

    }

}
