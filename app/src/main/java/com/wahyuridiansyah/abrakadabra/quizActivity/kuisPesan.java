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
import com.wahyuridiansyah.abrakadabra.helper.QuizHelperKenalan;

import java.util.List;

public class kuisPesan extends AppCompatActivity {
    List<Question> quesList;
    int score = 0;
    int qid=0;

    Question currentQ;
    TextView pertanyaan;
    Button jbA,jbB,jbC,jbD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_pesan);

        QuizHelperKenalan db = new QuizHelperKenalan(this);



        quesList =db.getAllQuestion();
        currentQ=quesList.get(qid); //dari soal yg di input di QuizHelper
        pertanyaan=(TextView)findViewById(R.id.question_pesan);

        jbA=(Button)findViewById(R.id.a0_pesan);
        jbB=(Button)findViewById(R.id.a1_pesan);
        jbC=(Button)findViewById(R.id.a2_pesan);
        jbD=(Button)findViewById(R.id.a3_pesan);
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
        }else{
            Intent intent = new Intent(kuisPesan.this,HasilKuis.class);
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
            Intent intent = new Intent(kuisPesan.this,HasilKuis.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }
    }

