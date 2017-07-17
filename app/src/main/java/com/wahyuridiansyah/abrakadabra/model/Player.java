package com.wahyuridiansyah.abrakadabra.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andri Ginting on 4/18/2017.
 */

public class Player implements Parcelable {
    private final String mFirstname;
    private final String mLastIntial;

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel source) {
            return new Player(source);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    //override dari interface Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFirstname);
        dest.writeString(mLastIntial);
    }
    public Player(String namadepan, String inisial){
        mFirstname=namadepan;
        mLastIntial=inisial;
    }
    protected Player(Parcel source){
        mFirstname=source.readString();
        mLastIntial=source.readString();
    }

    public String getmFirstname() {
        return mFirstname;
    }

    public String getmLastIntial() {
        return mLastIntial;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o){
            return true;
        }
        if (o==null || getClass() != o.getClass()){
            return false;
        }

        Player player = (Player)o;
        if (!mFirstname.equals(player.mFirstname)){
            return  false;
        }
        if (!mLastIntial.equals(player.mLastIntial)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = mFirstname.hashCode();
        result = 31*result + mLastIntial.hashCode();
        return result;
    }
}
