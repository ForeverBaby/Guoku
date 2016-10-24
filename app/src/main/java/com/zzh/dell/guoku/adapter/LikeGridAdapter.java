package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.LikeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DELL on 2016/10/22.
 */
public class LikeGridAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    List<LikeBean.EntityListBean> listBeen;
    public  int screenW;
    private int count;

    public LikeGridAdapter(List<LikeBean.EntityListBean> listBeen, Context context,int screenW,int count) {
        this.listBeen = listBeen;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.screenW = screenW;
        this.count = count;
    }

    @Override
    public int getCount() {
        return listBeen.size();
    }

    @Override
    public LikeBean.EntityListBean getItem(int position) {
        return listBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ViewHolder2 holder2 = null;
        if(convertView==null){
            if(this.count==2) {
                convertView = inflater.inflate(R.layout.grid2_view_img_item, parent, false);
                holder = new ViewHolder(convertView);
            }else {
                convertView = inflater.inflate(R.layout.grid_view_img_item,parent,false);
                holder2 = new ViewHolder2(convertView);
            }

        }else {
            if(count==2) {
                holder = (ViewHolder) convertView.getTag();
            }else {
                holder2 = (ViewHolder2)convertView.getTag();
            }
        }
        if(this.count==2&&holder!=null) {
            holder.title.setText(listBeen.get(position).getBrand());
            holder.context.setText(listBeen.get(position).getTitle());
            holder.money.setText(context.getResources().getString(R.string.tv_rmb,listBeen.get(position).getPrice()));
        holder.imgIcon.setLayoutParams(new LinearLayout.LayoutParams(-10+screenW/this.count,-10+screenW/this.count));
        Picasso.with(context).load(listBeen.get(position).getChief_image()).memoryPolicy(MemoryPolicy.NO_CACHE).fit().into(holder.imgIcon);
        }
        holder2.imgIcon.setLayoutParams(new LinearLayout.LayoutParams(-10+screenW/this.count,-10+screenW/this.count));
        Picasso.with(context).load(listBeen.get(position).getChief_image()).memoryPolicy(MemoryPolicy.NO_CACHE).fit().into(holder2.imgIcon);
        return convertView;
    }
    class ViewHolder{
        @BindView(R.id.context)
        TextView context;

        @BindView(R.id.img)
        ImageView imgIcon;

        @BindView(R.id.money)
        TextView money;

        @BindView(R.id.title)
        TextView title;
        View view;

        public ViewHolder(View view) {
            this.view = view;
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
    class ViewHolder2{

        @BindView(R.id.img)
        ImageView imgIcon;

        View view;

        public ViewHolder2(View view) {
            this.view = view;
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}
