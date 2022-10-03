package com.dmt.dangtus.learnandroid;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dmt.dangtus.learnandroid.model.FootballPlayer;

public class FootballPlayerDetail extends AppCompatActivity {

    TextView txtName, txtClub, txtRating, txtQuantity, txtPrice;
    ImageView imvAvata;
    Button btnBuyProduct;

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
            txtRating.setText(footballPlayer.getRating() + "");
            txtPrice.setText(footballPlayer.getPrice() + "");

            imvAvata.setImageResource(footballPlayer.getImage());
        }
    }

    private void anhXa() {
        txtName = (TextView) findViewById(R.id.nameTextView);
        txtClub = (TextView) findViewById(R.id.club);
        txtRating = (TextView) findViewById(R.id.ratingTextView);
        txtPrice = (TextView) findViewById(R.id.price);
        txtQuantity = (TextView) findViewById(R.id.quantity);

        imvAvata = (ImageView) findViewById(R.id.avataIMV);

        btnBuyProduct = (Button) findViewById(R.id.buyProductButton);
    }
}