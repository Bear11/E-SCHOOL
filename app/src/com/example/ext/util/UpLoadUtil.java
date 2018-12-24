package com.example.ext.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

/**
 * 上传文件类
 * 
 * @author Dollkey
 */
public class UpLoadUtil {

	private static final String CHARSET = "utf-8"; // 设置编码 ，为了上传图片而设定的变量
	private static final String TAG = "uploadFile"; // 为了上传图片而设定的变量

	public UpLoadUtil() {
	}

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public static String mapToString(Map<String, String> map) {
		StringBuffer buffer = new StringBuffer();
		try {
			if (map != null && !map.isEmpty()) {
				Set<Map.Entry<String, String>> me = map.entrySet();
				Iterator<Map.Entry<String, String>> it = me.iterator();
				while (it.hasNext()) {
					Map.Entry<String, String> entry = it.next();
					if (entry.getValue() != null) {
						buffer.append(entry.getKey())
								.append("=")
								.append(URLEncoder.encode(entry.getValue(),
										"utf-8")).append("&");
					} else {
						buffer.append(entry.getKey()).append("=")
								.append(URLEncoder.encode("error", "utf-8"))
								.append("&");
					}
				}
				buffer.deleteCharAt(buffer.length() - 1);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	public static String getUUID(){
		return UUID.randomUUID().toString(); // 边界标识 随机生成
	}
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public static String mapToStringWithFile(Map<String, String> map) {
		StringBuilder sbu = new StringBuilder();
		String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
		if (map != null) {
			// 上传的表单参数部分，格式请参考文章
			Set<Map.Entry<String, String>> me = map.entrySet();
			Iterator<Map.Entry<String, String>> it = me.iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> entry = it.next();
				if (entry.getValue() != null) {
					sbu.append("--");
					sbu.append(BOUNDARY);
					sbu.append("\r\n");
					sbu.append("Content-Disposition: form-data; name=\""
							+ entry.getKey() + "\"\r\n\r\n");
					sbu.append(entry.getValue());
					sbu.append("\r\n");
				}
			}
			sbu.append("--");
			sbu.append(BOUNDARY);
			sbu.append("\r\n");
		}
		return sbu.toString();
	}

	public static String upLoadData(String path, String param) {
		String res = "error";
		OutputStream outputStream = null;
		try {
			URL url = new URL(path);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(20000);
			connection.setReadTimeout(10000);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			byte[] data = param.getBytes();
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length",
					String.valueOf(data.length));
			outputStream = connection.getOutputStream();
			outputStream.write(data);
			if (connection.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						connection.getInputStream(), "utf-8"));
				String s = null;
				StringBuffer sb = new StringBuffer();
				while ((s = br.readLine()) != null) {
					sb.append(s);
				}
				res = sb.toString();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * 上传文件到服务器
	 * 
	 * @param file
	 *            需要上传的文件
	 * @param RequestURL
	 *            请求的url
	 * @return 返回响应的内容
	 */
	public static String uploadDataWithFile(String filePath, String RequestURL,
			String param) {
		String res = "error";
		String imageUrl = "";
		String result = null;
		String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
		String PREFIX = "--", LINE_END = "\r\n";
		String CONTENT_TYPE = "multipart/form-data"; // 内容类型
		try {
			File file = new File(filePath);
			if (!file.exists())
				return "error";
			// if(filePath.length==0)
			// return "1";
			if(param.length()>40){
				BOUNDARY = param.substring(2, 38);
			}
			URL url = new URL(RequestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(30 * 1000);
			conn.setConnectTimeout(30 * 1000);
			conn.setDoInput(true); // 允许输入流
			conn.setDoOutput(true); // 允许输出流
			conn.setUseCaches(false); // 不允许使用缓存
			conn.setRequestMethod("POST"); // 请求方式
			conn.setRequestProperty("Charset", CHARSET); // 设置编码
			// conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary="
					+ BOUNDARY);

			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			if (param != null) {
				dos.write(param.getBytes());
			}

			if (file != null) { // 当文件不为空时执行上传
//				DataOutputStream dos = new DataOutputStream(
//						conn.getOutputStream());
				StringBuffer sb = new StringBuffer();
				sb.append(PREFIX);
				sb.append(BOUNDARY);
				sb.append(LINE_END);
				/**
				 * 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
				 * filename是文件的名字，包含后缀名
				 */

				sb.append("Content-Disposition: form-data; name=\"filepic\"; filename=\""
						+ file.getName() + "\"" + LINE_END);
				sb.append("Content-Type: application/octet-stream; charset="
						+ CHARSET + LINE_END);
				sb.append(LINE_END);
				dos.write(sb.toString().getBytes());
				InputStream is = new FileInputStream(file);
				byte[] bytes = new byte[1024];
				int len = 0;
				while ((len = is.read(bytes)) != -1) {
					dos.write(bytes, 0, len);
				}
				is.close();
				dos.write(LINE_END.getBytes());
				byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END)
						.getBytes();
				dos.write(end_data);
				dos.flush();
				/**
				 * 获取响应码 200=成功 当响应成功，获取响应的流
				 */
				if (conn.getResponseCode() == 200) {
					BufferedReader br = new BufferedReader(new InputStreamReader(
							conn.getInputStream(),"utf-8"));
					String s = null;
					StringBuffer ssb = new StringBuffer();
					while ((s = br.readLine()) != null) {
						sb.append(s);
					}
					res = ssb.toString();
				} else {
					Log.e(TAG, "request error");
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;

	}
}
