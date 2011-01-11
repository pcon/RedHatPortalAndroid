package com.redhat.gss.avalon.android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Notifications {
	private static final String LOG_NAME = "Notifications";
	public static final int NOTIFICATION_ID_RECEIVED = 0x1221;

	public static Boolean sendNotification(String subject, String body, Intent i, Context c) {
		NotificationManager nManager = (NotificationManager) c.getSystemService(c.NOTIFICATION_SERVICE);
          
		Notification notification = new Notification(
			R.drawable.notification_icon, //Icon
			subject,					//Display name
			System.currentTimeMillis());	//Time to send

		notification.setLatestEventInfo(
			c,						//Context
			subject,					//Subject
			body,					//Body
			PendingIntent.getActivity(
				c,							//Context 
				0,							//RequestCode
				i,							//Intent
				PendingIntent.FLAG_UPDATE_CURRENT	//Flags
			)
		);
          
		notification.flags += Notification.FLAG_AUTO_CANCEL;

		nManager.notify(NOTIFICATION_ID_RECEIVED, notification);

		return true;
	}
}
