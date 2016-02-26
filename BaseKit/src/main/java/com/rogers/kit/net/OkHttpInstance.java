package com.rogers.kit.net;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by rogers on 15/10/19.
 */
public class OkHttpInstance {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpInstance okHttpUtil;
    private OkHttpClient okHttpClient;
    public OkHttpInstance() {
        okHttpClient = getOkHttpClient();
    }

    public static synchronized OkHttpInstance getOkHttpInstance(){
        if(okHttpUtil == null){
            okHttpUtil = new OkHttpInstance();
        }
        return okHttpUtil;
    }

    public OkHttpClient getOkHttpClient(){
        if(okHttpClient == null){
            okHttpClient = new OkHttpClient();
            okHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
        }
        return okHttpClient;
    }
}
