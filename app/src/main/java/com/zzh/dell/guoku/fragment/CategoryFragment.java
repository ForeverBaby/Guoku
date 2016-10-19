package com.zzh.dell.guoku.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.CategoryActivity;
import com.zzh.dell.guoku.adapter.CategoryADAdapter;
import com.zzh.dell.guoku.adapter.CategoryEntityAdapter;
import com.zzh.dell.guoku.adapter.CategoryImageTextAdapter;
import com.zzh.dell.guoku.bean.CategoryMainBean;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.GsonUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CustomMeasureGridView;
import com.zzh.dell.guoku.view.CustomMeasureListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements HttpCallBack {

    CategoryMainBean mainBean;

    @BindView(R.id.category_view_pager)
    AutoScrollViewPager autoScrollViewPager;

    @BindView(R.id.category_user_pager)
    LinearLayout userPager;

    @BindView(R.id.category_category_pager)
    LinearLayout categoryPager;

    @BindView(R.id.category_entity_grid)
    CustomMeasureGridView entityGrid;

    @BindView(R.id.category_imagetext_list)
    CustomMeasureListView imagetextList;

    @BindView(R.id.category_search_view)
    SearchView searchView;

    @BindView(R.id.category_scrollview)
    ScrollView scrollView;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        HttpUtils httpUtils = HttpUtils.getIntance();
        httpUtils.setCallBack(this);
//        httpUtils.getStrGET("CategoryFragment",
//                String.format(Contants.CATEGORY_MAIN_PATH,
//                        "b6fbc461c473452b1fa344ae6d1af2c2",
//                        "0b19c2b93687347e95c6b6f5cc91bb87"));

        return view;
    }

    @Override
    public void sendStr(String type, String str) {
        if ("CategoryFragment".equals(type)) {
            Gson gson = GsonUtils.getGson();
            mainBean = gson.fromJson(str, CategoryMainBean.class);

            autoScorllViewInit();
            userPagerInit();
            categoryPagerInit();
            imagetextListInit();
            entityGridInit();
            imagetextList.setFocusable(false);
            entityGrid.setFocusable(false);
            scrollView.smoothScrollTo(0, 0);
        }
    }

    private void entityGridInit() {
        List<CategoryMainBean.EntitiesBean> bean = mainBean.getEntities();
        CategoryEntityAdapter adapter = new CategoryEntityAdapter(bean, getActivity());
        entityGrid.setAdapter(adapter);
        entityGrid.setListViewHeightBasedOnChildren(entityGrid, 2);

    }

    private void imagetextListInit() {
        List<CategoryMainBean.ArticlesBean> bean = mainBean.getArticles();
        CategoryImageTextAdapter adapter = new CategoryImageTextAdapter(bean, getActivity());
        imagetextList.setAdapter(adapter);
        imagetextList.setListViewHeightBasedOnChildren(imagetextList);

    }

    private void categoryPagerInit() {
        final List<CategoryMainBean.CategoriesBean> bean = mainBean.getCategories();
        CategoryViewHolder viewHolder;
        for (int i = 0; i < bean.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.category_category_item, null);
            viewHolder = new CategoryViewHolder(view);
            String[] title = bean.get(i).getCategory().getTitle().split(" ");
            viewHolder.tv_title1.setText(title[0]);
            viewHolder.tv_title2.setText(title[1]);

            final int pos = i;
            viewHolder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = bean.get(pos).getCategory().getId();
                    String title = bean.get(pos).getCategory().getTitle();
                    Intent intent = new Intent(getActivity(), CategoryActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("title",title);
                    startActivity(intent);
                }
            });
            Picasso.with(getActivity()).load(bean.get(i).getCategory().getCover_url()).into(viewHolder.img);
            categoryPager.addView(view);
        }
    }

    class CategoryViewHolder {
        @BindView(R.id.category_category_item_title1)
        TextView tv_title1;
        @BindView(R.id.category_category_item_title2)
        TextView tv_title2;
        @BindView(R.id.category_category_item_img)
        ImageView img;

        public CategoryViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

    private void userPagerInit() {
        List<CategoryMainBean.AuthorizeduserBean> bean = mainBean.getAuthorizeduser();
        ViewHolder viewHolder;
        for (int i = 0; i < bean.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.category_user_item, null);
            viewHolder = new ViewHolder(view);
            viewHolder.tv_title.setText(bean.get(i).getUser().getNick());
            Picasso.with(getActivity()).load(bean.get(i).getUser().getAvatar_small()).into(viewHolder.img);
            userPager.addView(view);
        }
    }

    class ViewHolder {
        @BindView(R.id.category_user_item_img)
        ImageView img;
        @BindView(R.id.category_user_item_text)
        TextView tv_title;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

    private void autoScorllViewInit() {
        List<CategoryMainBean.BannerBean> bean = mainBean.getBanner();
        List<View> adList = new ArrayList<>();
        for (int i = 0; i < mainBean.getBanner().size(); i++) {
            LinearLayout view = new LinearLayout(getActivity());
            ImageView img = new ImageView(getActivity());
            view.addView(img);
            view.setBackgroundColor(Color.TRANSPARENT);
            Picasso.with(getActivity()).load(bean.get(i).getImg()).resize(493, 226).centerCrop().into(img);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(15, 5, 15, 15);
            img.setLayoutParams(params);
            adList.add(view);
        }
        CategoryADAdapter adAdapter = new CategoryADAdapter(adList);
        autoScrollViewPager.setBackgroundColor(Color.TRANSPARENT);
        autoScrollViewPager.setAdapter(adAdapter);
        //开启自动轮播效果
        autoScrollViewPager.startAutoScroll();
        //设置边界切换的动画
        autoScrollViewPager.setBorderAnimation(false);
        //设置循环轮播
        autoScrollViewPager.setCycle(true);
        //两个页面之间切换间隔的时间
        autoScrollViewPager.setInterval(7000);
        //设置切换的方向
        autoScrollViewPager.setDirection(AutoScrollViewPager.RIGHT);
        //当手触摸的时候停止滚动
        autoScrollViewPager.setStopScrollWhenTouch(true);
    }

    @Override
    public void sendStrbefore(String type) {

    }

    @Override
    public void sendStrAfter(String type) {

    }

    @OnClick(R.id.category_user_recommend)
    protected void recommendUser() {

    }

}
