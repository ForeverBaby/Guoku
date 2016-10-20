package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.AdData;

import java.util.List;

/**
 * Created by 32014 on 2016/10/20.
 */
public class AdAdapter extends BaseAdapter{
    List<String> list;
    Context context;

    public AdAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.image_item,null);
        ImageView image = (ImageView) convertView.findViewById(R.id.image_ad);
        Picasso.with(context).load(list.get(position)).fit().centerCrop().into(image);
        return convertView;
    }
}
