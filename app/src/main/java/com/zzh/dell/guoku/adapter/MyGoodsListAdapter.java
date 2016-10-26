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

import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.CommentActivity;
import com.zzh.dell.guoku.activity.LoginActivity;
import com.zzh.dell.guoku.activity.UserBaseActivity;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.bean.GoodsChildData;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.DateUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 32014 on 2016/10/21.
 */
public class MyGoodsListAdapter extends BaseAdapter implements View.OnClickListener, HttpCallBack {
    List<GoodsChildData.NoteListBean> note_list;
    Context context;
    private int pos = 0;
    private String date;
    private String path;
    private String type_poke = "poke_data";

    public MyGoodsListAdapter(List<GoodsChildData.NoteListBean> note_list, Context context) {
        this.note_list = note_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return note_list.size();
    }

    @Override
    public GoodsChildData.NoteListBean getItem(int position) {
        return note_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    ViewHolder viewHolder = null;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int position1 = position;
        pos = position1;

        if(convertView==null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.goods_child_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.note_name.setText(note_list.get(position).getCreator().getNickname());
        Picasso.with(context).load(note_list.get(position).getCreator().getAvatar_small())
                .fit().centerCrop().into(viewHolder.note_circle);
        viewHolder.note_content.setText(note_list.get(position).getContent());
        String s = String.valueOf(note_list.get(position).getUpdated_time());
        int poke = note_list.get(position).getPoke_already();
        if(poke == 0){
            viewHolder.good.setImageResource(R.mipmap.good);
            path = Contants.GOODS_DETAIL +"note/" +note_list.get(position).getEntity_id() + "/poke/1/";
        }else{
            viewHolder.good.setImageResource(R.mipmap.good_press);
            path = Contants.GOODS_DETAIL +"note/" +note_list.get(position).getEntity_id() + "/poke/0/";
        }
        date = DateUtils.getStandardDate(s);
        viewHolder.note_time.setText(date);
        convertView.setOnClickListener(this);
        viewHolder.note_circle.setOnClickListener(this);
        viewHolder.good.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.note_circle:
                GoodsChildData.NoteListBean.CreatorBean authorizeduserBean = note_list.get(pos).getCreator();
                Account.UserBean userBean = new Account.UserBean();
                userBean.setAvatar_large(authorizeduserBean.getAvatar_large());
                userBean.setAvatar_small(authorizeduserBean.getAvatar_small());
                userBean.setFollowing_count(authorizeduserBean.getFollowing_count());
                userBean.setEntity_note_count(authorizeduserBean.getEntity_note_count());
                userBean.setLike_count(authorizeduserBean.getLike_count());
                userBean.setRelation(authorizeduserBean.getRelation());
                userBean.setDig_count(authorizeduserBean.getDig_count());
                userBean.setUser_id(authorizeduserBean.getUser_id());
                userBean.setFan_count(authorizeduserBean.getFan_count());
                userBean.setNick(authorizeduserBean.getNick());
                userBean.setLocation(authorizeduserBean.getLocation());
                userBean.setEmail(authorizeduserBean.getEmail());
                userBean.setWebsite(authorizeduserBean.getWebsite());
                userBean.setBio(authorizeduserBean.getBio());
                userBean.setNickname(authorizeduserBean.getNickname());
                userBean.setTag_count(authorizeduserBean.getTag_count());
                userBean.setGender(authorizeduserBean.getGender());
                Intent intent1 = new Intent(context,UserBaseActivity.class);
                intent1.putExtra("data",userBean);
                context.startActivity(intent1);
                break;
            case R.id.note_image_good:
                if(GuokuApp.getIntance().getAccount() == null){
                    context.startActivity(new Intent(context, LoginActivity.class));
                    return;
                }
                HttpUtils httpUtils = new HttpUtils();
                Map<String,String> map = new HashMap<>();
                httpUtils.getStrPOST(type_poke,path,map);
                httpUtils.setCallBack(this);
                break;
            default:
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra("circle",note_list.get(pos).getCreator().getAvatar_small());
                intent.putExtra("content",note_list.get(pos).getContent());
                intent.putExtra("poke",note_list.get(pos).getPoke_already());
                intent.putExtra("name",note_list.get(pos).getCreator().getNickname());
                intent.putExtra("time",date);
                context.startActivity(intent);
                break;
        }
    }

    @Override
    public void sendStr(String type, String str) {
        if(type.equals(type_poke)){
            try {
                JSONObject object = new JSONObject(str);
                String poke_already = object.getString("poke_already");
                note_list.get(pos).setPoke_already(Integer.parseInt(poke_already));
                notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendStrbefore(String type) {

    }

    @Override
    public void sendStrAfter(String type) {

    }

    class ViewHolder{
        @BindView(R.id.note_circle)
        ImageView note_circle;

        @BindView(R.id.note_name)
        TextView note_name;

        @BindView(R.id.note_content)
        TextView note_content;

        @BindView(R.id.note_text_time)
        TextView note_time;

        @BindView(R.id.note_image_good)
        ImageView good;

        @BindView(R.id.note_image_pop)
        ImageView pop;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
