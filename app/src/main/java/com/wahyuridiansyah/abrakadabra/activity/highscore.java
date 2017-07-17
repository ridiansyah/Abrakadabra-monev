package com.wahyuridiansyah.abrakadabra.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wahyuridiansyah.abrakadabra.R;

public class highscore extends AppCompatActivity {

    private TextView hs;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        getSupportActionBar().hide();

        hs = (TextView)findViewById(R.id.hs_nilai);
        back=(Button)findViewById(R.id.tmbl_back);

        Bundle b = new Bundle();
        Intent intent = getIntent();
        int sc = intent.getIntExtra("score",0);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        int score_hs=b.getInt("score");;
        score_hs=preferences.getInt("score",0);
        if (score_hs>=sc){
            hs.setText(""+score_hs*10);
        }else{
            hs.setText(""+sc*10);
            SharedPreferences.Editor editor = preferences.edit();
            editor.commit();
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(highscore.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
