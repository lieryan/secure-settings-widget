package com.lieryan.adbwidget;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.RemoteViews;

public class ADBUpdater extends BroadcastReceiver {
	final static int[] statusImage = {R.drawable.disabled, R.drawable.enabled};
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("ADBUpdater", "received a request to toggle ADB");
		
		// get current USB debugging settings
		int adb = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ADB_ENABLED, 0);
		
		// toggle the USB debugging setting
		adb = adb == 0 ? 1 : 0;
		Settings.Secure.putInt(context.getContentResolver(), Settings.Secure.ADB_ENABLED, adb);
			
		// switch the icon to reflect USB debugging status
		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
		views.setImageViewResource(R.id.toggle, statusImage[adb]);
		
		// update the widgets
		appWidgetManager.updateAppWidget(new ComponentName(context, ADBAppWidgetProvider.class), views);
	}
}
