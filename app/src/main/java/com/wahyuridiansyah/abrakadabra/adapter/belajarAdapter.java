package com.wahyuridiansyah.abrakadabra.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wahyuridiansyah.abrakadabra.App;
import com.wahyuridiansyah.abrakadabra.ItemClickListener;
import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.materi.belajar_alam;
import com.wahyuridiansyah.abrakadabra.materi.belajar_kebiasaan;
import com.wahyuridiansyah.abrakadabra.materi.belajar_medhayoh;
import com.wahyuridiansyah.abrakadabra.materi.belajar_nyampeknopesan;
import com.wahyuridiansyah.abrakadabra.materi.belajar_perkenalan;
import com.wahyuridiansyah.abrakadabra.model.belajarSalam;
import com.wahyuridiansyah.abrakadabra.model.belajarKeluarga;
import com.wahyuridiansyah.abrakadabra.model.belajarsekolah;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andri Ginting on 4/13/2017.
 */

public class belajarAdapter extends RecyclerView.Adapter<belajarAdapter.MyViewHolder> {
    Context mContext = App.getMainContext();
    private List<gamesLevel> kategoriList;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView judul;
        public ImageView gambar_games;
        private ItemClickListener itemClickListener;
        ArrayList<gamesLevel> contact = new ArrayList<gamesLevel>();

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            judul = (TextView) itemView.findViewById(R.id.nama_kategori_belajar);
            gambar_games = (ImageView) itemView.findViewById(R.id.gambar_card_belajar);
        }

        @Override
        public void onClick(View v) {
            final int position = getAdapterPosition();
            gambar_games.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d("Position",""+position);
                }
            });
        }
    }


    public belajarAdapter(Context context, List<gamesLevel> gamesLevels) {
        this.mContext = context;
        this.kategoriList = gamesLevels;
    }

    @Override
    public belajarAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.belajar_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(belajarAdapter.MyViewHolder holder, final int position) {
        gamesLevel level = kategoriList.get(position);
        holder.judul.setText(level.getNama());
        Log.e("error_context", String.valueOf(mContext));
        Glide.with(mContext.getApplicationContext()).load(level.getGambar()).into(holder.gambar_games);
        holder.gambar_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0){
                    Intent coba = new Intent(mContext,belajarSalam.class);
                    mContext.startActivity(coba);
                }else if(position==1){
                    Intent coba1 = new Intent(mContext, belajar_perkenalan.class);
                    mContext.startActivity(coba1);
                }else if(position==3){
                    Intent coba1 = new Intent(mContext, belajar_alam.class);
                    mContext.startActivity(coba1);
                }
                else if(position==2){
                    Intent coba1 = new Intent(mContext, belajarKeluarga.class);
                    mContext.startActivity(coba1);
                }else if(position==5){
                    Intent coba1 =  new Intent(mContext, belajarsekolah.class);
                    mContext.startActivity(coba1);
                }
                else if(position==4){
                    Intent coba1 = new Intent(mContext, belajar_medhayoh.class);
                    mContext.startActivity(coba1);
                }
                else if(position==7){
                    Intent coba1 = new Intent(mContext, belajar_kebiasaan.class);
                    mContext.startActivity(coba1);
                }else if(position==6){
                    Intent coba1 = new Intent(mContext, belajar_nyampeknopesan.class);
                    mContext.startActivity(coba1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return kategoriList.size();
    }
}
