package com.dnm._97_ApnSettings;

import com.splunk.mint.Mint;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.util.Log;

public class Apn {

	Context						context;

	private static final Uri	APN_TABLE_URI		= Uri.parse("content://telephony/carriers");
	private static final Uri	PREFERRED_APN_URI	= Uri.parse("content://telephony/carriers/preferapn");
	private String				TAG					= "APN info";

	public Apn(Context con) {
		context = con;

	}

	public void SetApnSettings(ApnValues values) {

		deleteAllAPNs();
		InsertAPN(values);
		SetDefaultAPN(1);
		EnumerateAPNs();

	}

	public int InsertAPN(ApnValues values) {
		int id = -1;
		ContentResolver resolver = context.getContentResolver();

		Cursor c = null;
		try {
			Uri newRow = resolver.insert(APN_TABLE_URI, values.getValues());
			if (newRow != null) {
				c = resolver.query(newRow, null, null, null, null);
				Log.d(TAG, "Yeni APN eklendi:");
				printAllData(c);
				int idindex = c.getColumnIndex("_id");
				c.moveToFirst();
				id = c.getShort(idindex);
				Log.d(TAG, "Yeni ID: " + id + ": Apn ekleme baþarýlý!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Mint.logException(e);
		}

		if (c != null)
			c.close();
		return id;
	}

	public void deleteAllAPNs() {
		ContentResolver resolver = context.getContentResolver();
		resolver.delete(APN_TABLE_URI, null, null);

	}

	public String printAllData(Cursor c) {
		if (c == null)
			return null;
		String s = "";
		int record_cnt = c.getColumnCount();
		Log.d(TAG, "Toplam kayýt sayýsý: " + record_cnt);

		if (c.moveToFirst()) {
			String[] columnNames = c.getColumnNames();

			Log.d(TAG, getAllColumnNames(columnNames));
			s += getAllColumnNames(columnNames);
			do {
				String row = "";
				for (String columnIndex : columnNames) {
					int i = c.getColumnIndex(columnIndex);
					row += c.getString(i) + ":\t";
				}
				row += "\n";
				Log.d(TAG, row);
				s += row;
			} while (c.moveToNext());
			Log.d(TAG, "Tüm kayýtlar listelendi");
		}
		return s;
	}

	public String getAllColumnNames(String[] columnNames) {
		String s = "Kayýt adý :\n";
		for (String t : columnNames) {
			s += t + ":\t";
		}
		return s + "\n";
	}

	public void EnumerateAPNs() {
		Cursor c = context.getContentResolver().query(APN_TABLE_URI, null, null, null, null);
		if (c != null) {

			String s = "Tüm Apn'ler:\n";
			Log.d(TAG, s);
			try {
				s += printAllData(c);
			} catch (SQLException e) {
				e.printStackTrace();
				Mint.logException(e);
			}

			c.close();
		}

	}

	public boolean SetDefaultAPN(int id) {
		boolean res = false;
		ContentResolver resolver = context.getContentResolver();
		ContentValues values = new ContentValues();

		values.put("apn_id", id);
		try {
			resolver.update(PREFERRED_APN_URI, values, null, null);
			Cursor c = resolver.query(PREFERRED_APN_URI, new String[] { "name", "apn" }, "_id=" + id, null, null);
			if (c != null) {
				res = true;
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Mint.logException(e);
		}
		return res;
	}

}

// Sistem/app klasörüne taþýma kodu
// try {
// Process process = Runtime.getRuntime().exec("su");
// DataOutputStream out = new DataOutputStream(process.getOutputStream());
// out.writeBytes("mount -o remount,rw -t yaffs2 /dev/block/mtdblock3 /system\n");
// out.writeBytes("cat /sdcard/ApnApp.apk > /system/app/ApnApp.apk\n");
// out.writeBytes("mount -o remount,ro -t yaffs2 /dev/block/mtdblock3 /system\n");
// out.writeBytes("exit\n");
// out.flush();
// process.waitFor();
// } catch (Exception e) {
// // TODO: handle exception
// }
