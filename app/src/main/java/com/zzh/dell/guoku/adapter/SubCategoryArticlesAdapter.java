package com.zzh.dell.guoku.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.SubCategoryArticlesBean;
import com.zzh.dell.guoku.config.Contants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ishinagi_moeta on 2016/10/18.
 */
public class SubCategoryArticlesAdapter extends BaseAdapter {

    Context context;
    List<SubCategoryArticlesBean.ArticlesBean> bean;

    public SubCategoryArticlesAdapter(Context context, List<SubCategoryArticlesBean.ArticlesBean> bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.category_imagetext_list_item,null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_title.setText(bean.get(position).getTitle());
        viewHolder.tv_desc.setText(Html.fromHtml(bean.get(position).getContent()));
        String path = Contants.IMAGE_PATH+"/"+bean.get(position).getCover();
        Bitmap bmp = BitmapFactory.decodeFile(path);
        viewHolder.imageView.setImageBitmap(bmp);
//        Picasso.with(context).load(Contants.IMAGE_PATH+"/"+bean.get(position).getCover()).resize(240,200).centerCrop().into(viewHolder.imageView);
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.category_imagetext_list_img)
        ImageView imageView;
        @BindView(R.id.category_imagetext_list_title)
        TextView tv_title;
        @BindView(R.id.category_imagetext_list_desc)
        TextView tv_desc;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
