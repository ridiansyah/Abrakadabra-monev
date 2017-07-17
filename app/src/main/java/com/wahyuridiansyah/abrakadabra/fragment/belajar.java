package com.wahyuridiansyah.abrakadabra.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.adapter.belajarAdapter;
import com.wahyuridiansyah.abrakadabra.adapter.gamesLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wahyuridiansyah on 26/03/17.
 */
public class belajar extends Fragment {

    public belajar(){}
    protected Context context;
    RecyclerView recyclerView_belajar;
    private belajarAdapter adapter;
    private List<gamesLevel> gamesLevelList;


    public static belajar newInstance() {

        Bundle args = new Bundle();

        belajar fragment = new belajar();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview =inflater.inflate(R.layout.belajar, null);
        recyclerView_belajar= (RecyclerView)rootview.findViewById(R.id.recycler_view_belajar);
        getActivity().setTitle("Belajar");
        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gamesLevelList= new ArrayList<>();
        adapter= new belajarAdapter(getActivity(),gamesLevelList);
        belajar belajar = new belajar();

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView_belajar.setLayoutManager(layoutManager);
        recyclerView_belajar.addItemDecoration(new praktik.GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView_belajar.setItemAnimator(new DefaultItemAnimator());
        recyclerView_belajar.setAdapter(adapter);

        loadDataBelajar();
    }

    private void loadDataBelajar() {
        int gambar[]={
                R.drawable.salam,
                R.drawable.perkenalan,
                R.drawable.keluarga,
                R.drawable.alam,
                R.drawable.medhayoh,
                R.drawable.sekolah,
                R.drawable.nyampekno_pesan,
                R.drawable.kebiasaan,
        };

        String nama[]={
                "Salam","Ngendiken","Keluarga","Alam","Medhayoh","Sekolah","Nyampeken Pesan","Dolanan"
        };

        gamesLevel a = new gamesLevel(nama[0],gambar[0]);
        gamesLevelList.add(a);

        a = new gamesLevel(nama[1],gambar[1]);
        gamesLevelList.add(a);

        a = new gamesLevel(nama[2],gambar[2]);
        gamesLevelList.add(a);

        a = new gamesLevel(nama[3],gambar[3]);
        gamesLevelList.add(a);

        a = new gamesLevel(nama[4],gambar[4]);
        gamesLevelList.add(a);

        a = new gamesLevel(nama[5],gambar[5]);
        gamesLevelList.add(a);

        a = new gamesLevel(nama[6],gambar[6]);
        gamesLevelList.add(a);

        a = new gamesLevel(nama[7],gambar[7]);
        gamesLevelList.add(a);

        adapter.notifyDataSetChanged();
    }

    public int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}