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
import com.zzh.dell.guoku.bean.SubCategorySelectionBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ishinagi_moeta on 2016/10/19.
 */
public class SubCategorySelectionAdapter extends BaseAdapter {
    Context context;
    List<SubCategorySelectionBean.BeanBean> bean;

    public SubCategorySelectionAdapter(Context context, List<SubCategorySelectionBean.BeanBean> bean) {
        this.context = context;
        this.bean = bean;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.category_entity_grid_item, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_factory.setText(bean.get(position).getBrand());
        viewHolder.tv_name.setText(bean.get(position).getTitle());
        viewHolder.tv_price.setText("￥" + bean.get(position).getPrice());
        Picasso.with(context)
                .load(bean.get(position).getChief_image())
                .resize(200, 240)
                .centerCrop()
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(viewHolder.imageView);
        Picasso.with(context).invalidate(bean.get(position).getChief_image());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int entity_id = bean.get(position).getEntity_id();
                Intent intent = new Intent(context, GoodsChildActivity.class);
                intent.putExtra("id", entity_id);
                intent.putExtra("cid", bean.get(position).getCategory_id());
                intent.putExtra("imagePath", bean.get(position).getChief_image());
                context.startActivity(intent);
            }
        });

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
