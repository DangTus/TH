package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUserName, edPassword;
    TextView txtSignUp;
    Button btnLogin;
    ImageButton imbEye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edUserName.getText().toString().trim().isEmpty() || edPassword.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                } else if (!edUserName.getText().toString().trim().equals("2050531200316") || !edPassword.getText().toString().trim().equals("dangvanhoaitu")) {
                    Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu của bạn không đúng. Vui lòng đăng nhập lại!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intentLogin = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intentLogin);
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
    }
}