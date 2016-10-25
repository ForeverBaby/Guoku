package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
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
import com.zzh.dell.guoku.bean.CategoryMainBean;
import com.zzh.dell.guoku.bean.Sharebean;
import com.zzh.dell.guoku.config.Contants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ishinagi_moeta on 2016/10/17.
 */
public class CategoryImageTextAdapter extends BaseAdapter {
    List<CategoryMainBean.ArticlesBean> bean = new ArrayList<>();
    Context context;

    public CategoryImageTextAdapter(List<CategoryMainBean.ArticlesBean> bean, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.category_imagetext_list_item,null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_title.setText(bean.get(position).getArticle().getTitle());
        viewHolder.tv_desc.setText(Html.fromHtml(bean.get(position).getArticle().getContent()));
        Picasso.with(context)
                .load(Contants.IMAGE_PATH+"/"+bean.get(position).getArticle().getCover())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .resize(240,200)
                .centerCrop()
                .into(viewHolder.imageView);
        Picasso.with(context).invalidate(Contants.IMAGE_PATH+"/"+bean.get(position).getArticle().getCover());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle localBundle = new Bundle();
                Sharebean localSharebean = new Sharebean();
                localSharebean.setTitle(bean.get(position).getArticle().getTitle());
                if (bean.get(position).getArticle().getContent().length() > 50) {
                    localSharebean.setContext(bean.get(position).getArticle().getContent().substring(0, 50));
                }

                localSharebean.setAricleUrl(bean.get(position).getArticle().getUrl());
                localSharebean.setImgUrl(bean.get(position).getArticle().getCover());
                localSharebean.setIs_dig(bean.get(position).getArticle().isIs_dig());
                localSharebean.setAricleId(String.valueOf(bean.get(position).getArticle().getArticle_id()));
                localSharebean.setContext(bean.get(position).getArticle().getContent());
                localBundle.putParcelable(WebShareActivity.class.getName(), localSharebean);
                Intent intent = new Intent(context, WebShareActivity.class);
                intent.putExtra("share", localBundle);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.category_imagetext_list_img)
        ImageView imageView;
        @BindView(R.id.category_imagetext_list_title)
        TextView tv_title;
        @BindView(R.id.category_imagetext_list_desc)
        TextView tv_desc;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
