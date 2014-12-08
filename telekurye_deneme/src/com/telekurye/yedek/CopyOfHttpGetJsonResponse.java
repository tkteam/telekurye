package com.telekurye.yedek;
//package com.dnm._5_Helpers;
//
//import java.util.HashMap;
//
//public class CopyOfHttpGetJsonResponse {
//
//	public static class LoginResponse {
//
//		public static String getJson() {
//			HashMap<String, String> hm = new HashMap<String, String>();
//			hm.put("f", Info.tagLogin);
//			hm.put("u", Info.USERNAME);
//			hm.put("p", Info.PASSWORD);
//			hm.put("i", Info.IMEI);
//			return HttpRequestForJson.getJsonResponse(Info.LOGIN_SERVICE_URL, hm);
//		}
//
//	}
//
//	public static class OtherResponse {
//
//		public static String getJson(String tag, String JsonData) {
//			HashMap<String, String> hm = new HashMap<String, String>();
//			hm.put("f", tag);
//			hm.put("syncJ", JsonData);
//			return HttpRequestForJson.getJsonResponse(Info.LOGIN_SERVICE_URL, hm);
//		}
//
//	}
//
//	public static class ServerDateResponse {
//
//		public static String getJson() {
//			HashMap<String, String> hm = new HashMap<String, String>();
//			hm.put("f", Info.tagSyncServerDateTime);
//			return HttpRequestForJson.getJsonResponse(Info.LOGIN_SERVICE_URL, hm);
//		}
//
//	}
//
//}
