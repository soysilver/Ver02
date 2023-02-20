package com.example.ver02;

import android.app.Application;

public class GlobalVar extends Application {
    String ID="실패";
    int Age = 0;
    String Gender ="Fail";
    int Hand = 0;
    int sum = 60;

    public int getSum() {
        System.out.println(sum);
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
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

}
