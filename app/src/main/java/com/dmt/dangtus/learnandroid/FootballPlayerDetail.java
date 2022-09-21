package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import model.FootballPlayer;

public class FootballPlayerDetail extends AppCompatActivity {

    TextView txtName, txtClub;
    ImageView imvAvata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_player_detail);

        anhXa();

        Intent intent = getIntent();
        FootballPlayer footballPlayer = (FootballPlayer) intent.getSerializableExtra("duLieu");

        txtName.setText(footballPlayer.getName());
        txtClub.setText(footballPlayer.getClub());
        imvAvata.setImageResource(footballPlayer.getImage());
    }

    private void anhXa() {
        txtName = (TextView) findViewById(R.id.nameDetailTV);
        txtClub = (TextView) findViewById(R.id.clubDetailTV);
        imvAvata = (ImageView) findViewById(R.id.avataDetailIMV);
    }
}