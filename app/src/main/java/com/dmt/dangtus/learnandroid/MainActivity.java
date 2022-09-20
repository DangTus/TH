package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import model.FootballPlayer;
import model.FootballPlayerAdapter;

public class MainActivity extends AppCompatActivity {

    ListView lvFootballPlayer;
    ArrayList<FootballPlayer> footballPlayerArrayList;
    FootballPlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        adapter = new FootballPlayerAdapter(this, R.layout.football_player_item, footballPlayerArrayList);
        lvFootballPlayer.setAdapter(adapter);
    }

    private void anhXa() {
        lvFootballPlayer = (ListView) findViewById(R.id.footballPlayerLV);

        footballPlayerArrayList = new ArrayList<>();
        footballPlayerArrayList.add(new FootballPlayer( "Cristiano Ronaldo", "Manchester United", R.drawable.cristiano_ronaldo, 21.4));
        footballPlayerArrayList.add(new FootballPlayer( "Lionel Messi", "Paris Saint-Germain", R.drawable.lionel_messi, 48.1));
        footballPlayerArrayList.add(new FootballPlayer( "Kylian Mbappé", "Paris Saint-Germain", R.drawable.kylian_mbappe, 193.3));
        footballPlayerArrayList.add(new FootballPlayer( "Harry Maguire", "Manchester United", R.drawable.harry_maguire, 76.3));
    }
}