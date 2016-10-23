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
import com.zzh.dell.guoku.bean.GoodsChildData;
import com.zzh.dell.guoku.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 32014 on 2016/10/21.
 */
public class MyGoodsListAdapter extends BaseAdapter implements View.OnClickListener {
    List<GoodsChildData.NoteListBean> note_list;
    Context context;
    private int pos = 0;
    private String date;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        pos = position;
        ViewHolder viewHolder = null;
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
                Log.e("====","==头像===");
                break;
            case R.id.note_image_good:
                Log.e("====","==点赞===");
                break;
            default:
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra("circle",note_list.get(pos).getCreator().getAvatar_small());
                intent.putExtra("content",note_list.get(pos).getContent());
                intent.putExtra("name",note_list.get(pos).getCreator().getNickname());
                intent.putExtra("time",date);
                context.startActivity(intent);
                break;
        }
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
