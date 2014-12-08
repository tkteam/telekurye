package com.telekurye.yedek;
//package com.dnm._5_Helpers;
//
//import java.lang.reflect.Type;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Date;
//
//import com.dnm._2_Data_Download.DistributionMission;
//import com.dnm._2_Data_Download.MobileMessaging;
//import com.dnm._2_Data_Download.PickupMission;
//import com.dnm._4_Data_Other.Person;
//import com.dnm._4_Data_Other.User;
//import com.dnm._4_Data_Other.VersionUpdate;
//import com.dnm._7_TypeTokenClasses.SyncRequest;
//import com.dnm._7_TypeTokenClasses.SyncResult;
//import com.dnm._8_Tools.Tools;
//import com.dnm._96_Data_kullanilmayanlar.Missions;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
//import com.splunk.mint.Mint;
//import com.telekurye.utils.LiveData;
//
//public class CopyOfJsonToObject {
//
//	final static Gson	gson	= new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
//
//	public SyncRequest getSyncRequestObject() {
//
//		SyncRequest sr = new SyncRequest();
//
//		try {
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//			Date startDate = df.parse("1986-08-22T00:30:00");
//			sr.setLastSyncDate(startDate);
//			sr.setEndSyncDate(Tools.getDateNow());
//		} catch (ParseException e) {
//			e.printStackTrace();
//			Mint.logException(e);
//		}
//
//		return sr;
//	}
//
//	public String getJsonForRequest() {
//		return gson.toJson(getSyncRequestObject(), SyncRequest.class);
//	}
//
//	public String getJsonForVersionControl() {
//
//		VersionUpdate vu = new VersionUpdate();
//
//		vu.setNeedsUrgentUpdate(false);
//		vu.setId(LiveData.Login.getTargetObject().getId());
//		vu.setCurrentVersion(Info.CURRENT_VERSION);
//		vu.setUserId_Create(LiveData.Login.getTargetObject().getUserId_Create());
//		vu.setUserId_Modify(LiveData.Login.getTargetObject().getUserId_Modify());
//
//		Type listType = new TypeToken<SyncRequest<VersionUpdate>>() {
//		}.getType();
//
//		SyncRequest<VersionUpdate> sr = new SyncRequest<VersionUpdate>();
//		sr.setLastSyncDate(getSyncRequestObject().getLastSyncDate());
//		// sr.setEndSyncDate(getSyncRequestObject().getEndSyncDate());
//		sr.setTypedObjects(vu);
//
//		String asd = gson.toJson(sr, listType);
//		return asd;
//	}
//
//	public void saveLogin() {
//
//		String json = HttpGetJsonResponse.LoginResponse.getJson();
//		Type listType = new TypeToken<SyncResult<User<Person>>>() {
//		}.getType();
//		LiveData.Login = gson.fromJson(json, listType);
//
//	}
//
//	public void saveDistributionMission() {
//
//		String json = HttpGetJsonResponse.OtherResponse.getJson(Info.tagSyncDistributionMissions, getJsonForRequest());
//		// String json = LiveData.json;
//		Type listType = new TypeToken<SyncResult<ArrayList<DistributionMission>>>() {
//		}.getType();
//
//		SyncResult<ArrayList<DistributionMission>> asd = gson.fromJson(json, listType);
//
//		Collections.sort(asd.getTargetObject(), new DistributionMission());
//
//		// Collections.sort(asd.getTargetObject(), new Comparator<DistributionMission>() {
//		// @Override
//		// public int compare(DistributionMission lhs, DistributionMission rhs) {
//		// return lhs.getUniqueCode() - rhs.getUniqueCode();
//		// }
//		// });
//
//		LiveData.DistributionMission = asd;
//
//	}
//
//	public void saveMissions() {
//
//		String json = HttpGetJsonResponse.OtherResponse.getJson(Info.tagSyncMissions, getJsonForRequest());
//		Type listType = new TypeToken<SyncResult<ArrayList<Missions>>>() {
//		}.getType();
//		LiveData.Missions = gson.fromJson(json, listType);
//
//	}
//
//	public void saveMobileMessaging() {
//
//		String json = HttpGetJsonResponse.OtherResponse.getJson(Info.tagSyncMobileMessaging, getJsonForRequest());
//		Type listType = new TypeToken<SyncResult<ArrayList<MobileMessaging>>>() {
//		}.getType();
//		LiveData.MobileMessaging = gson.fromJson(json, listType);
//
//	}
//
//	public void savePickupMission() {
//
//		String json = HttpGetJsonResponse.OtherResponse.getJson(Info.tagSyncPickupMission, getJsonForRequest());
//		Type listType = new TypeToken<SyncResult<ArrayList<PickupMission>>>() {
//		}.getType();
//		LiveData.PickupMission = gson.fromJson(json, listType);
//
//	}
//
////	public void savePickupMission2() {
////
////		String json = HttpGetJsonResponse.ServerDateResponse.getJson();
////		LiveData.differentTime = gson.fromJson(json, SyncResult.class).getTargetObject().toString();
////
////	}
//
//	public void saveVersionControl() {
//
//		String SampleJson2 = "{\"LastSyncDate\":\"1986-08-22T00:30:00\",\"TypedObjects\":" + "{\"NeedsUrgentUpdate\":false,\"Id\":0,\"CurrentVersion\":86,\"UserId_Create\":0,\"UserId_Modify\":0}}";
//		String json = HttpGetJsonResponse.OtherResponse.getJson(Info.tagVersionControl, SampleJson2);
////		String json = HttpGetJsonResponse.OtherResponse.getJson(Info.tagVersionControl, getJsonForVersionControl());
//		Type listType = new TypeToken<SyncResult<VersionUpdate>>() {
//		}.getType();
//		LiveData.VersionControl = gson.fromJson(json, listType);
//
//	}
//
//}
