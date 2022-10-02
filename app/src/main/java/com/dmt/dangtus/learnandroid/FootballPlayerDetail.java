package com.dmt.dangtus.learnandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dmt.dangtus.learnandroid.model.FootballPlayer;

public class FootballPlayerDetail extends AppCompatActivity {

    TextView txtName, txtClub;
    ImageView imvAvata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_player_detail);

//        anhXa();
//
//        Intent intent = getIntent();
//        if(intent != null) {
//            FootballPlayer footballPlayer = (FootballPlayer) intent.getSerializableExtra("duLieu");
//
//            txtName.setText(footballPlayer.getName());
//            txtClub.setText(footballPlayer.getClub());
//            imvAvata.setImageResource(footballPlayer.getImage());
//        } else {
//            Toast.makeText(this, "intent null", Toast.LENGTH_SHORT).show();
//        }
    }

//    private void anhXa() {
//        txtName = (TextView) findViewById(R.id.nameDetailTV);
//        txtClub = (TextView) findViewById(R.id.clubDetailTV);
//        imvAvata = (ImageView) findViewById(R.id.avataDetailIMV);
//    }
}