package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.UserBaseActivity;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.bean.SearchUserBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ishinagi_moeta on 2016/10/22.
 */
public class SearchUserAdapter extends BaseAdapter {
    Context context;
    List<SearchUserBean.BeanBean> bean;
    LayoutInflater inflater;

    public SearchUserAdapter(Context context, List<SearchUserBean.BeanBean> bean, LayoutInflater inflater) {
        this.context = context;
        this.bean = bean;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        Account.UserBean userBean = new Account.UserBean();
        userBean.setAuthorized_author(false);
        userBean.setAvatar_large(bean.get(position).getAvatar_large());
        userBean.setAvatar_small(bean.get(position).getAvatar_small());
        userBean.setFollowing_count(bean.get(position).getFollowing_count());
        userBean.setEntity_note_count(bean.get(position).getEntity_note_count());
        userBean.setLike_count(bean.get(position).getLike_count());
        userBean.setRelation(bean.get(position).getRelation());
        userBean.setDig_count(bean.get(position).getDig_count());
        userBean.setUser_id(bean.get(position).getUser_id());
        userBean.setFan_count(bean.get(position).getFan_count());
        userBean.setNick(bean.get(position).getNick());
        userBean.setLocation(bean.get(position).getLocation());
        userBean.setEmail(bean.get(position).getEmail());
        userBean.setWebsite(bean.get(position).getWebsite());
        userBean.setBio(bean.get(position).getBio());
        userBean.setNickname(bean.get(position).getNickname());
        userBean.setTag_count(bean.get(position).getTag_count());
        userBean.setGender(bean.get(position).getGender());
        userBean.setMail_verified(true);
        return userBean;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fans_item, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SearchUserBean.BeanBean userBean = bean.get(position);
        Picasso.with(context).load(userBean.getAvatar_small()).fit().centerCrop().into(holder.fans_item_iv_pic);
        holder.fans_item_tv_name.setText(userBean.getNickname());
        holder.fans_item_tv_fans.setText("关注  " + userBean.getFollowing_count() + "    粉丝 " + userBean.getFan_count());
        if (userBean.isAuthorized_author()) {
            holder.imgAutuon.setVisibility(View.VISIBLE);
        }

        if (userBean.getRelation() == 0) {
            holder.fans_item_iv_status.setImageResource(R.mipmap.add);
            holder.fans_item_iv_status.setBackgroundResource(R.drawable.blue_shap);
        } else if (1 == userBean.getRelation()) {
            holder.fans_item_iv_status.setImageResource(R.mipmap.has);
            holder.fans_item_iv_status.setBackgroundResource(R.drawable.ttz_shap);

        } else if (2 == userBean.getRelation()) {
            holder.fans_item_iv_status.setImageResource(R.mipmap.add);
            holder.fans_item_iv_status.setBackgroundResource(R.drawable.blue_shap);
        } else if (3 == userBean.getRelation()) {
            holder.fans_item_iv_status.setImageResource(R.mipmap.double1);
            holder.fans_item_iv_status.setBackgroundResource(R.drawable.ttz_shap);
        }
        holder.fans_item_iv_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guangClickListener != null) {
                    guangClickListener.guangListener(position);
                    notifyDataSetChanged();
                }
            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserBaseActivity.class);
                Account.UserBean userBean = new Account.UserBean();
                userBean.setAuthorized_author(false);
                userBean.setAvatar_large(bean.get(position).getAvatar_large());
                userBean.setAvatar_small(bean.get(position).getAvatar_small());
                userBean.setFollowing_count(bean.get(position).getFollowing_count());
                userBean.setEntity_note_count(bean.get(position).getEntity_note_count());
                userBean.setLike_count(bean.get(position).getLike_count());
                userBean.setRelation(bean.get(position).getRelation());
                userBean.setDig_count(bean.get(position).getDig_count());
                userBean.setUser_id(bean.get(position).getUser_id());
                userBean.setFan_count(bean.get(position).getFan_count());
                userBean.setNick(bean.get(position).getNick());
                userBean.setLocation(bean.get(position).getLocation());
                userBean.setEmail(bean.get(position).getEmail());
                userBean.setWebsite(bean.get(position).getWebsite());
                userBean.setBio(bean.get(position).getBio());
                userBean.setNickname(bean.get(position).getNickname());
                userBean.setTag_count(bean.get(position).getTag_count());
                userBean.setGender(bean.get(position).getGender());
                userBean.setMail_verified(true);
                intent.putExtra("data", userBean);
                context.startActivity(intent);
            }
        });

        return convertView;

    }

    class ViewHolder {
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
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

    GuangClickListener guangClickListener;

    public void setGuangClickListener(GuangClickListener guangClickListener) {
        this.guangClickListener = guangClickListener;
    }

    public interface GuangClickListener {
        void guangListener(int position);
    }
}
