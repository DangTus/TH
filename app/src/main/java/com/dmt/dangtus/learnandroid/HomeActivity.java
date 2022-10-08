package com.dmt.dangtus.learnandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import com.dmt.dangtus.learnandroid.fragment.ViewPagerAdapter;
import com.dmt.dangtus.learnandroid.model.FootballPlayer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements HomeActivityInterface {

    private BottomNavigationView bottomNavigation;
    private ViewPager2 homeViewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private Boolean exit = false;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        anhXa();

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        viewPagerAdapter = new ViewPagerAdapter(this);
        homeViewPager.setAdapter(viewPagerAdapter);

        //su kien khi luot doi page trong viewpager2
        homeViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    bottomNavigation.getMenu().findItem(R.id.action_home).setChecked(true);
                    break;

                case 1:
                    bottomNavigation.getMenu().findItem(R.id.action_listview).setChecked(true);
                    break;

                case 2:
                    bottomNavigation.getMenu().findItem(R.id.action_profile).setChecked(true);
                    break;

                case 3:
                    bottomNavigation.getMenu().findItem(R.id.action_menu).setChecked(true);
                    break;
            }
            }
        });

        //su kien khi click vao o bottom navigation view
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        homeViewPager.setCurrentItem(0);
                        break;

                    case R.id.action_listview:
                        homeViewPager.setCurrentItem(1);
                        break;

                    case R.id.action_profile:
                        homeViewPager.setCurrentItem(2);
                        break;

                    case R.id.action_menu:
                        homeViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }

    private void anhXa() {
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNav);
        homeViewPager = (ViewPager2) findViewById(R.id.viewPagerHome);
    }

    private void setExitFalse() {
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                exit = false;
            }
        };
        t.schedule(task, 2000);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if(!exit) {
                Toast.makeText(this, "Nhấn cái nữa để thoát", Toast.LENGTH_SHORT).show();
                exit = true;
                setExitFalse();
            } else {
                this.finishAffinity();
            }
        }
        return false;
    }

    @Override
    public void FootballPlayerDetail(FootballPlayer footballPlayer) {
        Intent intent = new Intent(HomeActivity.this, FootballPlayerDetail.class);
        intent.putExtra("duLieu", footballPlayer);
        startActivity(intent);
    }

    @Override
    public void Logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Đăng xuất");
        builder.setMessage("Bạn có muốn đăng xuất không");
        builder.setIcon(R.drawable.img_avata);

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("userName");
                editor.remove("password");
                editor.remove("remember");
                editor.commit();

                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();
    }
}