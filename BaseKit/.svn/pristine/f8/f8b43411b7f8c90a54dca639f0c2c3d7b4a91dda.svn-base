package com.rogers.kit.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;

import java.util.Map;
import java.util.Set;

/**
 * 程序配置工具类 用户登录信息，数据缓存等。
 */
public final class BasePreferences implements SharedPreferences, Editor {

	private final SharedPreferences sharedPreferences;
	private final Editor editor;

	public BasePreferences(Context context) {
		this(context, "config");
	}

	public BasePreferences(Context context, String name) {
		this(context, name, Context.MODE_PRIVATE);
	}

	public BasePreferences(Context context, String name, int mode) {
		this.sharedPreferences = context.getSharedPreferences(name, mode);
		this.editor = this.sharedPreferences.edit();
	}

	public boolean getBoolean(String name) {
		return this.getBoolean(name, false);
	}

	public float getFloat(String name) {
		return this.getFloat(name, 0f);
	}

	public int getInt(String name) {
		return this.getInt(name, 0);
	}

	public long getLong(String name) {
		return this.getLong(name, 0l);
	}

	public String getString(String name) {
		return this.getString(name, null);
	}

	@Override
	public Editor putString(String name, String value) {
		return this.editor.putString(name, value);
	}

	@Override
	public Editor putInt(String name, int value) {
		return this.editor.putInt(name, value);
	}

	// public String getString(String name) {
	// return ObjectKit.getObject(this.getString(name, "")).toString();
	// }
	//
	// @Override
	// public Editor putString(String name, String value) {
	// return this.editor.putString(name, ObjectKit.getBASE64String(value));

	// }
	@Override
	public Editor putLong(String name, long value) {
		return this.editor.putLong(name, value);
	}
	@Override
	public Editor putFloat(String name, float value) {
		return this.editor.putFloat(name, value);
	}

	@Override
	public Editor putBoolean(String name, boolean value) {
		return this.editor.putBoolean(name, value);
	}

	@Override
	public Editor remove(String name) {
		return this.editor.remove(name);
	}

	@Override
	public Editor clear() {
		return this.editor.clear();
	}

	@Override
	public boolean commit() {
		return this.editor.commit();
	}

	@Override
	public boolean contains(String name) {
		return this.sharedPreferences.contains(name);
	}

	@Override
	public Editor edit() {
		return this.editor;
	}

	@Override
	public Map<String, ?> getAll() {
		return this.sharedPreferences.getAll();
	}

	@Override
	public boolean getBoolean(String name, boolean defValue) {
		return this.sharedPreferences.getBoolean(name, defValue);
	}

	@Override
	public float getFloat(String name, float defValue) {
		return this.sharedPreferences.getFloat(name, defValue);
	}

	@Override
	public int getInt(String name, int defValue) {
		return this.sharedPreferences.getInt(name, defValue);
	}

	@Override
	public long getLong(String name, long defValue) {
		return this.sharedPreferences.getLong(name, defValue);
	}

	@Override
	public String getString(String name, String defValue) {
		return this.sharedPreferences.getString(name, defValue);
	}

	@Override
	public void registerOnSharedPreferenceChangeListener(
			OnSharedPreferenceChangeListener onsharedpreferencechangelistener) {
		this.sharedPreferences
				.registerOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
	}

	@Override
	public void unregisterOnSharedPreferenceChangeListener(
			OnSharedPreferenceChangeListener onsharedpreferencechangelistener) {
		this.sharedPreferences
				.unregisterOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
	}

	@Override
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public void apply() {
		this.editor.apply();
	}

	@Override
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public Editor putStringSet(String arg0, Set<String> arg1) {
		return this.editor.putStringSet(arg0, arg1);
	}

	@Override
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public Set<String> getStringSet(String arg0, Set<String> arg1) {
		return this.sharedPreferences.getStringSet(arg0, arg1);
	}

}
