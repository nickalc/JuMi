package com.rogers.kit.base;

/**
 * Created by rogers on 15/10/19.
 */

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDex;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by rogers on 15/10/19.
 */
public class BaseApp extends Application {

    private static BaseApp instance;
    private BasePreferences preferences;

    public BaseApp() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Fresco.initialize(this);
    }

    public static BaseApp getInstance() {

        if (instance == null) {
            instance = new BaseApp();
        }
        return instance;
    }

    /**
     * 获取版本名
     *
     * @return 当前应用的版本名
     */
    public String getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public int getVersionCode() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public BasePreferences getPreferences() {
        if(preferences == null){
            preferences = new BasePreferences(this);
        }
        return preferences;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}

