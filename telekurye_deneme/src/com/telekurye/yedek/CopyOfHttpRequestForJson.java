package com.telekurye.yedek;
//package com.dnm._5_Helpers;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.CookieStore;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.protocol.ClientContext;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.protocol.BasicHttpContext;
//import org.apache.http.protocol.HTTP;
//import org.apache.http.protocol.HttpContext;
//
//import com.splunk.mint.Mint;
//
//public class CopyOfHttpRequestForJson {
//
//	public static String getJsonResponse(String url, HashMap<String, String> hashmap) {
//
//		String result2 = null;
//
//		try {
//
//			DefaultHttpClient httpclient = new DefaultHttpClient();
//			HttpGet httpget = new HttpGet(Info.LOGIN_SERVICE_URL + "?f=login&u=" + Info.USERNAME + "&p=" + Info.PASSWORD + "&i=" + Info.IMEI);
//			HttpResponse response1 = httpclient.execute(httpget);
//			HttpEntity entity = response1.getEntity();
//
//			if (entity != null) {
//				entity.consumeContent();
//			}
//
//			CookieStore cookieStore = httpclient.getCookieStore();
//			HttpContext localContext = new BasicHttpContext();
//			localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
//			// HttpClient client = HttpClientBuilder.create().build();
//			HttpClient client = new DefaultHttpClient();
//			HttpPost post = new HttpPost(url);
//
//			// post.setHeader("User-Agent", USER_AGENT);
//
//			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//
//			Iterator<String> keySetIterator = hashmap.keySet().iterator();
//			while (keySetIterator.hasNext()) {
//
//				String key = keySetIterator.next();
//				urlParameters.add(new BasicNameValuePair(key, hashmap.get(key)));
//
//			}
//
//			post.setEntity(new UrlEncodedFormEntity(urlParameters));
//			HttpResponse response = client.execute(post, localContext);
//			// System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
//			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//			StringBuffer result = new StringBuffer();
//			String line = "";
//			while ((line = rd.readLine()) != null) {
//				result.append(line);
//			}
//			result2 = result.toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//			Mint.logException(e);
//		}
//
//		return result2;
//	}
//
//}
//
////
//// CloseableHttpClient httpclient = HttpClients.createDefault();
////
//// try {
////
//// HttpPost httppost = new HttpPost(url);
////
//// MultipartEntityBuilder mpeb = MultipartEntityBuilder.create();
////
//// mpeb.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//// mpeb.addPart("f", new StringBody("login", ContentType.TEXT_PLAIN));
//// mpeb.addPart("u", new StringBody(Info.USERNAME, ContentType.TEXT_PLAIN));
//// mpeb.addPart("p", new StringBody(Info.PASSWORD, ContentType.TEXT_PLAIN));
//// mpeb.addPart("i", new StringBody(Info.IMEI, ContentType.TEXT_PLAIN));
////
//// httppost.setEntity(mpeb.build());
////
//// httpclient.execute(httppost);
////
//// MultipartEntityBuilder mpeb2 = MultipartEntityBuilder.create();
//// mpeb2.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
////
//// Iterator<String> keySetIterator = hashmap.keySet().iterator();
////
//// while (keySetIterator.hasNext()) {
////
//// String key = keySetIterator.next();
//// mpeb2.addPart(key, new StringBody(hashmap.get(key), ContentType.TEXT_PLAIN));
//// }
////
//// httppost.setEntity(mpeb2.build());
//// CloseableHttpResponse response = httpclient.execute(httppost);
////
//// try {
////
//// statusCode = response.getStatusLine().getStatusCode();
////
//// HttpEntity resEntity = response.getEntity();
//// if (resEntity != null) {
//// Json = EntityUtils.toString(resEntity);
//// }
////
//// resEntity.consumeContent();
//// } finally {
//// response.close();
//// }
//// } catch (IOException e) {
//// // TODO Auto-generated catch block
//// e.printStackTrace();
//// } finally {
//// try {
//// httpclient.close();
//// } catch (IOException e) {
//// // TODO Auto-generated catch block
//// e.printStackTrace();
//// }
//// }