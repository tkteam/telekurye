package com.telekurye.ui2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.dnm._2_Data_Download.DistributionMission;
import com.dnm._3_Data_Upload.DistributionMissionFeedBack;
import com.dnm._3_Data_Upload.DistributionMissionFeedBackPhoto;
import com.dnm._4_Data_Other.Locations;
import com.dnm._5_Helpers.GPSTracker;
import com.dnm._7_TypeTokenClasses.SyncRequest;
import com.splunk.mint.Mint;
import com.telekurye.camera.CapturePhoto;
import com.telekurye.utils.ConstHelper;
import com.telekurye.utils.Info;
import com.telekurye.utils.LiveData;
import com.telekurye.utils.Tools;

@SuppressLint("NewApi")
public class DistributionMissionFeedBackUi extends MasterActivity implements OnTabChangeListener {

	public CapturePhoto								capture;
	public String									imgPath;

	public TabHost									tabHost;

	public ImageView								img1;

	Button											btnTeslimatDurumu;
	Button											btnYakinlikDerecesi;
	Button											btnKimlikTipi;

	public EditText									etIdentity_name;
	public EditText									etIdentity_surname;
	public EditText									etIdentity_number;
	public EditText									etRelation_phone;
	public TextView									tvIdentityType;

	public TextView									tvGorevKodu;
	public TextView									tvAdSoyad;
	public TextView									tvFirmaAdi;
	public TextView									tvAdres;
	public TextView									tvRandevu;
	public TextView									tvDagitimTipi;
	public TextView									tvDokumanDurumu;

	public Button									btnFotografCek;
	public Button									btnGeri;
	public Button									btnFeedback_kaydet;

	public int										valueListviewItem;
	public int										valueEndpointStatusId;
	public int										valueFeedbackRelationId;

	public DistributionMission						dm;

	public DistributionMissionFeedBackPhoto			photo;
	public List<DistributionMissionFeedBackPhoto>	photos;
	public DistributionMissionFeedBack				feedBackData;
	public List<DistributionMissionFeedBack>		feedBackDatas;

	// public ProgressDialog progressDialog;

	public int										width1				= 200;
	public int										height1				= 78;
	public int										width2				= 200;
	public int										height2				= 60;

	public int										MaxDistance			= 10000000;
	private int										valueTab;

	private static int								PrograssbarStatus	= 0;
	private static int								photoStatus			= 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout._4_distribution_feed_back_layout);

		// tabHost = (TabHost) findViewById(R.id.tabSecim);
		img1 = (ImageView) findViewById(R.id.imageView1);

		etIdentity_name = (EditText) findViewById(R.id.etIdentityName);
		etIdentity_surname = (EditText) findViewById(R.id.identity_surname);
		etIdentity_number = (EditText) findViewById(R.id.identity_number);
		etRelation_phone = (EditText) findViewById(R.id.relation_phone);
		tvIdentityType = (TextView) findViewById(R.id.identiy_number_describer_text_view);

		tvGorevKodu = (TextView) findViewById(R.id.unique_code);
		tvAdSoyad = (TextView) findViewById(R.id.feed_name_text);
		tvFirmaAdi = (TextView) findViewById(R.id.company_name);
		tvAdres = (TextView) findViewById(R.id.feed_dist_adress_text);
		tvRandevu = (TextView) findViewById(R.id.feed_appointment_text);
		tvDagitimTipi = (TextView) findViewById(R.id.feed_dist_product);
		tvDokumanDurumu = (TextView) findViewById(R.id.transfer_info_text);

		btnFotografCek = (Button) findViewById(R.id.btn_fotografCek);
		btnFeedback_kaydet = (Button) findViewById(R.id.btn_feedback_kaydet);
		btnGeri = (Button) findViewById(R.id.button1_geri7);
		btnTeslimatDurumu = (Button) findViewById(R.id.btnTeslimatDurumu);
		btnYakinlikDerecesi = (Button) findViewById(R.id.btn_yakinlik_derecesi);
		btnKimlikTipi = (Button) findViewById(R.id.btnKimlikTipi);

		btnYakinlikDerecesi.setVisibility(View.GONE);
		etIdentity_name.setVisibility(View.GONE);
		etIdentity_surname.setVisibility(View.GONE);
		btnKimlikTipi.setVisibility(View.GONE);
		etIdentity_number.setVisibility(View.GONE);
		etRelation_phone.setVisibility(View.GONE);

		capture = new CapturePhoto(this);

		photos = new ArrayList<DistributionMissionFeedBackPhoto>();

		// CameraActivity = this;
		feedBackData = new DistributionMissionFeedBack();

		Bundle extras = getIntent().getExtras();
		if (extras != null) {

			valueListviewItem = extras.getInt("DistributionMissionID");
			valueEndpointStatusId = extras.getInt("endpointstatusid");
			valueFeedbackRelationId = extras.getInt("feedbackrelationid");
			valueTab = extras.getInt("OpenTab");

		}

		for (int i = 0; i < LiveData.DistributionMission.getTargetObject().size(); i++) {
			if (LiveData.DistributionMission.getTargetObject().get(i).getId() == valueListviewItem) {
				dm = LiveData.DistributionMission.getTargetObject().get(i);

			}
		}

		// ***************

		try {
			tvGorevKodu.setText("" + dm.getUniqueCode());
			tvAdSoyad.setText("" + dm.getName() + " " + dm.getSurname());
			tvFirmaAdi.setText("" + dm.getCompanyName());
			tvAdres.setText("" + dm.getAdressText().toString().toLowerCase());
			tvRandevu.setText((dm.getAppoinmentDate() == null) ? "" : dm.getAppoinmentDate().toGMTString()); // ****
			tvDagitimTipi.setText("" + dm.getProductName().toString().toLowerCase());
			String documentStatus = "";
			if (dm.getTransferInformation() != null) {
				for (int i = 0; i < dm.getTransferInformation().size(); i++) {
					documentStatus = documentStatus + "[" + dm.getTransferInformation().get(i).getDocumentName().toLowerCase() + "]\n\n"
							+ dm.getTransferInformation().get(i).getDescription().toLowerCase() + "\n\n";
				}
			}
			tvDokumanDurumu.setText(documentStatus);

		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}

		// *******************

		if (valueEndpointStatusId != -1) {
			for (int i = 0; i < ConstHelper.EndPointStatus.Id().size(); i++) {
				if (valueEndpointStatusId == ConstHelper.EndPointStatus.Id().get(i)) {

					try {

						feedBackData.setEndPointStatusId(ConstHelper.EndPointStatus.Id().get(i));
						btnTeslimatDurumu.setText(ConstHelper.EndPointStatus.Description().get(i));

						if (feedBackData.getEndPointStatusId() == ConstHelper.EndPointStatus.Id().get(1)) { // teslim edildi ise
							btnYakinlikDerecesi.setVisibility(View.VISIBLE);
							etIdentity_name.setVisibility(View.VISIBLE);
							etIdentity_surname.setVisibility(View.VISIBLE);
							btnKimlikTipi.setVisibility(View.VISIBLE);
							etIdentity_number.setVisibility(View.VISIBLE);
							etRelation_phone.setVisibility(View.VISIBLE);

						} else {
							btnYakinlikDerecesi.setVisibility(View.GONE);
							etIdentity_name.setVisibility(View.GONE);
							etIdentity_surname.setVisibility(View.GONE);
							btnKimlikTipi.setVisibility(View.GONE);
							etIdentity_number.setVisibility(View.GONE);
							etRelation_phone.setVisibility(View.GONE);

							feedBackData.setRelationId(0);
							feedBackData.setIdentityTypeId(0);
							etIdentity_name.setText("");
							etIdentity_surname.setText("");
							etIdentity_number.setText("");
							etRelation_phone.setText("");

						}
					} catch (Exception e) {
						e.printStackTrace();
						Mint.logException(e);
					}

				}
			}
		}

		if (valueFeedbackRelationId != -1) {
			for (int i = 0; i < ConstHelper.DistributionMissionFeedbackRelation.Id().size(); i++) {
				if (valueFeedbackRelationId == ConstHelper.DistributionMissionFeedbackRelation.Id().get(i)) {

					try {

						feedBackData.setRelationId(ConstHelper.DistributionMissionFeedbackRelation.Id().get(i));
						btnYakinlikDerecesi.setText(ConstHelper.DistributionMissionFeedbackRelation.Description().get(i));

					} catch (Exception e) {
						e.printStackTrace();
						Mint.logException(e);
					}

				}
			}
		}

		// **************
		tabHost = (TabHost) findViewById(R.id.tabSecim);
		tabHost.setup();

		setupTab(R.id.tab1, R.drawable.info1, "Bilgi");
		setupTab(R.id.tab2, R.drawable.tick, "Teslimat");
		setupTab(R.id.tab3, R.drawable.camera1, "Fotoðraf");

		tabHost.getTabWidget().getChildAt(0).setLayoutParams(new LinearLayout.LayoutParams(0, 85, 0.330f));
		tabHost.getTabWidget().getChildAt(1).setLayoutParams(new LinearLayout.LayoutParams(0, 85, 0.345f));
		tabHost.getTabWidget().getChildAt(2).setLayoutParams(new LinearLayout.LayoutParams(0, 85, 0.33f));

		tabHost.setCurrentTab(valueTab);
		tabHost.setOnTabChangedListener(this);

		// ****************

		btnTeslimatDurumu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(DistributionMissionFeedBackUi.this, ShowEndpointStatus.class);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				startActivity(i);
				finish();

			}
		});

		btnYakinlikDerecesi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(DistributionMissionFeedBackUi.this, ShowFeedbackRelation.class);
				i.putExtra("DistributionMissionID", valueListviewItem);
				i.putExtra("endpointstatusid", valueEndpointStatusId);
				i.putExtra("feedbackrelationid", valueFeedbackRelationId);
				startActivity(i);
				finish();
			}
		});

		btnGeri.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i1 = new Intent(DistributionMissionFeedBackUi.this, DistributionMissionList.class);
				startActivity(i1);

			}
		});

		btnKimlikTipi.setOnClickListener(new OnClickListener() {
			int	kimlikTipi	= 0;

			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(DistributionMissionFeedBackUi.this);
				builder.setTitle("Kimlik Tipi Seçiniz");

				final CharSequence[] choiceList = { "NÜFUS CÜZDANI", "EHLÝYET", "PASAPORT" };
				int selected = -1;

				builder.setSingleChoiceItems(choiceList, selected, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						if (which == 0) {
							kimlikTipi = 1;
						} else if (which == 1) {
							kimlikTipi = 2;
						} else if (which == 2) {
							kimlikTipi = 3;
						}

					}
					// }).setCancelable(false).setPositiveButton("ÝPTAL", new DialogInterface.OnClickListener() {
					// @Override
					// public void onClick(DialogInterface dialog, int which) {
					//
					// }
				}).setNegativeButton("TAMAM", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

						feedBackData.setIdentityTypeId(ConstHelper.DistributionMissionFeedbackRelation.Id().get(kimlikTipi));

						if (feedBackData.getIdentityTypeId() == 0) {
							tvIdentityType.setText("Kimlik No :");
							btnKimlikTipi.setText("Seçim Yapýnýz  >>");
						} else if (feedBackData.getIdentityTypeId() == 1) {
							tvIdentityType.setText("TC Kimlik No :");
							btnKimlikTipi.setText("NÜFUS CÜZDANI");
						} else if (feedBackData.getIdentityTypeId() == 2) {
							tvIdentityType.setText("Ehliyet No :");
							btnKimlikTipi.setText("EHLÝYET");
						} else if (feedBackData.getIdentityTypeId() == 3) {
							tvIdentityType.setText("Pasaport No :");
							btnKimlikTipi.setText("PASAPORT");
						}

						if (feedBackData.getIdentityTypeId() == 0) {
							etIdentity_number.setEnabled(false);
						} else if (feedBackData.getIdentityTypeId() != 0) {
							etIdentity_number.setEnabled(true);
						}

						kimlikTipi = 0;
					}
				});

				AlertDialog alert = builder.create();
				alert.show();

			}
		});

		// ****************

		// List<String> list4 = ConstHelper.IdentityType.Description();
		//
		// ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list4);
		// dataAdapter4.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
		// spinnerKimlikTipi.setAdapter(dataAdapter4);
		// spinnerKimlikTipi.setOnItemSelectedListener(new OnItemSelectedListener() {
		//
		// @Override
		// public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
		//
		// try {
		// feedBackData.setIdentityTypeId(ConstHelper.DistributionMissionFeedbackRelation.Id().get(position));
		// } catch (Exception e) {
		// e.printStackTrace(); Mint.logException(e);
		// }
		//
		// if (feedBackData.getIdentityTypeId() == 0) {
		// tvIdentityType.setText("Kimlik No :");
		// } else if (feedBackData.getIdentityTypeId() == 1) {
		// tvIdentityType.setText("TC Kimlik No :");
		// } else if (feedBackData.getIdentityTypeId() == 2) {
		// tvIdentityType.setText("Ehliyet No :");
		// } else if (feedBackData.getIdentityTypeId() == 3) {
		// tvIdentityType.setText("Pasaport No :");
		// }
		//
		// if (feedBackData.getIdentityTypeId() == 0) {
		// etIdentity_number.setEnabled(false);
		// } else if (feedBackData.getIdentityTypeId() != 0) {
		// etIdentity_number.setEnabled(true);
		// }
		//
		// }
		//
		// @Override
		// public void onNothingSelected(AdapterView<?> arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		// });

		// **************

		btnFeedback_kaydet.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (!Tools.isGPSEnabled(DistributionMissionFeedBackUi.this)) {
					Tools.toggleGPS(DistributionMissionFeedBackUi.this, true);
				} else if (feedBackData.getEndPointStatusId() == 0) {
					ValidationDialog("Lütfen bir teslimat durumu seçiniz");
					tabHost.setCurrentTab(1);
				} else if (feedBackData.getRelationId() == 0 && feedBackData.getEndPointStatusId() == 1) {
					ValidationDialog("Lütfen bir yakýnlýk derecesi seçiniz");
					tabHost.setCurrentTab(1);
				} else if ((etIdentity_name.getText().toString().equals("") || etIdentity_name.getText() == null) && feedBackData.getEndPointStatusId() == 1) {
					ValidationDialog("Lütfen teslim alan kiþinin adýný giriniz");
					tabHost.setCurrentTab(1);
				} else if ((etIdentity_surname.getText().toString().equals("") || etIdentity_surname.getText() == null) && feedBackData.getEndPointStatusId() == 1) {
					ValidationDialog("Lütfen teslim alan kiþinin soyadýný giriniz");
					tabHost.setCurrentTab(1);
				} else if (feedBackData.getIdentityTypeId() == 0 && feedBackData.getEndPointStatusId() == 1) {
					ValidationDialog("Lütfen bir kimlik tipi seçiniz");
					tabHost.setCurrentTab(1);
				} else if (feedBackData.getIdentityTypeId() == 1 && !TcNoKontrol(etIdentity_number.getText().toString()) && feedBackData.getEndPointStatusId() == 1) {
					ValidationDialog("Lütfen geçerli bir TC No giriniz");
					tabHost.setCurrentTab(1);
				} else if (feedBackData.getIdentityTypeId() == 2 && etIdentity_number.getText().toString().equals("") && feedBackData.getEndPointStatusId() == 1) {
					ValidationDialog("Lütfen geçerli bir Ehliyet No giriniz");
					tabHost.setCurrentTab(1);
				} else if (feedBackData.getIdentityTypeId() == 3 && etIdentity_number.getText().toString().equals("") && feedBackData.getEndPointStatusId() == 1) {
					ValidationDialog("Lütfen geçerli bir Pasaport No giriniz");
					tabHost.setCurrentTab(1);
				} else if (etRelation_phone.getText().toString().equals("") && feedBackData.getEndPointStatusId() == 1) {
					ValidationDialog("Lütfen geçerli bir Telefon Numarasý giriniz");
					tabHost.setCurrentTab(1);
				} else if (photoStatus == 0) { // fotoðraf validasyonu
					ValidationDialog("Lütfen en az bir adet fotoðraf çekiniz");
					tabHost.setCurrentTab(2);
				} else {

					photo = new DistributionMissionFeedBackPhoto();
					photo.setAlwaysUploadPhoto(true); // editle
					photo.setPhoto((String) img1.getTag());
					photo.setCreateDate(Tools.getDateNow()); // editle
					photo.setModifiedDate(Tools.getDateNow()); // editle
					photo.setUserId_Create(dm.getCourierId());
					photo.setUserId_Modify(dm.getCourierId());
					photo.setDmissionFBId(dm.getId());
					// photo.setOrientationValue(currentPhoto.OrientationValue); // editle 41.07375296999
					photos.add(photo);

					feedBackData.setUserDailyDistributionId(dm.getId());
					feedBackData.setId(dm.getId());
					feedBackData.setCreateDate(Tools.getDateNow()); // editle
					feedBackData.setModifiedDate(Tools.getDateNow()); // editle
					feedBackData.setRelationName(etIdentity_name.getText().toString());
					feedBackData.setRelationSurname(etIdentity_surname.getText().toString());
					feedBackData.setRelationPhone(etRelation_phone.getText().toString());
					feedBackData.setIdentityNo(etIdentity_number.getText().toString());
					feedBackData.setIsComplete(true); // editle
					feedBackData.setModifiedLatitude(GPSTracker.getLatitude());
					feedBackData.setModifiedLongitude(GPSTracker.getLongitude());
					feedBackData.setModifiedAccuracy((double) GPSTracker.getAccuracy());
					feedBackData.setModifiedDate(Tools.getDateNow()); // editle
					feedBackData.setUserId_Create(dm.getCourierId());
					feedBackData.setUserId_Modify(dm.getCourierId());
					feedBackData.setEndDayStatus(false);
					// feedBackData.setCourierSelectedLatitude(39.94375229);
					// feedBackData.setCourierSelectedLongitude(39.94375229);
					// feedBackData.setGotToStock(true);

					if (GPSTracker.getAccuracy() < Info.GPS_ACCURACY) {
						feedBackData.setLatitude(GPSTracker.getLatitude());
						feedBackData.setLongitude(GPSTracker.getLongitude());
						feedBackData.setAccuracy(GPSTracker.getAccuracy());

						feedBackData.setPhotos(photos);
						feedBackDatas = new ArrayList<DistributionMissionFeedBack>();
						feedBackDatas.add(feedBackData);
						SyncRequest<List<DistributionMissionFeedBack>> asd = new SyncRequest<List<DistributionMissionFeedBack>>();
						asd.setTypedObjects(feedBackDatas);
						LiveData.DistributionMissionFeedBack = asd;

						if (isUserInsideRectangle(GPSTracker.getLatitude(), GPSTracker.getLongitude(), dm.getX1(), dm.getY1(), dm.getX2(), dm.getY2())) {

							feedBackData.Insert();
							photo.Insert();
							Intent i1 = new Intent(DistributionMissionFeedBackUi.this, DistributionMissionList.class);
							startActivity(i1);

						} else {

							AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DistributionMissionFeedBackUi.this);

							alertDialogBuilder.setTitle("Dikkat!");
							alertDialogBuilder.setMessage("Bulunduðunuz konum, gönderi adresiyle uyumsuz gözüktüðünden dolayý kontrol edilecektir. Devam etmek istediðinizden emin misiniz?");
							alertDialogBuilder.setCancelable(false);
							alertDialogBuilder.setPositiveButton("Devam Et", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {

									feedBackData.Insert();
									photo.Insert();
									Intent i1 = new Intent(DistributionMissionFeedBackUi.this, DistributionMissionList.class);
									startActivity(i1);

								}
							});
							alertDialogBuilder.setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
								}
							});
							AlertDialog alertDialog = alertDialogBuilder.create();
							alertDialog.show();

						}
					} else {

						if (SortedAccuracy().get(0).getAccuracy() < Info.GPS_ACCURACY) {

							feedBackData.setLatitude(SortedAccuracy().get(0).getLatitude());
							feedBackData.setLongitude(SortedAccuracy().get(0).getLongitude());
							feedBackData.setAccuracy(SortedAccuracy().get(0).getAccuracy());

							feedBackData.setPhotos(photos);
							feedBackDatas = new ArrayList<DistributionMissionFeedBack>();
							feedBackDatas.add(feedBackData);
							SyncRequest<List<DistributionMissionFeedBack>> asd = new SyncRequest<List<DistributionMissionFeedBack>>();
							asd.setTypedObjects(feedBackDatas);
							LiveData.DistributionMissionFeedBack = asd;

							feedBackData.Insert();
							photo.Insert();
							Intent i1 = new Intent(DistributionMissionFeedBackUi.this, DistributionMissionList.class);
							startActivity(i1);

						} else {
							ValidationDialog("Bulunduðunuz konum bu görev için hatalýdýr. Lütfen konumunuzu deðiþtirip tekrar deneyiniz. \n" + SortedAccuracy().get(0).getAccuracy());
						}

					}

				}

			}
		});

		img1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (photoStatus != 0) {
					selectImage(v.getId());
				}

			}

		});

		btnFotografCek.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				capture.dispatchTakePictureIntent(CapturePhoto.SHOT_IMAGE, img1.getId());
			}

		});

		// *********************
	}

	public static ArrayList<Locations> SortedAccuracy() {

		ArrayList<Locations> gpsLogs = LiveData.GpsLogs;

		Collections.sort(gpsLogs, new Locations());

		for (int i = 0; i < gpsLogs.size(); i++) {
			Log.d("Sorted Accuracy", "" + gpsLogs.get(i).getAccuracy());
		}

		return gpsLogs;
	}

	public Boolean Distance(Double userX, Double userY, Double targetX, Double targetY, int MaxDistance) {
		Location loc1 = new Location("");
		loc1.setLatitude(userX);
		loc1.setLongitude(userY);

		Location loc2 = new Location("");
		loc2.setLatitude(targetX);
		loc2.setLongitude(targetY);

		System.out.println("x1 --- " + userX);
		System.out.println("y1 --- " + userY);
		System.out.println("x2 --- " + targetX);
		System.out.println("y2 --- " + targetY);

		float distanceInMeters = loc1.distanceTo(loc2);
		System.out.println("uzaklýk " + distanceInMeters);
		if (distanceInMeters <= MaxDistance) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean isUserInsideRectangle(Double userX, Double userY, Float targetX1, Float targetY1, Float targetX2, Float targetY2) {

		if (userX >= targetX1 && userX <= targetX2 && userY >= targetY1 && userY <= targetY2) {
			return true;
		} else {
			return false;
		}
	}

	public void ValidationDialog(String message) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DistributionMissionFeedBackUi.this);

		alertDialogBuilder.setTitle("Dikkat!");
		alertDialogBuilder.setMessage(message).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

	// **************************************************
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK) {
			ImageView imageView = (ImageView) findViewById(requestCode);
			if (capture.getActionCode() == CapturePhoto.PICK_IMAGE) {
				Uri targetUri = data.getData();
				imgPath = targetUri.toString();
				if (targetUri != null)
					capture.handleMediaPhoto(targetUri, imageView);
			} else {
				try {
					capture.handleCameraPhoto(imageView);
				} catch (IOException e) {
					e.printStackTrace();
					Mint.logException(e);
				}
			}

			photoStatus = 1;

		}

	}

	private void selectImage(final int id) {
		final CharSequence[] items = { "Fotoðrafý Sil", "Vazgeç" };

		AlertDialog.Builder builder = new AlertDialog.Builder(DistributionMissionFeedBackUi.this);
		builder.setTitle("Düzenle");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int item) {

				try {
					if (items[item].equals("Fotoðrafý Sil")) {
						img1.setImageResource(android.R.color.transparent);

						photoStatus = 0;
					}

					else if (items[item].equals("Vazgeç")) {
						dialog.dismiss();
					}
				} catch (Exception e) {
					e.printStackTrace();
					Mint.logException(e);
				}

			}
		});
		builder.show();
	}

	// private void sendOrSaveFeedBack() {
	//
	// AsyncTask<Void, String, Void> syncBack = new AsyncTask<Void, String, Void>() {
	// @Override
	// protected void onPreExecute() {
	// super.onPreExecute();
	//
	// Intent i1 = new Intent(DistributionMissionFeedBackUi.this, DistributionMissionList.class);
	// startActivity(i1);
	//
	// // progressDialog = new ProgressDialog(DistributionMissionFeedBackUi.this);
	// // Resources res = getResources();
	// // Drawable draw = res.getDrawable(R.drawable.progressbar1);
	// // progressDialog.setProgressDrawable(draw);
	// // progressDialog.setMax(100);
	// // progressDialog.setProgress(0);
	// // progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	// // progressDialog.setTitle("Lürfen bekleyiniz");
	// // progressDialog.setCancelable(false);
	// // progressDialog.setIndeterminate(false);
	// // progressDialog.show();
	//
	// }
	//
	// @Override
	// protected Void doInBackground(Void... params) {
	//
	// try {
	//
	// if (Tools.isConnectingToInternet(DistributionMissionFeedBackUi.this)) {
	//
	// publishProgress("Bilgiler Gönderiliyor...");
	// FeedBackData fbd = new FeedBackData();
	// fbd.SendDistributionMissionFeedBack();
	// // PrograssbarStatus = 10;
	//
	// for (int i = 20; i < 40; i++) {
	//
	// try {
	// Thread.sleep(50);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// Mint.logException(e);
	// }
	// // PrograssbarStatus = i;
	// }
	//
	// publishProgress("Fotoðraflar Gönderiliyor...");
	// // PrograssbarStatus = 50;
	// sendFeedbackImage smp = new sendFeedbackImage();
	// smp.sendFile(Info.PHOTO_SYNC_URL, Info.PHOTO_STORAGE_PATH + photo.getPhoto());
	// publishProgress("Görevler Güncelleniyor...");
	//
	// // PrograssbarStatus = 80;
	// JsonToObject jto = new JsonToObject();
	// jto.saveDistributionMission();
	// // PrograssbarStatus = 90;
	// publishProgress("Dosyalar Temizleniyor...");
	// File file = new File(Info.PHOTO_STORAGE_PATH + photo.getPhoto());
	// file.delete();
	// // ***********
	// // PrograssbarStatus = 95;
	// publishProgress("Dosyalar Temizleniyor...");
	// Thread.sleep(1000);
	//
	// LiveData.DistributionMissionFeedBack.getTypedObjects().get(0).setEndDayStatus(true);
	// FeedBackData fbd2 = new FeedBackData();
	// fbd2.SendDistributionMissionFeedBack();
	// // ***********
	// // PrograssbarStatus = 100;
	// } else {
	// publishProgress("Görev Bilgileri Kaydediliyor...");
	// // PrograssbarStatus = 30;
	// feedBackData.Insert();
	// // PrograssbarStatus = 70;
	// publishProgress("Fotoðraf Bilgileri Kaydediliyor...");
	// photo.Insert();
	// // PrograssbarStatus = 100;
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// Mint.logException(e);
	// }
	//
	// return null;
	// }
	//
	// @Override
	// protected void onProgressUpdate(String... values) {
	// super.onProgressUpdate(values);
	// System.out.println(values[0]);
	// // progressDialog.setMessage(values[0]);
	// // progressDialog.setProgress(PrograssbarStatus);
	// }
	//
	// @Override
	// protected void onPostExecute(Void result) {
	// super.onPostExecute(result);
	// try {
	// // progressDialog.dismiss();
	// // Tools.showCustomToast(DistributionMissionFeedBackUi.this, "Görev baþarýyla tamamlandý");
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// Mint.logException(e);
	// }
	//
	// }
	//
	// };
	// // syncBack.execute();
	// syncBack.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	// }

	public static Boolean TcNoKontrol(String tcno) {

		int x = 0, y = 0, z = 0, mod1 = 0, mod2 = 0, bastan1 = 0, sondan1 = 0, sondan2 = 0;

		try {
			for (int i = 0; i < tcno.length() - 1; i++) {
				x = x + Character.getNumericValue(tcno.charAt(i));
			}

			for (int i = 0; i < tcno.length() - 1; i = i + 2) {
				y = y + Character.getNumericValue(tcno.charAt(i));
			}

			for (int i = 1; i < tcno.length() - 2; i = i + 2) {
				z = z + Character.getNumericValue(tcno.charAt(i));
			}

			mod1 = x % 10;
			mod2 = ((7 * y) - z) % 10;

			bastan1 = Character.getNumericValue(tcno.charAt(0));
			sondan1 = Character.getNumericValue(tcno.charAt(10));
			sondan2 = Character.getNumericValue(tcno.charAt(9));

		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}

		if (tcno.length() == 11 || bastan1 != 0) {
			if (mod1 == sondan1 && mod2 == sondan2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public void onTabChanged(String tabId) {

		System.out.println(tabId);

		if (tabId.equals("Bilgi")) {

		} else if (tabId.equals("Teslimat")) {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // keyboard kapatýldý
			imm.hideSoftInputFromWindow(tabHost.getApplicationWindowToken(), 0);
		} else if (tabId.equals("Fotoðraf")) {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // keyboard kapatýldý
			imm.hideSoftInputFromWindow(tabHost.getApplicationWindowToken(), 0);
		}

	}

	private void setupTab(int tab, int icon, final String text) {

		View view = LayoutInflater.from(tabHost.getContext()).inflate(R.layout.tabs_bg, null);
		TextView tv = (TextView) view.findViewById(R.id.tabsText);
		tv.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
		tv.setText(text);

		TabSpec setContent = tabHost.newTabSpec(text).setIndicator(view).setContent(tab);
		tabHost.addTab(setContent);

	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	public void onBackPressed() {
	}
}
