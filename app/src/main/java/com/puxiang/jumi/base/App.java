package com.puxiang.jumi.base;

import com.puxiang.jumi.bean.Engine;
import com.rogers.kit.base.BaseApp;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 *
 */
public class App extends BaseApp {
    private static App sInstance;
    private Engine mEngine;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        mEngine = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/bingoogolapple/BGABanner-Android/server/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Engine.class);

      //  Fresco.initialize(this);
    }


    public static App getInstance() {
        return sInstance;
    }

    public Engine getEngine() {
        return mEngine;
    }
}