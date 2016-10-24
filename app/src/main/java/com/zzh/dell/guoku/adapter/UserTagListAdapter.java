package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.UserTagBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by DELL on 2016/10/23.
 */
public class UserTagListAdapter extends BaseAdapter {

    List<UserTagBean.TagsBean> list;
    Context context;
    LayoutInflater inflater;

    public UserTagListAdapter(Context context, List<UserTagBean.TagsBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public UserTagBean.TagsBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.person_item3,null);
            viewholder = new ViewHolder(convertView);
        }else {
            viewholder = (ViewHolder) convertView.getTag();
        }
        viewholder.person_item_tv_context.setText("#"+list.get(position).getTag());
        viewholder.person_item_tv_time.setText(list.get(position).getEntity_count()+"件商品");
        return convertView;
    }
    class ViewHolder{

        @BindView(R.id.person_item3_tv_context)
        TextView person_item_tv_context;

        @BindView(R.id.person_item3_tv_time)
        TextView person_item_tv_time;
        View view;

        public ViewHolder(View view) {
            this.view = view;
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}
