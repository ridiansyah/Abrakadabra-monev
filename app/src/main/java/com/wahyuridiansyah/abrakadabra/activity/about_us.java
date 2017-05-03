package com.wahyuridiansyah.abrakadabra.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wahyuridiansyah.abrakadabra.R;

public class about_us extends Fragment {

    public about_us() {
    }

    private ImageView gbr1,gbr2,gbr3,gbr4,gbr5;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.activity_about_us,container,false);
        gbr1=(ImageView)view.findViewById(R.id.foto1_about);
        gbr2=(ImageView)view.findViewById(R.id.foto2_about);
        gbr3=(ImageView)view.findViewById(R.id.foto3_about);
        gbr4=(ImageView)view.findViewById(R.id.foto4_about);
        gbr5=(ImageView)view.findViewById(R.id.foto5_about);


        gbr1.setImageResource(R.drawable.amanda);
        gbr2.setImageResource(R.drawable.sipa);
        gbr3.setImageResource(R.drawable.lulu);
        gbr4.setImageResource(R.drawable.andri);
        gbr5.setImageResource(R.drawable.wahyu);
        return view;

    }




}
