package com.kidslearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startMusic();   //starting music

        final ImageView imageView = findViewById(R.id.img);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {

                    imageView.animate().alpha(0f).setDuration(3000);
                    imageView.animate().translationX(1500f);

                    sleep(3000);
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

    }

    public void startMusic() {
        startService(new Intent(SplashActivity.this, MyService.class));    //for starting the service
    }
}
