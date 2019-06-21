package com.kidslearningapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SliderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        viewPager.setAdapter(imageAdapter);
        trackHistory();
    }

    public void trackHistory() { //for tracking history
        DatabaseHelper mDatabaseHelper;
        mDatabaseHelper = new DatabaseHelper(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final String timedate = dateFormat.format(new Date()); // Find todays date

        boolean insertData = mDatabaseHelper.addData("Slider Activity", timedate);

        if (insertData) {
        } else {
        }

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
