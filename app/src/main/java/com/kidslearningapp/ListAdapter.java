package com.kidslearningapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<HistoryClass> {

    private LayoutInflater mInflater;
    private ArrayList<HistoryClass> historyClassArrayList;
    private int mViewResourceId;

    public ListAdapter(Context context, int textViewResourceId, ArrayList<HistoryClass> historyClassArrayList) {
        super(context, textViewResourceId, historyClassArrayList);

        this.historyClassArrayList = historyClassArrayList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        HistoryClass historyClass = historyClassArrayList.get(position);

        if (historyClass != null) {
            TextView actvityname = (TextView) convertView.findViewById(R.id.actvityname);
            TextView timedate = (TextView) convertView.findViewById(R.id.timedate);
            if (actvityname != null) {
                actvityname.setText(historyClass.getActivityName());
            }
            if (timedate != null) {
                timedate.setText(historyClass.timeAndDate);
            }
        }

        return convertView;
    }
}