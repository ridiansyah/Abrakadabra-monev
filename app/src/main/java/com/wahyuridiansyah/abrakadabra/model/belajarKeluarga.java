package com.wahyuridiansyah.abrakadabra.model;

/**
 * Created by wahyuridiansyah on 08/05/17.
 */
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.activity.MainActivity;

public class belajarKeluarga extends AppIntro {
    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        addSlide(AppIntro2Fragment.newInstance("KELUARGA","",
                R.drawable.keluarga1, Color.parseColor("#cddc39")));

        addSlide(AppIntro2Fragment.newInstance("Nami Kulo Andri Suranta","",
                R.drawable.keluarga2, Color.parseColor("#2196f3")));

        addSlide(AppIntro2Fragment.newInstance("Romo Kula Asmane Slamet Hartono","Romo Makarya Ing Kantor Kelurahan",
                R.drawable.keluarga3, Color.parseColor("#d32f2f")));//

        addSlide(AppIntro2Fragment.newInstance("Ibu Kula Asmane Fenita Arie","Ibu Sadean Sekul Ing Griya",
                R.drawable.keluarga4, Color.parseColor("#00796b")));//

        addSlide(AppIntro2Fragment.newInstance("Kulo Nggadah Dulur Kalih,","Ingkang Setunggal Jaler Setunggal Estri",
                R.drawable.keluarga5, Color.parseColor("#66bb6a")));

        addSlide(AppIntro2Fragment.newInstance("Kula Sakniki Kelas Kalih Ing SMPN 13 Malang","",
                R.drawable.keluarga6, Color.parseColor("#5c6bc0")));

        addSlide(AppIntro2Fragment.newInstance("Griya Kula Wonten Jl. Sumbersari, Malang","",
                R.drawable.keluarga7, Color.parseColor("#8d6e63")));


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
