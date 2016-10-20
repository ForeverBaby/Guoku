package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.GoodsChildData;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 32014 on 2016/10/19.
 */
public class GoodsChildGridAdapter extends BaseAdapter{
    List<GoodsChildData.LikeUserListBean> list;
    Context context;

    public GoodsChildGridAdapter(List<GoodsChildData.LikeUserListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public GoodsChildData.LikeUserListBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.circle_image,null);
        CircleImageView image = (CircleImageView) convertView.findViewById(R.id.circle_image);
        String small_path = list.get(position).getAvatar_small();
        Picasso.with(context).load(small_path)
               .into(image);
        return convertView;
    }
}
