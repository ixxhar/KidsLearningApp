package com.kidslearningapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class PaintActivity extends AppCompatActivity {

    private static final String ActivityName = "PaintActiviy";  //for Activity Name

    DatabaseHelper mDatabaseHelper; //for database

    private RelativeLayout dashBoard;
    private MyView myView;
    public ImageView image;

    String id;

    Button b_red, b_blue, b_green, b_orange, b_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        trackHistory();

        Intent intent = getIntent();
        id = intent.getStringExtra("imageid");

        myView = new MyView(this);
        setContentView(R.layout.activity_paint);
        findViewById(R.id.dashBoard);

        b_red = (Button) findViewById(R.id.b_red);
        b_blue = (Button) findViewById(R.id.b_blue);
        b_green = (Button) findViewById(R.id.b_green);
        b_orange = (Button) findViewById(R.id.b_orange);
        b_clear = (Button) findViewById(R.id.b_clear);

        b_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.changePaintColor(0xFFFF0000);
            }
        });

        b_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.changePaintColor(0xFF0000FF);
            }
        });

        b_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.changePaintColor(0xFF00FF00);
            }
        });

        b_orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.changePaintColor(0xFFFF9900);
            }
        });

        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.changePaintColor(0xFFFFFFFF);
            }
        });

        dashBoard = (RelativeLayout) findViewById(R.id.dashBoard);
        dashBoard.addView(myView);

    }

    public class MyView extends View {

        private Paint paint;
        private Path path;
        public Bitmap mBitmap;
        public ProgressDialog pd;
        final Point p1 = new Point();
        public Canvas canvas;

        //Bitmap mutableBitmap ;
        public MyView(PaintActivity context) {

            super(context);

            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            pd = new ProgressDialog(context);
            this.paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeWidth(5f);

            if (id.equals("one")) {
                mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1).copy(Bitmap.Config.ARGB_8888, true);
                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
            } else if (id.equals("two")) {
                mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image2).copy(Bitmap.Config.ARGB_8888, true);
                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
            } else if (id.equals("three")) {
                mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image3).copy(Bitmap.Config.ARGB_8888, true);
                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
            } else if (id.equals("four")) {
                mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image4).copy(Bitmap.Config.ARGB_8888, true);
                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
            } else if (id.equals("five")) {
                mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image5).copy(Bitmap.Config.ARGB_8888, true);
                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
            } else if (id.equals("six")) {
                mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image6).copy(Bitmap.Config.ARGB_8888, true);
                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
            }

            this.path = new Path();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            this.canvas = canvas;
            this.paint.setColor(Color.RED);

            canvas.drawBitmap(mBitmap, 0, 0, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:

                    p1.x = (int) x;
                    p1.y = (int) y;
                    final int sourceColor = mBitmap.getPixel((int) x, (int) y);
                    final int targetColor = paint.getColor();
                    new TheTask(mBitmap, p1, sourceColor, targetColor).execute();
                    invalidate();
            }
            return true;
        }

        public void clear() {
            path.reset();
            invalidate();
        }

        public int getCurrentPaintColor() {
            return paint.getColor();
        }

        public void changePaintColor(int color) {
            this.paint.setColor(color);
        }

        class TheTask extends AsyncTask<Void, Integer, Void> {

            Bitmap bmp;
            Point pt;
            int replacementColor, targetColor;

            public TheTask(Bitmap bm, Point p, int sc, int tc) {
                this.bmp = bm;
                this.pt = p;
                this.replacementColor = tc;
                this.targetColor = sc;
                pd.setMessage("Filling....");
                pd.show();
            }

            @Override
            protected void onPreExecute() {
                pd.show();

            }

            @Override
            protected void onProgressUpdate(Integer... values) {

            }

            @Override
            protected Void doInBackground(Void... params) {
                FloodFill f = new FloodFill();
                f.floodFill(bmp, pt, targetColor, replacementColor);
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                pd.dismiss();
                invalidate();
            }
        }
    }

    // flood fill
    public class FloodFill {

        public void floodFill(Bitmap image, Point node, int targetColor, int replacementColor) {

            int width = image.getWidth();
            int height = image.getHeight();
            int target = targetColor;
            int replacement = replacementColor;

            if (target != replacement) {
                Queue<Point> queue = new LinkedList<Point>();
                do {

                    int x = node.x;
                    int y = node.y;
                    while (x > 0 && image.getPixel(x - 1, y) == target) {
                        x--;
                    }

                    boolean spanUp = false;
                    boolean spanDown = false;
                    while (x < width && image.getPixel(x, y) == target) {
                        image.setPixel(x, y, replacement);
                        if (!spanUp && y > 0 && image.getPixel(x, y - 1) == target) {
                            queue.add(new Point(x, y - 1));
                            spanUp = true;
                        } else if (spanUp && y > 0 && image.getPixel(x, y - 1) != target) {
                            spanUp = false;
                        }
                        if (!spanDown && y < height - 1 && image.getPixel(x, y + 1) == target) {
                            queue.add(new Point(x, y + 1));
                            spanDown = true;
                        } else if (spanDown && y < (height - 1) && image.getPixel(x, y + 1) != target) {
                            spanDown = false;
                        }
                        x++;
                    }

                } while ((node = queue.poll()) != null);
            }
        }
    }

    public void trackHistory() { //for tracking history
        mDatabaseHelper = new DatabaseHelper(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final String timedate = dateFormat.format(new Date()); // Find todays date

        boolean insertData = mDatabaseHelper.addData(ActivityName, timedate);

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