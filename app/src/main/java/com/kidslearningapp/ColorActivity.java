package com.kidslearningapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        trackHistory();

        Button red = (Button) findViewById(R.id.btn_red);
        Button orange = (Button) findViewById(R.id.btn_orange);
        Button yellow = (Button) findViewById(R.id.btn_yellow);
        Button green = (Button) findViewById(R.id.btn_green);
        Button blue = (Button) findViewById(R.id.btn_blue);
        Button perple = (Button) findViewById(R.id.btn_purple);

        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.sound1);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.sound2);
        final MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.sound3);
        final MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.sound4);
        final MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(), R.raw.sound5);
        final MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(), R.raw.sound6);

        View.OnClickListener elem = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btn_red:
                        mp1.start();
                        break;
                    case R.id.btn_orange:
                        mp2.start();
                        break;
                    case R.id.btn_yellow:
                        mp3.start();
                        break;
                    case R.id.btn_green:
                        mp4.start();
                        break;
                    case R.id.btn_blue:
                        mp5.start();
                        break;
                    case R.id.btn_purple:
                        mp6.start();
                        break;
                }
            }
        };
        red.setOnClickListener(elem);
        orange.setOnClickListener(elem);
        yellow.setOnClickListener(elem);
        green.setOnClickListener(elem);
        blue.setOnClickListener(elem);
        perple.setOnClickListener(elem);
    }

    public void trackHistory() { //for tracking history
        DatabaseHelper mDatabaseHelper;
        mDatabaseHelper = new DatabaseHelper(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final String timedate = dateFormat.format(new Date()); // Find todays date

        boolean insertData = mDatabaseHelper.addData("Color Activity", timedate);

        if (insertData) {
            Toast.makeText(getApplicationContext(), "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        startService(new Intent(ColorActivity.this, MyService.class)); //for stopinng the service
        finish();
        super.onBackPressed();
    }
}
