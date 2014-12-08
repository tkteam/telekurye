package com.dnm._5_Helpers;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import com.dnm._4_Data_Other.Locations;
import com.splunk.mint.Mint;
import com.telekurye.utils.Info;
import com.telekurye.utils.LiveData;

public class GPSTracker extends Service implements LocationListener {

	private final Context		mContext;

	// flag for GPS status
	boolean						isGPSEnabled					= false;

	// flag for network status
	boolean						isNetworkEnabled				= false;

	// flag for GPS status
	boolean						canGetLocation					= false;

	private static Location		location;														// location
	private static double		latitude;														// latitude
	private static double		longitude;														// longitude
	private static float		accuracy;
	private static float		speed;
	private static long			time;
	int							sayac							= 0;
	// The minimum distance to change Updates in meters
	private static final long	MIN_DISTANCE_CHANGE_FOR_UPDATES	= Info.GPS_MIN_DISTANCE;		// metre cinsinden

	// The minimum time between updates in milliseconds
	private static final long	MIN_TIME_BW_UPDATES				= Info.GPS_CONTROL_PERIOD;		// milisaniye cinsinden
	ArrayList<Locations>		GpsLog							= new ArrayList<Locations>();
	// Declaring a Location Manager
	protected LocationManager	locationManager;

	public GPSTracker(Context context) {
		this.mContext = context;
		getLocation();
	}

	public Location getLocation() {
		try {
			locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);

			// getting GPS status
			isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

			// getting network status
			isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

			if (!isGPSEnabled && !isNetworkEnabled) {
				// no network provider is enabled
			} else {
				this.canGetLocation = true;
				if (isNetworkEnabled) {
					locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
					Log.d("Network", "Network");
					if (locationManager != null) {
						location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						if (location != null) {
							latitude = location.getLatitude();
							longitude = location.getLongitude();
							accuracy = location.getAccuracy();
							speed = location.getSpeed();
							time = location.getTime();
							Log.d("GPS Enabled", "latitude : " + latitude + " longitude : " + longitude + " accuracy : " + accuracy);
						}
					}
				}
				// if GPS Enabled get lat/long using GPS Services
				if (isGPSEnabled) {
					if (location == null) {
						locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
						Log.d("GPS Enabled", "GPS Enabled");
						if (locationManager != null) {
							location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
							if (location != null) {
								latitude = location.getLatitude();
								longitude = location.getLongitude();
								accuracy = location.getAccuracy();
								speed = location.getSpeed();
								time = location.getTime();
								Log.d("GPS Enabled", "latitude : " + latitude + " longitude : " + longitude + " accuracy : " + accuracy);

							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			Mint.logException(e);
		}

		return location;
	}

	public void stopUsingGPS() {
		if (locationManager != null) {
			locationManager.removeUpdates(GPSTracker.this);
		}
	}

	public boolean canGetLocation() {
		return this.canGetLocation;
	}

	public void showSettingsAlert() {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

		// Setting Dialog Title
		alertDialog.setTitle("Dikkat");

		// Setting Dialog Message
		alertDialog.setMessage("GPS þuan kapalý. Devam edebilmeniz için GPS açýk olmalýdýr. GPS'i açmak istiyor musunuz?");

		// On pressing Settings button
		alertDialog.setPositiveButton("Ayarlar", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				mContext.startActivity(intent);
			}
		});

		// on pressing cancel button
		alertDialog.setNegativeButton("Ýptal", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});

		// Showing Alert Message
		alertDialog.show();
	}

	@Override
	public void onProviderDisabled(String provider) {
	}

	@Override
	public void onProviderEnabled(String provider) {
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onLocationChanged(Location location) {

		latitude = (location.getLatitude());
		longitude = (location.getLongitude());
		accuracy = (location.getAccuracy());
		speed = (location.getSpeed());
		time = (location.getTime());

		Locations loc = new Locations();

		loc.setLatitude((float) latitude);
		loc.setLongitude((float) longitude);
		loc.setAccuracy(accuracy);
		loc.setSpeed(speed);
		loc.setLocationTime(time);

		if (GpsLog.size() < Info.GPS_CONTROL_COUNT) {
			GpsLog.add(loc);
		} else {
			GpsLog.set(sayac % Info.GPS_CONTROL_COUNT, loc);

		}

		LiveData.GpsLogs = GpsLog;

		if (sayac == Info.GPS_CONTROL_COUNT - 1) {
			sayac = 0;
		} else {
			sayac++;
		}

	}

	public static double getLatitude() {
		return latitude;
	}

	public static double getLongitude() {
		return longitude;
	}

	public static float getAccuracy() {
		return accuracy;
	}

	public static float getSpeed() {
		return speed;
	}

	public static long getTime() {
		return time;
	}

}
