package com.example.senddata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.senddata.ui.fragments.CurrentEmployeesFragment;
import com.example.senddata.ui.fragments.PreviousEmployeesFragment;
import com.google.android.material.tabs.TabLayout;

public class EmployeeHistoryActivity extends AppCompatActivity {
TabLayout tabLayout;
FrameLayout frameLayout;
Fragment fragment=null;
FragmentManager fragmentManager;
FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_history);

        tabLayout=findViewById(R.id.tablayout);
        frameLayout=findViewById(R.id.framelayout);

        fragment=new CurrentEmployeesFragment();
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction().replace(R.id.framelayout,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment=null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment=new CurrentEmployeesFragment();
                        break;

                    case 1:
                        fragment=new PreviousEmployeesFragment();
                        break;
                }
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.framelayout,fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}