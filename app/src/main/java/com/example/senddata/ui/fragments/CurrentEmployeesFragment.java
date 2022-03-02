package com.example.senddata.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.senddata.R;
import com.example.senddata.adapter.PostAdapter;
import com.example.senddata.model.ApiResults;
import com.example.senddata.model.User;
import com.example.senddata.model.UserResults;
import com.example.senddata.ui.information.InformationActivity;
import com.example.senddata.ui.login.LogInActivity;
import com.example.senddata.ui.retrofit.Api;
import com.example.senddata.ui.viewmodel.BaseViewModel;
import com.example.senddata.ui.viewmodel.LoginViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentEmployeesFragment extends Fragment {
private RecyclerView recyclerView;
BaseViewModel baseViewModel;
    public CurrentEmployeesFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_current_employees, container, false);
        baseViewModel = new ViewModelProvider(this).get(BaseViewModel.class);
        userObservers();
        recyclerView = view.findViewById(R.id.rv_user);
        LinearLayoutManager mymanager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(mymanager);
        baseViewModel.getPost();

//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl("https://mocki.io/v1/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

//        UserApi userApi=retrofit.create(UserApi.class);
//        Call<List<User>> call= Api.getPost();
//        call.enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                if(!response.isSuccessful()){
//                    Toast.makeText(getContext(),response.code(),Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                List<User> userList =response.body();
//                PostAdapter postAdapter=new PostAdapter(getContext(),userList);
//                recyclerView.setAdapter(postAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//            }
//        });
        return view;
    }
        private void userObservers() {
            baseViewModel.getUserResponsedata().observe(getViewLifecycleOwner(), (Observer<List<UserResults>>) userResults -> {
                if(userResults == null){
                    Toast.makeText(getContext(), "Error has occured", Toast.LENGTH_SHORT).show();
                }else{
                    PostAdapter postAdapter=new PostAdapter(getContext(),userResults);
                    recyclerView.setAdapter(postAdapter);
                }
            });
            
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

//                Toast.makeText(this, "Back button pressed!", Toast.LENGTH_SHORT).show();
//                this.onBackPressed();
                finish();  //destroy method called
                return true;
        }
        return super.onOptionsItemSelected(item);  //immediate base class function call
    }

    private void finish() {
    }
}