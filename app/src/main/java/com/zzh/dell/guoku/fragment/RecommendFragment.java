package com.zzh.dell.guoku.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.MyGoodsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rg_group)
    RadioGroup rg_group;

    @BindView(R.id.rb_goods)
    RadioButton rb_goods;

    @BindView(R.id.rb_imageText)
    RadioButton rb_imageText;

    GoodsFragment goodsFragment;
    ImageTextFragment imagetextFragment;
    FragmentManager manager;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.view_line)
    View line;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this,view);
        initFragment();
        rg_group.setOnCheckedChangeListener(this);
        addFraToPager();
        return view;
    }
    private void addFraToPager() {
        List<Fragment> listFragment = new ArrayList<>();
        listFragment.add(goodsFragment);
        listFragment.add(imagetextFragment);
        MyGoodsAdapter adapter = new MyGoodsAdapter(manager,listFragment);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    private void initFragment() {
        manager = getFragmentManager();
        goodsFragment = GoodsFragment.newInstance();
        imagetextFragment = ImageTextFragment.newInstance();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch(position){
            case 0:
                rb_goods.setTextColor(getResources().getColor(R.color.colorAccent));
                rb_imageText.setTextColor(getResources().getColor(R.color.title_bar_gray));
                break;
            case 1:
                rb_goods.setTextColor(getResources().getColor(R.color.title_bar_gray));
                rb_imageText.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_goods:
                rb_goods.setTextColor(getResources().getColor(R.color.colorAccent));
                rb_imageText.setTextColor(getResources().getColor(R.color.title_bar_gray));
                break;
            case R.id.rb_imageText:
                rb_goods.setTextColor(getResources().getColor(R.color.title_bar_gray));
                rb_imageText.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }
    }
}
