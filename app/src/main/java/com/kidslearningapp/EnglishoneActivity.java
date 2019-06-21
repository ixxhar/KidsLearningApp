package com.kidslearningapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EnglishoneActivity extends AppCompatActivity {


    Button click1, click2, click3, click4, click5, click6, click7, click8, click9, click10, click11, click12, click13, click14, click15, click16, click17, click18, click19, click20, click21, click22, click23, click24, click25, click26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_englishone);
        trackHistory();

        click1 = findViewById(R.id.btn_a);
        click2 = findViewById(R.id.btn_b);
        click3 = findViewById(R.id.btn_c);
        click4 = findViewById(R.id.btn_d);
        click5 = findViewById(R.id.btn_e);
        click6 = findViewById(R.id.btn_f);
        click7 = findViewById(R.id.btn_g);
        click8 = findViewById(R.id.btn_h);
        click9 = findViewById(R.id.btn_i);
        click10 = findViewById(R.id.btn_j);
        click11 = findViewById(R.id.btn_k);
        click12 = findViewById(R.id.btn_l);
        click13 = findViewById(R.id.btn_m);
        click14 = findViewById(R.id.btn_n);
        click15 = findViewById(R.id.btn_o);
        click16 = findViewById(R.id.btn_p);
        click17 = findViewById(R.id.btn_q);
        click18 = findViewById(R.id.btn_r);
        click19 = findViewById(R.id.btn_s);
        click20 = findViewById(R.id.btn_t);
        click21 = findViewById(R.id.btn_u);
        click22 = findViewById(R.id.btn_v);
        click23 = findViewById(R.id.btn_w);
        click24 = findViewById(R.id.btn_x);
        click25 = findViewById(R.id.btn_y);
        click26 = findViewById(R.id.btn_z);


        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.a);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.b);
        final MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.c);
        final MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.d);
        final MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(), R.raw.e);
        final MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(), R.raw.f);
        final MediaPlayer mp7 = MediaPlayer.create(getApplicationContext(), R.raw.g);
        final MediaPlayer mp8 = MediaPlayer.create(getApplicationContext(), R.raw.h);
        final MediaPlayer mp9 = MediaPlayer.create(getApplicationContext(), R.raw.i);
        final MediaPlayer mp10 = MediaPlayer.create(getApplicationContext(), R.raw.j);
        final MediaPlayer mp11 = MediaPlayer.create(getApplicationContext(), R.raw.k);
        final MediaPlayer mp12 = MediaPlayer.create(getApplicationContext(), R.raw.l);
        final MediaPlayer mp13 = MediaPlayer.create(getApplicationContext(), R.raw.m);
        final MediaPlayer mp14 = MediaPlayer.create(getApplicationContext(), R.raw.n);
        final MediaPlayer mp15 = MediaPlayer.create(getApplicationContext(), R.raw.o);
        final MediaPlayer mp16 = MediaPlayer.create(getApplicationContext(), R.raw.p);
        final MediaPlayer mp17 = MediaPlayer.create(getApplicationContext(), R.raw.q);
        final MediaPlayer mp18 = MediaPlayer.create(getApplicationContext(), R.raw.r);
        final MediaPlayer mp19 = MediaPlayer.create(getApplicationContext(), R.raw.s);
        final MediaPlayer mp20 = MediaPlayer.create(getApplicationContext(), R.raw.t);
        final MediaPlayer mp21 = MediaPlayer.create(getApplicationContext(), R.raw.u);
        final MediaPlayer mp22 = MediaPlayer.create(getApplicationContext(), R.raw.v);
        final MediaPlayer mp23 = MediaPlayer.create(getApplicationContext(), R.raw.w);
        final MediaPlayer mp24 = MediaPlayer.create(getApplicationContext(), R.raw.x);
        final MediaPlayer mp25 = MediaPlayer.create(getApplicationContext(), R.raw.y);
        final MediaPlayer mp26 = MediaPlayer.create(getApplicationContext(), R.raw.z);


        View.OnClickListener elem = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.btn_a:
                        mp1.start();
                        break;
                    case R.id.btn_b:
                        mp2.start();
                        break;
                    case R.id.btn_c:
                        mp3.start();
                        break;
                    case R.id.btn_d:
                        mp4.start();
                        break;
                    case R.id.btn_e:
                        mp5.start();
                        break;
                    case R.id.btn_f:
                        mp6.start();
                        break;
                    case R.id.btn_g:
                        mp7.start();
                        break;
                    case R.id.btn_h:
                        mp8.start();
                        break;
                    case R.id.btn_i:
                        mp9.start();
                        break;
                    case R.id.btn_j:
                        mp10.start();
                        break;
                    case R.id.btn_k:
                        mp11.start();
                        break;
                    case R.id.btn_l:
                        mp12.start();
                        break;
                    case R.id.btn_m:
                        mp13.start();
                        break;
                    case R.id.btn_n:
                        mp14.start();
                        break;
                    case R.id.btn_o:
                        mp15.start();
                        break;
                    case R.id.btn_p:
                        mp16.start();
                        break;
                    case R.id.btn_q:
                        mp17.start();
                        break;
                    case R.id.btn_r:
                        mp18.start();
                        break;
                    case R.id.btn_s:
                        mp19.start();
                        break;
                    case R.id.btn_t:
                        mp20.start();
                        break;
                    case R.id.btn_u:
                        mp21.start();
                        break;
                    case R.id.btn_v:
                        mp22.start();
                        break;
                    case R.id.btn_w:
                        mp23.start();
                        break;
                    case R.id.btn_x:
                        mp24.start();
                        break;
                    case R.id.btn_y:
                        mp25.start();
                        break;
                    case R.id.btn_z:
                        mp26.start();
                        break;

                }
            }
        });

        click1.setOnClickListener(elem);
        click2.setOnClickListener(elem);
        click3.setOnClickListener(elem);
        click4.setOnClickListener(elem);
        click5.setOnClickListener(elem);
        click6.setOnClickListener(elem);
        click7.setOnClickListener(elem);
        click8.setOnClickListener(elem);
        click9.setOnClickListener(elem);
        click10.setOnClickListener(elem);
        click11.setOnClickListener(elem);
        click12.setOnClickListener(elem);
        click13.setOnClickListener(elem);
        click14.setOnClickListener(elem);
        click15.setOnClickListener(elem);
        click16.setOnClickListener(elem);
        click17.setOnClickListener(elem);
        click18.setOnClickListener(elem);
        click19.setOnClickListener(elem);
        click20.setOnClickListener(elem);
        click21.setOnClickListener(elem);
        click22.setOnClickListener(elem);
        click23.setOnClickListener(elem);
        click24.setOnClickListener(elem);
        click25.setOnClickListener(elem);
        click26.setOnClickListener(elem);
    }


    public void trackHistory() { //for tracking history
        DatabaseHelper mDatabaseHelper;
        mDatabaseHelper = new DatabaseHelper(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final String timedate = dateFormat.format(new Date()); // Find todays date

        boolean insertData = mDatabaseHelper.addData("Alphabet Activity", timedate);

        if (insertData) {
            Toast.makeText(getApplicationContext(), "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
