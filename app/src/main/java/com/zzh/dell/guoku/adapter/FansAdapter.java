package com.zzh.dell.guoku.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.Account;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by DELL on 2016/10/20.
 */
public class FansAdapter extends BaseAdapter {

    List<Account.UserBean> list;
    Context context;
    LayoutInflater inflater;

    public FansAdapter(Context context, List<Account.UserBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Account.UserBean getItem(int position) {
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
            convertView = inflater.inflate(R.layout.fans_item,parent,false);
            holder = new ViewHolder(convertView);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Account.UserBean userBean = list.get(position);
        Picasso.with(context).load(userBean.getAvatar_small()).fit().centerCrop().into(holder.fans_item_iv_pic);
        holder.fans_item_tv_name.setText(userBean.getNick());
        holder.fans_item_tv_fans.setText("关注  " + userBean.getFollowing_count() + "    粉丝 " + userBean.getFan_count());
        if(userBean.isAuthorized_author()){
            holder.imgAutuon.setVisibility(View.VISIBLE);
        }

        if(userBean.getRelation()==0){
            holder.fans_item_iv_status.setImageResource(R.mipmap.add);
            holder.fans_item_iv_status.setBackgroundResource(R.drawable.blue_shap);
        }else if(1==userBean.getRelation()){
            holder.fans_item_iv_status.setImageResource(R.mipmap.has);
            holder.fans_item_iv_status.setBackgroundResource(R.drawable.ttz_shap);

        }else if(2==userBean.getRelation()){
            holder.fans_item_iv_status.setImageResource(R.mipmap.add);
            holder.fans_item_iv_status.setBackgroundResource(R.drawable.blue_shap);
        }else if(3==userBean.getRelation()){
            holder.fans_item_iv_status.setImageResource(R.mipmap.double1);
            holder.fans_item_iv_status.setBackgroundResource(R.drawable.ttz_shap);
        }
        holder.fans_item_iv_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guangClickListener!=null){
                    guangClickListener.guangListener(position);
                    notifyDataSetChanged();
                }
            }
        });
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.fans_item_iv_pic)
        CircleImageView fans_item_iv_pic;

        @BindView(R.id.fans_item_iv_status)
        ImageView fans_item_iv_status;

        @BindView(R.id.fans_item_tv_fans)
        TextView fans_item_tv_fans;

        @BindView(R.id.fans_item_tv_name)
        TextView fans_item_tv_name;

        @BindView(R.id.img_authon)
        ImageView imgAutuon;

        View view;

        public ViewHolder(View view) {
            this.view = view;
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }

    GuangClickListener guangClickListener;

    public void setGuangClickListener(GuangClickListener guangClickListener) {
        this.guangClickListener = guangClickListener;
    }

    public interface GuangClickListener{
       void guangListener(int position);
   }
}
