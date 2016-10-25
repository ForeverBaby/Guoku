package com.zzh.dell.guoku.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.GoodsChildActivity;
import com.zzh.dell.guoku.adapter.MyGoodsChildAdapter;
import com.zzh.dell.guoku.bean.GoodsData;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsFragment extends Fragment{
    /**
     * sign和api_key???
     */
    private String goods_type = "goods_data";
    private GoodsData goodsData;
    private MyGoodsChildAdapter adapter;
    private List<GoodsData.DataBean> dataBeanList = new ArrayList<>();;

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
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        String time = String.valueOf(System.currentTimeMillis() / 1000L);
        lazyLoad(time,0);
        return view;
    }

    public void lazyLoad(String time, final int flag) {
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("count","30");
        treeMap.put("timestamp",time);
        treeMap.put("rcat","0");
        String path = StringUtils.getGetUrl(Contants.GOODS_PATH, treeMap);

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.getStrGET(goods_type, path);
        httpUtils.setCallBack(new HttpCallBack() {
            @Override
            public void sendStr(String type, String str) {
                if(type.equals(goods_type)){
                    initListView(str,flag);
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

    private void initListView(String str,int flag) {
        if(str!=null&&str.length()>20) {
            String data = "{\"data\":" + str + "}";
            Gson gson = new Gson();
            goodsData = gson.fromJson(data, GoodsData.class);
            if (flag == 0) {
                dataBeanList = goodsData.getData();
                adapter = new MyGoodsChildAdapter(dataBeanList, getActivity());
                listView.setAdapter(adapter);
            } else if (flag == 1) {
                dataBeanList = goodsData.getData();
                adapter = new MyGoodsChildAdapter(dataBeanList, getActivity());
                listView.setAdapter(adapter);
                listView.onRefreshComplete();
            } else {
                List<GoodsData.DataBean> list = goodsData.getData();
                int num = list.size();
                for (int i = 0; i < num; i++) {
                    dataBeanList.add(list.get(i));
                }
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
                listView.onRefreshComplete();
            }
            listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    if (dataBeanList != null && dataBeanList.size() > 0) {
                        String time = String.valueOf(System.currentTimeMillis() / 1000L);
                        lazyLoad(time, 1);
                    }
                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                    if (dataBeanList != null && dataBeanList.size() > 0) {
                        double post_time = dataBeanList.get(dataBeanList.size() - 1).getPost_time();
                        String time = String.valueOf(post_time);
                        lazyLoad(time, 2);
                    }
                }
            });
        }
    }

    public void goFirst(){
        ListView listView1 = listView.getRefreshableView();
        listView1.smoothScrollToPosition(0);
    }
}
