package com.example.senddata.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.senddata.R;
import com.example.senddata.model.Employee;
import com.example.senddata.model.EmployeeList;
import com.example.senddata.ui.home.HomeActivity;

public class MainActivity extends AppCompatActivity {
    Button sendButton;
    EditText sendId;
    EditText sendName;
    EditText sendAge;
    EditText sendSalary;
    EditText sendPhno;
    Spinner spinnerID;
    String SpinnerValue;
    TextView sendLevel;
    Button saveBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = findViewById(R.id.bt_proceed);
        sendId = findViewById(R.id.et_send_id);
        sendName = findViewById(R.id.et_send_name);
        sendPhno = findViewById(R.id.et_send_phno);
        sendLevel = findViewById(R.id.tv_send_level);
        saveBttn = findViewById(R.id.bt_save);
        sendAge = findViewById(R.id.et_send_age);
        sendSalary = findViewById(R.id.et_send_salary);

        String[] Levels = {"Please Select Levels", "Level 1", "Level 2", "Level 3", "Level 4"};
        spinnerID = findViewById(R.id.sp_send_level);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Levels);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerID.setAdapter(adapter);

        spinnerID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerValue = (String) spinnerID.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate())
                    return;
                String id = sendId.getText().toString();
                String name = sendName.getText().toString();
                String phno = sendPhno.getText().toString();
                String age = sendAge.getText().toString();
                String salary = sendSalary.getText().toString();

                Employee user = new Employee(id, name, phno, SpinnerValue, age, salary);

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                intent.putExtra("user", user);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Login Successfully!!!", Toast.LENGTH_SHORT).show();
            }
        });

        saveBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate())
                    return;
                String id = sendId.getText().toString();
                String name = sendName.getText().toString();
                String phno = sendPhno.getText().toString();
                String age = sendAge.getText().toString();
                String salary = sendSalary.getText().toString();
                Employee user = new Employee(id, name, phno, SpinnerValue, age, salary);
                EmployeeList.addEmployees(user);
            }
        });
    }

    private Boolean validate() {
        if (sendId.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please Fill ID", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sendPhno.getText().toString().isEmpty() || sendPhno.getText().length() < 10) {
            Toast.makeText(MainActivity.this, "Please Fill Phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sendName.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please Fill Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sendAge.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please Fill Age", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sendSalary.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please Fill Salary", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
