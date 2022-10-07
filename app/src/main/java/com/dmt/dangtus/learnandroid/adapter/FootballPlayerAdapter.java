package com.dmt.dangtus.learnandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmt.dangtus.learnandroid.R;

import java.text.DecimalFormat;
import java.util.List;

import com.dmt.dangtus.learnandroid.model.FootballPlayer;

public class FootballPlayerAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<FootballPlayer> footballPlayerList;

    public FootballPlayerAdapter(Context context, int layout, List<FootballPlayer> foodList) {
        this.context = context;
        this.layout = layout;
        this.footballPlayerList = foodList;
    }

    @Override
    public int getCount() {
        return footballPlayerList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);

            holder = new ViewHolder();
            //anh xa
            holder.txtName = (TextView) view.findViewById(R.id.nameTextView);
            holder.txtDescribe = (TextView) view.findViewById(R.id.clubTextView);
            holder.txtPrice = (TextView) view.findViewById(R.id.priceTextView);
            holder.imvImage = (ImageView) view.findViewById(R.id.avataIMV);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //gan gia tri
        FootballPlayer footballPlayer = footballPlayerList.get(i);
        holder.txtName.setText(footballPlayer.getName());
        holder.txtDescribe.setText(footballPlayer.getClub());

        double money = footballPlayer.getPrice();
        DecimalFormat hehe = new DecimalFormat("#,##0"); //#,##0.000
        holder.txtPrice.setText("$" + hehe.format(money));

        holder.imvImage.setImageResource(footballPlayer.getImage());

        return view;
    }

    private class ViewHolder {
        ImageView imvImage;
        TextView txtName, txtDescribe, txtPrice;
    }
}
