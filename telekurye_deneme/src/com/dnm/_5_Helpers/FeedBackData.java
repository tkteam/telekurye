package com.dnm._5_Helpers;

import java.lang.reflect.Type;
import java.util.List;

import com.dnm._3_Data_Upload.DistributionMissionFeedBack;
import com.dnm._7_TypeTokenClasses.SyncRequest;
import com.google.gson.reflect.TypeToken;
import com.telekurye.utils.LiveData;

public class FeedBackData {

	public void SendDistributionMissionFeedBack() {

		Type listType = new TypeToken<SyncRequest<List<DistributionMissionFeedBack>>>() {
		}.getType();

		String jsn = JSONHelper.ToJson(LiveData.DistributionMissionFeedBack, listType);
		System.out.println(jsn);

		sendFeedback sf = new sendFeedback(jsn);

	}

}
