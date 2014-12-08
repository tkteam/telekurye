package com.telekurye.ui2;

import java.io.File;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.dnm._3_Data_Upload.DistributionMissionFeedBack;
import com.dnm._3_Data_Upload.DistributionMissionFeedBackPhoto;
import com.dnm._5_Helpers.JSONHelper;
import com.dnm._5_Helpers.sendFeedback;
import com.dnm._5_Helpers.sendFeedbackImage;
import com.dnm._7_TypeTokenClasses.SyncRequest;
import com.google.gson.reflect.TypeToken;
import com.splunk.mint.Mint;
import com.telekurye.HttpRequest.reqDistributionMission;
import com.telekurye.HttpRequest.reqLogin;
import com.telekurye.HttpRequest.reqMissions;
import com.telekurye.HttpRequest.reqMobileMessaging;
import com.telekurye.HttpRequest.reqPickupMission;
import com.telekurye.HttpRequest.reqVersionControl;
import com.telekurye.utils.Info;
import com.telekurye.utils.LiveData;
import com.telekurye.utils.Tools;

public class Login extends MasterActivity implements OnClickListener {

	EditText				user_name;
	EditText				user_password;
	Button					login_button;
	CheckBox				check_remember_me;
	CheckBox				check_test_server;
	ProgressDialog			progressDialog;

	public static Context	AppContext	= null;
	public static int		errorStatus	= 0;	// giriþ yapýlýrken internet kesilirse uygulama patlamamasý için

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		// StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		setContentView(R.layout._1_login);

		Mint.initAndStartSession(Login.this, "2aaf93c4");
		Mint.enableDebug();

		user_name = (EditText) findViewById(R.id.user_name);
		user_password = (EditText) findViewById(R.id.user_password);
		login_button = (Button) findViewById(R.id.login_button);
		check_remember_me = (CheckBox) findViewById(R.id.check_remember_me);
		check_test_server = (CheckBox) findViewById(R.id.check_test_server);

		AppContext = this.getApplicationContext();

		// Tools.showCustomToast(Login.this, "" + Tools.getBatteryLevel(this));
		// Info.IMEI = Tools.getPhoneImei(Login.this);

		login_button.setOnClickListener(this);

		user_name.setText("01015");
		user_password.setText("600892");

	}

	@Override
	public void onClick(View v) {

		// Mint.logEvent("Button1 " + Tools.getDateNow().toLocaleString(), MintLogLevel.Error);
		// Mint.transactionStart("Test1");
		// try {
		// throw new Exception("sefa gurel");
		// } catch (Exception e) {
		// Mint.logExceptionMessage("level", " asdgf sag", e);
		// // Mint.logException(e);
		// }
		// Mint.logException(new Exception("test 123"));

		if (v.getId() == R.id.login_button) {
			try {

				Info.USERNAME = user_name.getText().toString();
				Info.PASSWORD = user_password.getText().toString();

				if (Tools.isConnectingToInternet(Login.this)) {

					new Thread(new Runnable() {

						@Override
						public void run() {
							reqLogin r1 = new reqLogin();
							r1.saveLogin();
							// System.out.println(r1.getJson());

							reqVersionControl r7 = new reqVersionControl();
							System.out.println(r7.getJson());

							// reqDistributionMission r2 = new reqDistributionMission();
							// System.out.println(r2.getJson());
							//
							// reqMissions r3 = new reqMissions();
							// System.out.println(r3.getJson());
							//
							// reqMobileMessaging r4 = new reqMobileMessaging();
							// System.out.println(r4.getJson());
							//
							// reqPickupMission r5 = new reqPickupMission();
							// System.out.println(r5.getJson());
						}
					}).start();

					// asyncTaskLogin();

				} else {
					Tools.showCustomToast(Login.this, "Ýnternet baðlantýsý bulunamadý!");
				}
			} catch (Exception e) {
				errorStatus = 1;
				Mint.logException(e);
				e.printStackTrace();
			}
		}

	}

	private void asyncTaskLogin() {

		AsyncTask<Void, String, Void> login = new AsyncTask<Void, String, Void>() {

			@Override
			protected void onPreExecute() {

				super.onPreExecute();

				try {
					progressDialog = new ProgressDialog(Login.this);
					Resources res = getResources();
					Drawable draw = res.getDrawable(R.drawable.progressbar1);
					progressDialog.setProgressDrawable(draw);
					progressDialog.setMax(100);
					progressDialog.setProgress(0);
					progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					progressDialog.setTitle("Giriþ Yapýlýyor...");
					progressDialog.setCancelable(false);
					progressDialog.setIndeterminate(false);
					progressDialog.show();
				} catch (Exception e) {
					Mint.logException(e);
					e.printStackTrace();
					errorStatus = 1;
					if (progressDialog.isShowing()) {
						progressDialog.dismiss();
					}
				}

			}

			@Override
			protected Void doInBackground(Void... params) {

				try {
					publishProgress("Kullanýcý bilgileri kontrol ediliyor...", "0");

					reqLogin r1 = new reqLogin();
					r1.saveLogin();
					reqVersionControl r7 = new reqVersionControl();
					r7.saveVersionControl();

					// JsonToObject jo = new JsonToObject();
					// jo.saveLogin();
					// jo.saveVersionControl();
					publishProgress("Kullanýcý bilgileri kontrol ediliyor...", "10");

					// 2014-11-10T13:39:43.2148018+02:00

					// try {
					// Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
					// String json = HttpGetJsonResponse.ServerDateResponse.getJson();
					// String startDateString = gson.fromJson(json, SyncResult.class).getTargetObject().toString();
					// DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
					// Date startDate = df.parse(startDateString);
					// LiveData.differentTime = startDate.getTime() - new Date().getTime();
					// Log.d("saat", "" + LiveData.differentTime);
					// } catch (ParseException e) {
					// e.printStackTrace();
					// Mint.logException(e);
					// }

					// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					// String currentDateandTime = sdf.format(new Date());

				} catch (Exception e) {
					e.printStackTrace();
					Mint.logException(e);
					errorStatus = 1;
					if (progressDialog.isShowing()) {
						progressDialog.dismiss();
					}
				}

				return null;
			}

			@Override
			protected void onProgressUpdate(String... values) {
				super.onProgressUpdate(values);
				progressDialog.setTitle(values[0]);
				progressDialog.setProgress(Integer.parseInt(values[1]));
			}

			@Override
			protected void onPostExecute(Void aVoid) {

				try {
					if (LiveData.Login.getProcessStatus() == 200) {

						if (LiveData.VersionControl.getTargetObject() == null) {
							asyncTaskSync();

						} else if (LiveData.VersionControl.getTargetObject().getCurrentVersion() > Info.CURRENT_VERSION) {
							progressDialog.dismiss();
							Tools.showCustomToast(Login.this, "Yeni Sürüm Bulundu! Lütfen Uygulamayý Güncelleyiniz.");
							// http://rl.telekurye.com.tr/MobileVersions/com.telekurye.FieldControlOne78.apk
						}

					} else {
						progressDialog.dismiss();

						Tools.showCustomToast(Login.this, " Giriþ Baþarýsýz! \n\n Kullanýcý Adý veya Þifre Hatalý ");
					}
				} catch (Exception e) {
					e.printStackTrace();
					Mint.logException(e);
					errorStatus = 1;
					if (progressDialog.isShowing()) {
						progressDialog.dismiss();
					}
				}

			}

		};

		login.execute(); // login.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	}

	private void asyncTaskSync() {
		AsyncTask<Void, String, Void> sync = new AsyncTask<Void, String, Void>() {

			@Override
			protected void onPreExecute() {

				super.onPreExecute();

			}

			@Override
			protected Void doInBackground(Void... params) {

				try {

					reqLogin r1 = new reqLogin();
					r1.saveLogin();
					publishProgress("Kullanýcý Bilgileri Senkronizasyonu Tamamlandý.", "20");

					reqVersionControl r7 = new reqVersionControl();
					r7.saveVersionControl();
					publishProgress("Versiyon Kontrolü Tamamlandý.", "35");

					reqDistributionMission r2 = new reqDistributionMission();
					r2.saveDistributionMission();
					publishProgress("Toplu Daðýtým Görevleri Senkronizasyonu Tamamlandý.", "50");

					reqMissions r3 = new reqMissions();
					r3.saveMissions();
					publishProgress("Broþür Görevi Senkronizasyonu Tamamlandý.", "65");

					reqMobileMessaging r4 = new reqMobileMessaging();
					r4.saveMobileMessaging();
					publishProgress("Mobil Mesaj Senkronizasyonu Tamamlandý.", "80");

					reqPickupMission r5 = new reqPickupMission();
					r5.savePickupMission();
					publishProgress("Malzeme Alým Görevi Senkronizasyonu Tamamlandý.", "100");

					// JsonToObject jto = new JsonToObject();
					// jto.saveLogin();
					// publishProgress("Kullanýcý Bilgileri Senkronizasyonu Tamamlandý.", "20");
					//
					// jto.saveVersionControl();
					// publishProgress("Versiyon Kontrolü Tamamlandý.", "35");
					//
					// jto.saveDistributionMission();
					// publishProgress("Toplu Daðýtým Görevleri Senkronizasyonu Tamamlandý.", "50");
					//
					// jto.saveMissions();
					// publishProgress("Broþür Görevi Senkronizasyonu Tamamlandý.", "65");
					//
					// jto.saveMobileMessaging();
					// publishProgress("Mobil Mesaj Senkronizasyonu Tamamlandý.", "80");
					//
					// jto.savePickupMission();
					// publishProgress("Malzeme Alým Görevi Senkronizasyonu Tamamlandý.", "100");

					LiveData.lastSyncDate = Tools.getDateNow();

				} catch (Exception e) {
					e.printStackTrace();
					Mint.logException(e);
					errorStatus = 1;
					if (progressDialog.isShowing()) {
						progressDialog.dismiss();
					}
				}

				return null;

			}

			@Override
			protected void onProgressUpdate(String... values) {

				super.onProgressUpdate(values);
				progressDialog.setTitle(values[0]);
				progressDialog.setProgress(Integer.parseInt(values[1]));
			}

			@Override
			protected void onPostExecute(Void aVoid) {
				try {
					progressDialog.dismiss();

					if (errorStatus == 0) {

						// ObjectToDatabase otd = new ObjectToDatabase();
						// otd.setAllData();

						Intent i1 = new Intent(Login.this, MainMenu.class);
						startActivity(i1);

						Tools.showCustomToast(Login.this, "Giriþ Baþarýlý");
						// startService(new Intent(getBaseContext(), AllSyncService.class));

						asyncTaskSyncBack();
					}

				} catch (Exception e) {
					e.printStackTrace();
					Mint.logException(e);
					errorStatus = 1;
					if (progressDialog.isShowing()) {
						progressDialog.dismiss();
					}
				}

			}

		};
		sync.execute();
	}

	private void asyncTaskSyncBack() {

		AsyncTask<Void, String, Void> syncBack = new AsyncTask<Void, String, Void>() {

			@Override
			protected Void doInBackground(Void... params) {

				while (true) {

					if (Tools.isConnectingToInternet(Login.this)) {
						try {

							sendDatabaseRecord();

							reqLogin r1 = new reqLogin();
							r1.saveLogin();

							reqVersionControl r7 = new reqVersionControl();
							r7.saveVersionControl();
							publishProgress("1/5 : Versiyon Kontrolü Tamamlandý.");

							reqDistributionMission r2 = new reqDistributionMission();
							r2.saveDistributionMission();
							publishProgress("2/5 : Toplu Daðýtým Görevleri Senkronizasyonu Tamamlandý.");

							reqMissions r3 = new reqMissions();
							r3.saveMissions();
							publishProgress("3/5 : Broþür Görevi Senkronizasyonu Tamamlandý.");

							reqMobileMessaging r4 = new reqMobileMessaging();
							r4.saveMobileMessaging();
							publishProgress("4/5 : Mobil Mesaj Senkronizasyonu Tamamlandý.");

							reqPickupMission r5 = new reqPickupMission();
							r5.savePickupMission();
							publishProgress("5/5 : Malzeme Alým Görevi Senkronizasyonu Tamamlandý.");

							// JsonToObject jto = new JsonToObject();
							//
							// jto.saveLogin();
							//
							// jto.saveVersionControl();
							// publishProgress("1/5 : Versiyon Kontrolü Tamamlandý.");
							//
							// jto.saveDistributionMission();
							// publishProgress("2/5 : Toplu Daðýtým Görevleri Senkronizasyonu Tamamlandý.");
							//
							// jto.saveMissions();
							// publishProgress("3/5 : Broþür Görevi Senkronizasyonu Tamamlandý.");
							//
							// jto.saveMobileMessaging();
							// publishProgress("4/5 : Mobil Mesaj Senkronizasyonu Tamamlandý.");
							//
							// jto.savePickupMission();
							// publishProgress("5/5 : Malzeme Alým Görevi Senkronizasyonu Tamamlandý.");

							LiveData.lastSyncDate = Tools.getDateNow();

						} catch (Exception e) {
							e.printStackTrace();
							Mint.logException(e);
							if (progressDialog.isShowing()) {
								progressDialog.dismiss();
							}
						}
					} else {
						publishProgress("Ýnternet baðlantýsý olmadýðý için güncelleme yapýlamadý.");
					}

					try {
						Thread.sleep(Info.SYNCPERIOD);
					} catch (InterruptedException e) {
						e.printStackTrace();
						Mint.logException(e);
					}
				}

			}

			@Override
			protected void onProgressUpdate(String... values) {

				super.onProgressUpdate(values);
				Log.i("SYNC", values[0]);

			}

		};
		syncBack.execute();
	}

	public void sendDatabaseRecord() {

		SyncRequest<List<DistributionMissionFeedBackPhoto>> photos = DistributionMissionFeedBackPhoto.GetAllDataForSync();

		String startDateString = "2014-10-03 11:26:36";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate = null;
		try {
			startDate = df.parse(startDateString);
		} catch (ParseException e) {
			e.printStackTrace();
			Mint.logException(e);
		}

		try {
			if (DistributionMissionFeedBack.GetAllDataForSync().getTypedObjects().size() > 0) {

				int counter = DistributionMissionFeedBack.GetRowCount();

				for (int i = 0; i < counter; i++) {

					SyncRequest<List<DistributionMissionFeedBack>> dmFeedBack = new SyncRequest<List<DistributionMissionFeedBack>>();
					List<DistributionMissionFeedBack> dmfb = new ArrayList<DistributionMissionFeedBack>();
					List<DistributionMissionFeedBackPhoto> dmfbPhotos = new ArrayList<DistributionMissionFeedBackPhoto>();

					dmfb.add(DistributionMissionFeedBack.getRow(0));

					for (int j = 0; j < photos.getTypedObjects().size(); j++) {

						if (photos.getTypedObjects().get(j).getDmissionFBId() == dmfb.get(0).getUserDailyDistributionId()) {
							dmfbPhotos.add(photos.getTypedObjects().get(j));
						}

					}

					dmfb.get(0).setPhotos(dmfbPhotos);

					dmFeedBack.setTypedObjects(dmfb);
					dmFeedBack.setLastSyncDate(startDate);
					dmFeedBack.setEndSyncDate(startDate);

					
					
					
					Type listType = new TypeToken<SyncRequest<List<DistributionMissionFeedBack>>>() {
					}.getType();

					String jsn = JSONHelper.ToJson(dmFeedBack, listType);
					System.out.println(jsn);
					sendFeedback sf = new sendFeedback(jsn);

					Thread.sleep(500);

					dmFeedBack.getTypedObjects().get(0).setEndDayStatus(true);
					String jsn2 = JSONHelper.ToJson(dmFeedBack, listType);
					System.out.println(jsn2);
					
					sendFeedback sf2 = new sendFeedback(jsn2);

					for (int j = 0; j < dmfbPhotos.size(); j++) {
						sendFeedbackImage smp = new sendFeedbackImage();
						smp.sendFile(Info.PHOTO_SYNC_URL, Info.PHOTO_STORAGE_PATH + dmfbPhotos.get(j).getPhoto());

						File file = new File(Info.PHOTO_STORAGE_PATH + dmfbPhotos.get(j).getPhoto());
						file.delete();
					}

					DistributionMissionFeedBack.DeleteRow(dmfb.get(0).getUserDailyDistributionId());

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// progressDialog.dismiss();
	}

	// @Override
	// public void onBackPressed() {
	//
	// }
}
