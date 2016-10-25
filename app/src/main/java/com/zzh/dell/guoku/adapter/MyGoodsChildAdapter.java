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
import com.zzh.dell.guoku.activity.LoginActivity;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.GoodsData;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.DateUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**{
 "entity_id": "4645850",
 "like_already": 0
 }
 * Created by 32014 on 2016/10/17.
 */
public class MyGoodsChildAdapter extends BaseAdapter{
    List<GoodsData.DataBean> list;
    Context context;
    String type_heart = "heart_data";
    HttpUtils httpUtils;

    public MyGoodsChildAdapter(List<GoodsData.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        httpUtils = new HttpUtils();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final ViewHolder viewHolder;
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
        final  int like_count = list.get(position).getContent().getEntity().getLike_count();
        viewHolder.text_count.setText(String.valueOf(like_count));
        String time = String.valueOf(list.get(position).getPost_time());
        String date = DateUtils.getStandardDate(time);
        viewHolder.text_time.setText(date);
        final int like_already = list.get(position).getContent().getEntity().getLike_already();
        if (like_already == 0){
            viewHolder.image_heart.setImageResource(R.mipmap.icon_like);
        }else{
            viewHolder.image_heart.setImageResource(R.mipmap.icon_like_press);
        }
        viewHolder.image_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(GuokuApp.getIntance().getAccount() == null){
                   context.startActivity(new Intent(context, LoginActivity.class));
               }else{
                   final int entity_id = list.get(pos).getContent().getEntity().getEntity_id();
                   String path;
                   if (like_already == 0){
                       path = Contants.GOODS_DETAIL + entity_id +"/like/1/";
                   }else{
                       path = Contants.GOODS_DETAIL + entity_id +"/like/0/";
                   }

                   Map<String,String> map = new HashMap<String, String>();
                   httpUtils.getStrPOST(type_heart,path,map);
                   httpUtils.setCallBack(new HttpCallBack() {
                       @Override
                       public void sendStr(String type, String str) {
                           if(type.equals(type_heart)){
                               try {
                                   JSONObject object = new JSONObject(str);
                                   int like_already = object.getInt("like_already");
                                   if(like_already == 0){
                                       int count = list.get(position).getContent().getEntity().getLike_count() - 1;
                                       list.get(position).getContent().getEntity().setLike_count(count);
                                       list.get(position).getContent().getEntity().setLike_already(0);

                                   }else{
                                       int count = list.get(position).getContent().getEntity().getLike_count() + 1;
                                       list.get(position).getContent().getEntity().setLike_count(count);
                                       list.get(position).getContent().getEntity().setLike_already(1);
                                   }
                                   notifyDataSetChanged();
                               } catch (JSONException e) {
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
                   });
               }
            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int like_already1 = list.get(pos).getContent().getEntity().getLike_already();
                int like_count1 = list.get(pos).getContent().getEntity().getLike_count();
                int entity_id = list.get(pos).getContent().getEntity().getEntity_id();
                Intent intent = new Intent(context, GoodsChildActivity.class);
                intent.putExtra("id",entity_id);
                intent.putExtra("cid",list.get(pos).getContent().getEntity().getCategory_id());
                intent.putExtra("imagePath",imagePath);
                intent.putExtra("already",like_already1);
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
