package com.kidslearningapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShapeImageAdaptor extends PagerAdapter {

    private Context mcontext;
    private LayoutInflater layoutInflater;
    private int[] myImages = new int[]{R.raw.hexagon, R.raw.moon,
            R.raw.ovel, R.raw.pentagon, R.raw.round, R.raw.rectangle, R.raw.square,
            R.raw.star, R.raw.diamond};

    private String[] myNames = new String[]{"hexagon", "moon", "ovel",
            "pentagon", "round", "rectangle", "square", "star", "diamond"};


    public ShapeImageAdaptor(Context context) {
        this.mcontext = context;
    }

    @Override
    public int getCount() {
        return myImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewAlphabets);
        imageView.setImageResource(myImages[position]);
        TextView textView = (TextView) view.findViewById(R.id.textViewAlphabets);
        textView.setText(myNames[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);

        final MediaPlayer mp1 = MediaPlayer.create(mcontext, R.raw.hexagona);
        final MediaPlayer mp2 = MediaPlayer.create(mcontext, R.raw.moona);
        final MediaPlayer mp3 = MediaPlayer.create(mcontext, R.raw.ovela);
        final MediaPlayer mp4 = MediaPlayer.create(mcontext, R.raw.pentagona);
        final MediaPlayer mp5 = MediaPlayer.create(mcontext, R.raw.rounda);
        final MediaPlayer mp6 = MediaPlayer.create(mcontext, R.raw.rectanglea);
        final MediaPlayer mp7 = MediaPlayer.create(mcontext, R.raw.squarea);
        final MediaPlayer mp8 = MediaPlayer.create(mcontext, R.raw.stara);
        final MediaPlayer mp9 = MediaPlayer.create(mcontext, R.raw.diamonda);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Toast.makeText(mcontext, "A", Toast.LENGTH_LONG).show();
                    mp1.start();
                } else if (position == 1) {
                    Toast.makeText(mcontext, "B", Toast.LENGTH_LONG).show();

                    mp2.start();
                } else if (position == 2) {
                    Toast.makeText(mcontext, "C", Toast.LENGTH_LONG).show();

                    mp3.start();
                } else if (position == 3) {
                    mp4.start();
                } else if (position == 4) {
                    mp5.start();
                } else if (position == 5) {
                    mp6.start();
                } else if (position == 6) {
                    mp7.start();
                } else if (position == 7) {
                    mp8.start();
                } else if (position == 8) {
                    mp9.start();
                } else if (position == 9) {
                } else {
                    Toast.makeText(mcontext, "it's the end point", Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}