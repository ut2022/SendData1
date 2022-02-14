package com.example.senddata.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senddata.ui.details.DetailsActivity;
import com.example.senddata.R;
import com.example.senddata.SelectListener;
import com.example.senddata.adapter.EmployeeAdapter;
import com.example.senddata.model.Employee;
import com.example.senddata.model.EmployeeList;

public class HomeActivity extends AppCompatActivity implements SelectListener {
    TextView receiverId;
    TextView receiverName;
    TextView receiverPhno;
    TextView receiverLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        EmployeeAdapter adapter = new EmployeeAdapter(HomeActivity.this, EmployeeList.employeeArrayList, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

//        receiverId = (TextView) findViewById(R.id.receive_value_id);
//        receiverName = (TextView) findViewById(R.id.receive_value_id1);
//        receiverPhno = (TextView) findViewById(R.id.receive_value_id2);
//        receiverLevel = (TextView) findViewById(R.id.receive_value_id3);

//        Employee user = getIntent().getParcelableExtra("user");
//        receiverId.setText(user.id);
//        receiverName.setText(user.name);
//        receiverPhno.setText(user.phoneno);
//        receiverLevel.setText(user.Spin);
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

    @Override
    public void onItemClicked(Employee employee) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("user", employee);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}