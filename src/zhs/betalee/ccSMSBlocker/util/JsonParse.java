package zhs.betalee.ccSMSBlocker.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import zhs.betalee.ccSMSBlocker.R;

import android.content.Context;
import android.text.TextUtils;

public class JsonParse {

	public static String jsonToStringBuilder(Context mContext,int RawResource){
		// **********����txt
		InputStream inputStream = mContext.getResources().openRawResource(RawResource);

		InputStreamReader inputStreamReader = null;

		try {
			inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(inputStreamReader);
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// >>>>>>>>>>>>>>>>>>>>>>>>>��ɶ�ȡTXT,����sb
		return sb.toString();
	}

	public static ArrayList<String> stringBuilderToArray(String lrc1,String objectString)
	throws Exception {
if (objectString==null) {
	objectString="NUMBER";
}
		ArrayList<String> mlists = new ArrayList<String>();


		// JSONArray contentArray1=getJSONArray(lrc1);
		JSONArray ja = new JSONArray(lrc1);
		int jalength=ja.length();
//		System.out.println("һ���ж���ĸ���" + jalength);
		for (int j = 0; j < jalength; j++) {

			// JSONObject jsonObject=new JSONObject(lrc1);
			// //���ص�������ʽ��һ��Object���ͣ����Կ���ֱ��ת����һ��Object
			JSONObject jsonObject = (JSONObject) ja.get(j);

//			String type = jsonObject.getString("TYPE");
			String number = jsonObject.getString(objectString);
			if (TextUtils.isEmpty(number))
				continue;
			
//				number.replaceAll("\\?", ".").replaceAll("\\*", ".*");
				mlists.add(number);
			

		}
		return mlists;
	}

	
//	// >>>>>>>>>>>>>>>>>>>>>>>>>����ȡjson
//	/**
//	 * ����Json����
//	 * 
//	 * @param urlPath
//	 * @return mlists
//	 * @throws Exception
//	 */
//	public static List<Person> getListPerson(String urlPath) throws Exception {
//		List<Person> mlists = new ArrayList<Person>();
//		byte[] data = readParse(urlPath);
//		JSONArray array = new JSONArray(new String(data));
//		for (int i = 0; i < array.length(); i++) {
//			JSONObject item = array.getJSONObject(i);
//			String name = item.getString("name");
//			String address = item.getString("address");
//			int age = item.getInt("age");
//			mlists.add(new Person(name, address, age));
//		}
//		return mlists;
//	}
//
//	/**
//	 * ��ָ����url�л�ȡ�ֽ�����
//	 * 
//	 * @param urlPath
//	 * @return �ֽ�����
//	 * @throws Exception
//	 */
//	public static byte[] readParse(String urlPath) throws Exception {
//		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//		byte[] data = new byte[1024];
//		int len = 0;
//		URL url = new URL(urlPath);
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		InputStream inStream = conn.getInputStream();
//
//		while ((len = inStream.read(data)) != -1) {
//			outStream.write(data, 0, len);
//
//		}
//		inStream.close();
//		return outStream.toByteArray();
//
//	}
}
