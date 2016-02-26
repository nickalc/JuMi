package com.rogers.kit.net;

import com.squareup.okhttp.RequestBody;

import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by rogers on 15/10/20.
 */
public class BaseRequestBody {
    private JSONObject object;
    private boolean isReturnAll;
    private HashMap<String, Type> requestModelMap;//存放实体Map
    private String requestURL;
    private File file;

    public RequestBody getObject() {
        RequestBody body = null;
        if(file!=null){
            //文件
            body = RequestBody.create(OkHttpInstance.JSON,file);
        }else{
            //json
            body = RequestBody.create(OkHttpInstance.JSON,object.toString());
        }
        return body;
    }

    public void setObject(JSONObject object) {
        this.object = object;
    }

    public boolean isReturnAll() {
        return isReturnAll;
    }

    public void setIsReturnAll(boolean isReturnAll) {
        this.isReturnAll = isReturnAll;
    }

    public HashMap<String, Type> getRequestModelMap() {
        return requestModelMap;
    }

    public void setRequestModelMap(HashMap<String, Type> requestModelMap) {
        this.requestModelMap = requestModelMap;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
