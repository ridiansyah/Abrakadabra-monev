package com.wahyuridiansyah.abrakadabra.quizActivity;

/**
 * Created by Andri Ginting on 4/24/2017.
 */

public class pertanyaanSekolah {
    String soal[]={
            "Menawa panjenengan arep menyang pekiwan?WC anngone matur",
            "Menawa nyuwun iji mlebu kelas jalaran telat, anggone matur",
            "Endi ukara kang unggah- ungguhe paling bener? ",

    };

    String opsiJawaban[][]={
            {"Pak kula ajeng teng WC sekedhap"," Pak nyuwun idin dhateng WC sekedhap"," Pak kula ajeng tindak WC sekedhap"," Pak badhe tindak dhateng WC sekedhap, matur nuwun"},
            {"Pak guru nyuwun sewu kula telat, menawi dipun keparengaken kula badhe ndherek pelajaran","Pak guru nyuwun sewu kula telat, yen oleh kula ajeng melu pelajaran","Pak guru nyuwun sewu kula telat, yen angsal kula ajeng tumut",
            "Pak guru nyuwun sewu kula telat, menawa angsal kula ajeng ndherek pelajaran"},
            {"Pak guru dereng dhateng","Pak guru dereng rawuh","Pak guru dereng dugi","Oak guru dereng teka"}
    };

    String jawabanBenar[]={
            " Pak badhe tindak dhateng WC sekedhap, matur nuwun",
            "Pak guru nyuwun sewu kula telat, menawi dipun keparengaken kula badhe ndherek pelajaran",
            "Pak guru dereng rawuh"

    };

    public int getLength() {
        return soal.length;
    }

    public String getPertanyaan(int a) {
        String pertanyaan = soal[1];
        return pertanyaan;
    }

    public String getPilihan(int index, int num) {
        String pilih = opsiJawaban[index][num - 1];
        return pilih;
    }

    public String getJawabanBenar(int a) {
        String jBenar = jawabanBenar[a];
        return jBenar;
    }

}
