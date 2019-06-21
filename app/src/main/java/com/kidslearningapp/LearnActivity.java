package com.kidslearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LearnActivity extends AppCompatActivity {

    Button btnalpha, btnnumber, btncolor, btnpoem, btnshape, btnurdualpha, btnprofesion, btnDua;

    public void trackHistory() { //for tracking history
        DatabaseHelper mDatabaseHelper;
        mDatabaseHelper = new DatabaseHelper(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final String timedate = dateFormat.format(new Date()); // Find todays date

        boolean insertData = mDatabaseHelper.addData("Shape Activity", timedate);

        if (insertData) {
            Toast.makeText(getApplicationContext(), "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        trackHistory();

        btnalpha = findViewById(R.id.alphabets);
        btncolor = findViewById(R.id.color);
        btnnumber = findViewById(R.id.numbers);
        btnpoem = findViewById(R.id.poems);
        btnshape = findViewById(R.id.shape);
        btnurdualpha = findViewById(R.id.urdualpha);
        btnprofesion = findViewById(R.id.profesion);

        btnalpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, AlphaActivity.class);
                stopService(new Intent(LearnActivity.this, MyService.class)); //for stopinng the service
                startActivity(intent);
            }
        });

        btnshape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, ShapeActivity.class);
                stopService(new Intent(LearnActivity.this, MyService.class)); //for stopinng the service
                startActivity(intent);
            }
        });
        btnurdualpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, UrduActivity.class);
                stopService(new Intent(LearnActivity.this, MyService.class)); //for stopinng the service
                startActivity(intent);
            }
        });
        btnprofesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, ProfessionSliderActivity.class);
                stopService(new Intent(LearnActivity.this, MyService.class)); //for stopinng the service
                startActivity(intent);
            }
        });
        btnnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, NumberActivity.class);
                stopService(new Intent(LearnActivity.this, MyService.class)); //for stopinng the service
                startActivity(intent);
            }
        });

        btncolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, ColorActivity.class);
                stopService(new Intent(LearnActivity.this, MyService.class)); //for stopinng the service
                startActivity(intent);
            }
        });

        btnpoem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, PoemActivity.class);
                stopService(new Intent(LearnActivity.this, MyService.class)); //for stopinng the service
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
