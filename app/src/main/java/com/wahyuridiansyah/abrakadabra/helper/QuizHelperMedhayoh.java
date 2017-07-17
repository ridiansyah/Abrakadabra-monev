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
 * Created by Andri Ginting on 4/24/2017.
 */

public class QuizHelperMedhayoh extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "soalMedhayoh";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_QUESTION="pertanyaan";
    private static final String KEY_ID="qID";
    private static final String KEY_QUESTION="pertanyaan";
    private static final String KEY_ANSWER ="jawaban";
    private static final String KEY_OPSIA ="opsiA";
    private static final String KEY_OPSIB ="opsiB";
    private static final String KEY_OPSIC ="opsiC";
    private static final String KEY_OPSID ="opsiD";
    private static final String KEY_OPSIE ="opsiE";
    private static final String KEY_OPSIF ="opsiF";


    private SQLiteDatabase dbase;
    public QuizHelperMedhayoh(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION+"("
                +KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_QUESTION
                +" TEXT, "+KEY_ANSWER+ " TEXT, "+KEY_OPSIA+ " TEXT, "+KEY_OPSIB
                +" TEXT, "+KEY_OPSIC+" TEXT, "+KEY_OPSID+" TEXT,"+KEY_OPSIE+" TEXT, "+KEY_OPSIF+" TEXT)";

        db.execSQL(sql);
        addQuestion_med();
    }
    private void addQuestion_med() {
        Question_Med q1 = new Question_Med("Sing perlu digatekake yen arep maradhayoh yaiku...","Glegeken","Tata Krama","Sopan","Turu","Watuk","Dhahar",
                "Tata Krama");
        this.addQuestion_med(q1);

        Question_Med q2 = new Question_Med("Mboten pareng maradhayoh ing wanci.... lan .... ","Glegeken","Tata Krama","Sopan","Turu","Watuk","Dhahar",
                "Turu");
        this.addQuestion_med(q2);

        Question_Med q3 = new Question_Med("Menawa dhahar mboten pareng .... utawa .... ing meja makan ","Glegeken","Tata Krama","Sopan","Turu","Watuk","Dhahar",
                "Watuk");
        this.addQuestion_med(q3);

        Question_Med q4 = new Question_Med("Senajan lagi nesu nanging yen pamitan kedah sing....","Glegeken","Tata Krama","Sopan","Turu","Watuk","Dhahar",
                "Sopan");
        this.addQuestion_med(q4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + TABLE_QUESTION);
        onCreate(db);
    }

    public void addQuestion_med(Question_Med qu){
        ContentValues values = new ContentValues();

        values.put(KEY_QUESTION,qu.getQUESTION());
        values.put(KEY_ANSWER,qu.getANSWER());

        values.put(KEY_OPSIA,qu.getOpsiA());
        values.put(KEY_OPSIB,qu.getOpsiB());
        values.put(KEY_OPSIC,qu.getOpsiC());
        values.put(KEY_OPSID,qu.getOpsiD());
        values.put(KEY_OPSIE,qu.getOpsiE());
        values.put(KEY_OPSIF,qu.getOpsiF());

        dbase.insert(TABLE_QUESTION,null,values);
    }

    public List<Question_Med> getAllQuestion(){
        List<Question_Med> quesList = new ArrayList<Question_Med>();

        String selectQuery = "SELECT * FROM "+TABLE_QUESTION;
        dbase= this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery,null);

        //memasukkan semua baris pada tabel kedalam array
        if (cursor.moveToFirst()){
            do {
                Question_Med quest = new Question_Med();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOpsiA(cursor.getString(3));
                quest.setOpsiB(cursor.getString(4));
                quest.setOpsiC(cursor.getString(5));
                quest.setOpsiD(cursor.getString(6));
                quest.setOpsiE(cursor.getString(7));
                quest.setOpsiF(cursor.getString(8));
                quesList.add(quest);
            }while(cursor.moveToNext()); //end of dowhile-looping
        }//end of if function
        Collections.shuffle(quesList);
        return quesList;
    }
}
