package com.kidslearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_moniter, btn_learn, btn_drawing, btn_quiz, btn_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_moniter = findViewById(R.id.btn_moniter);
        btn_drawing = findViewById(R.id.btn_drawing);
        btn_quiz = findViewById(R.id.btn_quiz);
        btn_learn = findViewById(R.id.btn_learn);
        btn_set = findViewById(R.id.btn_setting);

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });


        btn_drawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawActivity.class);
                startActivity(intent);
            }
        });

        btn_moniter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        btn_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LearnActivity.class);
                startActivity(intent);
            }
        });

        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        stopService(new Intent(MainActivity.this, MyService.class)); //for stopinng the service
        finish();
        super.onBackPressed();
    }


}
