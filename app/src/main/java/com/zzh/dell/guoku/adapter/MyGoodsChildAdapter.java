package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.GoodsChildActivity;
import com.zzh.dell.guoku.bean.GoodsData;
import com.zzh.dell.guoku.utils.DateUtils;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 32014 on 2016/10/17.
 */
public class MyGoodsChildAdapter extends BaseAdapter{
    List<GoodsData.DataBean> list;
    Context context;

    public MyGoodsChildAdapter(List<GoodsData.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public GoodsData.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.goods_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final String imagePath = list.get(position).getContent().getEntity().getChief_image();
        Picasso.with(context).load(imagePath)
                .transform(new Transformation() {
                    @Override
                    public Bitmap transform(Bitmap source) {
                        return source;
                    }

                    @Override
                    public String key() {
                        return imagePath;
                    }
                })
                .fit().centerCrop()
                .into(viewHolder.image);
        viewHolder.text_content.setText(list.get(position).getContent().getNote().getContent());
        viewHolder.text_count.setText(String.valueOf(list.get(position).getContent().getEntity().getLike_count()));
        String time = String.valueOf(list.get(position).getPost_time());
        String date = DateUtils.getStandardDate(time);
        viewHolder.text_time.setText(date);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int entity_id = list.get(pos).getContent().getEntity().getEntity_id();
                Intent intent = new Intent(context, GoodsChildActivity.class);
                intent.putExtra("id",entity_id);
                intent.putExtra("cid",list.get(pos).getContent().getEntity().getCategory_id());
                intent.putExtra("imagePath",imagePath);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.goods_item_image)
        ImageView image;

        @BindView(R.id.goods_item_text)
        TextView text_content;

        @BindView(R.id.goods_item_heart)
        ImageView image_heart;

        @BindView(R.id.goods_item_count)
        TextView text_count;

        @BindView(R.id.goods_item_time)
        TextView text_time;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
