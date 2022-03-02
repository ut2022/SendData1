package com.example.senddata.ui.information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.senddata.EmployeeHistoryActivity;
import com.example.senddata.R;
import com.example.senddata.model.ApiResults;
import com.example.senddata.model.Info;
import com.example.senddata.roomdatabase.UserEntity;
import com.example.senddata.ui.login.LogInActivity;
import com.example.senddata.ui.retrofit.Api;
import com.example.senddata.ui.retrofit.RetrofitClient;
import com.example.senddata.ui.splash.SplashActivity;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InformationActivity extends AppCompatActivity {
    TextView fetchedName;
    TextView fetchedPhno;
    ImageView nextactivity;
    public static String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        fetchedName = findViewById(R.id.tv_info_name);
        fetchedPhno = findViewById(R.id.tv_info_phno);
        nextactivity = findViewById(R.id.iv_nextbttn);

//        Intent intent = getIntent();
//        ApiResults apiResults = (ApiResults) intent.getSerializableExtra("info");
//        fetchedName.setText(apiResults.getName());
//        fetchedPhno.setText(apiResults.getCity());

        Intent intent = getIntent();
        UserEntity userEntity = (UserEntity) intent.getSerializableExtra("info");
        fetchedName.setText(userEntity.getName());
        fetchedPhno.setText(userEntity.getUserId());

//            Bundle extras = intent.getExtras();
//            String jsonString = extras.getString(context.JSON_STRING);

        nextactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeHistoryActivity.class);
//                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(InformationActivity.PREFS_NAME, 0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn", false);

                if (hasLoggedIn) {

                } else {
                    Intent intent = new Intent(InformationActivity.this, LogInActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 3000);
    }
}

