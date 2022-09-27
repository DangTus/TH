package com.dmt.dangtus.learnandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.dmt.dangtus.learnandroid.R;
import com.dmt.dangtus.learnandroid.adapter.FootballPlayerAdapter;
import com.dmt.dangtus.learnandroid.model.FootballPlayer;

import java.util.ArrayList;

public class ListViewFragment extends ListFragment {

    ArrayList<FootballPlayer> arrayList;
    FootballPlayerAdapter listAdapter;

    public ListViewFragment() {
        arrayList = new ArrayList<>();
        arrayList.add(new FootballPlayer(R.drawable.img_avata, "Đặng Văn Hoài Tú", "2050531200316", 10000, "VNĐ", 1.1));
        arrayList.add(new FootballPlayer(R.drawable.img_lionel_bestoanf, "Lionel BesToanf", "Barcelona", 999.9, "triệu USD", 5.9));
        arrayList.add(new FootballPlayer(R.drawable.img_harry_maguire, "Harry Maguire", "Manchester United", 87, "triệu Euro", 2));
        arrayList.add(new FootballPlayer(R.drawable.img_cristiano_ronaldo, "Cristiano Ronaldo", "Manchester United", 21.4, "triệu bảng Anh", 4));
        arrayList.add(new FootballPlayer(R.drawable.img_lionel_messi, "Lionel Messi", "Paris Saint-Germain", 55, "triệu USD", 4));
        arrayList.add(new FootballPlayer(R.drawable.img_kylian_mbappe, "Kylian Mbappé", "Paris Saint-Germain", 145, "triệu Euro", 5));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        listAdapter = new FootballPlayerAdapter(getActivity(), R.layout.item_football_player, arrayList);
        setListAdapter(listAdapter);

        return inflater.inflate(R.layout.fragment_listview, container, false);
    }
}
