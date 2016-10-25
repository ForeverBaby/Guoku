package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.WebActivity;
import com.zzh.dell.guoku.activity.WebShareActivity;
import com.zzh.dell.guoku.bean.SearchArticlesBean;
import com.zzh.dell.guoku.bean.Sharebean;
import com.zzh.dell.guoku.config.Contants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 搜索适配器
 * Created by Ishinagi_moeta on 2016/10/22.
 */
public class SearchArticlesAdapter extends BaseAdapter {

    List<SearchArticlesBean.ArticlesBean> bean;
    Context context;

    public SearchArticlesAdapter(List<SearchArticlesBean.ArticlesBean> bean, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.search_articles_list_item,null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_title.setText(bean.get(position).getTitle());
        Picasso.with(context)
                .load(Contants.IMAGE_PATH+"/"+bean.get(position).getCover())
                .resize(200, 200)
                .centerCrop()
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(viewHolder.img);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle localBundle = new Bundle();
                Sharebean localSharebean = new Sharebean();
                localSharebean.setTitle(bean.get(position).getTitle());
                if (bean.get(position).getContent().length() > 50) {
                    localSharebean.setContext(bean.get(position).getContent().substring(0, 50));
                }

                localSharebean.setAricleUrl(bean.get(position).getUrl());
                localSharebean.setImgUrl(bean.get(position).getCover());
                localSharebean.setIs_dig(bean.get(position).isIs_dig());
                localSharebean.setAricleId(String.valueOf(bean.get(position).getArticle_id()));
                localSharebean.setContext(bean.get(position).getContent());
                localBundle.putParcelable(WebShareActivity.class.getName(), localSharebean);
                Intent intent = new Intent(context, WebShareActivity.class);
                intent.putExtra("share", localBundle);
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

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
