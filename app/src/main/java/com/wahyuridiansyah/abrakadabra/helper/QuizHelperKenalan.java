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
 * Created by Andri Ginting on 4/28/2017.
 */

public class QuizHelperKenalan extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "soalKenalan";
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

    public QuizHelperKenalan(Context context) {
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
        Question q1 = new Question("Amanda : Nuwun sewu, panjenengan namine sinten nggih?\n" +
                "Andri : _______","Mboten semerap", "Nami kula Andri", "Kula saking Magelang", "Nuwun sewu",
                "Nami kula Andri");
        this.addQuestion(q1);

        Question q2 = new Question("Wahyu : _______\n " +
                "Lulu : Kula saking Gresik","Saking pundi?", "Niku sapa?", "Nami ne sinten?", "Ana pira?",
                "Saking pundi?");
        this.addQuestion(q2);

        Question q3 = new Question("Syifa : _______ nami kula Syifa. Panjengan sinten?\n" +
                "Andri : Kula Andri","Sugeng Siyang", "Inggih", "Tepangaken", "Saking pundi?",
                "Tepangaken");
        this.addQuestion(q3);

        Question q4 = new Question("Silahkan mampir, basa kramane?","Matur suwun", "Kula semerap", "Mangga pinarak", "Nuwun sewi",
                "Mangga pinarak");
        this.addQuestion(q4);

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
