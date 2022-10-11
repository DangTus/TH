package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {

    TableLayout tbLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        tbLayout = (TableLayout) findViewById(R.id.tableLayout);

        int soCot = 3;
        double soDong = Math.ceil(MainActivity.cauThuList.size() / soCot);

        Toast.makeText(this, ""+soDong, Toast.LENGTH_SHORT).show();
    }
}