package com.wahyuridiansyah.abrakadabra.model;

/**
 * Created by wahyuridiansyah on 17/05/17.
 */

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.activity.MainActivity;

public class belajarsekolah extends AppIntro {
    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        addSlide(AppIntro2Fragment.newInstance("SEKOLAH","Apa wae sing perlu digatekake marang guru ing sekolahan?",
                R.drawable.sekolah1, Color.parseColor("#b71c1c")));

        addSlide(AppIntro2Fragment.newInstance("","Yen ngomong kaliyan bapak/ibu guru kedah nganggo basa krama sing sopan. Jalaran bapak/ibu guru menika tiyah sepuh dados kedah diurmati.",
                R.drawable.sekolah2, Color.parseColor("#2962ff")));

        addSlide(AppIntro2Fragment.newInstance("","Fokus kaliyan materi ingkang disampekno guru ing kelas. Mboten pareng guneman kaliyan kancane piyambak.",
                R.drawable.sekolah3, Color.parseColor("#006064")));//

        addSlide(AppIntro2Fragment.newInstance("Nyuwun pangapura menawa telat mlebu kelas.","",
                R.drawable.sekolah4, Color.parseColor("#afb42b")));//

        addSlide(AppIntro2Fragment.newInstance("Nyuwun idin menawa badhe ten pekiwan/WC.","",
                R.drawable.sekolah5, Color.parseColor("#ff6f00")));//


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
