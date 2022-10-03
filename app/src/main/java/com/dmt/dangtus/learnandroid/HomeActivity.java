package com.dmt.dangtus.learnandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.dmt.dangtus.learnandroid.fragment.ViewPagerAdapter;
import com.dmt.dangtus.learnandroid.model.FootballPlayer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.Serializable;

public class HomeActivity extends AppCompatActivity implements FootballPlayerTransmission {

    private BottomNavigationView bottomNavigation;
    private ViewPager2 homeViewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        anhXa();

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
                }
                return true;
            }
        });
    }

    private void anhXa() {
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNav);
        homeViewPager = (ViewPager2) findViewById(R.id.viewPagerHome);
    }

    @Override
    public void DataFootballPlayer(FootballPlayer footballPlayer) {
        Intent intent = new Intent(HomeActivity.this, FootballPlayerDetail.class);
//        intent.putExtra("duLieu", footballPlayer);
        startActivity(intent);
    }
}