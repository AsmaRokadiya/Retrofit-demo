package com.example.retrodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Employee> employeeList;
    Employee employee;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.progressbar);
        recyclerView=findViewById(R.id.emprecycler);
        progressBar.setVisibility(View.VISIBLE);
        ApiService api=RetrofitClient.getApiService();
        Call<EmployeeList> call=api.getJSON();


        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                progressBar.setVisibility(View.GONE);

                if ((response.isSuccessful())){
                    employeeList=response.body().getEmployees();
                    adapter=new EmployeeAdapter(MainActivity.this,employeeList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });

    }
}
