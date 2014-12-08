package com.dnm._99_NotWorking;
//package com.test._99_NotWorking;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.mime.HttpMultipartMode;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.util.EntityUtils;
//
//public class MultipartPost {
//
//
//	public static void result3(CloseableHttpClient httpclient) throws IllegalStateException, IOException {
//
//		try {
//
//			// hm.put("u", "0100016");
//			// hm.put("p", "498623");
//			// hm.put("i", "352728054859749");
//
//			HttpPost httppost = new HttpPost("http://95.0.160.172/Services/AndroidTestServices/PhotoSync.aspx");
//
//			httppost.setHeader("Connection", "Keep-Alive");
//			httppost.setHeader("Username", "0100016");
//			httppost.setHeader("Password", "498623");
//			httppost.setHeader("UploadDate", "09-09-2014");
//
//			FileBody bin = new FileBody(new File("C:/logo.png"));
//
//			MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();
//			multipartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//			multipartEntity.addPart("uploadedfile", bin);
//			httppost.setEntity(multipartEntity.build());
//
//			CloseableHttpResponse response = httpclient.execute(httppost);
//			try {
//				System.out.println(response.getStatusLine());
//				HttpEntity resEntity = response.getEntity();
//				if (resEntity != null) {
//					System.out.println("Response content : " + EntityUtils.toString(resEntity));
//				}
//				resEntity.consumeContent();
//				System.out.println("----------------------------------------\n");
//
//			} finally {
//				response.close();
//			}
//		} finally {
//			// httpclient.close();
//		}
//
//	}
//
//}