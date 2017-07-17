package com.wahyuridiansyah.abrakadabra;

/**
 * Created by Andri Ginting on 4/15/2017.
 */

public class PertanyaanKenalan {

    public PertanyaanKenalan() {
    }

    private String mPertanyaan[] = {
            "Amanda : Nuwun sewu, panjenengan namine sinten nggih?\n" +
                    "Andri : _______",
            "Wahyu : _______\n" +
                    "Lulu : Kula saking Gresik",
            "Syifa : _______ nami kula Syifa. Panjengan sinten?\n" +
                    "Andri : Kula Andri",
            "Silahkan mampir, basa kramane?"
    };

    private String mPilihan[][] = {
            {"Mboten semerap", "Nami kula Andri", "Kula saking Magelang", "Nuwun sewu"},
            {"Saking pundi?", "Niku sapa?", "Nami ne sinten?", "Ana pira?"},
            {"Sugeng Siyang", "Inggih", "Tepangaken", "Saking pundi?"},
            {"Matur suwun", "Kula semerap", "Mangga pinarak", "Nuwun sewi"}
    };

    private String jawaban_benar[] = {
            "Nami kula Andri",
            "Saking pundi?",
            "Tepangaken",
            "Mangga pinarak"
    };

    public String getPertanyaan(int pos) {
        String pertanyaan = mPertanyaan[pos];
        return pertanyaan;
    }

    public String getJawaban1(int pos) {
        String jawaban1 = mPilihan[pos][0];
        return jawaban1;
    }

    public String getJawaban2(int pos) {
        String jawaban2 = mPilihan[pos][1];
        return jawaban2;
    }

    public String getJawaban3(int pos) {
        String jawaban3 = mPilihan[pos][2];
        return jawaban3;
    }

    public String getJawaban4(int pos) {
        String jawaban3 = mPilihan[pos][3];
        return jawaban3;
    }

    public String getJawabanBenar(int pos) {
        String Jbenar = jawaban_benar[pos];
        return Jbenar;
    }
    public int getLength(){
        return mPertanyaan.length;
    }
}
