package com.dmt.dangtus.learnandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        //xoa football player
        lvFootballPlayer.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                xacNhanXoa(i);
                return false;
            }
        });

        //chuyen qua trang detail
        lvFootballPlayer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, FootballPlayerDetail.class);
                intent.putExtra("duLieu", footballPlayerArrayList.get(i));
                startActivity(intent);
            }
        });
    }

    private void xacNhanXoa(int id) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Thông báo!");
        alert.setIcon(R.mipmap.ic_launcher);
        alert.setMessage("Bạn có thật sự muốn " + footballPlayerArrayList.get(id).getName() + " cút khỏi List view của bạn không?");
        alert.setCancelable(false);

        alert.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                footballPlayerArrayList.remove(id);
                adapter.notifyDataSetChanged();
            }
        });

        alert.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alert.show();
    }

    private void anhXa() {
        lvFootballPlayer = (ListView) findViewById(R.id.footballPlayerLV);

        footballPlayerArrayList = new ArrayList<>();
        footballPlayerArrayList.add(new FootballPlayer( "Đặng Văn Hoài Tú", "2050531200316", R.drawable.dvhtus, 1.1));
        footballPlayerArrayList.add(new FootballPlayer( "Lionel BesToanf", "Barcelona", R.drawable.lionel_bestoanf, 9999.9));
        footballPlayerArrayList.add(new FootballPlayer( "Harry Maguire", "Manchester United", R.drawable.harry_maguire, 76.3));
        footballPlayerArrayList.add(new FootballPlayer( "Cristiano Ronaldo", "Manchester United", R.drawable.cristiano_ronaldo, 21.4));
        footballPlayerArrayList.add(new FootballPlayer( "Lionel Messi", "Paris Saint-Germain", R.drawable.lionel_messi, 48.1));
        footballPlayerArrayList.add(new FootballPlayer( "Kylian Mbappé", "Paris Saint-Germain", R.drawable.kylian_mbappe, 193.3));

    }
}