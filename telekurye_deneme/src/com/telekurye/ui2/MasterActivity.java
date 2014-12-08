package com.telekurye.ui2;

import android.app.Activity;
import android.os.Bundle;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.telekurye.utils.Tools;

public class MasterActivity extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Tools.disableScreenLock(this);
		Tools.toggleGPS(MasterActivity.this, true);
		// Tools.toggleWIFI(MasterActivity.this, false); // wifiyi kapatýr
		// Mint.initAndStartSession(MasterActivity.this, "2aaf93c4");

	
	}

}
