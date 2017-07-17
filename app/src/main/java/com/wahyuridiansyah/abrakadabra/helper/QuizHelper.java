package com.wahyuridiansyah.abrakadabra.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andri Ginting on 4/21/2017.
 */

public class QuizHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "soalSalam";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_QUESTION="pertanyaan";
    private static final String KEY_ID="qID";
    private static final String KEY_QUESTION="pertanyaan";
    private static final String KEY_ANSWER ="jawaban";
    private static final String KEY_OPSIA ="opsiA";
    private static final String KEY_OPSIB ="opsiB";
    private static final String KEY_OPSIC ="opsiC";
    private static final String KEY_OPSID ="opsiD";

    private SQLiteDatabase dbase;

    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION+"("
                +KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_QUESTION
                +" TEXT, "+KEY_ANSWER+ " TEXT, "+KEY_OPSIA+ " TEXT, "+KEY_OPSIB
                +" TEXT, "+KEY_OPSIC+" TEXT, "+KEY_OPSID+" TEXT)";

        db.execSQL(sql);
        addQuestion();
    }

    //input pertanyaan
    private void addQuestion() {
        Question q1 = new Question("Syifa ketemu Bu Lulu ing sekolahan jam 7 isuk. Anggone Syifa matur...","Sugeng Enjing","Sugeng Sonten","Sugeng Sare","Sugeng Rawuh",
                "Sugeng Enjing");
        this.addQuestion(q1);

        Question q2 = new Question("Dinten niki tanggal 1 Januari 2018. Wahyu matur...","Sugeng Dahar","Sugeng Sonten","Sugeng Emjing", "Sugeng Warsa Enggal",
                "Sugeng Warsa Enggal");
        this.addQuestion(q2);

        Question q3 = new Question("Si mbah rawuh saka Malang. Ibuk matur...","Sugeng Rawuh"," Sungeng Lenggah"," Sugeng Siyang","Sugeng Dahar",
                "Sugeng Rawuh");
        this.addQuestion(q3);

        Question q4 = new Question("Bapak badhe tindhak makarya. Adhik matur...","Sugeng Enjing","Sugeng Makarya","Sugeng Midangetaken","Sugeng Tanggap",
                "Sugeng Makarya");
        this.addQuestion(q4);

        Question q5 = new Question("Mbak Mandha badhe sare. Dhik Syifa matur...","Sugeng Rawuh","Sugeng Sonten","Sugeng Sare","Sugeng Ngunjuk",
                "Sugeng Sare");
        this.addQuestion(q5);

        Question q6 = new Question("Bapak badhe dahar. Ibuk matur...","Sugeng Dahar","Sugeng Rawuh","Sugeng Tindhak","Sugeng Ndalu",
                "Sugeng Dahar");
        this.addQuestion(q6);

        Question q7 = new Question("Adhik maringi ibu radio. Adhik matur...","Sugeng sare","Sugeng Sonten","Sugeng Midangetaken","Sugeng Warsa Enggal",
                "Sugeng Midangetaken");
        this.addQuestion(q7);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + TABLE_QUESTION);
        onCreate(db);
    }

    public void addQuestion(Question qu){
        ContentValues values = new ContentValues();

        values.put(KEY_QUESTION,qu.getQUESTION());
        values.put(KEY_ANSWER,qu.getANSWER());

        values.put(KEY_OPSIA,qu.getOpsiA());
        values.put(KEY_OPSIB,qu.getOpsiB());
        values.put(KEY_OPSIC,qu.getOpsiC());
        values.put(KEY_OPSID,qu.getOpsiD());

        dbase.insert(TABLE_QUESTION,null,values);
    }

    public List<Question> getAllQuestion(){
        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT * FROM "+TABLE_QUESTION;
        dbase= this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery,null);

        //memasukkan semua baris pada tabel kedalam array
        if (cursor.moveToFirst()){
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOpsiA(cursor.getString(3));
                quest.setOpsiB(cursor.getString(4));
                quest.setOpsiC(cursor.getString(5));
                quest.setOpsiD(cursor.getString(6));
                quesList.add(quest);
            }while(cursor.moveToNext()); //end of dowhile-looping
        }//end of if function
        Collections.shuffle(quesList);
        return quesList;
    }
}
