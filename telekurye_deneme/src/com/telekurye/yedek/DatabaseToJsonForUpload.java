//package com.telekurye.yedek;
//
//import java.lang.reflect.Type;
//import java.util.List;
//
//import com.dnm._3_Data_Upload.DistributionMissionFeedBack;
//import com.dnm._5_Helpers.JSONHelper;
//import com.dnm._7_TypeTokenClasses.SyncRequest;
//import com.example.telekurye_deneme.sendFeedback;
//import com.google.gson.reflect.TypeToken;
//
//public class DatabaseToJsonForUpload {
//
//	public String jsonDistributionMissionFeedBack() {
//
//		Type listType = new TypeToken<SyncRequest<List<DistributionMissionFeedBack>>>() {
//		}.getType();
//
//		String jsn = JSONHelper.ToJson(DistributionMissionFeedBack.GetFirstDataForSync(), listType);
//		// System.out.println("-----> " + jsn);
//		return jsn;
//	}
//
//	public void DataUpload() {
//
//		sendFeedback sf = new sendFeedback();
//
//		sf.getMission(jsonDistributionMissionFeedBack());
//
//		// SendJsonData sjd = new SendJsonData("syncdistributionmissionfeedbacks", jsonDistributionMissionFeedBack());
//		//
//		// return sjd.getJson();
//	}
//
//}
//
//// public void insertData() {
////
//// DistributionMissionFeedBack dmf = new DistributionMissionFeedBack();
////
//// dmf.setId(6440585);
//// dmf.setEndPointStatusId(1);
//// dmf.setUserDailyDistributionId(7699031);
//// dmf.setLatitude(39.94375229);
//// dmf.setLongitude(32.85031891);
//// dmf.setAccuracy(4);
//// dmf.setRelationId(123);
//// dmf.setRelationName(null);
//// dmf.setRelationPhone(null);
//// dmf.setRelationSurname(null);
//// dmf.setIdentityTypeId(321);
//// dmf.setIdentityNo("25");
//// dmf.setIsComplete(true);
//// dmf.setModifiedLatitude(39.94375229);
//// dmf.setModifiedLongitude(32.85031891);
//// dmf.setModifiedAccuracy(4.0);
//// dmf.setCourierSelectedLatitude(null);
//// dmf.setCourierSelectedLongitude(null);
////
//// dmf.Insert();
////
//// }