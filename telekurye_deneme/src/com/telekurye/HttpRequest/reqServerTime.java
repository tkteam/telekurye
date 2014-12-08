package com.telekurye.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import com.telekurye.utils.Info;

public class reqServerTime {

	private String	Json;

	public reqServerTime() {

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(Info.SYNC_SERVICE_URL);

		try {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("f", "syncdistributionsmissions"));
			nameValuePairs.add(new BasicNameValuePair("syncJ", ""));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = httpclient.execute(httppost, getCookie());
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();

			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			Json = result.toString();

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// public void saveServerTime() {
	// Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
	// LiveData.differentTime = gson.fromJson(getJson(), SyncResult.class).getTargetObject().toString();
	//
	// }

	private HttpContext getCookie() {

		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(Info.LOGIN_SERVICE_URL);
		String json = null;
		HttpContext localContext = null;
		try {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("f", Info.tagLogin));
			nameValuePairs.add(new BasicNameValuePair("u", Info.USERNAME));
			nameValuePairs.add(new BasicNameValuePair("p", Info.PASSWORD));
			nameValuePairs.add(new BasicNameValuePair("i", Info.IMEI));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = httpclient.execute(httppost);

			HttpEntity entity = response.getEntity();

			if (entity != null) {
				entity.consumeContent();
			}

			CookieStore cookieStore = httpclient.getCookieStore();
			localContext = new BasicHttpContext();
			localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return localContext;
	}

	public String getJson() {
		return Json;
	}

}
