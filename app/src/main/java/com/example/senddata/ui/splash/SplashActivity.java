package com.example.senddata.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.service.autofill.UserData;
import android.util.Log;

import com.example.senddata.model.User;
import com.example.senddata.roomdatabase.UserDao;
import com.example.senddata.roomdatabase.UserDatabase;
import com.example.senddata.roomdatabase.UserEntity;
import com.example.senddata.roomdatabase.UserRepository;
import com.example.senddata.ui.fragments.CurrentEmployeesFragment;
import com.example.senddata.ui.information.InformationActivity;
import com.example.senddata.ui.login.LogInActivity;
import com.example.senddata.R;
import com.example.senddata.ui.main.MainActivity;
import com.example.senddata.ui.viewmodel.LoginViewModel;

public class SplashActivity extends AppCompatActivity {
private LoginViewModel loginViewModel;
     private int user_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        loginViewModel=new ViewModelProvider(this).get(LoginViewModel.class);
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                user_count=loginViewModel.getCount();
                if(user_count > 0)
                {
                    Log.d("main", "successful "+user_count);
                }
                else
                {
                    Log.d("main", "fail "+user_count);
                }
            }
        };
        new Thread(runnable).start();
//        userRepository=new UserRepository(getApplication());
//
//
//        loginViewModel.getAllPosts().observe(this, new Observer<UserEntity>() {
//            @Override
//            public void onChanged(UserEntity userEntity) {
//
//               user_count=loginViewModel.getCount();
//
//        });
//

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
           Intent intent=new Intent(SplashActivity.this,LogInActivity.class);
                startActivity(intent);
                finish();

//           if(hasLoggedIn){
//               Intent intent=new Intent(SplashActivity.this, InformationActivity.class);
//               startActivity(intent);
//               finish();
//           }
//           else {
//               Intent intent=new Intent(SplashActivity.this,LogInActivity.class);
//               startActivity(intent);
//               finish();
//           }
       }
   },3000);
    }




}