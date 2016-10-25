package com.zzh.dell.guoku.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.AdAdapter;
import com.zzh.dell.guoku.adapter.GoodsChildGridAdapter;
import com.zzh.dell.guoku.adapter.MyGoodsListAdapter;
import com.zzh.dell.guoku.adapter.MyViewPagerAdapter;
import com.zzh.dell.guoku.adapter.SplashViewPagerAdapter;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.bean.AdData;
import com.zzh.dell.guoku.bean.GoodsChildData;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.DateUtils;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.MyListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * http://api.guoku.com/mobile/v4/entity/4645416/?entity_id=4645416&sign=?&api_key=?
 */
public class GoodsChildActivity extends AppCompatActivity implements HttpCallBack, AdapterView.OnItemClickListener {

    @BindView(R.id.goods_child_image)
    ImageView image;

    @BindView(R.id.goods_child_viewpager)
    AutoScrollViewPager viewPager;

    @BindView(R.id.goods_child_ll)
    LinearLayout ll;

    @BindView(R.id.goods_child_title)
    TextView title;

    @BindView(R.id.goods_child_btn)
    Button btn;

    @BindView(R.id.text_like)
    TextView like_num;

    @BindView(R.id.goods_child_grid)
    GridView gridView;

    @BindView(R.id.goods_child_like_ll)
    LinearLayout like_ll;

    @BindView(R.id.goods_child_contain)
    MyListView listView;

    @BindView(R.id.ad_grid)
    GridView ad_gridview;

    @BindView(R.id.image_heart01)
    ImageView image_heart;

    private String type_data = "goods_child_data";
    private String imagePath;
    private String type_ad_data = "ad_data";
    private String type_comment = "comment_data";
    private ArrayList<String> detail_images = new ArrayList<>();
    private String buy_link;
    private int entity_id;
    private MyGoodsListAdapter myLikeAdapter;
    private int like_already = -1;
    String topPath;
    private GoodsChildData data;
    private String getUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_child);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
        }
        ButterKnife.bind(this);
        //entity_id是传过来的 int型
        Intent intent = getIntent();
        entity_id = intent.getIntExtra("id",-1);
        String cid = intent.getStringExtra("cid");
        imagePath = intent.getStringExtra("imagePath");
        like_already = intent.getIntExtra("already",-1);
        Log.e("=====","======"+like_already);
        if(like_already!=-1){
            if(like_already == 0){
                image_heart.setImageResource(R.mipmap.icon_like);
            }else{
                image_heart.setImageResource(R.mipmap.icon_like_press);
            }
        }
        topPath = Contants.GOODS_DETAIL + entity_id + "/";
        getAndSetData(topPath,entity_id);
        getAndSetBottomData(entity_id,cid);
    }

    private void getAndSetBottomData(int entity_id, String cid) {
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("count","10");
        treeMap.put("cid",cid);
        treeMap.put("eid",String.valueOf(entity_id));
        getUrl = StringUtils.getGetUrl(Contants.GOODS_AD, treeMap);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.getStrGET(type_ad_data,getUrl);
        Log.e("====","===="+getUrl);
        httpUtils.setCallBack(this);
    }

    public void clickBack(View view) {
        finish();
    }

    public void getAndSetData(String topPath,int id) {
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("entity_id",String.valueOf(id));
        String getUrl = StringUtils.getGetUrl(topPath, treeMap);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.getStrGET(type_data,getUrl);
        httpUtils.setCallBack(this);
    }

    private void setDataToView(final String str) {
        Gson gson = new Gson();
        if (str != null) {
            data = gson.fromJson(str, GoodsChildData.class);
            final int like_size = data.getEntity().getLike_count();
            final int like_already = data.getEntity().getLike_already();
            String brand1 = data.getEntity().getBrand();
            buy_link = data.getEntity().getItem_list().get(0).getBuy_link();
            if (brand1 == null || "".equals(brand1)) {
                title.setText(data.getEntity().getTitle());
            } else {
                String brand = brand1 + "-" + data.getEntity().getTitle();
                title.setText(brand);
            }
            btn.setText("￥" + data.getEntity().getPrice() + " 去购买");
            detail_images = (ArrayList<String>) data.getEntity().getDetail_images();
            detail_images.add(0, imagePath);
            int size = detail_images.size();
            if (size == 1) {
                viewPager.setVisibility(View.GONE);
                ll.setVisibility(View.GONE);
                image.setVisibility(View.VISIBLE);
                Picasso.with(this).load(imagePath).fit().into(image);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(GoodsChildActivity.this, PictureActivity.class);
                        intent.putExtra("flag", true);
                        intent.putExtra("detail_image", detail_images.get(0));
                        startActivity(intent);
                    }
                });
            } else {
                viewPager.setVisibility(View.VISIBLE);
                ll.setVisibility(View.VISIBLE);
                image.setVisibility(View.GONE);
                List<ImageView> viewList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    ImageView image_item = new ImageView(this);
                    Picasso.with(this).load(detail_images.get(i)).fit().into(image_item);
                    viewList.add(image_item);
                    ImageView point = new ImageView(this);
                    if (i == 0) {
                        point.setImageResource(R.drawable.goods_child_circle_select);
                    } else {
                        point.setImageResource(R.drawable.goods_child_circle);
                    }
                    point.setPadding(10, 0, 10, 0);
                    ll.addView(point);
                }
                MyViewPagerAdapter adapter = new MyViewPagerAdapter(entity_id,like_already,like_size, this, detail_images, viewList);
                viewPager.setAdapter(adapter);
                viewPager.setInterval(4000);
                viewPager.startAutoScroll();
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageSelected(int position) {
                        int childCount = ll.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            ImageView image = (ImageView) ll.getChildAt(i);
                            if (position == i) {
                                image.setImageResource(R.drawable.goods_child_circle_select);
                            } else {
                                image.setImageResource(R.drawable.goods_child_circle);
                            }
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }

            List<GoodsChildData.LikeUserListBean> like_user_list = data.getLike_user_list();
            if (like_size == 0) {
                like_ll.setVisibility(View.GONE);
            } else {
                like_ll.setVisibility(View.VISIBLE);
                like_num.setText(like_size + " 人喜爱");
                GoodsChildGridAdapter adapter1 = new GoodsChildGridAdapter(like_user_list, this);
                gridView.setAdapter(adapter1);
                gridView.setOnItemClickListener(this);
            }

            List<GoodsChildData.NoteListBean> note_list = data.getNote_list();
            myLikeAdapter = new MyGoodsListAdapter(note_list, this);
            listView.setAdapter(myLikeAdapter);
        }
    }

    @Override
    public void sendStr(String type, String str) {
        if(type.equals(type_data)){
            setDataToView(str);
        }else if(type.equals(type_ad_data)){
            setDataToBottom(str);
        }else if(type.equals(type_comment)){
            if(str!=null){
                Toast.makeText(GoodsChildActivity.this, "评论成功！", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setDataToBottom(String str) {
        Gson gson = new Gson();
        String data = "{\"data\":" + str + "}";
        AdData adData = gson.fromJson(data, AdData.class);
        final List<AdData.DataBean> beanList = adData.getData();
        List<String> list = new ArrayList<>();
        for(int i=0;i<beanList.size()-1;i++){
            list.add(beanList.get(i).getChief_image());
        }
        AdAdapter adAdapter = new AdAdapter(list,this);
        ad_gridview.setAdapter(adAdapter);
        ad_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GoodsChildActivity.this,GoodsChildActivity.class);
                intent.putExtra("id",beanList.get(position).getEntity_id());
                intent.putExtra("cid",beanList.get(position).getCategory_id());
                intent.putExtra("imagePath",beanList.get(position).getChief_image());
                startActivity(intent);
            }
        });
    }

    @Override
    public void sendStrbefore(String type) {
    }

    @Override
    public void sendStrAfter(String type) {

    }

    /**喜欢的gridview的点击
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        GoodsChildData.LikeUserListBean authorizeduserBean = data.getLike_user_list().get(position);
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
        Intent intent = new Intent(this,UserBaseActivity.class);
        intent.putExtra("data",userBean);
        this.startActivity(intent);
    }


    @OnClick(R.id.goods_child_btn)
    public void onClick(){
        Intent intent = new Intent(this,WebActivity.class);
        intent.putExtra("data",buy_link);
        startActivity(intent);
    }

    @OnClick(R.id.click_rl)
    public void onClick02(){
        if(topPath != null){
            Intent intent = new Intent(this,FansActivity.class);
            Log.e("====","====="+topPath);
            intent.putExtra("url",topPath);
            this.startActivity(intent);
        }
    }


    /**爱心的点击
     * @param view
     */
    public void clickHeart(View view) {
        String path;
        if(like_already!=-1){
            if(like_already == 0){
                image_heart.setImageResource(R.mipmap.icon_like_press);
                path = Contants.GOODS_DETAIL + entity_id +"/like/1/";
            }else{
                image_heart.setImageResource(R.mipmap.icon_like);
            path = Contants.GOODS_DETAIL +entity_id +"/like/0/";
        }
            HttpUtils httpUtils = new HttpUtils();
            Map<String,String> map = new HashMap<>();
            httpUtils.getStrPOST("gg",path,map);
        }
    }

    /**评论的点击
     * @param view
     */
    public void clickNote(View view) {
        if(GuokuApp.getIntance().getAccount() == null){
            startActivity(new Intent(this,LoginActivity.class));
        }else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view1 = LayoutInflater.from(this)
                    .inflate(R.layout.comment_item, null);
            Button back = (Button) view1.findViewById(R.id.comment_btn);
            Button send = (Button) view1.findViewById(R.id.comment_send);
            final EditText editText = (EditText) view1.findViewById(R.id.comment_et);
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            builder.setView(view1);
            final AlertDialog dialog = builder.create();
            Window window = dialog.getWindow();
            WindowManager.LayoutParams params = new WindowManager.LayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.gravity = Gravity.BOTTOM;
            window.setAttributes(params);
            window.setBackgroundDrawableResource(R.color.colorWhite);
            window.setWindowAnimations(R.style.popwin_anim_style);
            dialog.show();

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String string = editText.getText().toString();
                    if(TextUtils.isEmpty(string)){
                        Toast.makeText(GoodsChildActivity.this, R.string.comment_not, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(entity_id!=0){
                        String path = Contants.GOODS_DETAIL + entity_id +"/add/note/";
                        Map<String,String> map = new HashMap<>();
                        map.put("note",string);
                        HttpUtils httpUtils = new HttpUtils();
                        httpUtils.getStrPOST(type_comment,path,map);
                        httpUtils.setCallBack(GoodsChildActivity.this);
                        dialog.dismiss();
                    }
                }
            });
        }
    }

    /**更多的点击
     * @param view
     */
    public void clickMore(View view) {
        Log.e("====","==更多===");
    }
}
