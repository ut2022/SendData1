package com.example.senddata.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.senddata.R;
import com.example.senddata.adapter.PostAdapter;
import com.example.senddata.adapter.PreviousAdapter;
import com.example.senddata.model.PreviousResults;
import com.example.senddata.model.UserResults;
import com.example.senddata.ui.viewmodel.BaseViewModel;
import com.example.senddata.ui.viewmodel.PreviousViewModel;

import java.util.List;


public class PreviousEmployeesFragment extends Fragment {
    PreviousViewModel previousViewModel;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_previous_employees, container, false);
        previousViewModel = new ViewModelProvider(this).get(PreviousViewModel.class);
        previousObservers();
        recyclerView = view.findViewById(R.id.rv_previous);
        LinearLayoutManager mymanager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(mymanager);
        previousViewModel.getPre();

        return view;
    }
    private void previousObservers() {
        previousViewModel.getPreviousResponsedata().observe(getViewLifecycleOwner(), (Observer<List<PreviousResults>>) previousResults -> {
            if (previousResults == null) {
                Toast.makeText(getContext(), "Error has occured", Toast.LENGTH_SHORT).show();
            } else {
                PreviousAdapter preAdapter = new PreviousAdapter(getContext(), previousResults);
                recyclerView.setAdapter(preAdapter);
            }
        });
    }
}