package com.example.foregroundandbackgroundservice24112020;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyForegroundService extends Service {

    NotificationManager mNotificationManager;
    NotificationCompat.Builder mBuilder;
    String CHANNEL_ID = "MY_CHANNEL";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d("BBB","onCreate");
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mBuilder = createNotification();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("BBB","onStartCommand");
        startForeground(1 , mBuilder.build());
        return super.onStartCommand(intent, flags, startId);
    }

    private NotificationCompat.Builder createNotification(){
        NotificationCompat.Builder notify = new NotificationCompat.Builder(MyForegroundService.this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.btn_star)
                .setShowWhen(true)
                .setContentTitle("Thông báo mới")
                .setContentText("Có phiên bản mới")
                .setPriority(2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Notification",
                    NotificationManager.IMPORTANCE_HIGH
            );
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            notificationChannel.enableVibration(true);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
        return notify;

    }
}
