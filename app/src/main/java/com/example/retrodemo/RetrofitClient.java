package com.example.retrodemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String ROOT_URl="https://api.myjson.com";

    private static Retrofit getInstance(){

        return new Retrofit.Builder().baseUrl(ROOT_URl).addConverterFactory(GsonConverterFactory.create()).build();

    }

    public static ApiService getApiService(){

        return getInstance().create(ApiService.class);
    }
}
