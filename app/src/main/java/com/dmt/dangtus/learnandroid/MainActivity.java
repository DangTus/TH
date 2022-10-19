package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.dmt.dangtus.learnandroid.adapter.UserApapter;
import com.dmt.dangtus.learnandroid.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private List<User> userList;
    private UserApapter adapter;
    private Switch swDocNgang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        layoutManager = new LinearLayoutManager(this);
        showRecycleView("doc");

        swDocNgang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    showRecycleView("ngang");
                    swDocNgang.setText("Ngang");
                } else {
                    showRecycleView("doc");
                    swDocNgang.setText("Dọc");
                }
            }
        });
    }

    private void showRecycleView(String direction) {
        switch (direction) {
            case "doc":
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                break;
            case "ngang":
                layoutManager.setOrientation(RecyclerView.HORIZONTAL);
                break;
        }
        recyclerView.setLayoutManager(layoutManager);

        adapter = new UserApapter(userList, direction);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void anhXa() {
        swDocNgang = findViewById(R.id.docNgangSwitch);
        recyclerView = findViewById(R.id.listRecyclerView);

        userList = new ArrayList<>();
        userList.add(new User("Tus 1"));
        userList.add(new User("Tus 2"));
        userList.add(new User("Tus 3"));
        userList.add(new User("Tus 4"));
        userList.add(new User("Tus 5"));
        userList.add(new User("Tus 6"));
        userList.add(new User("Tus 7"));
        userList.add(new User("Tus 8"));
        userList.add(new User("Tus 9"));
        userList.add(new User("Tus 10"));
    }
}