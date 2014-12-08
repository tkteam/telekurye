package com.telekurye.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.dnm._4_Data_Other.Person;
import com.dnm._4_Data_Other.User;
import com.dnm._7_TypeTokenClasses.SyncResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.telekurye.utils.Info;
import com.telekurye.utils.LiveData;

public class reqLogin {

	private String	Json;

	public reqLogin() {

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(Info.LOGIN_SERVICE_URL);
		try {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("f", Info.tagLogin));
			nameValuePairs.add(new BasicNameValuePair("u", Info.USERNAME));
			nameValuePairs.add(new BasicNameValuePair("p", Info.PASSWORD));
			nameValuePairs.add(new BasicNameValuePair("i", Info.IMEI));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = httpclient.execute(httppost);
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

	public void saveLogin() {

		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		Type listType = new TypeToken<SyncResult<User<Person>>>() {
		}.getType();
		LiveData.Login = gson.fromJson(getJson(), listType);

	}

	public String getJson() {
		return Json;
	}


}
