package cn.whl.wechatutils.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientSend {

	private static HttpClientSend httpSend;

	private HttpClientSend(){
		
	}
	/**
	 * 采用单列方式来访问操作
	 * 
	 * @return
	 */
	public static synchronized HttpClientSend getInstance() {
		if (httpSend == null) {
			httpSend = new HttpClientSend();
		}
		return httpSend;
	}

	/**
	 * <p>
	 * POST方法
	 * </p>
	 *
	 *            ：返回的编码
	 * @return
	 */
	public String doAccessHttpPost(String sendUrl)throws Exception {
		StringBuffer receive = new StringBuffer();
		BufferedWriter wr = null;
		try {
			URL url = new URL(sendUrl);
			HttpURLConnection URLConn = (HttpURLConnection) url.openConnection();
			URLConn.setDoOutput(true);
			URLConn.setDoInput(true);
			((HttpURLConnection) URLConn).setRequestMethod("POST");
			URLConn.setUseCaches(false);
			HttpURLConnection.setFollowRedirects(true);
			URLConn.setConnectTimeout(2500);
			URLConn.setReadTimeout(3500);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					URLConn.getInputStream(), "UTF-8"));
			String line;
			while ((line = rd.readLine()) != null) {
				receive.append(line).append("\r\n");
			}
			rd.close();
		} 
		catch(java.net.SocketTimeoutException e){
			throw new Exception("连接短信服务器超时:"+e.getMessage());
		}
		catch (IOException e) {
			receive.append("访问产生了异常:").append(e.getMessage());
			throw new Exception("访问产生了异常:"+e.getMessage());
		} finally {
			if (wr != null) {
				try {
					wr.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				wr = null;
			}
		}

		return receive.toString();
	}

	public String doAccessHTTPGet(String sendUrl) {
		StringBuffer receive = new StringBuffer();
		BufferedReader in = null;
		try {
			URL url = new URL(sendUrl);
			HttpURLConnection URLConn = (HttpURLConnection) url
					.openConnection();
			URLConn.setDoInput(true);
			URLConn.setDoOutput(true);
			URLConn.connect();
			URLConn.setConnectTimeout(3000);
			URLConn.setReadTimeout(3500);
			URLConn.getOutputStream().flush();
			in = new BufferedReader(new InputStreamReader(URLConn
					.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				receive.append(line).append("\r\n");
			}
		} catch (IOException e) {
			receive.append("访问产生了异常-->").append(e.getMessage());
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				in = null;
			}
		}
		return receive.toString();
	}
}
