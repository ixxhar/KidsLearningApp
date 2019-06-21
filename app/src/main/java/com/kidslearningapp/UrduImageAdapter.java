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

public class UrduImageAdapter extends PagerAdapter {

    private Context mcontext;
    private LayoutInflater layoutInflater;

    private int[] myImages = new int[]{R.raw.aama, R.raw.alif_anaar, R.raw.ballaa,
            R.raw.tay_titli, R.raw.tay_tamatar, R.raw.say_soar, R.raw.jeem_juta,
            R.raw.chay_choonti, R.raw.hey_hukka, R.raw.khey_kharbooza, R.raw.daal_darakht, R.raw.daal_dakiya, R.raw.zaal_zohaab,
            R.raw.ray_riksaw, R.raw.zey_zebra, R.raw.seen_cyclee, R.raw.sheen_shaljam, R.raw.suad_saabun,
            R.raw.toen_tota, R.raw.zuen_zaroof, R.raw.ain_imaarat, R.raw.ghain_gulail, R.raw.fey_frok,
            R.raw.kaaf_kainchi, R.raw.kaaf_kitaab, R.raw.gaaf_guriya, R.raw.laam_limu, R.raw.meem_machli,
            R.raw.noon_nul, R.raw.hey_helicopter, R.raw.wao_warzish, R.raw.yay_yasmeen,};

    private String[] myNames = new String[]{"aama", "alif_anaar", "ballaa",
            "tay_titli", "tay_tamatar", "say_soar", "jeem_juta", "chay_choonti",
            "hey_hukka", "khey_kharbooza", "daal_darakht", "daal_dakiya", "zaal_zohaab", "ray_riksaw",
            "zey_zebra", "seen_cyclee", "sheen_shaljam", "suad_saabun", "toen_tota", "zuen_zaroof",
            "ain_imaarat", "ghain_gulail", "fey_frok", "kaaf_kainchi", "kaaf_kitaab", "gaaf_guriya", "laam_limu", "meem_machli",
            "noon_nul", "hey_helicopter", "wao_warzish", "yay_yasmeen"};


    UrduImageAdapter(Context context) {
        mcontext = context;
    }

    @Override
    public int getCount() {

        return myImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
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


        final MediaPlayer mp1 = MediaPlayer.create(mcontext, R.raw.aam);
        final MediaPlayer mp2 = MediaPlayer.create(mcontext, R.raw.anaaar);
        final MediaPlayer mp3 = MediaPlayer.create(mcontext, R.raw.balla);
        final MediaPlayer mp4 = MediaPlayer.create(mcontext, R.raw.titli);
        final MediaPlayer mp5 = MediaPlayer.create(mcontext, R.raw.tamatar);
        final MediaPlayer mp6 = MediaPlayer.create(mcontext, R.raw.soar);
        final MediaPlayer mp7 = MediaPlayer.create(mcontext, R.raw.juta);
        final MediaPlayer mp8 = MediaPlayer.create(mcontext, R.raw.choonti);
        final MediaPlayer mp9 = MediaPlayer.create(mcontext, R.raw.hukka);
        final MediaPlayer mp10 = MediaPlayer.create(mcontext, R.raw.kharbooza);
        final MediaPlayer mp11 = MediaPlayer.create(mcontext, R.raw.drkht);
        final MediaPlayer mp12 = MediaPlayer.create(mcontext, R.raw.dakiya);
        final MediaPlayer mp13 = MediaPlayer.create(mcontext, R.raw.zohaab);
        final MediaPlayer mp14 = MediaPlayer.create(mcontext, R.raw.riksha);
        final MediaPlayer mp15 = MediaPlayer.create(mcontext, R.raw.zebraa);
        final MediaPlayer mp16 = MediaPlayer.create(mcontext, R.raw.cycle);
        final MediaPlayer mp17 = MediaPlayer.create(mcontext, R.raw.shaljam);
        final MediaPlayer mp18 = MediaPlayer.create(mcontext, R.raw.saabun);
        final MediaPlayer mp19 = MediaPlayer.create(mcontext, R.raw.tota);
        final MediaPlayer mp20 = MediaPlayer.create(mcontext, R.raw.zaroof);
        final MediaPlayer mp21 = MediaPlayer.create(mcontext, R.raw.imaarat);
        final MediaPlayer mp22 = MediaPlayer.create(mcontext, R.raw.gulail);
        final MediaPlayer mp23 = MediaPlayer.create(mcontext, R.raw.frok);
        final MediaPlayer mp24 = MediaPlayer.create(mcontext, R.raw.kainchi);
        final MediaPlayer mp25 = MediaPlayer.create(mcontext, R.raw.kitaab);
        final MediaPlayer mp26 = MediaPlayer.create(mcontext, R.raw.guriya);
        final MediaPlayer mp27 = MediaPlayer.create(mcontext, R.raw.limu);
        final MediaPlayer mp28 = MediaPlayer.create(mcontext, R.raw.machli);
        final MediaPlayer mp29 = MediaPlayer.create(mcontext, R.raw.nullll);
        final MediaPlayer mp30 = MediaPlayer.create(mcontext, R.raw.helicopter);
        final MediaPlayer mp31 = MediaPlayer.create(mcontext, R.raw.warzish);
        final MediaPlayer mp32 = MediaPlayer.create(mcontext, R.raw.yasmeen);

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
                } else if (position == 26) {
                    mp27.start();
                } else if (position == 27) {
                    mp28.start();
                } else if (position == 28) {
                    mp29.start();
                } else if (position == 29) {
                    mp30.start();
                } else if (position == 30) {
                    mp31.start();
                } else if (position == 31) {
                    mp32.start();
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