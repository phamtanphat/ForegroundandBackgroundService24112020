package com.example.foregroundandbackgroundservice24112020;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyBackgroundService extends Service {

    // Chỉ dùng khi các dùng bound service
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("BBB","onCreate Service");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("BBB","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}