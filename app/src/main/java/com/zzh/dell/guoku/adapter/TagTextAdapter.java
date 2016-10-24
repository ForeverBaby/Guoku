package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.Tag;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DELL on 2016/10/24.
 */
public class TagTextAdapter extends BaseAdapter {
    List<Tag> list;
    Context context;
    LayoutInflater inflater;

    public TagTextAdapter(Context context, List<Tag> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Tag getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.item_tag_text,null);
            viewholder = new Viewholder(convertView);
        }else {
            viewholder = (Viewholder) convertView.getTag();
        }
        viewholder.viewt.setText(list.get(position).getTitle());
        return convertView;
    }
    class Viewholder{
        @BindView(R.id.textView1)
        TextView viewt;
        View view;

        public Viewholder(View view) {
            this.view = view;
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}
