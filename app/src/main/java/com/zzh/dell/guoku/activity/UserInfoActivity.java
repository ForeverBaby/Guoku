package com.zzh.dell.guoku.activity;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.app.GuokuApp;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.BitmapUtils;
import com.zzh.dell.guoku.utils.DialogUtils;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CostumDialog;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserInfoActivity extends AppCompatActivity implements HttpCallBack {

    @BindView(R.id.title_bar_centrt_tv)
    TextView title_bar_centrt_tv;

    @BindView(R.id.title_bar_left_iv)
    ImageView title_bar_left_iv;

    @BindView(R.id.user_info_pic)
    ImageView user_info_pic;

    @BindView(R.id.user_info_ll_name)
    LinearLayout user_info_ll_name;

    @BindView(R.id.user_info_tv_name)
    TextView user_info_tv_name;

    @BindView(R.id.user_info_ll_sex)
    LinearLayout user_info_ll_sex;

    @BindView(R.id.user_info_tv_sex)
    TextView user_info_tv_sex;

    @BindView(R.id.user_info_ll_sign)
    LinearLayout user_info_ll_sign;

    @BindView(R.id.user_info_tv_sign)
    TextView user_info_tv_sign;

    @BindView(R.id.user_info_ll_add)
    LinearLayout user_info_ll_add;

    @BindView(R.id.user_info_tv_add)
    TextView user_info_tv_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        utils = new HttpUtils();
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorbgBlack));
        }
        utils.setCallBack(this);
        initView();
        title_bar_centrt_tv.setText("编辑个人资料");
        title_bar_left_iv.setImageResource(R.drawable.back_selector);
        IntentFilter inr = new IntentFilter();
        inr.addAction("Main.Login.btn.type1");
        inr.addAction("Main.Login.btn.type2");
        change = new MainActivity.ChangeListener();
        registerReceiver(change, inr);
    }

    MainActivity.ChangeListener change;

    Account.UserBean user;

    private void initView() {

        Account account = GuokuApp.getIntance().getAccount();
        if(account!=null) {
            user = account.getUser();
            Picasso.with(this).load(user.getAvatar_small()).fit().centerCrop().into(user_info_pic);
            user_info_tv_name.setText(user.getNickname());
            user_info_tv_sex.setText(getGender(user.getGender()));
            if (user.getBio() != null) {
                user_info_tv_sign.setText((String) user.getBio());
            } else {
                user_info_tv_sign.setText("");
            }
            user_info_tv_add.setText(user.getLocation());
        }

    }

    private String getGender(String str){
        if("0".equals(str)||"M".equals(str)||"男".equals(str)){
            return "男";
        }else {
            return "女";
        }
    }


    @OnClick(R.id.user_info_ll_sign)
    public void sign(View paramView) {
        final EditText localEditText = new EditText(this);
        localEditText.setText(String.valueOf(user.getBio()));
        DialogUtils.getEDialog(this, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        if ((localEditText.getText().toString() != null) && (!"".equals(localEditText.getText().toString()))) {
                            UserInfoActivity localUserInfoAct = UserInfoActivity.this;
                            Map<String, String> map = new ArrayMap<String, String>();
                            map.put("bio", localEditText.getText().toString());
                            utils.getStrPOST("bio", "http://api.guoku.com/mobile/v4/user/update/", map);
                        }
                    }
                }
                , "修改简介", localEditText).show();
    }

    HttpUtils utils;

    @OnClick(R.id.title_bar_left_iv)
    void back() {
        finish();
    }

    @OnClick(R.id.user_info_pic)
    public void Pic(View paramView) {

        DialogUtils.listDialgo(this, new String[]{"相册", "拍照", "取消"}, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                switch (paramInt) {
                    case 0:
                        Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
                        getAlbum.setType("image/*");
                        startActivityForResult(getAlbum, 0);
                        break;
                    case 1:
                        Intent int1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                            File file = new File(Contants.IMAGES_PATH);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            File file1 = new File(file, "temp.png");
                            path = Uri.fromFile(file1);
                            int1.putExtra(MediaStore.EXTRA_OUTPUT, path);
                            BitmapUtils.insertImgStore(UserInfoActivity.this, path.toString(), file1.getAbsolutePath());
                        }
                        startActivityForResult(int1, 1);
                        break;
                    default:
                        break;
                }
            }
        }).show();
    }

    Uri path;

    @OnClick(R.id.user_info_ll_add)
    public void add(View paramView) {
        final EditText localEditText = new EditText(this);
        localEditText.setText(user.getLocation());
        DialogUtils.getEDialog(this, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        if ((localEditText.getText().toString() != null) && (!"".equals(localEditText.getText().toString()))) {
                            Map<String, String> map = new ArrayMap<String, String>();
                            map.put("location", localEditText.getText().toString());
                            utils.getStrPOST("location", "http://api.guoku.com/mobile/v4/user/update/", map);
                        }
                    }
                }
                , "修改所在地", localEditText).show();
    }


    @Override
    public void sendStr(String type, String str) {
        Gson gson = new Gson();
        Account account = GuokuApp.getIntance().getAccount();
        if (str != null) {
            Account.UserBean userBean = gson.fromJson(str, Account.UserBean.class);
            if(userBean!=null) {
                account.setUser(userBean);
                GuokuApp.getIntance().login(account);
                initView();
                Intent intent = new Intent();
                intent.setAction("Main.Login.btn.type1");
                sendBroadcast(intent);
            }
        }

    }

    @OnClick(R.id.user_info_ll_name)
    public void name(View paramView) {
        final EditText localEditText = new EditText(this);
        localEditText.setText(user.getNick());
        DialogUtils.getEDialog(this, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        if ((localEditText.getText().toString() != null) && (!"".equals(localEditText.getText().toString()))) {
                            Map<String, String> map = new ArrayMap<String, String>();
                            map.put("nickname", localEditText.getText().toString());
                            utils.getStrPOST("location", "http://api.guoku.com/mobile/v4/user/update/", map);
                        }
                    }
                }
                , "修改昵称", localEditText).show();
    }


    @OnClick(R.id.user_info_ll_sex)
    public void sex(View paramView) {
        DialogUtils.listDialgo(this, new String[]{"男", "女", "取消"}, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                Map<String, String> map = new ArrayMap<String, String>();
                switch (paramInt) {

                    case 0:
                        map.put("gender", "M");
                        break;
                    case 1:
                        map.put("gender", "F");
                        break;
                    default:
                        break;

                }
                utils.getStrPOST("gender", "http://api.guoku.com/mobile/v4/user/update/", map);
            }
        }).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null||resultCode!=RESULT_OK) {
            if (requestCode == 0) {
                path = data.getData();
            }

        }
        ContentResolver resolver = getContentResolver();
        try {

            Bitmap bitmap = MediaStore.Images.Media.getBitmap(resolver, path);
            String s = BitmapUtils.saveImageToSDCard(bitmap, "temp.png");
            Bitmap bitmapByPath = BitmapUtils.getBitmapByPath(s);
            Picasso.with(this).load(path.toString()).resize(70, 70).centerCrop().into(user_info_pic);
//            user_info_pic.setImageBitmap(bitmapByPath);
            Log.e("===","====");
            upPic("http://api.guoku.com/mobile/v4/user/update/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Handler handler = new Handler();

    protected void upPic(String paramString) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        TreeMap localTreeMap = new TreeMap();
        builder.setType(MultipartBody.FORM);
        int count = 0;
        if (GuokuApp.getIntance().getAccount() != null) {
            builder.addFormDataPart("session", GuokuApp.getIntance().getAccount().getSession());
            localTreeMap.put("session", GuokuApp.getIntance().getAccount().getSession());
            count++;
        }
        File file = new File(Contants.IMAGES_PATH + "/temp.png");
        builder.addFormDataPart("image", file.getName(), RequestBody.create(null, file));

        builder.addFormDataPart("sign", StringUtils.getSign(localTreeMap));
        builder.addFormDataPart("api_key", "0b19c2b93687347e95c6b6f5cc91bb87");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().post(builder.build()).url(paramString).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(UserInfoActivity.this, "上传失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                if (string != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            Account.UserBean userBean = gson.fromJson(string, Account.UserBean.class);
                            Account account = GuokuApp.getIntance().getAccount();
                            account.setUser(userBean);
                            GuokuApp.getIntance().login(account);
                            Intent intent = new Intent();
                            intent.setAction("Main.Login.btn.type1");
                            Toast.makeText(UserInfoActivity.this, "上传成功", Toast.LENGTH_SHORT).show();
                            sendBroadcast(intent);
                        }
                    });
                }
            }
        });

    }

    CostumDialog dialog;

    @Override
    public void sendStrbefore(String type) {
        dialog = new CostumDialog(this);
        dialog.show();

    }

    @Override
    public void sendStrAfter(String type) {
        dialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(change);
    }
}
