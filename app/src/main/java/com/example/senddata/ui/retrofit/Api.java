package com.example.senddata.ui.retrofit;

import com.example.senddata.model.ApiResults;
import com.example.senddata.model.PreviousResults;
import com.example.senddata.model.UserResults;
import com.example.senddata.roomdatabase.UserEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL="https://mocki.io/v1/";
    @GET("4bb5be2c-906b-43c3-921b-5ffb26cd9a93")
     Call<UserEntity> getAllData();

    @GET("414a8d43-5f09-46b2-a0be-fc84178f3f1d")
    Call<List<UserResults>> getPost();

    @GET("0617823a-8f4b-4548-b43b-4cfd80dd3c55")
    Call<List<PreviousResults>> getPre();


}
