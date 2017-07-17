package com.wahyuridiansyah.abrakadabra.quizActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.activity.HasilKuis;
import com.wahyuridiansyah.abrakadabra.helper.Question_Med;
import com.wahyuridiansyah.abrakadabra.helper.QuizHelperMedhayoh;

import java.util.List;

public class kuisMedhayoh extends AppCompatActivity {

    List<Question_Med> quesList;
    int score = 0;
    int qid=0;

    Question_Med currentQ;
    TextView pertanyaan,skor;
    Button jbA,jbB,jbC,jbD,jbE,jbF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_medhayoh);
        getSupportActionBar().setTitle("Medhayoh");

        QuizHelperMedhayoh db = new QuizHelperMedhayoh(this);

        quesList =db.getAllQuestion();
        currentQ=quesList.get(qid); //dari soal yg di input di QuizHelper
        pertanyaan=(TextView)findViewById(R.id.question_med);

        jbA=(Button)findViewById(R.id.a0_med);
        jbB=(Button)findViewById(R.id.a1_med);
        jbC=(Button)findViewById(R.id.a2_med);
        jbD=(Button)findViewById(R.id.a3_med);
        jbE=(Button)findViewById(R.id.a4_med);
        jbF=(Button)findViewById(R.id.a5_med);

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
        jbE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(jbE.getText().toString());
            }
        });
        jbF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(jbF.getText().toString());
            }
        });
    }

    private void QuestionView() {
        pertanyaan.setText(currentQ.getQUESTION());
        jbA.setText(currentQ.getOpsiA());
        jbB.setText(currentQ.getOpsiB());
        jbC.setText(currentQ.getOpsiC());
        jbD.setText(currentQ.getOpsiD());
        jbE.setText(currentQ.getOpsiE());
        jbF.setText(currentQ.getOpsiF());
        qid++;
    }

    private void getAnswer(String jawaban){
        if (currentQ.getANSWER().equals(jawaban)){
            score++;
        }else{
            Intent intent = new Intent(kuisMedhayoh.this,HasilKuis.class);
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
            Intent intent = new Intent(kuisMedhayoh.this,HasilKuis.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }

    }

