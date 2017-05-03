package com.wahyuridiansyah.abrakadabra;

import android.app.Activity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Andri Ginting on 4/5/2017.
 */

public class QuestionAlam extends Activity {
    BufferedReader bReader = null;
    static JSONArray quesList=null;


    public void loadQuestion() throws Exception{
        try{
            InputStream pertanyaan = this.getBaseContext()
                    .getResources()
                    .openRawResource(R.raw.materi1);
            bReader= new BufferedReader(new InputStreamReader(pertanyaan));
            StringBuilder quesString = new StringBuilder();

            String aJsonLine=null;

            while((aJsonLine=bReader.readLine()) !=null){
                quesString.append(aJsonLine);
            }

            //debugging untuk lihat prosesnya
            Log.d(this.getClass().toString(),quesString.toString());

            JSONObject quesObj = new JSONObject(quesString.toString());
            quesList=quesObj.getJSONArray("pertanyaan");

            Log.d(this.getClass().getName(),"banyak Pertanyaan"+quesList.length());
        }catch (Exception e){

        }finally {
            try{
                bReader.close();
            }catch (Exception e){
                Log.e("",e.getMessage().toString(),e.getCause());
            }
        }
    }

    public static JSONArray getQuesList(){
        return quesList;
    }

}
