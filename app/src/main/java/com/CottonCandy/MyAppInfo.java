package com.CottonCandy;
import android.graphics.drawable.*;


public class MyAppInfo {
    private Drawable image;
    private String appName;
	private String appPackage;
	
    public MyAppInfo(Drawable image, String appName,String appPackage) {
        this.image = image;
        this.appName = appName;
		this.appPackage = appPackage;
    }
    public MyAppInfo() {
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
	
	public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }
	
	
}
