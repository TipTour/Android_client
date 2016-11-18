package com.example.cholmink.tiptour_login.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.cholmink.tiptour_login.data.TourItem;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by dnay2 on 2016-11-18.
 */

public class TourSearchAdapter extends BaseAdapter implements Filterable {

    private ArrayList<TourItem> original;
    private ArrayList<TourItem> items;
    private Context context;

    public TourSearchAdapter(ArrayList<TourItem> items, Context context) {
        this.items = items;
        this.original = items;
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
        TextView nameText;
        TextView detailText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if(v == null){
            v = View.inflate(context, 0/*layout of item*/, null);
            holder = new ViewHolder();
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }


        /**
         * 홀더의 내용으로 꾸미기
         */


        return v;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<TourItem> FilteredArrList = new ArrayList<>();

                if (items == null) {
                    items = new ArrayList<>(original);
                }
                if (constraint == null || constraint.length() == 0) {
                    results.count = original.size();
                    results.values = original;
                } else {
                    constraint = constraint.toString().toLowerCase(Locale.KOREA);
                    for (TourItem data : original) {
                        String str = data.getName();
                        if (str.toLowerCase().startsWith(constraint.toString()) //검색어로 시작
                                || str.toLowerCase().equals(constraint.toString()) //검색어와 일치
                                || str.toLowerCase().contains(constraint) //검색어를 포함
                                ) {
                            FilteredArrList.add(new TourItem(
                                    data.getName(),
                                    data.getDetail()));
                        }
                    }
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                items = (ArrayList<TourItem>) results.values;
                notifyDataSetChanged();
            }

        };
    }

}
