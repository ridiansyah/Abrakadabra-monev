package com.wahyuridiansyah.abrakadabra.model;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.activity.MainActivity;


public class belajarSalam extends AppIntro {
    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        addSlide(AppIntro2Fragment.newInstance("Sugeng Injing !","Selamat Pagi ! ",
                R.drawable.pagi, Color.parseColor("#5c6bc0")));
        addSlide(AppIntro2Fragment.newInstance("Sugeng Siyang !","Selamat Siang ! ",
                R.drawable.siang, Color.parseColor("#26c6da")));

        addSlide(AppIntro2Fragment.newInstance("Sugeng Sonten !","Selamat Sore ! ",
                R.drawable.sore, Color.parseColor("#66bb6a")));//
        addSlide(AppIntro2Fragment.newInstance("Sugeng Ndalu !","Selamat Malam ! ",
                R.drawable.malam, Color.parseColor("#4527a0")));//

        addSlide(AppIntro2Fragment.newInstance("Sugeng Rawuh !","Selamat Datang ! ",
                R.drawable.halo, Color.parseColor("#7e57c2")));
        addSlide(AppIntro2Fragment.newInstance("Sugeng Tindhak !","Selamat Jalan ! ",
                R.drawable.malam, Color.parseColor("#ab47bc")));

        addSlide(AppIntro2Fragment.newInstance("Sugeng Makaraya !","Selamat Bekerja ! ",
                R.drawable.kerja, Color.parseColor("#ef5350")));
        addSlide(AppIntro2Fragment.newInstance("Sugeng Sare !","Selamat Tidur ! ",
                R.drawable.tidur, Color.parseColor("#29b6f6")));

        addSlide(AppIntro2Fragment.newInstance("Sugeng Ambal Warsa !","Selamat Ulang Tahun ! ",
                R.drawable.ultah, Color.parseColor("#26a69a")));
        addSlide(AppIntro2Fragment.newInstance("Sugeng Warsa Enggal !","Selamat Tahun Baru ! ",
                R.drawable.taunbaru, Color.parseColor("#78909c")));

        addSlide(AppIntro2Fragment.newInstance("Sugeng Dahar !","Selamat Makan ! ",
                R.drawable.makan, Color.parseColor("#9ccc65")));
        addSlide(AppIntro2Fragment.newInstance("Sugeng Ngunjuk !","Selamat Minum ! ",
                R.drawable.minum, Color.parseColor("#d4e157")));

        addSlide(AppIntro2Fragment.newInstance("Mangga Lenggah !","Selamat Duduk ! ",
                R.drawable.duduk, Color.parseColor("#ffee58")));
        addSlide(AppIntro2Fragment.newInstance("Sugeng Midangetaken !","Selamat Mendengarkan ! ",
                R.drawable.dengar, Color.parseColor("#ffca28")));

        //showStatusBar(false);
        setBarColor(Color.parseColor("#333639"));
        setSeparatorColor(Color.parseColor("#2196f3"));
    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onSlideChanged() {
    }


}
