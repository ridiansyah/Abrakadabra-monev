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
 * Created by Andri Ginting on 4/22/2017.
 */

public class QuizHelperKebiasaan extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "soalKebiasaan";
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

    public QuizHelperKebiasaan(Context context) {
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
        addQuestion_Kebiasaan();
    }

    //input pertanyaan
    private void addQuestion_Kebiasaan() {
        Question q1 = new Question("Don,ayo .... bakso ning warungne Bu Minten. \n Ukara kasebut diucapake kancane marang Doni. Titik-titik diiseni tembung","Tuku","Tumbas","Mundhut","nyuwun",
                "Tuku");
        this.addQuestion_Kebiasaan(q1);

        Question q2 = new Question("Eyang saweg ... jampi","Shahar","Ngunjuk","Nedha","Ngombe",
                "Ngunjuk");
        this.addQuestion_Kebiasaan(q2);

        Question q3 = new Question("Alex \t: Gus,kowe opo ora ngeleng karnaval?\n" +
                "Agus \t: Ora, akulagi aras-arasen metu\n" +
                "Alex \t: Aku pengen ndeleng, kancanana ya\n" +
                "Agus \t: Ya wis ayo \n" +
                "Ukara pachelaton ing dhuwur nggunakake basa ...","Ngoko lugu"," Ngoko andhap","Krama lugu","Krama alus",
                "Ngoko lugu");
        this.addQuestion_Kebiasaan(q3);

        Question q4 = new Question("Aku ndek wingi lunga menyang Surabaya numpak bis. \n" +
                "Ukara kasebut yen diowahi nganggo basa krama alus sing bener","Kula kala wingi tindak dhateng Surabaya numpak bis"," Kula kala wingi tindak dhateng Surabaya nitih bis",
                "Kula kala wingi kesah dhateng Surabaya numpak bis","Kula kala wingi kesah dhateng Surabaya nitih bis",
                "Kula kala wingi kesah dhateng Surabaya nitih bis");
        this.addQuestion_Kebiasaan(q4);

        Question q5 = new Question("Wah hebar, aku melu bungah kowe entuk juara 1 ing lomba maca geguritan! \n" +
                "Ukara iki lumrah diarani tatakrama kanggo...","Ngalem"," Sapa aruh","Nyuwun ngapura","Nyuwun idin",
                "Ngalem");
        this.addQuestion_Kebiasaan(q5);

        Question q6 = new Question("Bagus nalika ana toko buku ketemu karp Bu Retno gurune, anggone sapa aruh Bagus marang Bu Retno mangkene...","Sugeng sonten Bu Retno,badhe mundhut menapa bu?",
                "Sugeng sonten Bu Retno, ajeng tumbas napa bu?","Sugeng sonten Bu Retno, badhe napa niki?","Sugeng sonten Bu Retno, badhe tumbas napa bu?",
                "Sugeng sonten Bu Retno,badhe mundhut menapa bu?");
        this.addQuestion_Kebiasaan(q6);

        Question q7 = new Question("Ukara ing ngisor iki sing migunakake unggah-unggah basa sing bener yaiku..."," Panjenengan nedha menapa?"," Kula ngunjuk wedhang kopi"," Bapak sare wonten kamar","Pak Rais badhe tindhak pundi?",
                "Bapak sare wonten kamar");
        this.addQuestion_Kebiasaan(q7);

        Question q8 = new Question("Aku sakluwarga nalika lelungan menyang Yogja bingung, amarga papan dunung alamt sing bakal diparani during ngerti, mula in dalan aku takon marang wong kang ngerti papan iku. \n" +
                "Basa kang prayoga dienggo takon marang wong liyp yaiku... ","Krama","Krama alus","Krama andhap","ngoko lugu",
                "Krama");
        this.addQuestion_Kebiasaan(q8);

        Question q9 = new Question("Mas,sampeyan benjing diutus bapak dhateng Solo. Basa kang digunakake yaiku...","Krama","Krama alus","Krama andhap","ngoko lugu",
                "Krama");
        this.addQuestion_Kebiasaan(q9);

        Question q10 = new Question("Nalika bapak mulih, aku lagi budhal ngaji. Krama aluse mulih yaiku...","Bidal","tindak","kondur","lunga",
                "kondur");
        this.addQuestion_Kebiasaan(q10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + TABLE_QUESTION);
        onCreate(db);
    }

    public void addQuestion_Kebiasaan(Question qu){
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
