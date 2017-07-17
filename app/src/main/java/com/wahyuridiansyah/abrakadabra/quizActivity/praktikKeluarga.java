package com.wahyuridiansyah.abrakadabra.quizActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.activity.HasilKuis;

public class praktikKeluarga extends AppCompatActivity {

    ImageView dashboard;
    EditText isi1, isi2, isi3, isi4, isi5, isi6;
    TextView pertanyaan;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praktik_keluarga);
        getSupportActionBar().setTitle("KUIS KELUARGA");

        dashboard = (ImageView) findViewById(R.id.image_kuis_keluarga);
        dashboard.setImageResource(R.drawable.back_kuis);

        pertanyaan = (TextView) findViewById(R.id.question_keluarga);
        isi1 = (EditText) findViewById(R.id.isi1);
        isi2 = (EditText) findViewById(R.id.isi2);
        isi3 = (EditText) findViewById(R.id.isi3);
        isi4 = (EditText) findViewById(R.id.isi4);
        isi5 = (EditText) findViewById(R.id.isi5);
        isi6 = (EditText) findViewById(R.id.isi6);

        next = (Button) findViewById(R.id.next_keluarga);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isi1.getText() == null) {
                    Toast.makeText(praktikKeluarga.this, "Masih ada yang kosong", Toast.LENGTH_SHORT);
                }else if(isi2.getText() == null) {
                    Toast.makeText(praktikKeluarga.this, "Masih ada yang kosong", Toast.LENGTH_SHORT);
                }else if(isi3.getText() == null) {
                    Toast.makeText(praktikKeluarga.this, "Masih ada yang kosong", Toast.LENGTH_SHORT);
                }else if(isi4.getText() == null) {
                    Toast.makeText(praktikKeluarga.this, "Masih ada yang kosong", Toast.LENGTH_SHORT);
                }else if(isi5.getText() == null) {
                    Toast.makeText(praktikKeluarga.this, "Masih ada yang kosong", Toast.LENGTH_SHORT);
                }else if(isi6.getText() == null) {
                    Toast.makeText(praktikKeluarga.this, "Masih ada yang kosong", Toast.LENGTH_SHORT);
                } else {
                    Bundle b = new Bundle();
                    Intent intent = new Intent(praktikKeluarga.this, HasilKuis.class);
                    b.putInt("score",8);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
