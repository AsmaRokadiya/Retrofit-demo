package com.example.retrodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    private Context context;
    private List<Employee> employeeList;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_emp_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        Employee employee=employeeList.get(position);

        holder.employeeName.setText(employee.getName());
        holder.email.setText(employee.getEmail());
        holder.designation.setText(employee.getDesignation());
        holder.salary.setText(employee.getSalary());
        holder.dob.setText(employee.getDob());
        holder.contactNumber.setText(employee.getContactNumber());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
