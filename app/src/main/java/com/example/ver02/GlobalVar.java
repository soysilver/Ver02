package com.example.ver02;

import android.app.Application;

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
