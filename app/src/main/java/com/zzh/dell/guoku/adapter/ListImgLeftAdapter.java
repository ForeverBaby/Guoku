package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.Comment;
import com.zzh.dell.guoku.utils.DateUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DELL on 2016/10/22.
 */
public class ListImgLeftAdapter extends BaseAdapter {
    List<Comment.CommentBean> list;
    Context context;
    LayoutInflater inflater;

    public ListImgLeftAdapter(Context context, List<Comment.CommentBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Comment.CommentBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.list_img_left_adapter_item,parent,false);
            holder = new ViewHolder(convertView);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.person_item_tv_context.setText(list.get(position).getNote().getContent());
        holder.person_item_tv_time.setText(DateUtils.getStandardDate(String.valueOf(list.get(position).getNote().getUpdated_time())));
        Picasso.with(context).load(list.get(position).getEntity().getChief_image()).fit().centerCrop().into(holder.person_item_iv_pic);
        return convertView;
    }
    class ViewHolder{
        @BindView(R.id.person_item_iv_pic)
        ImageView person_item_iv_pic;

        @BindView(R.id.person_item_tv_context)
        TextView person_item_tv_context;

        @BindView(R.id.person_item_tv_time)
        TextView person_item_tv_time;

        View view;

        public ViewHolder(View view) {
            this.view = view;
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }

}
