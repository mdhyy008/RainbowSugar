package com.CottonCandy;
import java.util.*;
import android.content.pm.*;
import android.content.*;

public class ApkTool {
 
    public static List<MyAppInfo> mLocalInstallApps = null;

    public static List<MyAppInfo> scanLocalInstallAppList(PackageManager packageManager,int mode) {
        List<MyAppInfo> myAppInfos = new ArrayList<MyAppInfo>();
        try {
            List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
            for (int i = 0; i < packageInfos.size(); i++) {
                PackageInfo packageInfo = packageInfos.get(i);
               
            if ((ApplicationInfo.FLAG_SYSTEM & packageInfo.applicationInfo.flags) != mode) {
               continue;
            }
                MyAppInfo myAppInfo = new MyAppInfo();
					
                myAppInfo.setAppName(packageInfo.packageName);
                if (packageInfo.applicationInfo.loadIcon(packageManager) == null) {
                    continue;
                }
                myAppInfo.setImage(packageInfo.applicationInfo.loadIcon(packageManager));
                myAppInfos.add(myAppInfo);
            }
        }catch (Exception e){
        }
        return myAppInfos;
    }
}
