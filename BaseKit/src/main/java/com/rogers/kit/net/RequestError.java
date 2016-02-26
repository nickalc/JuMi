package com.rogers.kit.net;

import com.android.volley.VolleyError;

import java.io.Serializable;

public class RequestError extends VolleyError implements Serializable{
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}
	
}
