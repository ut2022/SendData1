package com.example.senddata.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.senddata.R;
import com.example.senddata.ui.main.MainActivity;

public class LogInActivity extends AppCompatActivity {
    public static String PREFS_NAME = "MyPrefsFile";
    EditText loginName;
    EditText loginPhno;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        login = findViewById(R.id.bt_login);
        loginPhno=findViewById(R.id.et_login_phno);
        loginName=findViewById(R.id.et_login_name);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate())
                    return;
                SharedPreferences sharedPreferences = getSharedPreferences(LogInActivity.PREFS_NAME, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putBoolean("hasLoggedIn", true);
                editor.commit();

                startActivity(new Intent(LogInActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private Boolean validate() {
        if (loginName.getText().toString().isEmpty()) {
            Toast.makeText(LogInActivity.this, "Please Fill Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (loginPhno.getText().toString().isEmpty()|| loginPhno.getText().length() <= 10) {
            Toast.makeText(LogInActivity.this, "Please Fill PhoneNumber", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}