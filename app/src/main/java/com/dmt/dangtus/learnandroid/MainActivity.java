package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMonHoc;
    ArrayList<String> monHoc;
    TextView txtMonHoc;
    Button btnThem, btnCapNhat, btnXoa;
    int viTri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        monHoc = new ArrayList<>();
        monHoc.add("Android");
        monHoc.add("PHP");
        monHoc.add("Java");
        monHoc.add("ASP.NET");

        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, monHoc);
        lvMonHoc.setAdapter(arrayAdapter);

        //click
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                viTri = i;
                txtMonHoc.setText(monHoc.get(i));
            }
        });

        //long click
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("monHoc", monHoc.get(i));
                startActivity(intent);

                return false;
            }
        });

        //them mon hoc moi
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monHocAdd = txtMonHoc.getText().toString();
                if(monHocAdd.equals("")) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập môn học cần thêm", Toast.LENGTH_SHORT).show();
                } else {
                    monHoc.add(monHocAdd);
                    arrayAdapter.notifyDataSetChanged();

                    txtMonHoc.setText("");
                }
            }
        });

        //cap nhat mon hoc hien tai
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viTri >= 0) {
                    monHoc.set(viTri, txtMonHoc.getText().toString());
                    arrayAdapter.notifyDataSetChanged();

                    viTri = -1;
                    txtMonHoc.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn môn học cần chỉnh sửa", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //xoa nhat mon hoc hien tai
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viTri >= 0) {
                    monHoc.remove(viTri);
                    arrayAdapter.notifyDataSetChanged();

                    viTri = -1;
                    txtMonHoc.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn môn học cần xóa", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void anhXa() {
        lvMonHoc = (ListView) findViewById(R.id.monHocListView);

        btnThem = (Button) findViewById(R.id.themButton);
        btnCapNhat = (Button) findViewById(R.id.capNhatButton);
        btnXoa = (Button) findViewById(R.id.xoaButton);

        txtMonHoc = (TextView) findViewById(R.id.monHocEditText);
    }
}