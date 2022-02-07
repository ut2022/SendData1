package com.example.senddata.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senddata.Details;
import com.example.senddata.R;
import com.example.senddata.SelectListener;
import com.example.senddata.model.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {
    private ArrayList<Employee> employeeArrayList;
    private SelectListener listener;
    private Context ct;
    // RecyclerView recyclerView;
    public EmployeeAdapter(Context ct,ArrayList<Employee> listdata, SelectListener listener) {
        this.employeeArrayList = listdata;
        this.listener=listener;
        this.ct=ct;
    }

    @Override
    public EmployeeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recyclerviewitem, parent, false);
        EmployeeHolder viewHolder = new EmployeeHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EmployeeHolder holder, int position) {
        holder.textView.setText(employeeArrayList.get(position).getId());
        holder.textView1.setText(employeeArrayList.get(position).getName());
        holder.textView2.setText(employeeArrayList.get(position).getPhoneno());
        holder.textView3.setText(employeeArrayList.get(position).getSpin());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(ct, Details.class);
                intent.putExtra("id",employeeArrayList.get(position).getId());
                intent.putExtra("name",employeeArrayList.get(position).getName());
                intent.putExtra("phonenumber",employeeArrayList.get(position).getPhoneno());
                intent.putExtra("spin",employeeArrayList.get(position).getSpin());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ct.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }

    public static class EmployeeHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public CardView cardView;

        public EmployeeHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.Recycle1);
            this.textView1 = (TextView) itemView.findViewById(R.id.Recycle2);
            this.textView2 = (TextView) itemView.findViewById(R.id.Recycle3);
            this.textView3 = (TextView) itemView.findViewById(R.id.Recycle4);
            this.cardView =(CardView)itemView.findViewById(R.id.container);
        }
    }
}
