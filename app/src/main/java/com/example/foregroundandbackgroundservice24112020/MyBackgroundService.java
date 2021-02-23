package com.example.foregroundandbackgroundservice24112020;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyBackgroundService extends Service {

    // Chỉ dùng khi các dùng bound service
    Handler handler;
    int i = 0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate Service", Toast.LENGTH_SHORT).show();
        handler = new Handler();
//        Log.d("BBB","onCreate Service");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i <= 100){
                    Toast.makeText(MyBackgroundService.this, "Giá trị của i : " + i, Toast.LENGTH_SHORT).show();
                    i++;
                    handler.postDelayed(this , 2000);
                }else{
                    Toast.makeText(MyBackgroundService.this, "Kết thúc", Toast.LENGTH_SHORT).show();
                }
            }
        },2000);


        return START_NOT_STICKY;
    }

}
