package com.wahyuridiansyah.abrakadabra.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.wahyuridiansyah.abrakadabra.R;

/**
 * Created by wahyuridiansyah on 26/03/17.
 */
public class pengenalan extends Fragment {

    public pengenalan() {
    }

    RelativeLayout view;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview=(RelativeLayout)inflater.inflate(R.layout.pengenalan, container, false);
        getActivity().setTitle("Pengenalan");
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        imageView =(ImageView)view.findViewById(R.id.image_pengenalan);
        imageView.setImageResource(R.drawable.hs_logo);
        super.onViewCreated(view, savedInstanceState);
    }
}
