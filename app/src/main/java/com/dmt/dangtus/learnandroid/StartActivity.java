package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Boolean remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        //lay gia tri
        remember = sharedPreferences.getBoolean("remember", false);

        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Intent intent;
                if(remember) {
                    intent = new Intent(StartActivity.this, HomeActivity.class);
                } else {
                    intent = new Intent(StartActivity.this, MainActivity.class);
                }
                startActivity(intent);
            }
        };
        t.schedule(task, 2000);
    }
}