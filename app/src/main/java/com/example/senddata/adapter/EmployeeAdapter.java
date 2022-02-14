package com.example.senddata.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senddata.R;
import com.example.senddata.SelectListener;
import com.example.senddata.model.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {
    private ArrayList<Employee> employeeArrayList;
    private SelectListener listener;
    private Context ct;  //current object calling

    // RecyclerView recyclerView;
    public EmployeeAdapter(Context ct, ArrayList<Employee> listdata, SelectListener listener) {
        this.employeeArrayList = listdata;
        this.listener = listener;
        this.ct = ct;
    }

    @Override
    public EmployeeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_employee, parent, false);
        EmployeeHolder viewHolder = new EmployeeHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EmployeeHolder holder, int position) {
        holder.tv_holder_id.setText(employeeArrayList.get(position).getId());
        holder.tv_holder_name.setText(employeeArrayList.get(position).getName());
        holder.tv_holder_phno.setText(employeeArrayList.get(position).getPhoneno());
        holder.tv_holder_level.setText(employeeArrayList.get(position).getSpin());
        holder.onclick_listener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(employeeArrayList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }

    public static class EmployeeHolder extends RecyclerView.ViewHolder {
        public TextView tv_holder_id;
        public TextView tv_holder_name;
        public TextView tv_holder_phno;
        public TextView tv_holder_level;
        public CardView onclick_listener;

        public EmployeeHolder(View itemView) {
            super(itemView);
            this.tv_holder_id = (TextView) itemView.findViewById(R.id.tv_item_id);
            this.tv_holder_name = (TextView) itemView.findViewById(R.id.tv_item_name);
            this.tv_holder_phno = (TextView) itemView.findViewById(R.id.tv_item_phno);
            this.tv_holder_level = (TextView) itemView.findViewById(R.id.tv_item_level);
            this.onclick_listener = (CardView) itemView.findViewById(R.id.cv_item);
        }
    }
}
