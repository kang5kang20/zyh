package com.zyh.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTestUtils {
	public static String testHttpConnection(String urlString, String method, String postJson) throws IOException {
		// 创建服务地址
		URL url = new URL(urlString);
		// 打开一个通向服务地址的连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置发送方式
		connection.setRequestMethod(method);
		// 设置数据格式
		connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
		// 设置输入输出
		connection.setDoInput(true);
		connection.setDoOutput(true);
		if (null != postJson || "".equals(postJson)) {
			OutputStream os = connection.getOutputStream();
			os.write(postJson.getBytes());
		}
		if (connection.getResponseCode() != 200) {
			throw new RuntimeException("http请求失败,错误代码:" + connection.getResponseCode());
		}
		InputStream is = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		StringBuilder sb = new StringBuilder();
		String temp = null;
		while (null != (temp = br.readLine())) {
			sb.append(temp);
		}
		String json = sb.toString();
		is.close();
		isr.close();
		br.close();
		connection.disconnect();
		return json;
	}
}
