package com.example.senddata.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.senddata.ui.login.LogInActivity;
import com.example.senddata.R;
import com.example.senddata.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        Thread thread=new Thread(){
//
//            public void run(){
//                try{
//                    sleep(3000);
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//            }
//                finally {
//                   Intent intent=new Intent(SplashActivity.this, MainActivity.class);
//                   startActivity(intent);
//                }
//                }
//        };thread.start();

   new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
       @Override
       public void run() {
           SharedPreferences sharedPreferences=getSharedPreferences(LogInActivity.PREFS_NAME,0);
           boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);

           if(hasLoggedIn){
               Intent intent=new Intent(SplashActivity.this,MainActivity.class);
               startActivity(intent);
               finish();
           }
           else {
               Intent intent=new Intent(SplashActivity.this,LogInActivity.class);
               startActivity(intent);
               finish();
           }
       }
   },3000);
    }


}