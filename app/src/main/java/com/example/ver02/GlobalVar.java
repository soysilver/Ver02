package com.example.ver02;

import static java.lang.Integer.parseInt;

import android.app.Application;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GlobalVar extends Application {
    String ID="실패";
    int Age = 0;
    String Gender ="Fail";
    int Hand = 0;
    int Tempo = 60;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;

    int sum = 60;
    int mean = 60;
    int per = 60;

    int btn1=0;
    int btn2=0;
    int btn3=0;
    int btn4=0;
    int btn5=0;
    int btn6=0;
    int btn7=0;
    int btn8=0;
    int btn9=0;
    int btn10=0;
    int btn11=0;
    int btn12=0;
    int btn13=0;
    int btn14=0;
    int btn15=0;

    public int getBtn1() {
        return btn1;
    }

    public void setBtn1(int btn1) {
        this.btn1 = btn1;
    }

    public int getBtn2() {
        return btn2;
    }

    public void setBtn2(int btn2) {
        this.btn2 = btn2;
    }

    public int getBtn3() {
        return btn3;
    }

    public void setBtn3(int btn3) {
        this.btn3 = btn3;
    }

    public int getBtn4() {
        return btn4;
    }

    public void setBtn4(int btn4) {
        this.btn4 = btn4;
    }

    public int getBtn5() {
        return btn5;
    }

    public void setBtn5(int btn5) {
        this.btn5 = btn5;
    }

    public int getBtn6() {
        return btn6;
    }

    public void setBtn6(int btn6) {
        this.btn6 = btn6;
    }

    public int getBtn7() {
        return btn7;
    }

    public void setBtn7(int btn7) {
        this.btn7 = btn7;
    }

    public int getBtn8() {
        return btn8;
    }

    public void setBtn8(int btn8) {
        this.btn8 = btn8;
    }

    public int getBtn9() {
        return btn9;
    }

    public void setBtn9(int btn9) {
        this.btn9 = btn9;
    }

    public int getBtn10() {
        return btn10;
    }

    public void setBtn10(int btn10) {
        this.btn10 = btn10;
    }

    public int getBtn11() {
        return btn11;
    }

    public void setBtn11(int btn11) {
        this.btn11 = btn11;
    }

    public int getBtn12() {
        return btn12;
    }

    public void setBtn12(int btn12) {
        this.btn12 = btn12;
    }

    public int getBtn13() {
        return btn13;
    }

    public void setBtn13(int btn13) {
        this.btn13 = btn13;
    }

    public int getBtn14() {
        return btn14;
    }

    public void setBtn14(int btn14) {
        this.btn14 = btn14;
    }

    public int getBtn15() {
        return btn15;
    }

    public void setBtn15(int btn15) {
        this.btn15 = btn15;
    }


    int rand[][]= new int [5][3];

    public void setMap() {
        Random r = new Random(parseInt(ID));
        rand[0][0]= r.nextInt(100);
        rand[0][1]= 80;
        rand[0][2]= 120;
        rand[1][0]= r.nextInt(100);
        rand[1][1]= 90;
        rand[1][2]= 110;
        rand[2][0]= r.nextInt(100);
        rand[2][1]= 100;
        rand[2][2]= 100;
        rand[3][0]= r.nextInt(100);
        rand[3][1]= 110;
        rand[3][2]= 90;
        rand[4][0]= r.nextInt(100);
        rand[4][1]= 120;
        rand[4][2]= 80;

        for(int i=0; i<5; i++){
            for(int j=0; j<2; j++){
                if (rand[i][0]<rand[j][0]){
                    int a = rand[i][0];
                    int b = rand[i][1];
                    int c = rand[i][2];
                    rand[i][0]=rand[j][0];
                    rand[i][1]=rand[j][1];
                    rand[i][2]=rand[j][2];
                    rand[j][0]=a;
                    rand[j][1]=b;
                    rand[j][2]=c;
                    System.out.println(a+" "+b);
                }
            }
        }
    }


    public int getMap(int i, int j){
        return rand[i][j];
    }

    public int getTempo() {
        System.out.println(Tempo);
        return Tempo;
    }

    public void setTempo(int sum) {
        this.Tempo = sum;
        System.out.println(sum);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
        System.out.println(ID);
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getHand() {
        return Hand;
    }

    public void setHand(int hand) {
        Hand = hand;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getMean() {
        return mean;
    }

    public void setMean(int mean) {
        this.mean = mean;
    }

    public int getPer() {
        return per;
    }

    public void setPer(int per) {
        this.per = per;
    }




}
