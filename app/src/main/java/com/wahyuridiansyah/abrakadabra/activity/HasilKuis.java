package com.wahyuridiansyah.abrakadabra.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wahyuridiansyah.abrakadabra.R;

public class HasilKuis extends AppCompatActivity {

    Button back;
    TextView skor_sementara,point;
    int hscore=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis);

        skor_sementara =(TextView)findViewById(R.id.skor_sementara);
        back= (Button)findViewById(R.id.kembali);
        point=(TextView)findViewById(R.id.point);

        Bundle b = getIntent().getExtras();
        SharedPreferences prefs = this.getSharedPreferences("highScore", Context.MODE_PRIVATE);
        int score = b.getInt("score");
        skor_sementara.setText(score*10+" pts");
        if (score<=30){
            point.setText("TERIMAKASIH DAN TETAP SEMANGAT ");
        }

         hscore = prefs.getInt("key",score);
        if(score>hscore){
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("key",score);
            editor.commit();
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HasilKuis.this,MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.icon_hs,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.highscore:

                Intent intent = new Intent(HasilKuis.this,highscore.class);
                intent.putExtra("score",hscore);
                startActivity(intent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
