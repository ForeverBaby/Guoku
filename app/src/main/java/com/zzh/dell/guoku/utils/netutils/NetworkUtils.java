package com.zzh.dell.guoku.utils.netutils;

import android.annotation.TargetApi;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

/**朱张华
 * Created by DELL on 2016/10/14.
 */
public class NetworkUtils {
//    public static boolean judgeNetwork(Context context){
//        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo[] allNetworks = systemService.getAllNetworkInfo();
//        int length = allNetworks.length;
//        for (int i = 0; i < length; i++) {
//            if(allNetworks[i].getState()==NetworkInfo.State.CONNECTED){
////                NetworkInfo inf = allNetworks[i];
////                if(){
////
////                }
//                return true;
//            }
//        }
//
//        return false;
//    }
public static boolean checkNetWork(Context paramContext)
{
    boolean bool1 = isWifi(paramContext);
    boolean bool2 = isMobile(paramContext);
    return (bool1) || (bool2);
}

    public static boolean isMobile(Context paramContext)
    {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService(Context.CONNECTIVITY_SERVICE)).getNetworkInfo(0);
        boolean bool = false;
        if (localNetworkInfo != null) {
            bool = localNetworkInfo.isConnected();
        }
        return bool;
    }

    public static boolean isWifi(Context paramContext)
    {
        if (paramContext != null)
        {
            NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService(Context.CONNECTIVITY_SERVICE)).getNetworkInfo(1);
            if (localNetworkInfo != null)
                return localNetworkInfo.isConnected();
        }
        return false;
    }
}
