package com.kidslearningapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingActivity extends AppCompatActivity {
    AudioManager audioManager;

    public void trackHistory() { //for tracking history
        DatabaseHelper mDatabaseHelper;
        mDatabaseHelper = new DatabaseHelper(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final String timedate = dateFormat.format(new Date()); // Find todays date

        boolean insertData = mDatabaseHelper.addData("Setting Activity", timedate);

        if (insertData) {
            Toast.makeText(getApplicationContext(), "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        trackHistory();

        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);  //for increase decrease

        findViewById(R.id.btnstop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(SettingActivity.this, MyService.class)); //for stopinng the service
            }
        });

        //for increasing decreasing music
        findViewById(R.id.btnincrease).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
            }
        });
        findViewById(R.id.btndecrease).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
            }
        });
        findViewById(R.id.btnstart).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startService(new Intent(SettingActivity.this, MyService.class));    //for starting the service

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}