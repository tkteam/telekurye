package com.telekurye.ui2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dnm._5_Helpers.GPSTracker;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.splunk.mint.Mint;
import com.telekurye.utils.LiveData;

public class MainMenu extends MasterActivity {

	TextView			tvWelcome;
	Button				btnWholeDist;
	Button				btnPickupOrder;
	Button				btnMessage;
	Button				btnSettings;
	LinearLayout		llSettings;
	public GPSTracker	gps;

	private EasyTracker	easyTracker	= null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		// StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		setContentView(R.layout._2_menu);

		tvWelcome = (TextView) findViewById(R.id.username_surname_text);
		btnWholeDist = (Button) findViewById(R.id.btn_whole_dist);
		btnPickupOrder = (Button) findViewById(R.id.btn_pickup_order);
		btnMessage = (Button) findViewById(R.id.message_button);
		btnSettings = (Button) findViewById(R.id.settings_button);

		gps = new GPSTracker(MainMenu.this);

		easyTracker = EasyTracker.getInstance(this);

		try {

			if (LiveData.DistributionMission.getTargetObject().size() == 0) {
				btnWholeDist.setVisibility(View.GONE);

			} else {
				btnWholeDist.setVisibility(View.VISIBLE);
			}

			if (LiveData.PickupMission.getTargetObject().size() == 0) {
				btnPickupOrder.setVisibility(View.GONE);

			} else {
				btnPickupOrder.setVisibility(View.VISIBLE);
			}

			if (LiveData.MobileMessaging.getTargetObject().size() == 0) {
				btnMessage.setVisibility(View.GONE);

			} else {
				btnMessage.setVisibility(View.VISIBLE);
			}

			btnSettings.setVisibility(View.GONE);

			tvWelcome.setText("HOÞGELDÝNÝZ : " + LiveData.Login.getTargetObject().getPerson().getName() + " " + LiveData.Login.getTargetObject().getPerson().getSurname());
			btnWholeDist.setText("Toplu Daðýtým    [" + LiveData.DistributionMission.getTargetObject().size() + "]");

			// btnSettings.setText("" + LiveData.VersionControl.getTargetObject().getCurrentVersion());
		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}

		btnWholeDist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i1 = new Intent(MainMenu.this, DistributionMissionList.class);
				startActivity(i1);
				finish();

			}
		});

		btnPickupOrder.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		btnMessage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				easyTracker.send(MapBuilder.createEvent("TrackEventTest", "butona_basýldý", "track_event", null).build());
				// DistributionMissionFeedBack.DeleteRow(8282541);

				// Toast.makeText(MainMenu.this, ""+DistributionMissionFeedBack.getRow(0).getRelationName(), Toast.LENGTH_LONG).show();

				// for (int i = 0; i < LiveData.GpsLogs.size(); i++) {
				// Log.i("Geo_Location",i+" - "+ LiveData.GpsLogs.get(i).getLatitude().toString());
				// }

			}
		});

		btnSettings.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// //*********** Apn kayýt ***********
				// new Thread(new Runnable() {
				//
				// @Override
				// public void run() {
				//
				// ApnValues values = new ApnValues();
				// values.setNAME("Turkcell Internet");
				// values.setMCC("286");
				// values.setMNC("01");
				// values.setAPN("internet");
				// values.setNUMERIC("28601");
				// values.setTYPE("default,supl");
				//
				// Apn apnTools = new Apn(MainMenu.this);
				// apnTools.SetApnSettings(values);
				// }
				// }).start();
				// //*********************************

			}
		});

	}

	@Override
	public void onBackPressed() {

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.menu_kafasi) {
			Intent productIntent = new Intent(this, DistributionMissionList.class);
			startActivity(productIntent);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menuoption, menu);
		return true;
	}

	@Override
	protected void onStart() {
		super.onStart();
		EasyTracker.getInstance(this).activityStart(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		EasyTracker.getInstance(this).activityStop(this);

	}
}
