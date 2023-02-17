package com.example.ver02;

import android.app.Activity;
import android.os.Environment;

import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Action2 extends Activity {
    //초기 입력값
    GlobalVar global = (GlobalVar) getApplication();
    MainActivity m = new MainActivity();

    //실행 중
    String name;
    float x, y , abx= 0;
    int time1 = 0;
    int time2 = 0;
    int time = getTime();

    //계산용

    int[] arr = new int[100];
    int arr_num = 0;
    int Sum = 0;
    int i = 0;
    //혹시 작동 안될 때
    int Age=900, Hand = 3;
    String ID="oo", Gender= "not";
    //날짜
    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public Action2(String Name) {
        this.name = Name;
    }

    void setTime1(int Time1) {
        this.time1 = Time1;
    }
    void setTime2(int Time2) {
        this.time2 = Time2;
    }
    void changeTime() {
        System.out.println(" 시간1"+ time1 +"시간2" + time2);
        time2 = time1;
        System.out.println(" 시간1"+ time1 +"시간2" + time2);

    }
    public int getTime() {
        System.out.println(" 시간1"+ time1 +"시간2" + time2);
        return (int)(time1 - time2);

    }

    public void setX(float X) {
        this.x = X;
    }
    public void setabX(float X) {
        this.abx = X;
    }
    public void setY(float Y) {
        this.y = Y;
    }

    public void setHand(int Hand) {
        this.Hand = Hand;
    }
    public void setIdentify(String ID, int Age, String Gender, int Hand){
        this.ID = ID;
        this.Age = Age;
        this.Gender = Gender;
        this.Hand = Hand;
    };



    public void Init() {
        String fileTitle = "Please.txt";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), fileTitle);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter first = new FileWriter(file, false);
            //BufferedWriter writer = new BufferedWriter(first);
            CSVWriter writer = new CSVWriter(first);
            String[] entries = "Date#Timestamp#PID#Age#Gender#Handness#StageID#SetID#BPM_set#Event#SignalID#TrialID#x#y#BPM_part_avg#BPM_part_median#BPM_part_middle#Gap#x#y#count#bpm".split("#");  // 1
            writer.writeNext(entries);  // 2
            writer.close();

        } catch (IOException e) {

        }
    }


    public void writeFile1() {
        String fileTitle = "Please.txt";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), fileTitle);
        String a = file.getPath();
        System.out.println(a);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter first = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(first);

            String[] entries1 = {String.valueOf((dateFormat)), Integer.toString(time1) , ID, Integer.toString(Age), Gender, Integer.toString(Hand), "1", Float.toString(abx), Float.toString(y), Integer.toString(arr_num), Integer.toString(arr[arr_num-1]), String.valueOf(getSum()) };  // 3
            writer.writeNext(entries1);

            writer.close();

        } catch (IOException e) {

        }
    }

    public void putArray(){
        int a = getTime();
        arr[arr_num]=60000/a;
        arr_num++;

 //       global.setSum(this.getSum());
//        System.out.println(global.getSum());

    }

    public int getArrNum(){
        return arr_num;
    }

    //배열의 평균 bpm 구하는 함수
    public int getSum(){
        for (int i= 0; i < arr_num; i++){
            Sum += arr[i];
        }
        Sum = Sum/arr_num;
        return Sum;
    }
}