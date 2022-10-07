package com.dmt.dangtus.learnandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.dmt.dangtus.learnandroid.HomeActivityInterface;
import com.dmt.dangtus.learnandroid.R;

public class MenuFragment extends Fragment {

    private Button btnLogOut;
    private HomeActivityInterface homeActivityInterface;

    public MenuFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        homeActivityInterface = (HomeActivityInterface) getActivity();

        anhXa(view);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeActivityInterface.Logout();
            }
        });

        return view;
    }

    private void anhXa(View view) {
        btnLogOut = (Button) view.findViewById(R.id.logOutButton);
    }
}
