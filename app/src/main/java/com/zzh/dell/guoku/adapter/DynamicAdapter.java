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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 32014 on 2016/10/21.
 */
public class DynamicAdapter extends BaseAdapter{
    private JSONArray jsonArray;
    Context context;
    String str;

    public DynamicAdapter(String str, Context context) {
        this.str = str;
        this.context = context;
        try {
            jsonArray = new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCount() {
        return jsonArray.length();
    }

    @Override
    public JSONObject getItem(int position) {
        JSONObject obj = null;
        try {
            obj = jsonArray.getJSONObject(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.dynamic_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String type = null;
        try {
            type = getItem(position).getString("type");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        switch(type){
            case "user_follow":
                //关注
                initFollow(position,viewHolder);
                break;
            case "user_like":
                //喜爱
                initLike(position,viewHolder);
                break;
        }
        return convertView;
    }

    private void initLike(int position, ViewHolder viewHolder) {
        try {
            JSONObject content = getItem(position).getJSONObject("content");
            JSONObject liker = content.getJSONObject("liker");
            viewHolder.goods.setVisibility(View.VISIBLE);
            Picasso.with(context)
                    .load(liker.getString("avatar_small"))
                    .fit().centerCrop().into(viewHolder.image);
            viewHolder.user.setText(liker.getString("nickname"));
            JSONObject entity = liker.getJSONObject("entity");
            Picasso.with(context).load(entity.getString("chief_image"))
            .fit().centerCrop().into(viewHolder.goods);

            viewHolder.text_sen.setText(R.string.dynamic_like);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initFollow(int position, ViewHolder viewHolder) {
        try {
            JSONObject content = getItem(position).getJSONObject("content");
            JSONObject user = content.getJSONObject("user");
            String path = user.getString("avatar_small");
            viewHolder.goods.setVisibility(View.GONE);

            Picasso.with(context).load(path)
                    .fit().centerCrop().into(viewHolder.image);
            viewHolder.user.setText(user.getString("nickname"));
            viewHolder.me.setText(content.getJSONObject("target").getString("nickname"));
            viewHolder.text_sen.setText(R.string.dynamic_sen);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    class ViewHolder{

        @BindView(R.id.dynamic_sen)
        TextView text_sen;

        @BindView(R.id.item_dynamic_image)
        CircleImageView image;

        @BindView(R.id.item_dynamic_user)
        TextView user;

        @BindView(R.id.item_dynamic_me)
        TextView me;

        @BindView(R.id.item_dynamic_goods)
        ImageView goods;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
