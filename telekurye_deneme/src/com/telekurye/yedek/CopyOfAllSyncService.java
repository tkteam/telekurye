//package com.telekurye.yedek;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.os.IBinder;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.dnm._5_Helpers.JsonToObject;
//import com.splunk.mint.Mint;
//
//public class CopyOfAllSyncService extends Service {
//
//	@Override
//	public IBinder onBind(Intent intent) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int onStartCommand(Intent intent, int flags, int startId) {
//
//		while (true) {
//			try {
//				JsonToObject jto = new JsonToObject();
//
//				jto.saveLogin();
//
//				// jto.saveVersionControl();
//				// Log.d("123","1/5 : Versiyon Kontrolü Tamamlandý.");
//
//				jto.saveDistributionMission();
//				Log.d("123", "2/5 : Toplu Daðýtým Görevleri Senkronizasyonu Tamamlandý.");
//
//				jto.saveMissions();
//				Log.d("123", "3/5 : Broþür Görevi Senkronizasyonu Tamamlandý.");
//
//				jto.saveMobileMessaging();
//				Log.d("123", "4/5 : Mobil Mesaj Senkronizasyonu Tamamlandý.");
//
//				jto.savePickupMission();
//				Log.d("132", "5/5 : Malzeme Alým Görevi Senkronizasyonu Tamamlandý.");
//
//				// jto.saveBuildingType();
//				// publishProgress("Bina Tipi Senkronizasyonu Tamamlandý.");
//
//				// jto.saveDistributionMissionFeedbackRelation();
//				// publishProgress("Toplu Daðýtým Bilgileri Senkronizasyonu Tamamlandý.");
//
//				// jto.saveEndPointStatus();
//				// publishProgress("End Point Statuleri Senkronizasyonu Tamamlandý.");
//
//				// jto.saveIdentityType();
//				// publishProgress("Kimlik Tipi Senkronizasyonu Tamamlandý.");
//
//				// jto.saveMobileMessagingStatusType();
//				// publishProgress("Mobil Mesaj Statu Tipi Senkronizasyonu Tamamlandý.");
//				//
//				// jto.saveMobileMessagingType();
//				// publishProgress("Mobil Mesaj Tipi Senkronizasyonu Tamamlandý.");
//
//				// jto.savePickUpFeedBackStatus();
//				// publishProgress("Malzeme Alým Senkronizasyonu Tamamlandý.");
//			} catch (Exception e) {
//				e.printStackTrace();
//				Mint.logException(e);
//			}
//			try {
//				// Thread.sleep(120000);
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				Mint.logException(e);
//			}
//		}
//
//		// new Thread(new Runnable() {
//		//
//		// @Override
//		// public void run() {
//		// while (true) {
//		//
//		// try {
//		// Thread.sleep(120000);
//		// asyncTaskSyncBack();
//		// } catch (InterruptedException e) {
//		// e.printStackTrace();
//		// }
//		// }
//		//
//		// }
//		// }).start();
//
//	}
//
//	@Override
//	public void onDestroy() {
//
//		Toast.makeText(this, "Service Stoped", Toast.LENGTH_LONG).show();
//		super.onDestroy();
//	}
//
//	private void asyncTaskSyncBack() {
//		AsyncTask<Void, String, Void> syncBack = new AsyncTask<Void, String, Void>() {
//
//			@Override
//			protected Void doInBackground(Void... params) {
//
//				while (true) {
//					try {
//						JsonToObject jto = new JsonToObject();
//
//						jto.saveLogin();
//
//						// jto.saveVersionControl();
//						// publishProgress("1/5 : Versiyon Kontrolü Tamamlandý.");
//
//						jto.saveDistributionMission();
//						publishProgress("2/5 : Toplu Daðýtým Görevleri Senkronizasyonu Tamamlandý.");
//
//						jto.saveMissions();
//						publishProgress("3/5 : Broþür Görevi Senkronizasyonu Tamamlandý.");
//
//						jto.saveMobileMessaging();
//						publishProgress("4/5 : Mobil Mesaj Senkronizasyonu Tamamlandý.");
//
//						jto.savePickupMission();
//						publishProgress("5/5 : Malzeme Alým Görevi Senkronizasyonu Tamamlandý.");
//
//						// jto.saveBuildingType();
//						// publishProgress("Bina Tipi Senkronizasyonu Tamamlandý.");
//
//						// jto.saveDistributionMissionFeedbackRelation();
//						// publishProgress("Toplu Daðýtým Bilgileri Senkronizasyonu Tamamlandý.");
//
//						// jto.saveEndPointStatus();
//						// publishProgress("End Point Statuleri Senkronizasyonu Tamamlandý.");
//
//						// jto.saveIdentityType();
//						// publishProgress("Kimlik Tipi Senkronizasyonu Tamamlandý.");
//
//						// jto.saveMobileMessagingStatusType();
//						// publishProgress("Mobil Mesaj Statu Tipi Senkronizasyonu Tamamlandý.");
//						//
//						// jto.saveMobileMessagingType();
//						// publishProgress("Mobil Mesaj Tipi Senkronizasyonu Tamamlandý.");
//
//						// jto.savePickUpFeedBackStatus();
//						// publishProgress("Malzeme Alým Senkronizasyonu Tamamlandý.");
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//					try {
//						// Thread.sleep(120000);
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//
//			}
//
//			@Override
//			protected void onProgressUpdate(String... values) {
//
//				super.onProgressUpdate(values);
//				Log.i("SYNC", values[0]);
//
//			}
//
//		};
//		syncBack.execute();
//	}
//
//}
