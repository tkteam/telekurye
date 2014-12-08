package com.dnm._5_Helpers;

import java.lang.reflect.Type;
import java.util.List;

import com.dnm._3_Data_Upload.DistributionMissionFeedBack;
import com.dnm._7_TypeTokenClasses.SyncRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ObjectToJson {

	private final static Gson	gson	= new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

	public static String getJsonDistributionMissionFeedBack() {

		SyncRequest<List<DistributionMissionFeedBack>> sr = new SyncRequest<List<DistributionMissionFeedBack>>();

		// sr'a veriler burada eklenecek

		Type listType = new TypeToken<SyncRequest<List<DistributionMissionFeedBack>>>() {
		}.getType();

		String data = gson.toJson(sr, listType);

		return data;

	}

}
