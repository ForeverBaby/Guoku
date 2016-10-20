package com.zzh.dell.guoku.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zzh.dell.guoku.R;

import java.util.List;

/**
 * Created by 32014 on 2016/10/17.
 */
public class MyGoodsAdapter extends FragmentStatePagerAdapter{
    List<Fragment> fragmentList;

    String[] name = new String[]{"商品","图文"};

    public MyGoodsAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return name[position];
    }
}
