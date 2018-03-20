package com.CottonCandy;

import android.net.wifi.*;
import android.content.*;

public class WifiUtils {

    private final WifiManager mWifiManager;

    public WifiUtils(Context context) {
        mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    //判断WiFi是否打开
    public boolean isopenWifi() {
        return mWifiManager.isWifiEnabled();
    }

    //开启WiFi
    public boolean openWifi() {
        if (!mWifiManager.isWifiEnabled()) {
            boolean b = mWifiManager.setWifiEnabled(true);
            return b;
        }
        return true;
    }

    //关闭WiFi
    public boolean closeWifi() {
        if (mWifiManager.isWifiEnabled()) {
            boolean b = mWifiManager.setWifiEnabled(false);
            return b;
        }
        return true;
    }
}







