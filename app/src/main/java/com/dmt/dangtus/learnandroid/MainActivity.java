package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUserName, edPassword;
    TextView txtSignUp;
    Button btnLogin;
    ImageButton imbEye;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        //gan gia tri sharedPreferences
        edUserName.setText(sharedPreferences.getString("userName", ""));
        edPassword.setText(sharedPreferences.getString("password", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("remember", false));

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edUserName.getText().toString().trim();
                String password = edPassword.getText().toString().trim();

                if(userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                } else if (!userName.equals("admin") || !password.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu của bạn không đúng. Vui lòng đăng nhập lại!", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    if(cbRemember.isChecked()) {;
                        editor.putString("userName", userName);
                        editor.putString("password", password);
                        editor.putBoolean("remember", true);
                        editor.commit();
                    } else {
                        editor.remove("userName");
                        editor.remove("password");
                        editor.remove("remember");
                        editor.commit();
                    }
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imbEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((Integer) imbEye.getTag() == R.drawable.ic_eye_hide) {
                    imbEye.setImageResource(R.drawable.ic_eye);
                    imbEye.setTag(R.drawable.ic_eye);

                    //129 la kieu password
                    edPassword.setInputType(129);
                } else if ((Integer) imbEye.getTag() == R.drawable.ic_eye) {
                    imbEye.setImageResource(R.drawable.ic_eye_hide);
                    imbEye.setTag(R.drawable.ic_eye_hide);

                    edPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                //dua vi tri con tro ve phia cuoi van ban
                int position = edPassword.length();
                Editable etext = edPassword.getText();
                Selection.setSelection(etext, position);
            }
        });
    }

    private void anhXa() {
        txtSignUp = (TextView) findViewById(R.id.signUpLayout);

        btnLogin = (Button) findViewById(R.id.loginButton);

        edUserName = (EditText) findViewById(R.id.userNameEditText);
        edPassword = (EditText) findViewById(R.id.passwordEditText);

        imbEye = (ImageButton) findViewById(R.id.eyeIMB);
        imbEye.setTag(R.drawable.ic_eye);

        cbRemember = (CheckBox) findViewById(R.id.rememberCheckBox);
    }
}