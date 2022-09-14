package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    TextView txtLogin;
    EditText edtName, edtUserName, edtPassword, getEdtPasswordConfirm;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        anhXa();

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intentSignUp = new Intent(SignUpActivity.this, MainActivity.class);
//                startActivity(intentSignUp);
                checkEmpty(edtName);
            }
        });


    }

    private void checkEmpty(EditText edtDuLieu) {
        if(edtDuLieu.getText().toString().trim().isEmpty()) {
            edtDuLieu.setError("Vui lòng nhập");
        }
    }

    private void anhXa() {
        txtLogin = (TextView) findViewById(R.id.loginLayout);
        btnSignUp = (Button) findViewById(R.id.signUpButton);

        edtName = (EditText) findViewById(R.id.fullNameEditText);
        edtUserName = (EditText) findViewById(R.id.userNameEditText);
        edtPassword = (EditText) findViewById(R.id.passwordEditText);
        getEdtPasswordConfirm = (EditText) findViewById(R.id.confirmPasswordEditText);
    }
}