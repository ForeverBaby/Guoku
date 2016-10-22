package com.zzh.dell.guoku.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.callback.SearchListCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchListFragment extends ListFragment {

    public static final int ENTITYFRAGMENT = 0;
    public static final int ARTICLESFRAGMENT = 1;
    public static final int CATEGORYFRAGMENT = 2;
    public static final int USERFRAGMENT = 3;

    BaseAdapter adapter;
    @BindView(R.id.list)
    PullToRefreshListView listView;

    private int type;
    private SearchListCallBack callBack;

    public void init(){
        callBack.init(type);
    }

    public void setCallBack(SearchListCallBack callBack) {
        this.callBack = callBack;
    }

    public void setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
        listView.setAdapter(adapter);
    }

    public SearchListFragment(int type) {
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_list, container, false);
        ButterKnife.bind(this, view);
        initList();
        return view;
    }

    private void initList() {
        listView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                callBack.upDate(type);
            }
        });
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.search_list_empty,null);
        listView.setEmptyView(view);
    }

}