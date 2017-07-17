package com.wahyuridiansyah.abrakadabra.quizActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.activity.HasilKuis;
import com.wahyuridiansyah.abrakadabra.helper.Question;
import com.wahyuridiansyah.abrakadabra.helper.QuizHelper;

import java.util.List;

public class KuisSalam extends AppCompatActivity {

    List<Question>quesList;
    int score = 0;
    int qid=0;

    Question currentQ;
    TextView pertanyaan,skor;
    Button jbA,jbB,jbC,jbD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_salam);
        getSupportActionBar().setTitle("KUIS SALAM");


        QuizHelper db = new QuizHelper(this);

        quesList =db.getAllQuestion();
        currentQ=quesList.get(qid); //dari soal yg di input di QuizHelper
        pertanyaan=(TextView)findViewById(R.id.pertanyaan_salam);
        skor=(TextView)findViewById(R.id.score_salam);

        jbA=(Button)findViewById(R.id.ans1_salam);
        jbB=(Button)findViewById(R.id.ans2_salam);
        jbC=(Button)findViewById(R.id.ans3_salam);
        jbD=(Button)findViewById(R.id.ans4_salam);

        QuestionView();

        jbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(jbA.getText().toString());
            }
        });
        jbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(jbB.getText().toString());
            }
        });
        jbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(jbC.getText().toString());
            }
        });
        jbD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(jbD.getText().toString());
            }
        });
    }

    private void QuestionView() {
        pertanyaan.setText(currentQ.getQUESTION());
        jbA.setText(currentQ.getOpsiA());
        jbB.setText(currentQ.getOpsiB());
        jbC.setText(currentQ.getOpsiC());
        jbD.setText(currentQ.getOpsiD());
        qid++;
    }

    private void getAnswer(String jawaban){
        if (currentQ.getANSWER().equals(jawaban)){
            score++;
            skor.setText("Nilai "+score+" pts");
        }else{
            Intent intent = new Intent(KuisSalam.this,HasilKuis.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }

        if (qid<quesList.size()){
            currentQ=quesList.get(qid);
            QuestionView();
        }else{
            Intent intent = new Intent(KuisSalam.this,HasilKuis.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }
}
