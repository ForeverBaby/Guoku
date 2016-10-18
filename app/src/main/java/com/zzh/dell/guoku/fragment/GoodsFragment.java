package com.zzh.dell.guoku.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zzh.dell.guoku.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsFragment extends LazyFragment {

    private boolean flag = false;

    public static GoodsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        GoodsFragment fragment = new GoodsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @BindView(R.id.pullListView)
    PullToRefreshListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_goods, container, false);
        ButterKnife.bind(this,view);
        flag = true;
        lazyLoad();
        return view;
    }

    @Override
    protected void lazyLoad() {
        if(!flag || !isVisible){
            return;
        }

    }
}
