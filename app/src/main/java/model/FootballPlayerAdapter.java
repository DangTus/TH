package model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmt.dangtus.learnandroid.R;

import java.util.List;

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

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout, null);

        //anh xa
        TextView txtName = (TextView) view.findViewById(R.id.nameTextView);
        TextView txtDescribe = (TextView) view.findViewById(R.id.clubTextView);
        TextView txtPrice = (TextView) view.findViewById(R.id.priceTextView);
        ImageView imvImage = (ImageView) view.findViewById(R.id.avataIMV);

        //gan gia tri
        FootballPlayer footballPlayer = footballPlayerList.get(i);
        txtName.setText(footballPlayer.getName());
        txtDescribe.setText(footballPlayer.getClub());
        txtPrice.setText(footballPlayer.getPrice() + " £");
        imvImage.setImageResource(footballPlayer.getImage());

        return view;
    }
}
