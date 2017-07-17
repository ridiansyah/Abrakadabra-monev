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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wahyuridiansyah.abrakadabra.ItemClickListener;
import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.activity.MainActivity;
import com.wahyuridiansyah.abrakadabra.quizActivity.KuisSalam;
import com.wahyuridiansyah.abrakadabra.quizActivity.kuisKebiasaan;
import com.wahyuridiansyah.abrakadabra.quizActivity.kuisMedhayoh;
import com.wahyuridiansyah.abrakadabra.quizActivity.kuisPesan;
import com.wahyuridiansyah.abrakadabra.quizActivity.kuisSekolah;
import com.wahyuridiansyah.abrakadabra.quizActivity.praktikAlam;
import com.wahyuridiansyah.abrakadabra.quizActivity.praktikKeluarga;
import com.wahyuridiansyah.abrakadabra.quizActivity.praktikPerkenalan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andri Ginting on 4/2/2017.
 */
public class kategoriAdapter extends RecyclerView.Adapter<kategoriAdapter.MyViewHolder> {

    private List<gamesLevel> kategoriList;
    Context mContext = MainActivity.getmContext();

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView judul;
        public ImageView gambar_games;
        private ItemClickListener itemClickListener;

        Context ctx;
        ArrayList<gamesLevel> contact = new ArrayList<gamesLevel>();

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            judul = (TextView) itemView.findViewById(R.id.nama_kategori_games);
            gambar_games = (ImageView) itemView.findViewById(R.id.gambar_card_games);


        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getLayoutPosition());
            final int position = getLayoutPosition();}

        public void setOnClickListen(ItemClickListener ic) {
            this.itemClickListener = ic;
        }
    }


    public kategoriAdapter(Context context, List<gamesLevel> gamesLevels) {
        mContext = context;
        this.kategoriList = gamesLevels;
    }

    @Override
    public kategoriAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kategori_card, null);
        kategoriAdapter.MyViewHolder holder = new kategoriAdapter.MyViewHolder(itemView);
        return holder;
        //return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(kategoriAdapter.MyViewHolder holder, final int position) {
        gamesLevel level = kategoriList.get(position);
        holder.judul.setText(level.getNama());
        Glide.with(mContext).load(level.getGambar()).into(holder.gambar_games);
        Log.e("error_contextAdapter", String.valueOf(mContext));
        holder.gambar_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0){
                    Intent coba = new Intent(mContext,KuisSalam.class);
                    mContext.startActivity(coba);
                    Toast.makeText(v.getContext(),"Ayo mulai saiki",Toast.LENGTH_SHORT).show();
                }else if(position==1){
                    Intent coba1 = new Intent(mContext, praktikPerkenalan.class);
                    mContext.startActivity(coba1);
                    Toast.makeText(v.getContext(), "Ayo Mulai saiki", Toast.LENGTH_SHORT).show();
                }else if(position==2){
                    Intent coba1 = new Intent(mContext, praktikKeluarga.class);
                    mContext.startActivity(coba1);
                    Toast.makeText(v.getContext(), "Ayo mulai saiki", Toast.LENGTH_SHORT).show();
                }
                else if(position==3){
                    Intent coba1 = new Intent(mContext, praktikAlam.class);
                    mContext.startActivity(coba1);
                    Toast.makeText(v.getContext(), "Ayo mulai saiki", Toast.LENGTH_LONG).show();
                }else if(position==4){
                    Intent coba1 = new Intent(mContext, kuisMedhayoh.class);
                    mContext.startActivity(coba1);
                    Toast.makeText(v.getContext(), "Ayo mulai saiki", Toast.LENGTH_LONG).show();
                }
                else if(position==5){
                    Intent coba1 = new Intent(mContext, kuisSekolah.class);
                    mContext.startActivity(coba1);
                    Toast.makeText(v.getContext(), "Ayo mulai saiki", Toast.LENGTH_LONG).show();
                }
                else if(position==6){
                    Intent coba1 = new Intent(mContext, kuisPesan.class);
                    mContext.startActivity(coba1);
                    Toast.makeText(v.getContext(), "Ayo mulai saiki", Toast.LENGTH_LONG).show();
                }
                else if(position==7){
                    Intent coba1 = new Intent(mContext, kuisKebiasaan.class);
                    mContext.startActivity(coba1);
                    Toast.makeText(v.getContext(), "Ayo mulai saiki", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return kategoriList.size();
    }
}


