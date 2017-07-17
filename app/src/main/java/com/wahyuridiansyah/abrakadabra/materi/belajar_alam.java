package com.wahyuridiansyah.abrakadabra.materi;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.wahyuridiansyah.abrakadabra.R;

public class belajar_alam extends AppCompatActivity {

    ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_belajar_alam);

        gambar=(ImageView)findViewById(R.id.gmb_alam);
        gambar.setImageResource(R.drawable.alam1);
    }

}
