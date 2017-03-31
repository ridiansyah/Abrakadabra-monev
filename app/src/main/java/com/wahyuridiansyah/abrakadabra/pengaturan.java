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
public class pengaturan extends Fragment {

    public pengaturan(){}
    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (RelativeLayout) inflater.inflate(R.layout.pengaturan, container, false);

        getActivity().setTitle("Pengaturan");

        return view;
    }
}