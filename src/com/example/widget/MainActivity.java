package com.example.widget;

import java.util.Random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class MainActivity extends AppWidgetProvider {

 
  @Override
  public void onUpdate(Context context, AppWidgetManager appWidgetManager,
      int[] appWidgetIds) {

    // Get all ids
  //  ComponentName thisWidget = new ComponentName(context,
      //  MainActivity.class);
   //// int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
    int widgetId=appWidgetIds[0];
  //  for (int widgetId : allWidgetIds) {
      // Create some random data
      int number = (new Random().nextInt(100));

      RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
          R.layout.activity_main);
  
      // Set the text
      remoteViews.setTextViewText(R.id.update, number+"");

      // Register an onClickListener
      Intent intent = new Intent(context, MainActivity.class);

      intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
      intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

      PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
          120, intent, PendingIntent.FLAG_UPDATE_CURRENT);
      remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
      appWidgetManager.updateAppWidget(widgetId, remoteViews);
    }
//  }
} 