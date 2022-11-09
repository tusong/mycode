package com.tydic.ioam.pub.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * 简单封装了 get和post请求
 * @author song
 *
 */
public class HttpWrapper {

	public static String doPost(String urlstr,String contents) {
		OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
		try {
			URL url = new URL(urlstr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("Charsert", "UTF-8");
			con.setDoOutput(true);
			outputStream = con.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream);
			outputStreamWriter.write(contents);
			//调用flush刷新，数据才会从缓冲区写出
			outputStreamWriter.flush();
			
			inputStream = con.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);
			while ((tempLine = reader.readLine()) != null) {
	            resultBuffer.append(tempLine);
	        }
			
			System.out.println(resultBuffer.toString());
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally {
            try {
            	if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                
                if (outputStream != null) {
                    outputStream.close();
                }
                
                if (reader != null) {
                    reader.close();
                }
                
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                
                if (inputStream != null) {
                    inputStream.close();
                }
            }catch(Exception e) {
            	throw new RuntimeException(e);
            }
        }

		return resultBuffer.toString();
	}
	
	public static String doGet(String urlstr) {
		
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
		try {
			URL url = new URL(urlstr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			inputStream = con.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);
			while ((tempLine = reader.readLine()) != null) {
	            resultBuffer.append(tempLine);
	        }
			
			System.out.println(resultBuffer.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
            try {
		        if (reader != null) {
		            reader.close();
		        }
		        
		        if (inputStreamReader != null) {
		            inputStreamReader.close();
		        }
		        
		        if (inputStream != null) {
		            inputStream.close();
		        }
            }catch(Exception e) {
            	
            }
		}
		
		return resultBuffer.toString();
	}
//	public static void main(String[] args) {
//		Map<String, String> obj = new HashMap<String, String>();
//		obj.put("appKey", "29671538");
//		obj.put("content", "【海量网】测试短信，请忽略内容。回T退订");
//		obj.put("mobile", "13500043529");
////		obj.put("subPort", "");//扩展端口
////		obj.put("sendTime", "");//发送时间。可以为空。目前暂不支持定时发送
//		System.err.println("签名前:"+JSON.toJSONString(obj));
//		
//		String sign = "";
//		try {
//			sign = SignUtilMap.getSignMp(obj, "f523440a3e28480bacb5a6430332af71");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		obj.put("sign", sign);
//		
//		String paramStr = "";
//		for(Map.Entry<String, String> query : obj.entrySet()){
//			paramStr+= query.getKey()+"="+query.getValue()+"&";
//		}
//		paramStr = paramStr.substring(0,paramStr.lastIndexOf("&"));
//		
//		System.err.println("paramStr: "+paramStr);
//		String url = "http://mass.baobeituan.com/sms/v1/single?"+paramStr;
//		System.err.println("url: "+url);
//		String resultString = HttpWrapper.doPost(url, "");
//		System.err.println("result:"+resultString);
//	}


	public static void main(String[] args) {
		long lastmillis = 166634013025l;
		System.out.println(System.currentTimeMillis());
		long time = System.currentTimeMillis() - lastmillis;
		long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
		System.out.println(seconds);
	}
}
