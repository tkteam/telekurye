package com.telekurye.utils;

public class Info {

	public static int			SYNCPERIOD										= 1000 * 60 * 2;

	public final static int		CURRENT_VERSION									= 86;

	public final static int		SCALED_PHOTO_PERCENT							= 70;

	public static int			GPS_CONTROL_PERIOD								= 1000 * 3;																			// "SYNCPERIOD" deðerine tam
																																										// bölünmelidir
	public static int			GPS_ACCURACY									= 100;																					// metre cinsinden doðruluk
																																										// deðeri
	public static int			GPS_CONTROL_COUNT								= SYNCPERIOD / GPS_CONTROL_PERIOD;
	public static int			GPS_MIN_DISTANCE								= 10;																					// gps bilgilerinin yenilenmesi
																																										// için gereken min
																																										// yerdeðiþtirme miktarý

	public static String		USERNAME										= "";
	public static String		PASSWORD										= "";
	public static String		IMEI											= "352728054859749";
	// public static String IMEI = "";
	// public static String SYNCDATERANGE = "{\"EndSyncDate\":\"2034-08-25T10:13:09\",\"LastSyncDate\":\"1986-08-22T00:30:00\"}";

	public static final String	PHOTO_STORAGE_PATH								= "/storage/sdcard0/telekurye/";

	
	
	
//	public static String		LOGIN_SERVICE_URL								= "http://rl.telekurye.com.tr/androidservices/Default.aspx";
//	public static String		SYNC_SERVICE_URL								= "http://rl.telekurye.com.tr/androidservices/Default.aspx";
//	public static String		PHOTO_SYNC_URL									= "http://rl.telekurye.com.tr/androidservices/PhotoSync.aspx";
//	public static String		ERROR_LOG_URL									= "http://rl.telekurye.com.tr/androidservices/ExceptionLog.aspx";
//	public static String		DATABASE_UPLOAD_URL								= "http://rl.telekurye.com.tr/androidservices/CourierDatabaseUpload.aspx";

	public static String		LOGIN_SERVICE_URL								= "http://androidservices.telekurye.com.tr/androidservices/Default.aspx";
	public static String		SYNC_SERVICE_URL								= "http://androidservices.telekurye.com.tr/androidservices/Default.aspx";
	public static String		PHOTO_SYNC_URL									= "http://androidservices.telekurye.com.tr/androidservices/PhotoSync.aspx";
	public static String		ERROR_LOG_URL									= "http://androidservices.telekurye.com.tr/androidservices/ExceptionLog.aspx";
	public static String		DATABASE_UPLOAD_URL								= "http://androidservices.telekurye.com.tr/androidservices/CourierDatabaseUpload.aspx";

	
	
	
	
	
	
	
	// public static String LOGIN_SERVICE_URL = "http://192.168.11.123/fieldcontrol2/Default.aspx";
	// public static String SYNC_SERVICE_URL = "http://192.168.11.123/fieldcontrol2/Default.aspx";
	// public static String PHOTO_SYNC_URL = "http://192.168.11.123/fieldcontrol2/PhotoSync.aspx";
	// public static String ERROR_LOG_URL = "http://192.168.11.123/fieldcontrol2/ExceptionLog.aspx";
	// public static String DATABASE_UPLOAD_URL = "http://192.168.11.123/fieldcontrol2/CourierDatabaseUpload.aspx";

	// public static String LOGIN_SERVICE_URL = "http://95.0.160.172/Services/AndroidTestServices/Default.aspx";
	// public static String SYNC_SERVICE_URL = "http://95.0.160.172/Services/AndroidTestServices/Default.aspx";
	// public static String PHOTO_SYNC_URL = "http://95.0.160.172/Services/AndroidTestServices/PhotoSync.aspx";
	// public static String ERROR_LOG_URL = "http://95.0.160.172/Services/AndroidTestServices/ExceptionLog.aspx";
	// public static String DATABASE_UPLOAD_URL = "http://95.0.160.172/Services/AndroidTestServices/CourierDatabaseUpload.aspx";

	// ***************** HTTP REQUEST TAGS ***********************************

	public static String		tagLogin										= "login";																				// giriþ
	public static String		tagSyncServerDateTime							= "GSDT";																				// Tarih Senkronizasyonu

	// --- STATUS SENKRONÝZASYONLARI (Download)

	public static String		tagSyncEndpointStatus							= "syncendpointstatus";																// End Point Statüleri
	public static String		tagSyncPickUpMissionStatus						= "syncpickupfeedbackstatus";															// Malzeme alým
	public static String		tagSyncDistrubutionRelations					= "syncdistributionmissionfeedbackrelation";											// Toplu Daðýtým bilgileri
	public static String		tagSyncBuildingTypes							= "syncbuildingtypes";																	// Bina tipi
	public static String		tagSyncIdentityType								= "syncidentitytype";																	// Kimlik tipi
	public static String		tagSyncMobileMessagingStatusType				= "mobilemessagingstatustype";															// Mobil Mesaj Statü Tipi
	public static String		tagSyncMobileMessagingType						= "mobilemessagingtype";																// mobil mesaj tipi
																																										// senkronizasyonu

	// --- GÖREV SENKRONÝZASYONLARI (Download)

	public static String		tagSyncMissions									= "syncmissions";																		// Broþür Görevi
	public static String		tagSyncPickupMission							= "syncpickupmissions";																// Malzeme Alým Görevi
	public static String		tagSyncDistributionMissions						= "syncdistributionsmissions";															// Toplu Daðýtým Görevleri
	public static String		tagSyncMobileMessaging							= "mobilemessaging";																	// Mobil Mesaj senkronizasyonu

	// --- FEEDBACK SENKRONÝZASYONLARI (Upload)

	public static String		tagSyncLocations								= "synclocations";																		// Lokasyon
	public static String		tagSyncFeedBackData								= "syncfeedbacks";																		// Broþür geribildirim
	public static String		tagSyncPickupOrderFeedBack						= "syncpickupfeedbacks";																// (503) Malzeme Alýmý
																																										// Geribildirimi
	public static String		tagSyncDistributionMissionsFeedbacks			= "syncdistributionmissionfeedbacks";													// Daðýtým Görevleri
																																										// Geribildirimi
	public static String		tagSyncMobileMessagingStatusChangelog			= "mobilemessagingstatuschangelog";													// Mobil Mesaj Changelog

	// --- Diðer

	public static String		tagSyncDistributionMissionsFeedbacksAllUsers	= "syncdistributionmissionfeedbacks";													// (Upload)
	public static String		tagSyncBatchMissions							= "batchmissionassign";																// *** (503) Toplu Zimmetleme
	public static String		tagVersionControl								= "checkforupdate";																	// *** (503)
	public static String		tagPrinterVersionControl						= "checkforprinterupdate";																// *** (503)
	public static String		tagDummySync									= "syncdummydata";																		// (Upload)

	// ***********************************************************************
}
