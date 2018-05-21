package com.xingyoucai.irm.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

	private static OkHttpClient clent = null;
	public final static int CONNECT_TIMEOUT = 1000;
	public final static int READ_TIMEOUT = 1000;
	public final static int WRITE_TIMEOUT = 1000;

	public static OkHttpClient getInstance() {
		if (clent == null)
			clent = new OkHttpClient.Builder().readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)// 设置读取超时时间
					.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)// 设置写的超时时间
					.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)// 设置连接超时时间
					.build();
		return clent;
	}
	
	public static String post(String url,String json) throws IOException{
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json);
		Request request = new Request.Builder().url(url).header("token", "qlWB2ZgvV3ZGDTuAUGEdiHceANW1jjM4EZPDuxYNQ0k").post(requestBody).build();
		Response response = getInstance().newCall(request).execute();
		String result = response.body().string();
		return result;
	}
	
	public static String get(String url) throws IOException{
		Request request = new Request.Builder().url(url).header("token", "qlWB2ZgvV3ZGDTuAUGEdiHceANW1jjM4EZPDuxYNQ0k").get().build();
		Response response = getInstance().newCall(request).execute();
		String result = response.body().string();
		return result;
	}
}
