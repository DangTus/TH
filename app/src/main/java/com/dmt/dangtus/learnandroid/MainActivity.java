package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ImageView imgCauHoi, imgTraLoi;
    public static ArrayList<String> cauThuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        String[] mangCauThu = getResources().getStringArray(R.array.list_cauthu);
        cauThuList = new ArrayList<>(Arrays.asList(mangCauThu));

        //tron mang
        Collections.shuffle(cauThuList);

        int idHinh = getResources().getIdentifier(cauThuList.get(5), "drawable", getPackageName());
        imgCauHoi.setImageResource(idHinh);

        imgTraLoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        imgCauHoi = (ImageView) findViewById(R.id.hinhCauHoi);
        imgTraLoi = (ImageView) findViewById(R.id.hinhTraLoi);
    }
}