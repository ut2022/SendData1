package com.example.senddata.ui.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.senddata.roomdatabase.UserEntity;
import com.example.senddata.roomdatabase.UserRepository;
import com.example.senddata.ui.login.LogInActivity;
import com.example.senddata.ui.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel implements Observable {
    public UserRepository userRepository;
    public LiveData<UserEntity> getAllPosts;

    private MutableLiveData<LogInActivity.Validationtype> validationLivedata=new MutableLiveData<>() ;

    public MutableLiveData<UserEntity> getApiResponsedata() {
        return apiResponsedata;
    }
    private MutableLiveData<UserEntity> apiResponsedata=new MutableLiveData<>();
    private String username="";

    @Bindable
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    private String userid="";

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
//        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getUserphonenumber() {
        return userphonenumber;
    }

    public void setUserphonenumber(String userphonenumber) {
        this.userphonenumber = userphonenumber;
//        notifyPropertyChanged(BR.userphonenumber);
    }

    private String userphonenumber="";

    public void validate(String name,String phonenumber,String id){
        if (name.isEmpty()) {
            validationLivedata.setValue(LogInActivity.Validationtype.NAME);
        return;
        }
        if (phonenumber.isEmpty()|| phonenumber.length() <= 10) {
            validationLivedata.setValue(LogInActivity.Validationtype.PHONE);
        return;
        }
        if (id.isEmpty()) {
            validationLivedata.setValue(LogInActivity.Validationtype.ID);
            return;
        }
        validationLivedata.setValue(LogInActivity.Validationtype.SUCCESS);
    }

    public MutableLiveData<LogInActivity.Validationtype> getValidationLivedata() {
        return validationLivedata;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    public void onButtonClicked() {
        validate(username,userphonenumber,userid);
    }

//    public void getAllData() {
//        RetrofitClient.getRetrofitInstance().getMyApi().getAllData();
//        Call<ApiResults> call = RetrofitClient.getRetrofitInstance().getMyApi().getAllData();
//        call.enqueue(new Callback<ApiResults>() {
//            @Override
//            public void onResponse(Call<ApiResults> call, Response<ApiResults> response) {
//                ApiResults apiResults = response.body();
////                Toast.makeText(getApplicationContext(), "SUCCESS" + apiResults.getName(), Toast.LENGTH_LONG).show();
//                Log.e(TAG, "onResponse: " + response.code());
//                Log.e(TAG, "onResponse: name " + response.body().getName());
//                Log.e(TAG, "onResponse: phonenumber " + response.body().getCity());
//
//                apiResponsedata.setValue(apiResults);
//
//            }
//
//            @Override
//            public void onFailure(Call<ApiResults> call, Throwable t) {
//                apiResponsedata.setValue(null);
////                Toast.makeText(getApplicationContext(), "An error has occured" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }

    public LoginViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        getAllPosts = userRepository.getAllPosts();
    }
    public void insert(UserEntity userEntity){
        userRepository.insert(userEntity);
    }
    public LiveData<UserEntity> getAllPosts()
    {
        return getAllPosts;
    }

    public void getAllData(){
        Call<UserEntity> call=RetrofitClient.getRetrofitInstance().getMyApi().getAllData();
        call.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                UserEntity userEntity= response.body();
                if(response.isSuccessful()){
                    userRepository.insert(userEntity);
                    apiResponsedata.setValue(userEntity);
                }
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {
                apiResponsedata.setValue(null);
                Log.d("main", "onFailure: "+t.getMessage());
            }
        });
    }
    public LiveData<Integer> getCount(){
        return userRepository.getCount();
    }
}
