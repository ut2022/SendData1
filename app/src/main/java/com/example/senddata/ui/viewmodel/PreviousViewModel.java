package com.example.senddata.ui.viewmodel;

import static android.content.ContentValues.TAG;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.senddata.model.Previous;
import com.example.senddata.model.PreviousResults;
import com.example.senddata.model.UserResults;
import com.example.senddata.ui.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreviousViewModel extends ViewModel {
    private MutableLiveData<List<PreviousResults>> previousResponsedata = new MutableLiveData<>();

    public MutableLiveData<List<PreviousResults>> getPreviousResponsedata() {
        return previousResponsedata;

    }
    public void getPre(){
        RetrofitClient.getRetrofitInstance().getMyApi().getPre();
        Call<List<PreviousResults>> call = RetrofitClient.getRetrofitInstance().getMyApi().getPre();
        call.enqueue(new Callback<List<PreviousResults>>() {
            @Override
            public void onResponse(Call<List<PreviousResults>> call, Response<List<PreviousResults>> response) {
                List<PreviousResults> previousResults = response.body();
                Log.e(TAG, "onResponse: " + response.code());
                previousResponsedata.setValue(previousResults);
            }

            @Override
            public void onFailure(Call<List<PreviousResults>> call, Throwable t) {
                previousResponsedata.setValue(null);
            }
        });
    }
}