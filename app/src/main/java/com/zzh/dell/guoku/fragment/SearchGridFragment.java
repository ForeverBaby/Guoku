package com.zzh.dell.guoku.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.zzh.dell.guoku.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchGridFragment extends Fragment {


    public SearchGridFragment() {
        // Required empty public constructor
    }

    BaseAdapter adapter;
    @BindView(R.id.grid)
    public GridView listView;

    public void setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_grid, container, false);
        ButterKnife.bind(this, view);
        View emptyView = LayoutInflater.from(getActivity()).inflate(R.layout.search_list_empty, null);
        listView.setEmptyView(emptyView);
        return view;
    }

}
