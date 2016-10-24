package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.Entity2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DELL on 2016/10/23.
 */
public class EntitysAdapter extends BaseAdapter {
    List<Entity2.EntityListBean> list;
    Context context;
    LayoutInflater inflater;

    public EntitysAdapter(Context context, List<Entity2.EntityListBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Entity2.EntityListBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.entity_item, null);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.entity_item_tv_com.setText(String.valueOf(list.get(position).getNote_count()));
        holder.entity_item_tv_like.setText(String.valueOf(list.get(position).getLike_count()));
        holder.entity_item_tv_name.setText(list.get(position).getTitle());
        if (!"0".equals(list.get(position).getLike_already())) {
            holder.entity_item_iv_islike.setImageResource(R.mipmap.icon_like_press);
        } else {
            holder.entity_item_iv_islike.setImageResource(R.mipmap.icon_like);
        }

        holder.entity_item_tv_price.setText(String.format(context.getResources().getString(R.string.tv_rmb), list.get(position).getPrice()));
        Picasso.with(context).load(list.get(position).getChief_image()).fit().centerCrop().into(holder.entity_item_iv_pic);
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.entity_item_iv_islike)
        ImageView entity_item_iv_islike;

        @BindView(R.id.entity_item_iv_pic)
        ImageView entity_item_iv_pic;

        @BindView(R.id.entity_item_tv_com)
        TextView entity_item_tv_com;
        @BindView(R.id.entity_item_tv_like)
        TextView entity_item_tv_like;

        @BindView(R.id.entity_item_tv_name)
        TextView entity_item_tv_name;

        @BindView(R.id.entity_item_tv_price)
        TextView entity_item_tv_price;

        View view;

        public ViewHolder(View view) {
            this.view = view;
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
