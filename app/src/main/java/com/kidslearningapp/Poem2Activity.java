package com.kidslearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Poem2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem2);

        trackHistory();

        stopService(new Intent(Poem2Activity.this, MyService.class)); //for stopinng the service


        VideoView videoView = findViewById(R.id.video1);

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.poem2);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();


    }

    @Override
    public void onBackPressed() {
        startService(new Intent(Poem2Activity.this, MyService.class));    //for starting the service
        super.onBackPressed();
    }

    public void trackHistory() { //for tracking history
        DatabaseHelper mDatabaseHelper;
        mDatabaseHelper = new DatabaseHelper(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final String timedate = dateFormat.format(new Date()); // Find todays date

        boolean insertData = mDatabaseHelper.addData("Poem2 Activity", timedate);

        if (insertData) {
            Toast.makeText(getApplicationContext(), "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
        }

    }
}
