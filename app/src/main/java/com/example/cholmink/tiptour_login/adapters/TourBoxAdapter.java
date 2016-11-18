package com.example.cholmink.tiptour_login.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cholmink.tiptour_login.R;
import com.example.cholmink.tiptour_login.data.StaticData;
import com.example.cholmink.tiptour_login.data.TourBoxItem;

import java.util.ArrayList;

/**
 * Created by dnay2 on 2016-11-18.
 */

public class TourBoxAdapter extends BaseAdapter {

    private StaticData mData = StaticData.getInstance();
    private ArrayList<TourBoxItem> items;
    private Context context;

    public TourBoxAdapter(ArrayList<TourBoxItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        if(items != null) return items.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        LinearLayout itembg;
        TextView numberText;
        TextView nameText;
        TextView timeText;
        TextView lengthText;
        TextView costText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if(v == null){
            v = View.inflate(context, R.layout.fragment_tourbox_item, null);
            holder = new ViewHolder();
            holder.itembg = (LinearLayout) v.findViewById(R.id.itembg);
            v.setTag(holder);
        } else{
            holder = (ViewHolder) v.getTag();
        }
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mData.getHeight()/10);
        holder.itembg.setLayoutParams(llp);
        if(position%2 == 0) holder.itembg.setBackgroundColor(0xff000000);
        else holder.itembg.setBackgroundColor(0xffffff00);

        /**
         * holder로 꾸미기
         */

        return v;
    }
}
