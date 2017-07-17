package com.wahyuridiansyah.abrakadabra.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.wahyuridiansyah.abrakadabra.model.Player;

/**
 * Created by Andri Ginting on 4/18/2017.
 */

//masih rencana untuk buat login pake sharedpreferences
public class PreferencesHelp {

    private static final String PLAYER_PREFERENCES = "playepreferences";
    private static final String PREFERENCES_NAMA_DEPAN=PLAYER_PREFERENCES+ ".firstName";
    private static final String PREFERENCES_NAMA_BELAKANG=PLAYER_PREFERENCES +".lastInitial";

    private PreferencesHelp(){
        //kosongan
    }

    public static void writeToPreferences(Context context, Player player){
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_NAMA_DEPAN,player.getmFirstname());
        editor.putString(PREFERENCES_NAMA_BELAKANG,player.getmLastIntial());
    }

    public static Player getPlayer (Context context){
        /*untuk cek preferences. udah ada yg login apa belum
         */
        SharedPreferences preferences = getSharedPreferences(context);
            final String firstname = preferences.getString(PREFERENCES_NAMA_DEPAN,null);
            final String lastInitial = preferences.getString(PREFERENCES_NAMA_BELAKANG,null);

            if (null == firstname || null == lastInitial){
                return null;
            }
            return new Player(firstname,lastInitial);
        }

    public static void SignOut(Context context){
        SharedPreferences.Editor editor = getEditor(context);
        editor.remove(PREFERENCES_NAMA_DEPAN);
        editor.remove(PREFERENCES_NAMA_BELAKANG);
        editor.apply();
    }

    public static boolean isSignedIn(Context context){
        final SharedPreferences preferences = getSharedPreferences(context);
            return preferences.contains(PREFERENCES_NAMA_BELAKANG)
                    && preferences.contains(PREFERENCES_NAMA_BELAKANG);

    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return  preferences.edit();
    }


    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PLAYER_PREFERENCES,Context.MODE_PRIVATE);
    }
}
