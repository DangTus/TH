package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtKetQua;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        anhXa();

        Intent intent = getIntent();
        String monHoc = intent.getStringExtra("monHoc");
        txtKetQua.setText(txtKetQua.getText() + "\"" + monHoc + "\"");

        //back
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    private void anhXa() {
        txtKetQua = (TextView) findViewById(R.id.ketQuaTextView);
        btnback = (Button) findViewById(R.id.backButton);
    }
}