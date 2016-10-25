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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.WebActivity;
import com.zzh.dell.guoku.adapter.MyImageTextAdapter;
import com.zzh.dell.guoku.bean.ImageTextData;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagetextFragment extends Fragment {

    private String image_type = "image_data";
    private List<ImageTextData.DataBean> dataList = new ArrayList<>();
    private MyImageTextAdapter adapter;
    private int page = 0;

    public static ImagetextFragment newInstance() {

        Bundle args = new Bundle();

        ImagetextFragment fragment = new ImagetextFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.pullListView02)
    PullToRefreshListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_imagetext, container, false);
        ButterKnife.bind(this,view);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        page = 1;
        lazyLoad(page,0);
        return view;
    }

    Handler handler = new Handler();
    private void lazyLoad(int page, final int flag) {
        String path = initPath(page);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(path).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                final String data = "{\"data\":" + str + "}";
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        initListView(data,flag);
                    }
                });
            }
        });
    }

    private void initListView(String data,int flag) {
        Gson gson = new Gson();
        ImageTextData imageTextData = gson.fromJson(data, ImageTextData.class);

        if(flag == 0){
            dataList = imageTextData.getData();
            adapter = new MyImageTextAdapter(dataList,getActivity());
            listView.setAdapter(adapter);
        }else if(flag == 1){
            dataList = imageTextData.getData();
            adapter = new MyImageTextAdapter(dataList,getActivity());
            listView.setAdapter(adapter);
            listView.onRefreshComplete();
        }else{
            List<ImageTextData.DataBean> list = imageTextData.getData();
            int len = list.size();
            for(int i=0;i<len;i++){
                dataList.add(list.get(i));
            }
            adapter = new MyImageTextAdapter(dataList,getActivity());
            listView.setAdapter(adapter);
            listView.onRefreshComplete();
        }
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                lazyLoad(page,1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                lazyLoad(page,2);
            }
        });
    }

    public void goFirst(){
        ListView listView1 = listView.getRefreshableView();
        listView1.smoothScrollToPosition(0);
    }

    private String initPath(int page) {
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("page",String.valueOf(page));
        treeMap.put("size",String.valueOf(20));
        String getUrl = StringUtils.getGetUrl(Contants.IMAGE_TEXT_PATH, treeMap);
        return getUrl;
    }
}
