package com.wahyuridiansyah.abrakadabra.quizActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.activity.HasilKuis;

public class kuisSekolah extends AppCompatActivity {

    private TextView soal,poin;
    private Button a0,a1,a2,a3;

    private pertanyaanSekolah tanya = new pertanyaanSekolah();

    private int mScore = 0;
    private String mJawaban;
    private int noSoal=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_sekolah);
        getSupportActionBar().setTitle("Sekolah");

        soal = (TextView)findViewById(R.id.question_sekolah);
        a0=(Button)findViewById(R.id.a0_sekolah);
        a1=(Button)findViewById(R.id.a1_sekolah);
        a2=(Button)findViewById(R.id.a2_sekolah);
        a3=(Button)findViewById(R.id.a3_sekolah);
        poin =(TextView)findViewById(R.id.point_sekolah);
        updateSoalAlam();
    }

    private void updateSoalAlam() {
        if (noSoal<tanya.getLength()){
            soal.setText(tanya.getPertanyaan(noSoal));
            a0.setText(tanya.getPilihan(noSoal,1));
            a1.setText(tanya.getPilihan(noSoal,2));
            a2.setText(tanya.getPilihan(noSoal,3));
            a3.setText(tanya.getPilihan(noSoal,4));

            mJawaban=tanya.getJawabanBenar(noSoal);
            noSoal++;
        } else{
            Toast.makeText(kuisSekolah.this,"Praktik e Wes mari! ",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(kuisSekolah.this,HasilKuis.class);
            intent.putExtra("score",mScore);
            startActivity(intent);
            finish();
        }
    }

    public void Clicked_sekolah(View view) {
        Button answer = (Button)view;

        if (answer.getText() == mJawaban){
            mScore+=1;
        }else {
            updateScore(mScore);
            updateSoalAlam();
        }
    }

    private void updateScore(int mScore) {
        poin.setText(mScore+" pts");
    }
    }

