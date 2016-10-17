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
import com.zzh.dell.guoku.bean.CategoryMainBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ishinagi_moeta on 2016/10/17.
 */
public class CategoryEntityAdapter extends BaseAdapter {

    List<CategoryMainBean.EntitiesBean> bean = new ArrayList<>();
    Context context;

    public CategoryEntityAdapter(List<CategoryMainBean.EntitiesBean> bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.category_entity_grid_item,null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_factory.setText(bean.get(position).getEntity().getBrand());
        viewHolder.tv_name.setText(bean.get(position).getEntity().getTitle());
        viewHolder.tv_price.setText("￥"+bean.get(position).getEntity().getPrice());
        Picasso.with(context).load(bean.get(position).getEntity().getChief_image()).into(viewHolder.imageView);

        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.category_entity_grid_item_img)
        ImageView imageView;
        @BindView(R.id.category_entity_grid_item_factory)
        TextView tv_factory;
        @BindView(R.id.category_entity_grid_item_name)
        TextView tv_name;
        @BindView(R.id.category_entity_grid_item_price)
        TextView tv_price;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
