# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in G:\androidtools\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
################common###############
-keep class com.jph.android.entity.** { *; } #实体类不参与混淆
-keep class com.jph.android.view.** { *; } #自定义控件不参与混淆

################baidu map###############
-libraryjars libs/baidumapapi_v3_2_0.jar
-libraryjars libs/locSDK_5.0.jar
-keep class com.baidu.** { *; }
-keep class vi.com.gdi.bgl.android.**{*;}
-dontwarn com.baidu.**


################afinal##################
#-libraryjars libs/afinal_0.5_bin.jar
#-keep class net.tsz.afinal.** { *; }
#-keep public class * extends net.tsz.afinal.**
#-keep public interface net.tsz.afinal.** {*;}
#-dontwarn net.tsz.afinal.**

################xutils##################
-libraryjars libs/xUtils-2.6.14.jar
-keep class com.lidroid.xutils.** { *; }
-keep public class * extends com.lidroid.xutils.**
-keepattributes Signature
-keepattributes *Annotation*
-keep public interface com.lidroid.xutils.** {*;}
-dontwarn com.lidroid.xutils.**
-keepclasseswithmembers class com.jph.android.entity.** {
    <fields>;
    <methods>;
}

################支付宝##################
-libraryjars libs/alipaysecsdk.jar
-libraryjars libs/alipayutdid.jar
-libraryjars libs/alipaysdk.jar
-keep class com.alipay.android.app.IAliPay{*;}
-keep class com.alipay.android.app.IAlixPay{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
-keep class com.alipay.android.app.lib.ResourceMap{*;}

################gson##################
-libraryjars libs/gson-2.2.4.jar
-keep class com.google.gson.** {*;}
#-keep class com.google.**{*;}
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.google.** {
    <fields>;
    <methods>;
}
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-dontwarn com.google.gson.**



################httpmime/httpcore##########
-libraryjars libs/httpcore-4.3.2.jar
-libraryjars libs/httpmime-4.3.5.jar
-keep class org.apache.http.** {*;}
-dontwarn org.apache.http.**

####################jpush##################
-libraryjars libs/jpush-sdk-release1.7.1.jar
-keep class cn.jpush.** { *; }
-keep public class com.umeng.fb.ui.ThreadView { } #双向反馈功能代码不混淆
-dontwarn cn.jpush.**
-keepclassmembers class * {
    public <init>(org.json.JSONObject);
}
 #不混淆R类
-keep public class com.jph.android.R$*{
    public static final int *;
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

####################umeng##################
-libraryjars libs/umeng-analytics-v5.2.4.jar
-keep class com.umeng.analytics.** {*;}
-dontwarn com.umeng.analytics.**

#-keep public class * extends com.umeng.**
#-keep public class * extends com.umeng.analytics.**
#-keep public class * extends com.umeng.common.**
#-keep public class * extends com.umeng.newxp.**
-keep class com.umeng.** { *; }
-keep class com.umeng.analytics.** { *; }
-keep class com.umeng.common.** { *; }
-keep class com.umeng.newxp.** { *; }

-keepclassmembers class * {
   public <init>(org.json.JSONObject);
}
-keep class com.umeng.**

-keep public class com.idea.fifaalarmclock.app.R$*{
    public static final int *;
}

-keep public class com.umeng.fb.ui.ThreadView {
}

-dontwarn com.umeng.**

-dontwarn org.apache.commons.**

-keep public class * extends com.umeng.**

-keep class com.umeng.** {*; }

####################universal-image-loader########
-libraryjars libs/universal-image-loader-1.9.3.jar
-keep class com.nostra13.universalimageloader.** {*;}
-dontwarn com.nostra13.universalimageloader.**


####################zxing#####################
-libraryjars libs/zxing.jar
-libraryjars libs/zxing_apply.jar
-keep class com.google.zxing.** {*;}
-dontwarn com.google.zxing.**

####################BASE64Decoder##################
-libraryjars libs/sun.misc.BASE64Decoder.jar

####################support.v4#####################
-libraryjars libs/android-support-v4.jar
-keep class android.support.v4.** { *; }
-dontwarn android.support.v4.**

###################other####################
# slidingmenu 的混淆
-dontwarn com.jeremyfeinstein.slidingmenu.lib.**
-keep class com.jeremyfeinstein.slidingmenu.lib.** { *; }
# ActionBarSherlock混淆
-dontwarn com.actionbarsherlock.**
-keep class com.actionbarsherlock.** { *; }
-keep interface com.actionbarsherlock.** { *; }
-keep class * extends java.lang.annotation.Annotation { *; }
-keepclasseswithmembernames class * {
    native <methods>;
}

-keep class com.jph.android.entity.** {
    <fields>;
    <methods>;
}

-dontwarn android.support.**
-dontwarn com.slidingmenu.lib.app.SlidingMapActivity
-keep class android.support.** { *; }
-keep class com.actionbarsherlock.** { *; }
-keep interface com.actionbarsherlock.** { *; }
-keep class com.slidingmenu.** { *; }
-keep interface com.slidingmenu.** { *; }
