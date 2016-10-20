package com.zzh.dell.guoku.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
public class RecommendFragment extends Fragment{

    @BindView(R.id.goods_tab)
    TabLayout tabLayout;

    GoodsFragment goodsFragment;
    ImagetextFragment imagetextFragment;
    FragmentManager manager;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this,view);
        initFragment();
        addFraToPager();
        return view;
    }
    private void addFraToPager() {
        List<Fragment> listFragment = new ArrayList<>();
        listFragment.add(goodsFragment);
        listFragment.add(imagetextFragment);
        MyGoodsAdapter adapter = new MyGoodsAdapter(manager,listFragment);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragment() {
        manager = getFragmentManager();
        goodsFragment = GoodsFragment.newInstance();
        imagetextFragment = ImagetextFragment.newInstance();
    }
}
