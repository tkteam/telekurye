package com.telekurye.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.dnm._4_Data_Other.VersionUpdate;
import com.dnm._7_TypeTokenClasses.SyncRequest;
import com.dnm._7_TypeTokenClasses.SyncResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.splunk.mint.Mint;
import com.telekurye.utils.Info;
import com.telekurye.utils.LiveData;

public class reqVersionControl {

	private String	Json;

	public reqVersionControl() {

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(Info.SYNC_SERVICE_URL);

		try {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("f", Info.tagVersionControl));
			nameValuePairs.add(new BasicNameValuePair("syncJ", getJsonForRequest()));
			// nameValuePairs.add(new BasicNameValuePair("syncJ",
			// "{\"LastSyncDate\":\"1986-08-22T00:30:00\",\"TypedObjects\":{\"NeedsUrgentUpdate\":false,\"Id\":0,\"CurrentVersion\":77,\"UserId_Create\":0,\"UserId_Modify\":0}}"));

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

	public void saveVersionControl() {

		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
			Type listType = new TypeToken<SyncResult<VersionUpdate>>() {
			}.getType();
			LiveData.VersionControl = gson.fromJson(getJson(), listType);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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

			// System.out.println(cookieStore.getCookies().get(0).getValue());

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return localContext;
	}

	private String getJsonForRequest() {

		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		SyncRequest<VersionUpdate> sr = new SyncRequest<VersionUpdate>();
		Type listType = new TypeToken<SyncRequest<VersionUpdate>>() {
		}.getType();
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date startDate = df.parse("1986-08-22T00:30:00");
			sr.setLastSyncDate(startDate);
			// sr.setEndSyncDate(Tools.getDateNow());

			VersionUpdate vu = new VersionUpdate();

			vu.setNeedsUrgentUpdate(false);
			vu.setId(LiveData.Login.getTargetObject().getId());
			vu.setCurrentVersion(Info.CURRENT_VERSION);
			vu.setUserId_Create(LiveData.Login.getTargetObject().getUserId_Create());
			vu.setUserId_Modify(LiveData.Login.getTargetObject().getUserId_Modify());

			sr.setTypedObjects(vu);

		} catch (ParseException e) {
			e.printStackTrace();
			Mint.logException(e);
		}

		return gson.toJson(sr, listType);
	}

	public String getJson() {
		return Json;
	}

}
