package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.WebActivity;
import com.zzh.dell.guoku.bean.ImageTextData;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.DateUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 32014 on 2016/10/18.
 */
public class MyImageTextAdapter extends BaseAdapter{
    List<ImageTextData.DataBean> dataList;

    Context context;
    private int pos = 0;

    public MyImageTextAdapter(List<ImageTextData.DataBean> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public ImageTextData.DataBean getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        pos = position;
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.image_text_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(dataList.get(position).getTitle());
        viewHolder.digest.setText(dataList.get(position).getDigest());
        String time = String.valueOf(dataList.get(position).getPub_time());
        String date = DateUtils.getStandardDate(time);
        viewHolder.time.setText(date);
        Picasso.with(context).load(Contants.IMAGE_TOP_PATH + dataList.get(position).getCover())
                .fit().centerCrop().into(viewHolder.image);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int article_id = dataList.get(position).getArticle_id();
                String path = Contants.IMAGE_TEXT_DETAIL + article_id;
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("data",path);
                context.startActivity(intent);
            }
        });
        return convertView;
    }


    class ViewHolder{
        @BindView(R.id.image_image)
        ImageView image;

        @BindView(R.id.image_text_title)
        TextView title;

        @BindView(R.id.image_text_digest)
        TextView digest;

        @BindView(R.id.image_text_time)
        TextView time;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
