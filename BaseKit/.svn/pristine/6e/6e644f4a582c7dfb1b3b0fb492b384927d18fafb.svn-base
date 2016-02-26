package com.rogers.kit.net;

import android.text.TextUtils;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by rogers on 15/10/19.
 */
public class OKHttpRequest {

    /**
     * 发送GET请求
     * @param requestCallBack
     */
    public static void initGetRequest(final BaseRequestBody body, final IRequestCallBack requestCallBack){
        final Request request = new Request.Builder()
                .url(body.getRequestURL())
                .build();
        OkHttpInstance.getOkHttpInstance().getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                RequestError error = new RequestError();
                error.setMessage("请求失败");
                error.setCode(0);
                requestCallBack.onFail(error,body.getRequestURL());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                RequestError error = new RequestError();
                if (null != requestCallBack) {
                    try {
                        if (!TextUtils.isEmpty(request.body().toString())) {
                            if (body.isReturnAll()) {
                                requestCallBack.onSuccess(request.toString(), body.getRequestURL());
                            } else {
                                JSONObject object = new JSONObject(request.body().toString());
                                requestCallBack.onSuccess(JSONUtil.toBean(object.getString("data"), body.getRequestModelMap().get(body.getRequestURL())), body.getRequestURL());
                            }
                        } else {
                            error.setMessage("暂无数据");
                            error.setCode(0);
                            requestCallBack.onFail(error, body.getRequestURL());
                        }
                    } catch (Exception e) {
                        error.setMessage("数据格式异常");
                        error.setCode(0);
                        requestCallBack.onFail(error, body.getRequestURL());
                    }
                }
            }
        });
    }


    /**
     * 发起POST请求
     */
    public static void initPostRequest(final BaseRequestBody body, final IRequestCallBack requestCallBack){
        final Request request = new Request.Builder()
                .url(body.getRequestURL())
                .post(body.getObject())
                .build();
        OkHttpInstance.getOkHttpInstance().getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                RequestError error = new RequestError();
                error.setMessage("请求失败");
                error.setCode(0);
                requestCallBack.onFail(error,body.getRequestURL());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                RequestError error = new RequestError();
                if (null != requestCallBack) {
                    try {
                        if (!TextUtils.isEmpty(request.body().toString())) {
                            if (body.isReturnAll()) {
                                requestCallBack.onSuccess(request.toString(), body.getRequestURL());
                            } else {
                                JSONObject object = new JSONObject(request.body().toString());
                                requestCallBack.onSuccess(JSONUtil.toBean(object.getString("data"), body.getRequestModelMap().get(body.getRequestURL())), body.getRequestURL());
                            }
                        } else {
                            error.setMessage("暂无数据");
                            error.setCode(0);
                            requestCallBack.onFail(error, body.getRequestURL());
                        }
                    } catch (Exception e) {
                        error.setMessage("数据格式异常");
                        error.setCode(0);
                        requestCallBack.onFail(error, body.getRequestURL());
                    }
                }
            }
        });
    }

    /**
     * 上传文件接口
     * @param body
     * @param requestCallBack
     */
    public static void uploadFile(final BaseRequestBody body, final IRequestCallBack requestCallBack){
        try {
            Request request = new Request.Builder()
                    .url(body.getRequestURL())
                    .post(body.getObject())
                    .build();
            OkHttpInstance.getOkHttpInstance().getOkHttpClient().newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
