package com.example.senddata.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senddata.R;
import com.example.senddata.model.User;
import com.example.senddata.model.UserResults;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<UserResults> postList;
    Context context;

    public PostAdapter(Context context,List<UserResults> users){
        this.context =context;
        postList=users;
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.current_details,parent,false);
       return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        UserResults userResults=postList.get(position);
        holder.name.setText("name : "+ userResults.getName());
        holder.city.setText("city : "+ userResults.getCity());
        holder.designation.setText("designation : "+ userResults.getDesignation());
        holder.employee_id.setText("employee_id : "+ userResults.getEmployee_id());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
    TextView name,city,designation,employee_id;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.tv_current_name);
            city=itemView.findViewById(R.id.tv_current_city);
            designation=itemView.findViewById(R.id.tv_current_designation);
            employee_id=itemView.findViewById(R.id.tv_current_id);
        }
    }

}
