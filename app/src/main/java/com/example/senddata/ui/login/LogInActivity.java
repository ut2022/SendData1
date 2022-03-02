package com.example.senddata.ui.login;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.senddata.databinding.ActivityLogInBinding;
import com.example.senddata.roomdatabase.UserDao;
import com.example.senddata.roomdatabase.UserDatabase;
import com.example.senddata.roomdatabase.UserEntity;
import com.example.senddata.ui.information.InformationActivity;
import com.example.senddata.R;
import com.example.senddata.model.ApiResults;
import com.example.senddata.model.Info;
import com.example.senddata.ui.main.MainActivity;
import com.example.senddata.ui.retrofit.RetrofitClient;
import com.example.senddata.ui.viewmodel.LoginViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {
    public static String PREFS_NAME = "MyPrefsFile";
    EditText etName;
    EditText etPhno;
    Button buttonLogin;
    EditText etId;
    LoginViewModel loginViewModel;
    Boolean islogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class); //initialize viewmodel
        ActivityLogInBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_log_in);
        registerObservers();
        binding.setViewModel(loginViewModel);

        buttonLogin = findViewById(R.id.bt_login);
        etPhno = findViewById(R.id.et_login_phno);
        etName = findViewById(R.id.et_login_name);
        etId = findViewById(R.id.et_login_id);
//        buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                loginViewModel.validate(etName.getText().toString(),etPhno.getText().toString(),etId.getText().toString());
//                UserEntity userEntity=new UserEntity();
//                userEntity.setUserId(etId.getText().toString());
//                userEntity.setName(etName.getText().toString());
//                userEntity.setUserphno(etPhno.getText().toString());
//
////                startActivity(new Intent(LogInActivity.this, MainActivity.class));
////                finish();
//            if(validate(userEntity)){
//                UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
//                UserDao userDao=userDatabase.userDao();
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        userDao.registerUser(userEntity);
//                        Toast.makeText(getApplicationContext(),"User Registered",Toast.LENGTH_SHORT).show();
//                    }
//                }).start();
//            }else {
//                Toast.makeText(getApplicationContext(),"Fill all fields",Toast.LENGTH_SHORT).show();
//            }
//            }
//        });
    }

    private void registerObservers() {
        loginViewModel.getApiResponsedata().observe(this, new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity userEntity) {
                if(userEntity == null){
                    Toast.makeText(LogInActivity.this, "Error has occured", Toast.LENGTH_SHORT).show();
                }else{
//                    if (!islogin)
////                        return;
//                    SharedPreferences sharedPreferences = getSharedPreferences(LogInActivity.PREFS_NAME, 0);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//
//                    editor.putBoolean("hasLoggedIn", true);
//                    editor.commit();
//
//                    Intent intent=new Intent(LogInActivity.this,InformationActivity.class);
//                    intent.putExtra("info",apiResults);
//                    startActivity(intent);
//                    pass apiresult
                }
                    //save apiresult in room db
            }
        });

        loginViewModel.getValidationLivedata().observe(this, new Observer<Validationtype>() {
            @Override
            public void onChanged(Validationtype s) {
                switch (s) {
                    case NAME:
                        Toast.makeText(LogInActivity.this, "Please Fill Name", Toast.LENGTH_SHORT).show();
                        break;

                    case PHONE:
                        Toast.makeText(LogInActivity.this, "Please Fill PhoneNumber", Toast.LENGTH_SHORT).show();
                        break;

                    case SUCCESS:
//                        Toast.makeText(LogInActivity.this, "Success", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
////                intent.putExtra("user", user);
//                        startActivity(intent);
                        loginViewModel.getAllData();
                        break;

                    case ID:
                        Toast.makeText(LogInActivity.this, "Please Fill Id", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private Boolean validate(UserEntity userEntity) {
        if (etName.getText().toString().isEmpty()) {
            Toast.makeText(LogInActivity.this, "Please Fill Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPhno.getText().toString().isEmpty() || etPhno.getText().length() <= 10) {
            Toast.makeText(LogInActivity.this, "Please Fill PhoneNumber", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etId.getText().toString().isEmpty()) {
            Toast.makeText(LogInActivity.this, "Please Fill Id", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public enum Validationtype {
        PHONE, NAME, SUCCESS, ID
    }


}

