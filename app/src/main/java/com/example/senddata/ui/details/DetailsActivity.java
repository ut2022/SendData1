package com.example.senddata.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.senddata.R;
import com.example.senddata.model.Employee;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
//        String id = getIntent().getStringExtra("id");
//        String name = getIntent().getStringExtra("name");
//        String phoneno = getIntent().getStringExtra("phonenumber");
//        String spin= getIntent().getStringExtra("spin");
//        String salary = getIntent().getStringExtra("sendSalary");

//        TextView formId=findViewById(R.id.form_id);
//        formId.setText(id);
//        TextView formName=findViewById(R.id.form_name);
//        formName.setText(name);
//        TextView formphno=findViewById(R.id.form_phno);
//        formphno.setText(phoneno);
//        TextView formspin=findViewById(R.id.form_level);
//        formspin.setText(spin);
//        TextView formsalary=findViewById(R.id.form_salary);
//        formsalary.setText(salary);

        Employee user = getIntent().getParcelableExtra("user");
        TextView formId = findViewById(R.id.form_id);
        TextView formName = findViewById(R.id.form_name);
        TextView formPhno = findViewById(R.id.form_phno);
        TextView formLevel = findViewById(R.id.form_level);
        TextView formSalary = findViewById(R.id.form_salary);
        TextView formAge = findViewById(R.id.form_age);

        formId.setText(user.id);
        formName.setText(user.name);
        formPhno.setText(user.phoneno);
        formLevel.setText(user.Spin);
        formSalary.setText(user.salary);
        formAge.setText(user.age);
    }
}