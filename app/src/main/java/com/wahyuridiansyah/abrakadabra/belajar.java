package com.wahyuridiansyah.abrakadabra;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by wahyuridiansyah on 26/03/17.
 */
public class belajar extends Fragment {

    public belajar(){}
    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (RelativeLayout) inflater.inflate(R.layout.belajar, container, false);

        getActivity().setTitle("Belajar");

        return view;
    }
}