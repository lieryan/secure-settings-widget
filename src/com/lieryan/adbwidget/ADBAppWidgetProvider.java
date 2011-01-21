package com.lieryan.adbwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ADBAppWidgetProvider extends AppWidgetProvider {
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		Intent intent = new Intent(context, ADBUpdater.class);
		PendingIntent pending = PendingIntent.getBroadcast(context, 0, intent, 0);
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
		views.setOnClickPendingIntent(R.id.toggle, pending);
		appWidgetManager.updateAppWidget(appWidgetIds, views);
	}
}
