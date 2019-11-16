package com.example.retrodemo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    public TextView employeeName, designation,email,salary,dob,contactNumber;

    public EmployeeViewHolder(@NonNull View itemView) {
        super(itemView);

        employeeName=itemView.findViewById(R.id.name);
        email=itemView.findViewById(R.id.email);
        designation=itemView.findViewById(R.id.designation);
        salary=itemView.findViewById(R.id.salary);
        dob=itemView.findViewById(R.id.dob);
        contactNumber=itemView.findViewById(R.id.contacts);



    }
}
