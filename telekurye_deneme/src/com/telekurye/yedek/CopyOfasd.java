package com.telekurye.yedek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import com.splunk.mint.Mint;
import com.telekurye.utils.Info;

public class CopyOfasd {

	public CookieStore login() {

		CloseableHttpResponse response2 = null;
		CookieStore cookieStore = null;

		try {

			cookieStore = new BasicCookieStore();
			CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

			HttpUriRequest login = RequestBuilder.post().setUri(new URI(Info.LOGIN_SERVICE_URL)).addParameter("f", "login").addParameter("u", Info.USERNAME).addParameter("p", Info.PASSWORD)
					.addParameter("i", Info.IMEI).build();

			response2 = httpclient.execute(login);
			HttpEntity entity = response2.getEntity();
			// EntityUtils.consume(entity);

		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		} finally {
			try {
				response2.close();
			} catch (IOException e) {
				e.printStackTrace();
				Mint.logException(e);
			}
		}

		return cookieStore;

	}

	public String getMission(CookieStore cookieStore) {

		String json = null;

		try {

			HttpContext localContext = new BasicHttpContext();

			localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

			String url2 = Info.LOGIN_SERVICE_URL;

			HttpClient client2 = HttpClientBuilder.create().build();
			HttpPost post2 = new HttpPost(url2);

			List<NameValuePair> urlParameters2 = new ArrayList<NameValuePair>();

			urlParameters2.add(new BasicNameValuePair("f", "syncdistributionsmissions"));
			urlParameters2.add(new BasicNameValuePair("syncJ", ""));

			post2.setEntity(new UrlEncodedFormEntity(urlParameters2));

			HttpResponse response2 = client2.execute(post2, localContext);
			System.out.println("Response Code : " + response2.getStatusLine().getStatusCode());

			BufferedReader rd2 = new BufferedReader(new InputStreamReader(response2.getEntity().getContent()));

			StringBuffer result2 = new StringBuffer();
			String line2 = "";
			while ((line2 = rd2.readLine()) != null) {
				result2.append(line2);
			}
			System.out.println(result2);
			json = result2.toString();
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}
		return json;

	}

}
