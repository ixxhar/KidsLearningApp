package com.kidslearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UrduActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu);

        stopService(new Intent(UrduActivity.this, MyService.class)); //for stopinng the service

        trackHistory();

        ViewPager uviewpager = findViewById(R.id.uviewPager);
        UrduImageAdapter pimageAdapter = new UrduImageAdapter(this);
        uviewpager.setAdapter(pimageAdapter);

    }


    @Override
    public void onBackPressed() {
        startService(new Intent(UrduActivity.this, MyService.class)); //for stopinng the service
        finish();
        super.onBackPressed();
    }

    public void trackHistory() { //for tracking history
        DatabaseHelper mDatabaseHelper;
        mDatabaseHelper = new DatabaseHelper(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final String timedate = dateFormat.format(new Date()); // Find todays date

        boolean insertData = mDatabaseHelper.addData("Urdu Activity", timedate);

        if (insertData) {
            Toast.makeText(getApplicationContext(), "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }
}
