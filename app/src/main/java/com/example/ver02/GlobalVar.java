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
                System.out.println(rand[i][j]);
            }
        }

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

        for(int i=0; i<5; i++){
            for(int j=0; j<3; j++){
                System.out.println(rand[i][j]);
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


    public void petID() {
        try{
            System.out.println(ID);
        }catch (Exception e){
            System.out.println(0);
        }


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
