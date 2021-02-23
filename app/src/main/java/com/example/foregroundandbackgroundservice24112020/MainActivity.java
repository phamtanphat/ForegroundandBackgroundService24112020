package com.example.foregroundandbackgroundservice24112020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtnBackground,mBtnForeground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnBackground = findViewById(R.id.buttonBackgroundService);
        mBtnForeground = findViewById(R.id.buttonForegroundService);

        mBtnBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyBackgroundService.class);
                intent.putExtra("chuoi","hello");
                startService(intent);
            }
        });

        mBtnForeground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyForegroundService.class);
                ContextCompat.startForegroundService(MainActivity.this,intent);
            }
        });
    }
}