package com.dmt.dangtus.learnandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dmt.dangtus.learnandroid.R;
import com.dmt.dangtus.learnandroid.model.User;

import java.util.List;

public class UserApapter extends RecyclerView.Adapter<UserApapter.ViewHolder> {

    private List<User> userList;
    private String direction;

    public UserApapter(List<User> userList, String direction) {
        this.userList = userList;
        this.direction = direction;
    }

    @NonNull
    @Override
    public UserApapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (direction) {
            case "doc":
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_vertical, parent, false);
                break;
            case "ngang":
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_horizontal, parent, false);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_vertical, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserApapter.ViewHolder holder, int position) {
        String name = userList.get(position).getName();

        holder.setData(name);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.nameTextView);
        }

        public void setData(String name) {
            txtName.setText(name);
        }
    }
}
