package com.dmt.dangtus.learnandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dmt.dangtus.learnandroid.model.FootballPlayer;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FootballPlayerDetail extends AppCompatActivity {

    TextView txtName, txtClub, txtQuantity, txtPrice;
    ImageView imvAvata;
    Button btnBuyProduct;
    RatingBar rtbSkill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_player_detail);

        anhXa();

        Intent intent = getIntent();
        FootballPlayer footballPlayer = (FootballPlayer) intent.getSerializableExtra("duLieu");
        if(footballPlayer != null) {
            txtName.setText(footballPlayer.getName());
            txtClub.setText(footballPlayer.getClub());

            double money = footballPlayer.getPrice();
            DecimalFormat hehe = new DecimalFormat("#,##0"); //#,##0.000
            txtPrice.setText(hehe.format(money) + "");

            imvAvata.setImageResource(footballPlayer.getImage());

            rtbSkill.setRating(footballPlayer.getSkill());
        }
    }

    private void anhXa() {
        txtName = (TextView) findViewById(R.id.nameTextView);
        txtClub = (TextView) findViewById(R.id.club);
        txtPrice = (TextView) findViewById(R.id.price);
        txtQuantity = (TextView) findViewById(R.id.quantity);
        imvAvata = (ImageView) findViewById(R.id.avataIMV);

        btnBuyProduct = (Button) findViewById(R.id.buyProductButton);

        rtbSkill = (RatingBar) findViewById(R.id.skillRatingBar);
    }
}