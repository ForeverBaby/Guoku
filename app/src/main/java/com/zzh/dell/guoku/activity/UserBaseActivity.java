package com.zzh.dell.guoku.activity;

import android.os.Build;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.fragment.MeFragment;
import com.zzh.dell.guoku.fragment.MessageFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserBaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_base);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));
        }
        Account.UserBean userBean = getIntent().getParcelableExtra("data");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        MeFragment fragment = new MeFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("userBean",userBean);
        fragment.setArguments(bundle);
        transaction.add(R.id.fl_content2,fragment);
        transaction.commit();
    }
}
