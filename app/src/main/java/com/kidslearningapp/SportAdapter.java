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

public class SportAdapter extends PagerAdapter {

    private Context mcontext;
    private LayoutInflater layoutInflater;

    private int[] myImages = new int[]{R.raw.apple, R.raw.baseball, R.raw.clock,
            R.raw.donkey, R.raw.elephant, R.raw.father, R.raw.grandmother, R.raw.hungry,
            R.raw.internet, R.raw.justics, R.raw.kingroo, R.raw.l_for_landon, R.raw.monkey, R.raw.norway,
            R.raw.overtime, R.raw.pillow, R.raw.question, R.raw.rabbit, R.raw.s_for_superman, R.raw.telephone,
            R.raw.underware, R.raw.vaxniate, R.raw.worldwide, R.raw.xylephone, R.raw.norway, R.raw.zebra,};

    private String[] myNames = new String[]{"apple", "baseball", "clock",
            "donkey", "elephant", "father", "grandmother", "hungry",
            "internet", "justics", "kingroo", "landon", "monkey", "norway",
            "overtime", "pillow", "question", "rabbit", "superman", "telephone",
            "underware", "vaxniate", "worldwide", "xylephone", "norway", "zebra"};


    public SportAdapter(Context context) {
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

        final MediaPlayer mp1 = MediaPlayer.create(mcontext, R.raw.a_for_apple);
        final MediaPlayer mp2 = MediaPlayer.create(mcontext, R.raw.b_for_baseball);
        final MediaPlayer mp3 = MediaPlayer.create(mcontext, R.raw.c_for_clock);
        final MediaPlayer mp4 = MediaPlayer.create(mcontext, R.raw.d_for_donkey);
        final MediaPlayer mp5 = MediaPlayer.create(mcontext, R.raw.e_for_elep);
        final MediaPlayer mp6 = MediaPlayer.create(mcontext, R.raw.f_for_father);
        final MediaPlayer mp7 = MediaPlayer.create(mcontext, R.raw.g_for_grandm);
        final MediaPlayer mp8 = MediaPlayer.create(mcontext, R.raw.h_for_hungry);
        final MediaPlayer mp9 = MediaPlayer.create(mcontext, R.raw.i_for_internet);
        final MediaPlayer mp10 = MediaPlayer.create(mcontext, R.raw.j_for_justics);
        final MediaPlayer mp11 = MediaPlayer.create(mcontext, R.raw.k_for_kingroo);
        final MediaPlayer mp12 = MediaPlayer.create(mcontext, R.raw.l_for_landon);
        final MediaPlayer mp13 = MediaPlayer.create(mcontext, R.raw.m_for_mokey);
        final MediaPlayer mp14 = MediaPlayer.create(mcontext, R.raw.n_for_norway);
        final MediaPlayer mp15 = MediaPlayer.create(mcontext, R.raw.o_for_overtime);
        final MediaPlayer mp16 = MediaPlayer.create(mcontext, R.raw.p_for_pillow);
        final MediaPlayer mp17 = MediaPlayer.create(mcontext, R.raw.q_for_question);
        final MediaPlayer mp18 = MediaPlayer.create(mcontext, R.raw.r_for_rabbit);
        final MediaPlayer mp19 = MediaPlayer.create(mcontext, R.raw.s_for_superman);
        final MediaPlayer mp20 = MediaPlayer.create(mcontext, R.raw.t_for_telephone);
        final MediaPlayer mp21 = MediaPlayer.create(mcontext, R.raw.u_for_underware);
        final MediaPlayer mp22 = MediaPlayer.create(mcontext, R.raw.v_for_vexniate);
        final MediaPlayer mp23 = MediaPlayer.create(mcontext, R.raw.w_for_worldwide);
        final MediaPlayer mp24 = MediaPlayer.create(mcontext, R.raw.x_for_xylephone);
        final MediaPlayer mp25 = MediaPlayer.create(mcontext, R.raw.y_for_yougrt);
        final MediaPlayer mp26 = MediaPlayer.create(mcontext, R.raw.z_for_zebra);

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
                    mp10.start();
                } else if (position == 10) {
                    mp11.start();
                } else if (position == 11) {
                    mp12.start();
                } else if (position == 12) {
                    mp13.start();
                } else if (position == 13) {
                    mp14.start();
                } else if (position == 14) {
                    mp15.start();
                } else if (position == 15) {
                    mp16.start();
                } else if (position == 16) {
                    mp17.start();
                } else if (position == 17) {
                    mp18.start();
                } else if (position == 18) {
                    mp19.start();
                } else if (position == 19) {
                    mp20.start();
                } else if (position == 20) {
                    mp21.start();
                } else if (position == 21) {
                    mp22.start();
                } else if (position == 22) {
                    mp23.start();
                } else if (position == 23) {
                    mp24.start();
                } else if (position == 24) {
                    mp25.start();
                } else if (position == 25) {
                    mp26.start();
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