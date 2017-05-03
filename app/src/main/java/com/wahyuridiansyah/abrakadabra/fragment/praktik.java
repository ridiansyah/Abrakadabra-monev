package com.wahyuridiansyah.abrakadabra.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
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
import com.wahyuridiansyah.abrakadabra.adapter.gamesLevel;
import com.wahyuridiansyah.abrakadabra.adapter.kategoriAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wahyuridiansyah on 26/03/17.
 */
public class praktik extends Fragment implements View.OnClickListener{
    public praktik(){}
    private RecyclerView recyclerView;
    private kategoriAdapter adapter;
    private List<gamesLevel> gamesLevelList;
    protected Context context;

    public static praktik newInstance(){
        return new praktik();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.praktik,null);
        recyclerView=(RecyclerView)rootview.findViewById(R.id.recycler_view);
        getActivity().setTitle("Praktik");
        return rootview;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      gamesLevelList= new ArrayList<>();
        adapter= new kategoriAdapter(getActivity(),gamesLevelList);

        RecyclerView.LayoutManager mlayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        loadData();

    }

    public int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));
    }

    public void loadData(){

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
          "Salam","Perkenalan","Keluarga","Alam","Medhayoh","Sekolah","Nyampekno Pesan","Kebiasaan"
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

    @Override
    public void onClick(View v) {

    }


    public static class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            //super.getItemOffsets(outRect, view, parent, state);

            int position = parent.getChildAdapterPosition(view); //posisinya
            int column = position%spanCount; //kolomnya

            if (includeEdge){
                outRect.left=spacing-column*spacing/spanCount;
                outRect.right=(column+1)*spacing/spanCount;

                if (position<spanCount){
                    outRect.top=spacing;
                }
                outRect.bottom=spacing;
            }else{
                outRect.left=column*spacing/spanCount;
                outRect.right=spacing-(column-1)*spacing/spanCount;
                if (position>=spanCount){
                    outRect.top=spacing;
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}