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
import com.example.senddata.ui.home.Home;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button sendButton;
    EditText sendText;
    EditText sendname;
    EditText sendAge;
    EditText sendSalary;
    EditText sendphno;
    Spinner spinnerID;
    String SpinnerValue;
    TextView sendLevel;
    Button saveBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = findViewById(R.id.buttonProceed);
        sendText = findViewById(R.id.send_text_id);
        sendname = findViewById(R.id.send_name_id);
        sendphno = findViewById(R.id.send_phno_id);
        sendLevel = findViewById(R.id.level);
        saveBttn = findViewById(R.id.buttonSave);
        sendAge =findViewById(R.id.age);
        sendSalary =findViewById(R.id.salary);

        String[] Levels = {"Please Select Levels", "Level 1", "Level 2", "Level 3", "Level 4"};
        spinnerID = findViewById(R.id.idSpinner);
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
                String id = sendText.getText().toString();
                String name = sendname.getText().toString();
                String phno = sendphno.getText().toString();
                String age = sendAge.getText().toString();
                String salary = sendSalary.getText().toString();

                Employee user = new Employee(id, name, phno, SpinnerValue,age,salary);

                Intent intent = new Intent(getApplicationContext(), Home.class);
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
                String id = sendText.getText().toString();
                String name = sendname.getText().toString();
                String phno = sendphno.getText().toString();
                String age = sendAge.getText().toString();
                String salary= sendSalary.getText().toString();
                Employee user = new Employee(id, name, phno, SpinnerValue,age,salary);

                EmployeeList.addEmployees(user);
            }
        });
    }

    private Boolean validate() {
        if (sendText.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please Fill ID", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sendphno.getText().toString().isEmpty() || sendphno.getText().length() < 10) {
            Toast.makeText(MainActivity.this, "Please Fill Phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sendname.getText().toString().isEmpty()) {
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
