package com.zzh.dell.guoku.fragment;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.adapter.DynamicAdapter;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment implements HttpCallBack {

    private String dynamic_type = "dynamic_data";

    public MessageFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.dynamic_text)
    TextView dynamic_text;

    @BindView(R.id.message_text)
    TextView message_text;

    @BindView(R.id.dynamic_line)
    View dynamic_line;

    @BindView(R.id.message_line)
    View message_line;

    @BindView(R.id.dynamic_list)
    PullToRefreshListView dynamic_list;

    @BindView(R.id.message_list)
    PullToRefreshListView message_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        ButterKnife.bind(this,view);
        dynamic_list.setMode(PullToRefreshBase.Mode.BOTH);
        message_list.setMode(PullToRefreshBase.Mode.BOTH);
        onClick01();
        return view;
    }

    @OnClick(R.id.dynamic_text)
    public void onClick01(){
        showDynamic();
        String time = String.valueOf(System.currentTimeMillis()/1000L);
        dynamicData(time);

    }

    @OnClick(R.id.message_text)
    public void onClick02(){
        showMessage();
    }

    private void showDynamic(){
        dynamic_line.setVisibility(View.VISIBLE);
        dynamic_text.setTextColor(getActivity().getResources().getColor(R.color.colorBlack));
        dynamic_list.setVisibility(View.VISIBLE);
        message_line.setVisibility(View.GONE);
        message_text.setTextColor(getActivity().getResources().getColor(R.color.gray_fzxx));
        message_list.setVisibility(View.GONE);
    }

    private void showMessage(){
        message_line.setVisibility(View.VISIBLE);
        message_text.setTextColor(getActivity().getResources().getColor(R.color.colorBlack));
        message_list.setVisibility(View.VISIBLE);
        dynamic_line.setVisibility(View.GONE);
        dynamic_text.setTextColor(getActivity().getResources().getColor(R.color.gray_fzxx));
        dynamic_list.setVisibility(View.GONE);
    }

    public void dynamicData(String time){
        Map<String,String> map = new ArrayMap<>();
        map.put("count","30");
        map.put("timestamp",time);
        String getUrl = StringUtils.getGetUrl(Contants.DYNAMIC_PATH, map);
        Log.e("=====","===DynamicPath==="+getUrl);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.getStrGET(dynamic_type,getUrl);
        httpUtils.setCallBack(this);
    }

    @Override
    public void sendStr(String type, String str) {
        if(type.equals(dynamic_type)){
            //登录了才调用
//            initListView(str);
        }
    }

    @Override
    public void sendStrbefore(String type) {
    }

    @Override
    public void sendStrAfter(String type) {

    }

    private void initListView(String str) {
        DynamicAdapter adapter = new DynamicAdapter(str,getActivity());
        dynamic_list.setAdapter(adapter);
    }
}
