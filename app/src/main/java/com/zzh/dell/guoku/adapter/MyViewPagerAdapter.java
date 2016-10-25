package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.PictureActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 32014 on 2016/10/20.
 */
public class MyViewPagerAdapter extends PagerAdapter{
    int entity_id;
    int like_already;
    int like_size;
    ArrayList<String> list;
    Context context;
    List<ImageView> imageViewList;

    public MyViewPagerAdapter(int entity_id,int like_already,int like_size,Context context,ArrayList<String> list, List<ImageView> imageViewList) {
        this.entity_id = entity_id;
        this.like_already = like_already;
        this.like_size = like_size;
        this.context = context;
        this.list = list;
        this.imageViewList = imageViewList;
    }

    @Override
    public int getCount() {
        return imageViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final int pos = position;
        ImageView image = imageViewList.get(position);
        container.addView(image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PictureActivity.class);
                intent.putExtra("like_size",like_size);
                intent.putExtra("like_already",like_already);
                intent.putExtra("entity_id",entity_id);
                intent.putExtra("pos",pos);
                intent.putStringArrayListExtra("pictureUrl",list);
                context.startActivity(intent);
            }
        });
        return image;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViewList.get(position));
    }
}
