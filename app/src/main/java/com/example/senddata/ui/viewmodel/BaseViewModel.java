package com.example.senddata.ui.viewmodel;

import static android.content.ContentValues.TAG;

import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.senddata.model.ApiResults;
import com.example.senddata.model.User;
import com.example.senddata.model.UserResults;
import com.example.senddata.ui.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseViewModel extends ViewModel {

    private MutableLiveData<List<UserResults>> userResponsedata=new MutableLiveData<>();

    public MutableLiveData<List<UserResults>> getUserResponsedata() {
        return userResponsedata;

    }

    public void getPost(){
        RetrofitClient.getRetrofitInstance().getMyApi().getPost();
        Call<List<UserResults>> call = RetrofitClient.getRetrofitInstance().getMyApi().getPost();
        call.enqueue(new Callback<List<com.example.senddata.model.UserResults>>() {
            @Override
            public void onResponse(Call<List<com.example.senddata.model.UserResults>> call, Response<List<com.example.senddata.model.UserResults>> response) {
                List<UserResults> userResults = response.body();
//                Toast.makeText(getApplicationContext(), "SUCCESS" + apiResults.getName(), Toast.LENGTH_LONG).show();
                Log.e(TAG, "onResponse: " + response.code());

                userResponsedata.setValue(userResults);
            }

            @Override
            public void onFailure(Call<List<com.example.senddata.model.UserResults>> call, Throwable t) {
                userResponsedata.setValue(null);
            }
        });
    }
}
