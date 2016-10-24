package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.zzh.dell.guoku.bean.CategoryMainBean;
import com.zzh.dell.guoku.bean.MyLikeActBean;
import com.zzh.dell.guoku.config.Contants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DELL on 2016/10/22.
 */
public class ArticlesCategoryAdapter extends BaseAdapter {

    List<MyLikeActBean.ArticlesBean> list;
    Context context;
    LayoutInflater inflater;

    public ArticlesCategoryAdapter(List<MyLikeActBean.ArticlesBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public MyLikeActBean.ArticlesBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.home_one_articles_item,parent,false);
            holder = new ViewHolder(convertView);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvBelow.setText(list.get(position).getDigest());
        holder.tvName.setText(list.get(position).getTitle());
        Picasso.with(context).load("http://imgcdn.guoku.com/"+list
                .get(position)
                .getCover())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .fit()
                .centerCrop()
                .into(holder.imgIcon);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int article_id = list.get(position).getArticle_id();
                String path = Contants.IMAGE_TEXT_DETAIL + article_id;
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("data",path);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
    class ViewHolder{
        @BindView(R.id.img_article)
        ImageView imgIcon;

        @BindView(R.id.article_below)
        TextView tvBelow;

        @BindView(R.id.article_title)
        TextView tvName;
        View view;

        public ViewHolder(View view) {
            this.view = view;
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}
