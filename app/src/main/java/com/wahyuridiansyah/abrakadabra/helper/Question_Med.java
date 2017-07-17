package com.wahyuridiansyah.abrakadabra.helper;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Andri Ginting on 4/21/2017.
 */

public class Question_Med extends AppCompatActivity {
    private int ID;
    private String QUESTION;
    private String opsiA;
    private String opsiB;
    private String opsiC;
    private String opsiD;
    private String opsiE;
    private String opsiF;
    private String ANSWER;

    public Question_Med() {
        ID=0;
        QUESTION="";
        opsiA="";
        opsiB="";
        opsiC="";
        opsiD="";
        opsiE="";
        opsiF="";
        ANSWER="";
    }

    public Question_Med( String QUESTION, String opsiA, String opsiB, String opsiC, String opsiD,String opsiE,String opsiF, String ANSWER) {
        this.QUESTION = QUESTION;
        this.opsiA = opsiA;
        this.opsiB = opsiB;
        this.opsiC = opsiC;
        this.opsiD = opsiD;
        this.opsiE = opsiE;
        this.opsiF = opsiF;
        this.ANSWER = ANSWER;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public String getOpsiA() {
        return opsiA;
    }

    public void setOpsiA(String opsiA) {
        this.opsiA = opsiA;
    }

    public String getOpsiB() {
        return opsiB;
    }

    public void setOpsiB(String opsiB) {
        this.opsiB = opsiB;
    }

    public String getOpsiC() {
        return opsiC;
    }

    public void setOpsiC(String opsiC) {
        this.opsiC = opsiC;
    }

    public String getOpsiD() {
        return opsiD;
    }

    public void setOpsiD(String opsiD) {
        this.opsiD = opsiD;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }

    public String getOpsiE() {
        return opsiE;
    }

    public void setOpsiE(String opsiE) {
        this.opsiE = opsiE;
    }

    public String getOpsiF() {
        return opsiF;
    }

    public void setOpsiF(String opsiF) {
        this.opsiF = opsiF;
    }
}
