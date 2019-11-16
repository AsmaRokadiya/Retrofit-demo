package com.example.retrodemo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("bins/17guwi")
    Call<EmployeeList> getJSON();
}

