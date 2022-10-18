package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dmt.dangtus.learnandroid.adapter.UserApapter;
import com.dmt.dangtus.learnandroid.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<User> userList;
    UserApapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new UserApapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void anhXa() {
        recyclerView = findViewById(R.id.listRecyclerView);

        userList = new ArrayList<>();
        userList.add(new User("Tus 1"));
        userList.add(new User("Tus 2"));
        userList.add(new User("Tus 3"));
        userList.add(new User("Tus 4"));
        userList.add(new User("Tus 5"));
    }
}