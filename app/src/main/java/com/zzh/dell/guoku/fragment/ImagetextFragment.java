package com.zzh.dell.guoku.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzh.dell.guoku.R;

/**
 * A simple {@link Fragment} subclass.
 */
class ImageTextFragment extends LazyFragment {

    public static ImageTextFragment newInstance() {

        Bundle args = new Bundle();

        ImageTextFragment fragment = new ImageTextFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_imagetext, container, false);
        return view;
    }

    @Override
    protected void lazyLoad() {

    }
}
