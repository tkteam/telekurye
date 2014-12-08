package com.dnm._5_Helpers;

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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import com.splunk.mint.Mint;
import com.telekurye.utils.Info;

public class sendFeedback {

	public sendFeedback(final String JsonString) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				getMission(JsonString);
			}
		}).start();
	}

	public String getMission(String JsonString) {

		String json = null;

		try {
			CookieStore cookieStore = Login();
			HttpContext localContext = new BasicHttpContext();
			localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
			HttpClient client = new DefaultHttpClient();
			String postURL = Info.LOGIN_SERVICE_URL;
			HttpPost post = new HttpPost(postURL);

			List<NameValuePair> params = new ArrayList<NameValuePair>();

			params.add(new BasicNameValuePair("f", "syncdistributionmissionfeedbacks"));
			params.add(new BasicNameValuePair("syncJ", JsonString));

			UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
			post.setEntity(ent);
			HttpResponse responsePOST = client.execute(post, localContext);

			System.out.println("Response Code : " + responsePOST.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(responsePOST.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result.toString());
			json = result.toString();
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}
		return json;

	}

	public CookieStore Login() {

		DefaultHttpClient httpclient = new DefaultHttpClient();

		HttpGet httpget = new HttpGet(Info.LOGIN_SERVICE_URL + "?f=login&u=" + Info.USERNAME + "&p=" + Info.PASSWORD + "&i=" + Info.IMEI);

		HttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
		} catch (ClientProtocolException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		HttpEntity entity = response.getEntity();

		if (entity != null) {
			try {
				entity.consumeContent();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return httpclient.getCookieStore();
	}

}
