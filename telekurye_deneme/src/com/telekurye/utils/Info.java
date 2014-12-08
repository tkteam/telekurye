package com.telekurye.utils;

public class Info {

	public static int			SYNCPERIOD										= 1000 * 60 * 2;

	public final static int		CURRENT_VERSION									= 86;

	public final static int		SCALED_PHOTO_PERCENT							= 70;

	public static int			GPS_CONTROL_PERIOD								= 1000 * 3;																			// "SYNCPERIOD" de�erine tam
																																										// b�l�nmelidir
	public static int			GPS_ACCURACY									= 100;																					// metre cinsinden do�ruluk
																																										// de�eri
	public static int			GPS_CONTROL_COUNT								= SYNCPERIOD / GPS_CONTROL_PERIOD;
	public static int			GPS_MIN_DISTANCE								= 10;																					// gps bilgilerinin yenilenmesi
																																										// i�in gereken min
																																										// yerde�i�tirme miktar�

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

	public static String		tagLogin										= "login";																				// giri�
	public static String		tagSyncServerDateTime							= "GSDT";																				// Tarih Senkronizasyonu

	// --- STATUS SENKRON�ZASYONLARI (Download)

	public static String		tagSyncEndpointStatus							= "syncendpointstatus";																// End Point Stat�leri
	public static String		tagSyncPickUpMissionStatus						= "syncpickupfeedbackstatus";															// Malzeme al�m
	public static String		tagSyncDistrubutionRelations					= "syncdistributionmissionfeedbackrelation";											// Toplu Da��t�m bilgileri
	public static String		tagSyncBuildingTypes							= "syncbuildingtypes";																	// Bina tipi
	public static String		tagSyncIdentityType								= "syncidentitytype";																	// Kimlik tipi
	public static String		tagSyncMobileMessagingStatusType				= "mobilemessagingstatustype";															// Mobil Mesaj Stat� Tipi
	public static String		tagSyncMobileMessagingType						= "mobilemessagingtype";																// mobil mesaj tipi
																																										// senkronizasyonu

	// --- G�REV SENKRON�ZASYONLARI (Download)

	public static String		tagSyncMissions									= "syncmissions";																		// Bro��r G�revi
	public static String		tagSyncPickupMission							= "syncpickupmissions";																// Malzeme Al�m G�revi
	public static String		tagSyncDistributionMissions						= "syncdistributionsmissions";															// Toplu Da��t�m G�revleri
	public static String		tagSyncMobileMessaging							= "mobilemessaging";																	// Mobil Mesaj senkronizasyonu

	// --- FEEDBACK SENKRON�ZASYONLARI (Upload)

	public static String		tagSyncLocations								= "synclocations";																		// Lokasyon
	public static String		tagSyncFeedBackData								= "syncfeedbacks";																		// Bro��r geribildirim
	public static String		tagSyncPickupOrderFeedBack						= "syncpickupfeedbacks";																// (503) Malzeme Al�m�
																																										// Geribildirimi
	public static String		tagSyncDistributionMissionsFeedbacks			= "syncdistributionmissionfeedbacks";													// Da��t�m G�revleri
																																										// Geribildirimi
	public static String		tagSyncMobileMessagingStatusChangelog			= "mobilemessagingstatuschangelog";													// Mobil Mesaj Changelog

	// --- Di�er

	public static String		tagSyncDistributionMissionsFeedbacksAllUsers	= "syncdistributionmissionfeedbacks";													// (Upload)
	public static String		tagSyncBatchMissions							= "batchmissionassign";																// *** (503) Toplu Zimmetleme
	public static String		tagVersionControl								= "checkforupdate";																	// *** (503)
	public static String		tagPrinterVersionControl						= "checkforprinterupdate";																// *** (503)
	public static String		tagDummySync									= "syncdummydata";																		// (Upload)

	// ***********************************************************************
}
