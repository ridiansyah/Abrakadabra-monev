package com.wahyuridiansyah.abrakadabra;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class quizAlam extends AppCompatActivity {

    EditText tanya = null;
    RadioButton answer1 = null;
    RadioButton answer2 = null;
    RadioButton answer3 = null;
    RadioButton answer4 = null;
    RadioGroup answers = null;
    Button finish = null;
    //int pilihJawaban = -1;
    int indeksTanya = 0;
    //int numEvents = 0;
    int jawab[] = null;
    int jawabanBenar[] = null;
    boolean review = false;
    //Button next = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_alam);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RelativeLayout quizA = (RelativeLayout) findViewById(R.id.quizAlam);
        quizA.setVisibility(View.INVISIBLE);
        QuestionAlam alam=new QuestionAlam();
        try {
            alam.loadQuestion();
            tanya = (EditText) findViewById(R.id.question);
            answer1 = (RadioButton) findViewById(R.id.a0);
            answer2 = (RadioButton) findViewById(R.id.a1);
            answer3 = (RadioButton) findViewById(R.id.a2);
            answer4 = (RadioButton) findViewById(R.id.a3);
            answers = (RadioGroup) findViewById(R.id.answers);

            RadioGroup layoutTanya = (RadioGroup) findViewById(R.id.answers);
            Button finish = (Button) findViewById(R.id.finish);
            finish.setOnClickListener(nextListener);

            jawab = new int[QuestionAlam.getQuesList().length()];
            java.util.Arrays.fill(jawab, -1);

            jawabanBenar = new int[QuestionAlam.getQuesList().length()];
            java.util.Arrays.fill(jawabanBenar, -1);

            this.showQuestions(0, review);

            quizA.setVisibility(View.VISIBLE);
        } catch (Exception e) {
//            Log.e("", e.getMessage().toString(), e.getCause());
        }
    }

    private void showQuestions(int qIndex, boolean review) {
        try {
            JSONObject aQues = QuestionAlam.getQuesList().getJSONObject(qIndex);
            String quesValue = aQues.getString("pertanyaan");

            if (jawabanBenar[qIndex] == -1) {
                String jawaban_benar = aQues.getString("jawabanbenar");
                jawabanBenar[qIndex] = Integer.parseInt(jawaban_benar);
            }

            tanya.setText(quesValue.toCharArray(), 0, quesValue.length());
            answers.check(-1);
            answer1.setTextColor(Color.WHITE);
            answer2.setTextColor(Color.WHITE);
            answer3.setTextColor(Color.WHITE);
            answer4.setTextColor(Color.WHITE);

            JSONArray ListJawaban = aQues.getJSONArray("jawaban");
            String aJawaban = ListJawaban.getJSONObject(0).getString("jawaban");

            answer1.setText(aJawaban.toCharArray(), 0, aJawaban.length());
            aJawaban = ListJawaban.getJSONObject(1).getString("jawaban");

            answer2.setText(aJawaban.toCharArray(), 0, aJawaban.length());
            aJawaban = ListJawaban.getJSONObject(2).getString("jawaban");

            answer3.setText(aJawaban.toCharArray(), 0, aJawaban.length());
            aJawaban = ListJawaban.getJSONObject(3).getString("jawaban");

            answer4.setText(aJawaban.toCharArray(), 0, aJawaban.length());
            Log.d("", jawab[qIndex] + "");

            if (jawab[qIndex] == 0)
                answers.check(R.id.a0);
            if (jawab[qIndex] == 1)
                answers.check(R.id.a1);
            if (jawab[qIndex] == 2)
                answers.check(R.id.a2);
            if (jawab[qIndex] == 3)
                answers.check(R.id.a3);

            setScore();

            if (indeksTanya == (QuestionAlam.getQuesList().length() - 1))
                finish.setEnabled(false);

            if (indeksTanya < (QuestionAlam.getQuesList().length() - 1))
                finish.setEnabled(true);

            if (review) {
                Log.d("review", jawab[qIndex] + "" + jawabanBenar[qIndex]);
                if (jawab[qIndex] != jawabanBenar[qIndex]) {
                    if (jawab[qIndex] == 0)
                        answer1.setTextColor(Color.RED);
                    if (jawab[qIndex] == 1)
                        answer1.setTextColor(Color.RED);
                    if (jawab[qIndex] == 2)
                        answer1.setTextColor(Color.RED);
                    if (jawab[qIndex] == 3)
                        answer1.setTextColor(Color.RED);
                }

                if (jawabanBenar[qIndex]==0)
                    answer1.setTextColor(Color.BLUE);
                if (jawabanBenar[qIndex]==1)
                    answer1.setTextColor(Color.BLUE);
                if (jawabanBenar[qIndex]==2)
                    answer1.setTextColor(Color.BLUE);
                if (jawabanBenar[qIndex]==3)
                    answer1.setTextColor(Color.BLUE);
            }

        } catch (JSONException e) {
            Log.e(this.getClass().toString(),e.getMessage(),e.getCause());
        }
    }

    private View.OnClickListener finishListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setJawaban();

            int skor = 0;
            for (int i=0; i<jawabanBenar.length;i++){
                if ((jawabanBenar[i] != -1) && (jawabanBenar[i]==jawab[i]))
                        skor++;
            }
        }
    };

    private View.OnClickListener nextListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setJawaban();
            indeksTanya++;
            if (indeksTanya >= QuestionAlam.getQuesList().length())
                indeksTanya = QuestionAlam.getQuesList().length()-1;

            showQuestions(indeksTanya,review);
        }
    };

    private void setJawaban() {
        if (answer1.isChecked())
            jawab[indeksTanya]=0;
        if (answer2.isChecked())
            jawab[indeksTanya]=1;
        if (answer3.isChecked())
            jawab[indeksTanya]=2;
        if (answer4.isChecked())
            jawab[indeksTanya]=3;

        Log.d("",Arrays.toString(jawab));
        Log.d("",Arrays.toString(jawabanBenar));
    }

    private void setScore() {
        this.setTitle("Kamu Menjawab " + (indeksTanya + 1) + "/ " + QuestionAlam.getQuesList().length());
    }
}
