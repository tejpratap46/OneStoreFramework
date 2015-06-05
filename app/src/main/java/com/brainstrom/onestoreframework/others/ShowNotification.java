package com.brainstrom.onestoreframework.others;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.brainstrom.onestoreframework.R;

/**
 * Created by Tej on 03-Jun-15.
 */
public class ShowNotification {

    @SuppressLint("NewApi")
    public void createNotification(Context context, Class<Activity> activityClass, String Title, String Text) {
        // prepare intent which is triggered if the
        // notification is selected

        Intent intent = new Intent(context, activityClass).putExtra("message", Text);
        PendingIntent pIntent = PendingIntent
                .getActivity(context, 0, intent, 0);

        // build notification
        // the addAction re-use the same intent to keep the example short
        Notification n = new Notification.Builder(context)
                .setContentTitle(Title).setContentText(Text)
                .setSmallIcon(R.drawable.ic_launcher).setContentIntent(pIntent)
                .setAutoCancel(true)
                .addAction(R.drawable.ic_launcher, "View", pIntent).build();

        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);
    }
}
