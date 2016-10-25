package com.zzh.dell.guoku.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.MyGoodsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecommendFragment extends Fragment {


    GoodsFragment goodsFragment;
    FragmentManager manager;

    @BindView(R.id.tab_layout)
    TabLayout indicator;

    @BindView(R.id.pager)
    ViewPager viewPaget;

    @BindView(R.id.main_line)
    LinearLayout main_line;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);
        initFragment();
        addFraToPager();
        initListener();
        return view;
    }

    public void gotoFirstPosition(boolean flag) {

        if (viewPaget.getCurrentItem() == 0) {
            goodsFragment.goFirst();
        } else {
            imagetextFragment.goFirst();

        }
    }

    private void initListener() {
        viewPaget.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    Animation anim = new TranslateAnimation(width, 0, 0, 0);
                    anim.setDuration(300);
                    anim.setFillAfter(true);
                    main_line.startAnimation(anim);
                } else if (position == 1) {
                    Animation anim = new TranslateAnimation(0, width, 0, 0);
                    anim.setDuration(300);
                    anim.setFillAfter(true);
                    main_line.startAnimation(anim);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    ImagetextFragment imagetextFragment = ImagetextFragment.newInstance();

    private void addFraToPager() {
        String[] name = new String[]{"商品", "图文"};
        List<Fragment> listFragment = new ArrayList<>();
        listFragment.add(goodsFragment);
        listFragment.add(imagetextFragment);

        MyGoodsAdapter adapter = new MyGoodsAdapter(getFragmentManager(), listFragment, name);
        viewPaget.setAdapter(adapter);

        indicator.setSelectedTabIndicatorColor(getResources().getColor(android.R.color.transparent));
        indicator.setupWithViewPager(viewPaget);

    }

    int width = 0;

    private void initFragment() {

        goodsFragment = GoodsFragment.newInstance();

        DisplayMetrics m = new DisplayMetrics();
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        defaultDisplay.getMetrics(m);
        width = m.widthPixels / 2;
        main_line.setLayoutParams(new LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT));
    }

}
