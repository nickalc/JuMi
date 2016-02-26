package com.rogers.kit.net;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

public class JSONUtil {

	/**
	 * <code>fromObject</code>
	 * 
	 * @description: TODO(字符串或者对象转化为JSONObject)
	 * @param object
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject fromObject(Object object) throws JSONException {
		GsonBuilder gsonb = new GsonBuilder();
		gsonb.setDateFormat("yyyy-MM-dd hh:mm:ss");
		gsonb.registerTypeAdapter(java.util.Date.class,
				new DateTimeTypeAdapter());
		Gson gson = gsonb.create();
		return new JSONObject(gson.toJson(object));
	}
	
	
    /**
     * 将给定的 {@code JSON} 字符串转换成指定的类型对象。<strong>此方法通常用来转换普通的 {@code JavaBean} 对象。</strong>
     * @param <T>
     *
     * @param <T> 要转换的目标类型。
     * @param json 给定的 {@code JSON} 字符串。
     * @param clazz 要转换的目标类。
     * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
     * @since 1.0
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
        	return gson.fromJson(json, clazz);
        } catch (Exception ex) {
            Log.e(json + " 无法转换为 " + clazz.getName() + " 对象!", ex.getMessage());
            return null;
        }
    }

	public static JSONArray objectToArray(Object object) throws JSONException {
		GsonBuilder gsonb = new GsonBuilder();
		Gson gson = gsonb.create();
		gsonb.setDateFormat("yyyy-MM-dd HH:mm:ss");
		return new JSONArray(gson.toJson(object));
	}

	/**
	 * <code>toBean</code>
	 * 
	 * @param <T>
	 * 
	 * @description: TODO(json字符串转化为类)
	 * @param jsonString
	 * @param beanclass
	 * @return
	 */
	public static <T> T toBean(String jsonString, Class<T> beanclass) {
		GsonBuilder gsonb = new GsonBuilder().serializeNulls();
		gsonb.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = gsonb.create();
		return gson.fromJson(jsonString, beanclass);
	}

	public static <T> T toBean(String jsonString, Type t) {
		GsonBuilder gsonb = new GsonBuilder().serializeNulls();
		gsonb.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = gsonb.create();
		return gson.fromJson(jsonString, t);
	}

	/**
	 * <code>toBean</code>
	 * 
	 * @param <T>
	 * 
	 * @description: TODO(json对象转化为类)
	 * @param object
	 * @param beanclass
	 * @return
	 */
	public static <T> T toBean(JSONObject object, Class<T> beanclass) {
		return toBean(object.toString(), beanclass);
	}

	/**
	 * 把字符串转换成JSON对象
	 * 
	 * @param string
	 * @return
	 */
	public static JSONObject toJSONObject(String string) {
		try {
			return new JSONObject(string);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 把字符串转换成JSON数组对象
	 * 
	 * @param string
	 * @return
	 */
	public static JSONArray toJSONArray(String string) {
		try {
			return new JSONArray(string);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 将对象转出json字符串
	 * @param object
	 * @return
	 */
	public static String toJSONString(Object object){
		GsonBuilder gsonb = new GsonBuilder();
		gsonb.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = gsonb.create();
		return gson.toJson(object);
	}

}
