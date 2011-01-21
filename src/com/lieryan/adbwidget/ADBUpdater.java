package com.lieryan.adbwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;

public class ADBUpdater extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("ADBUpdater", "received a request to toggle ADB");
		int adb = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ADB_ENABLED, 0);
		adb = adb == 0 ? 1 : 0;
		Settings.Secure.putInt(context.getContentResolver(), Settings.Secure.ADB_ENABLED, adb);
	}
}
