package com.zzh.dell.guoku.view;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.LoginActivity;
import com.zzh.dell.guoku.app.GuokuApp;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * Created by DELL on 2016/10/18.
 */
public class CustomShareBoard extends PopupWindow implements View.OnClickListener{

    private Activity mActivity;

    private View rootView;

    private String title;

    private String url;

    public CustomShareBoard(Activity paramActivity) {
        super(paramActivity);
        this.mActivity = paramActivity;
        initView(paramActivity);
    }

    LinearLayout share_wx_1;
    LinearLayout share_wx_2;
    LinearLayout share_sina;
    LinearLayout share_llq;
    LinearLayout share_mail;
    LinearLayout layout_refresh;
    LinearLayout layout_copy;
    LinearLayout layout_report;
    TextView cancel;

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_board, null, false);
        share_wx_1 = (LinearLayout) view.findViewById(R.id.share_wx_1);
        share_wx_2 = (LinearLayout) view.findViewById(R.id.share_wx_2);
        share_sina = (LinearLayout) view.findViewById(R.id.share_sina);
        share_llq = (LinearLayout) view.findViewById(R.id.share_llq);
        share_mail = (LinearLayout) view.findViewById(R.id.share_mail);
        layout_refresh = (LinearLayout) view.findViewById(R.id.layout_refresh);
        layout_copy = (LinearLayout) view.findViewById(R.id.layout_copy);
        layout_report = (LinearLayout) view.findViewById(R.id.layout_report);
        cancel = (TextView) view.findViewById(R.id.cancel);
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setTouchable(true);
        initListener();
    }

    private void initListener() {
        share_wx_1.setOnClickListener(this);
        share_wx_2.setOnClickListener(this);
        share_sina.setOnClickListener(this);
        share_llq.setOnClickListener(this);
        share_mail.setOnClickListener(this);
        layout_refresh.setOnClickListener(this);
        layout_copy.setOnClickListener(this);
        layout_report.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(GuokuApp.getIntance().getAccount()==null){
            Intent intent = new Intent(mActivity, LoginActivity.class);
            mActivity.startActivity(intent);
            return;
        }
        switch (v.getId()) {
            case R.id.share_wx_1:
                showShare(true, WechatMoments.NAME);
                break;
            case R.id.share_wx_2:
                showShare(true, Wechat.NAME);

                break;
            case R.id.share_sina:
                showShare(true, SinaWeibo.NAME);
                break;
            case R.id.share_llq:
                Intent localIntent2 = new Intent("android.intent.action.VIEW");
                localIntent2.setData(Uri.parse(this.url));
                this.mActivity.startActivity(localIntent2);
                break;
            case R.id.share_mail:
                sendMail();
                break;
            case R.id.layout_refresh:
                isrefresh = true;
                break;
            case R.id.layout_copy:
                ((ClipboardManager)this.mActivity.getSystemService(Context.CLIPBOARD_SERVICE)).setText(this.url);
                Toast.makeText(this.mActivity, this.mActivity.getString(R.string.tv_already_copy),Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_report:
                break;
            case R.id.cancel:
                break;
        }
        dismiss();
    }

//    private void shareWX() {
//        ShareSDK.initSDK(mActivity);
//        Platform.ShareParams sp = new Platform.ShareParams();
//        sp.setShareType(Platform.SHARE_IMAGE);
//        sp.setText(title + paramString1 + "（分享自 @果库）" + url);
//        sp.setImagePath(url);
//        Platform WX = ShareSDK.getPlatform(Wechat.NAME);
//        WX.setPlatformActionListener(new PlatformActionListener() {
//            @Override
//            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
//
//            }
//
//            @Override
//            public void onError(Platform platform, int i, Throwable throwable) {
//
//            }
//
//            @Override
//            public void onCancel(Platform platform, int i) {
//
//            }
//        });
//        WX.share(sp);
//    }

//    private void sharewxment() {
//        ShareSDK.initSDK(mActivity);
//        Platform.ShareParams sp = new Platform.ShareParams();
//        sp.setText(title + paramString1 + "（分享自 @果库）" + url);
//        sp.setImagePath(url);
//        Platform WXM = ShareSDK.getPlatform(WechatMoments.NAME);
//        WXM.setPlatformActionListener(new PlatformActionListener() {
//            @Override
//            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
//
//            }
//
//            @Override
//            public void onError(Platform platform, int i, Throwable throwable) {
//
//            }
//
//            @Override
//            public void onCancel(Platform platform, int i) {
//
//            }
//        });
//        WXM.share(sp);
//    }

    public boolean isrefresh = false;


    private void sendMail() {
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setType("plain/text");
        localIntent.putExtra("android.intent.extra.SUBJECT", this.mActivity.getResources().getString(R.string.tv_static_title));
        localIntent.putExtra("android.intent.extra.TEXT", this.title + this.url);
        this.mActivity.startActivity(localIntent);
    }
    String paramString1;
    String paramString2;
    String aturl;
    /**
     * @param paramContext 当前activity的Context
     * @param paramString1 副标题
     * @param paramString2 当前分享内容的url
     * @param paramString3 当前分享图片的url
     * @param paramString4 当前标题
     */
    public void setShareContext(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
//        configPlatforms(paramString1);
        ShareSDK.initSDK(paramContext);
        this.url = paramString3;
        this.title = paramString4;
        this.paramString1 = paramString1;
        aturl = paramString2;
    }
//    private void share_xinlang(){
//        ShareSDK.initSDK(mActivity);
//        Platform.ShareParams sp = new Platform.ShareParams();
//        sp.setText(title + paramString1 + "（分享自 @果库）" + url);
//        sp.setImagePath(url);
//
//        Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
//        weibo.setPlatformActionListener(new PlatformActionListener() {
//            @Override
//            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
//
//            }
//
//            @Override
//            public void onError(Platform platform, int i, Throwable throwable) {
//
//            }
//
//            @Override
//            public void onCancel(Platform platform, int i) {
//
//            }
//        }); // 设置分享事件回调
// 执行图文分享
//        weibo.share(sp);
//    }
    //快捷分享的文档：http://wiki.mob.com/Android_%E5%BF%AB%E6%8D%B7%E5%88%86%E4%BA%AB
    private void showShare(boolean silent, String platform){
     OnekeyShare oks = new OnekeyShare();
//        oks.setImagePath(url);
        //不同平台的分享参数，请看文档
        //http://wiki.mob.com/Android_%E4%B8%8D%E5%90%8C%E5%B9%B3%E5%8F%B0%E5%88%86%E4%BA%AB%E5%86%85%E5%AE%B9%E7%9A%84%E8%AF%A6%E7%BB%86%E8%AF%B4%E6%98%8E


        oks.setSilent(silent);


        oks.setDialogMode();
        oks.disableSSOWhenAuthorize();
        if (platform != null) {
            oks.setPlatform(platform);
        }
        // 去自定义不同平台的字段内容
        // http://wiki.mob.com/Android_%E5%BF%AB%E6%8D%B7%E5%88%86%E4%BA%AB#.E4.B8.BA.E4.B8.8D.E5.90.8C.E5.B9.B3.E5.8F.B0.E5.AE.9A.E4.B9.89.E5.B7.AE.E5.88.AB.E5.8C.96.E5.88.86.E4.BA.AB.E5.86.85.E5.AE.B9
        oks.setShareContentCustomizeCallback(new ShareContentCustomizeDemo());

        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
//        oks.setTitle(title);
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
//        oks.setTitleUrl(url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(title + "（分享自 @果库）" + aturl);
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setInstallUrl(url);
//        oks.set
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("评论");
        // site是分享此内容的网站名称，仅在QQ空间使用
//        oks.setSite(mActivity.getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(mActivity);
    }


}
