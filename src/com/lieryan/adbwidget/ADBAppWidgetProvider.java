package com.lieryan.adbwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.RemoteViews;

public class ADBAppWidgetProvider extends AppWidgetProvider {
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
		
		// install click handler
		Intent intent = new Intent(context, ADBUpdater.class);
		PendingIntent pending = PendingIntent.getBroadcast(context, 0, intent, 0);
		views.setOnClickPendingIntent(R.id.toggle, pending);
		
		// switch the icon to reflect USB debugging status 
		int adb = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ADB_ENABLED, 0);
		views.setImageViewResource(R.id.toggle, ADBUpdater.statusImage[adb]);
		
		// update the widgets
		appWidgetManager.updateAppWidget(appWidgetIds, views);
	}
}
