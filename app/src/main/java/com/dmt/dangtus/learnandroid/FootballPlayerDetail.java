package com.dmt.dangtus.learnandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dmt.dangtus.learnandroid.model.FootballPlayer;

import java.text.DecimalFormat;

public class FootballPlayerDetail extends AppCompatActivity {

    private TextView txtName, txtClub, txtQuantity, txtPrice;
    private ImageView imvAvata, imvLike;
    private Button btnBuyProduct;
    private RatingBar rtbSkill;

    private FootballPlayer footballPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_player_detail);

        anhXa();

        Intent intent = getIntent();
        footballPlayer = (FootballPlayer) intent.getSerializableExtra("duLieu");
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

    public void changeQuantityProduct(View view) {
        int quantity = Integer.parseInt(txtQuantity.getText().toString());

        switch (view.getId()) {
            case R.id.quantityMinus:
                quantity = quantity > 1 ? quantity - 1 : quantity;
                break;

            case R.id.quantityPlus:
                quantity++;
                break;
        }

        txtQuantity.setText(quantity+"");
    }

    public void likeProduct(View view) {
        footballPlayer.setLike(!footballPlayer.isLike());

        if(footballPlayer.isLike()) {
            imvLike.setImageResource(R.drawable.ic_like);
        } else {
            imvLike.setImageResource(R.drawable.ic_unlike);
        }
    }

    private void anhXa() {
        txtName = (TextView) findViewById(R.id.nameTextView);
        txtClub = (TextView) findViewById(R.id.club);
        txtPrice = (TextView) findViewById(R.id.price);
        txtQuantity = (TextView) findViewById(R.id.quantity);

        imvAvata = (ImageView) findViewById(R.id.avataIMV);
        imvLike = (ImageView) findViewById(R.id.likeIMV);

        btnBuyProduct = (Button) findViewById(R.id.buyProductButton);

        rtbSkill = (RatingBar) findViewById(R.id.skillRatingBar);
    }
}