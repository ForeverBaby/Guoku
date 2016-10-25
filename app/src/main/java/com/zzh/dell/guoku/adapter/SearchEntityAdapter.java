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
import com.zzh.dell.guoku.bean.SearchEntityBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商品适配器
 * Created by Ishinagi_moeta on 2016/10/21.
 */
public class SearchEntityAdapter extends BaseAdapter {
    Context context;
    List<SearchEntityBean.EntityListBean> list;

    public SearchEntityAdapter(Context context, List<SearchEntityBean.EntityListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.search_entity_list_item, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final SearchEntityBean.EntityListBean bean = list.get(position);
        viewHolder.tv_title.setText(bean.getTitle());
        viewHolder.tv_price.setText("￥ " + bean.getPrice());
        viewHolder.tv_like.setText(String.valueOf(bean.getLike_count()));
        viewHolder.tv_talk.setText(String.valueOf(bean.getNote_count()));
        Picasso.with(context)
                .load(bean.getChief_image())
                .resize(200, 200)
                .centerCrop()
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(viewHolder.img);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int entity_id = list.get(position).getEntity_id();
                Intent intent = new Intent(context, GoodsChildActivity.class);
                intent.putExtra("id",entity_id);
                intent.putExtra("cid",list.get(position).getCategory_id());
                intent.putExtra("imagePath",list.get(position).getChief_image());
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.item_img)
        ImageView img;
        @BindView(R.id.item_title)
        TextView tv_title;
        @BindView(R.id.item_price)
        TextView tv_price;
        @BindView(R.id.item_like)
        TextView tv_like;
        @BindView(R.id.item_talk)
        TextView tv_talk;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
