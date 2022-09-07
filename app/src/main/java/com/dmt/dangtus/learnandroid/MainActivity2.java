package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtKetQua = (TextView) findViewById(R.id.ketQuaTextView);

        Intent intent = getIntent();
        String monHoc = intent.getStringExtra("monHoc");
        txtKetQua.setText(txtKetQua.getText() + monHoc);
    }
}