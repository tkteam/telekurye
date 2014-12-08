package com.telekurye.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.telekurye.ui2.R;

public class Tools {

	public static void disableScreenLock(Context c) {
		PowerManager pm = (PowerManager) c.getSystemService(Context.POWER_SERVICE);
		WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE, "INFO");
		wl.acquire();

		KeyguardManager km = (KeyguardManager) c.getSystemService(Context.KEYGUARD_SERVICE);
		KeyguardLock kl = km.newKeyguardLock("name");
		kl.disableKeyguard();
	}

	public static String getPhoneImei(Context c) {
		TelephonyManager TelephonyMgr = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
		String phoneIMEI = TelephonyMgr.getDeviceId();
		return phoneIMEI;
	}

	public static void toggleWIFI(Context c, boolean bool) {

		WifiManager wifiManager = (WifiManager) c.getSystemService(Context.WIFI_SERVICE);

		if (wifiManager.isWifiEnabled() == bool) {
			return;
		} else {
			wifiManager.setWifiEnabled(bool);
		}

	}

	public static boolean isTablet(Context c) {
		return (c.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}

	public static void toggleGPS(Context c, boolean enable) {
		String provider = Settings.Secure.getString(c.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

		if (provider.contains("gps") == enable) {
			return; // the GPS is already in the requested state
		}

		final Intent poke = new Intent();
		poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
		poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
		poke.setData(Uri.parse("3"));
		c.sendBroadcast(poke);
	}

	public static void showCustomToast(Context c, String message) {

		LayoutInflater inflater = LayoutInflater.from(c);
		View layout;

		layout = inflater.inflate(R.layout._z_toast, null);

		TextView text = (TextView) layout.findViewById(R.id.tvToast);
		text.setText(message);

		Toast toast = new Toast(c);
		toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();

	}

	public static boolean isConnectingToInternet(Context c) {
		ConnectivityManager connectivity = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null)
				for (int i = 0; i < info.length; i++)
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
		}
		return false;
	}

	public static Boolean isGPSEnabled(Context c) {
		LocationManager locationManager = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
		return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}

	public static Date getDateNow() {
		Date now = new Date();
		now.setTime(now.getTime());
		return now;
	}

	public static int getBatteryLevel(Context c) {
		Intent batteryIntent = c.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
		int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
		int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

		// Error checking that probably isn't needed but I added just in case.
		if (level == -1 || scale == -1) {
			return 50;
		}
		float result = ((float) level / (float) scale) * 100.0f;
		return (int) result;
	}

	public static void copyFiles(File sourceLocation, File targetLocation) throws IOException {

		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				targetLocation.mkdir();
			}
			File[] files = sourceLocation.listFiles();
			for (File file : files) {
				InputStream in = new FileInputStream(file);
				OutputStream out = new FileOutputStream(targetLocation + "/" + file.getName());

				// Copy the bits from input stream to output stream
				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
				file.delete();
			}
		}
	}

	public static void clearDirectory(File targetDirectory) throws IOException {

		if (targetDirectory.isDirectory()) {
			File[] files = targetDirectory.listFiles();
			for (File file : files) {
				file.delete();
			}
		}
	}

}
