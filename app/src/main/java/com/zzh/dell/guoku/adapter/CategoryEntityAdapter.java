package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.GoodsChildActivity;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
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
        Picasso.with(context)
                .load(bean.get(position).getEntity().getChief_image())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .resize(200,240)
                .centerCrop()
                .into(viewHolder.imageView);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int entity_id = bean.get(position).getEntity().getEntity_id();
                Intent intent = new Intent(context, GoodsChildActivity.class);
                intent.putExtra("id",entity_id);
                intent.putExtra("cid",bean.get(position).getEntity().getCategory_id());
                intent.putExtra("imagePath",bean.get(position).getEntity().getChief_image());
                context.startActivity(intent);
            }
        });
        Picasso.with(context).invalidate(bean.get(position).getEntity().getChief_image());

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
