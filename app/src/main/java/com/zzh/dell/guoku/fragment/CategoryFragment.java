package com.zzh.dell.guoku.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zzh.dell.guoku.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    @BindView(R.id.category_view_pager)
    AutoScrollViewPager autoScrollViewPager;

    @BindView(R.id.category_user_pager)
    ViewPager userPager;

    @BindView(R.id.category_category_pager)
    ViewPager categoryPager;

    @BindView(R.id.category_entity_list)
    ListView entityList;

    @BindView(R.id.category_imagetext_list)
    ListView imagetextList;

    @BindView(R.id.category_search_view)
    SearchView searchView;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
