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

public class NumberAdapter extends PagerAdapter {

    private Context mcontext;
    private LayoutInflater layoutInflater;

    private int[] myImages = new int[]{R.drawable.onee, R.drawable.twoo, R.drawable.threee, R.drawable.fourr, R.drawable.fivee, R.drawable.sixx, R.drawable.sevenn, R.drawable.eightt,
            R.drawable.ninee, R.drawable.tennn};

    private String[] myNames = new String[]{"one", "two", "three",
            "four", "five", "six", "seven", "eight",
            "nine", "ten"};


    public NumberAdapter(Context context) {
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

        final MediaPlayer mp1 = MediaPlayer.create(mcontext, R.raw.one);
        final MediaPlayer mp2 = MediaPlayer.create(mcontext, R.raw.two);
        final MediaPlayer mp3 = MediaPlayer.create(mcontext, R.raw.three);
        final MediaPlayer mp4 = MediaPlayer.create(mcontext, R.raw.four);
        final MediaPlayer mp5 = MediaPlayer.create(mcontext, R.raw.five);
        final MediaPlayer mp6 = MediaPlayer.create(mcontext, R.raw.six);
        final MediaPlayer mp7 = MediaPlayer.create(mcontext, R.raw.seven);
        final MediaPlayer mp8 = MediaPlayer.create(mcontext, R.raw.eight);
        final MediaPlayer mp9 = MediaPlayer.create(mcontext, R.raw.nine);
        final MediaPlayer mp10 = MediaPlayer.create(mcontext, R.raw.ten);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    mp1.start();
                } else if (position == 1) {
                    mp2.start();
                } else if (position == 2) {
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
                    mp10.start();
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