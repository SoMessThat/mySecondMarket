package com.cjw.project.tool.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

public class MapUtil {
	public static String GetLocationMsg(double latitude,double longitude){

		String message = "";
		String ak="T2nwphiIpi2QRUbdmLTQf8z1e3SP2Wgc";
		String url = String.format(
						"http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location=%s,%s&output=json&pois=1&latest_admin=1&ak=%s",
						latitude,longitude,ak);
		URL myURL = null;
		URLConnection httpsConn = null;

		try {
			myURL = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			httpsConn = (URLConnection) myURL.openConnection();
			if (httpsConn != null) {
				InputStreamReader insr = new InputStreamReader(
						httpsConn.getInputStream(), "UTF-8");
				BufferedReader br = new BufferedReader(insr);
				String data = null;
				while ((data = br.readLine()) != null) {
					message = message+data;
				}
				insr.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;

	}

	public final static void main(String[] args) {

	        	String obj=GetLocationMsg(32.7763644055,100.4338731743);
	        	
	        	//转换成json格式字符串
	        	int index1 = obj.indexOf('(');
    			String a = obj.substring(index1 + 1);
    			String jsonStr = a.substring(0, a.length()-1);
//    			System.out.println(jsonStr);
    			//转换为json对象
    			JSONObject json = JSONObject.fromObject(jsonStr);
    			//第一层
    			System.out.println(json.getString("status"));
    			//第二层
    			JSONObject result=json.getJSONObject("result");
    			System.out.println(result.getString("formatted_address"));
    			
	}
}