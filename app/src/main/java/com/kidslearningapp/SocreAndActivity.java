package com.kidslearningapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SocreAndActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    DatabaseHelperScore databaseHelperScore;

    ArrayList<HistoryClass> historyActivityArrayList;
    ListView listView;
    HistoryClass historyClass;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socre_and);

        Intent intent = getIntent();
        id = intent.getStringExtra("parentid");

        if (id.equals("one")) {
            myDB = new DatabaseHelper(this);

            historyActivityArrayList = new ArrayList<HistoryClass>();
            Cursor data = myDB.getData();
            int numRows = data.getCount();
            if (numRows == 0) {
                Toast.makeText(getApplicationContext(), "The Database is empty  :(.", Toast.LENGTH_LONG).show();
            } else {
                int i = 0;
                while (data.moveToNext()) {
                    historyClass = new HistoryClass(data.getString(1), data.getString(2));
                    historyActivityArrayList.add(i, historyClass);
                    i++;
                }
                ListAdapter adapter = new ListAdapter(this, R.layout.row_item, historyActivityArrayList);
                listView = (ListView) findViewById(R.id.listview);
                listView.setAdapter(adapter);
            }
        }

        if (id.equals("two")) {
            databaseHelperScore = new DatabaseHelperScore(this);

            historyActivityArrayList = new ArrayList<HistoryClass>();
            Cursor data = databaseHelperScore.getData();
            int numRows = data.getCount();
            if (numRows == 0) {
                Toast.makeText(getApplicationContext(), "The Database is empty  :(.", Toast.LENGTH_LONG).show();
            } else {
                int i = 0;
                while (data.moveToNext()) {
                    historyClass = new HistoryClass(data.getString(1), data.getString(2));
                    historyActivityArrayList.add(i, historyClass);
                    i++;
                }
                ListAdapter adapter = new ListAdapter(this, R.layout.row_item, historyActivityArrayList);
                listView = (ListView) findViewById(R.id.listview);
                listView.setAdapter(adapter);
            }


        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
