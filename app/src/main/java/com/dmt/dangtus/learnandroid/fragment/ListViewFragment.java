package com.dmt.dangtus.learnandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.dmt.dangtus.learnandroid.FootballPlayerTransmission;
import com.dmt.dangtus.learnandroid.R;
import com.dmt.dangtus.learnandroid.adapter.FootballPlayerAdapter;
import com.dmt.dangtus.learnandroid.model.FootballPlayer;

import java.util.ArrayList;

public class ListViewFragment extends ListFragment {

    ArrayList<FootballPlayer> arrayList;
    FootballPlayerAdapter listAdapter;
    private FootballPlayerTransmission footballPlayerTransmission;

    public ListViewFragment() {
        arrayList = new ArrayList<>();
        arrayList.add(new FootballPlayer(R.drawable.img_avata,                  "Đặng Văn Hoài Tú",         "2050531200316",        1,          1, false));
        arrayList.add(new FootballPlayer(R.drawable.img_lionel_bestoanf,        "Lionel BesToanf",          "Barcelona",            999999999,  6, true));
        arrayList.add(new FootballPlayer(R.drawable.img_harry_maguire,          "Harry Maguire",            "Manchester United",    84930664,   2, false));
        arrayList.add(new FootballPlayer(R.drawable.img_cristiano_ronaldo,      "Cristiano Ronaldo",        "Manchester United",    23461095.1, 4, true));
        arrayList.add(new FootballPlayer(R.drawable.img_lionel_messi,           "Lionel Messi",             "Paris Saint-Germain",  55000000,   4, false));
        arrayList.add(new FootballPlayer(R.drawable.img_kylian_mbappe_lottin,   "Kylian Mbappe Lottin",     "Paris Saint-Germain",  141546100,  5, true));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        footballPlayerTransmission = (FootballPlayerTransmission) getActivity();

        listAdapter = new FootballPlayerAdapter(getActivity(), R.layout.item_football_player, arrayList);
        setListAdapter(listAdapter);

        return inflater.inflate(R.layout.fragment_listview, container, false);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        footballPlayerTransmission.DataFootballPlayer(arrayList.get(position));
    }
}
