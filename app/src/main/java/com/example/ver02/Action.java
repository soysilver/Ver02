package com.example.ver02;

import android.app.Activity;
import android.os.Environment;

import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Action extends Activity {
    //초기 입력값

    //실행 중
    String name;
    float x, y , abx= 0;
    int time1 = 0;
    int time2 = 0;
    int time = getTime();

    //계산용
    int status= 0;
    int setID = 0;
    int BPMset = 0;
    int[] arr = new int[40];
    int[] Sound = new int[40];
    int[] Sorted = new int[40];
    int arr_num = 0;
    int sound_num = 0;
    int Sum = 0;
    int i = 0;

    //혹시 작동 안될 때
    int Age=900, Hand = 3;
    String ID="oo", Gender= "not";


    //날짜
    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public Action(String Name) {
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
    public void setIdentify(String ID, int Age, String Gender, int Hand, int status, int setID, int BPMset){
        this.ID = ID;
        this.Age = Age;
        this.Gender = Gender;
        this.Hand = Hand;
        this.status = status;
        this.setID = setID;
        if(BPMset==80){
            this.BPMset = 1;
        }
        else if(BPMset==90){
            this.BPMset = 2;
        }
        else if(BPMset==100){
            this.BPMset = 3;
        }
        else if(BPMset==110){
            this.BPMset = 4;
        }
        else if(BPMset==120){
            this.BPMset = 5;
        }
        else this.BPMset = 0;

    };


    public String readFile(String path){
        try {

            FileInputStream inFs = new FileInputStream(path);
            BufferedReader reader = new BufferedReader(
                    new FileReader(new File(path))
            );
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println("exists");
                System.out.println(str);
            }
            reader.close();
            return str;
        } catch (FileNotFoundException e1) {
            System.out.println("e1");
        } catch (IOException e2) {
            System.out.println("e2");
        }
        System.out.println("try 안됨");
        return "try 안됨";

        }


    public void Init() {
        String fileTitle = "PID_timestamp_number.txt";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), fileTitle);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter first = new FileWriter(file, true);
            //BufferedWriter writer = new BufferedWriter(first);
            CSVWriter writer = new CSVWriter(first);
            String[] entries = "Date#Timestamp#PID#Age#Gender#Handness#StageID#SetID#BPM_set#Event#SignalID#TrialID#x#y#BPM_part_avg#BPM_part_median#BPM_part_middle#Gap".split("#");  // 1
            writer.writeNext(entries);  // 2
            writer.close();

        } catch (IOException e) {

        }
    }


    public void writeFile1() {
        String fileTitle = "PID_timestamp_number.txt";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), fileTitle);
        String a = file.getPath();
        System.out.println(a);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter first = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(first);

            String[] entries1 = {dateFormat.format(date), Integer.toString(time1) , ID, Integer.toString(Age), Gender, Integer.toString(Hand), String.valueOf(status),String.valueOf(setID), String.valueOf(BPMset), Integer.toString(sound_num), Integer.toString(arr_num), Integer.toString(arr[arr_num-1]), Float.toString(abx), Float.toString(y), String.valueOf(getSum()),String.valueOf(getMean()),String.valueOf(getSortedSum()), String.valueOf(time1-Sound[arr_num -1]) };  // 3
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

    public void putSound(int a){
        Sound[sound_num]=a;
        sound_num++;
    }
    public void initArr(){
        arr_num = 0;
    }

    public int getArrNum(){
        return arr_num;
    }

    //배열의 평균 bpm 구하는 함수
    public int getSum(){
        for (int i= 1; i < arr_num; i++){
            Sum += arr[i];
        }
        Sum = Sum/arr_num;
        return Sum;
    }

    public int getSortedSum(){
        if (arr_num >4){
            for (int i= 2; i < arr_num-2; i++){
                Sum += Sorted[i];
            }
            Sum = Sum/(arr_num-4);
            return Sum;
        }
        else return 0;
    }

    public int getMean(){
        for(int i = 1 ; i < arr_num ; i ++) {
            Sorted[i] = arr[i];
        }
            for(int i = 1 ; i < arr_num ; i ++) {
                 for(int j = 0 ; j < arr_num - i ; j ++){
                    if(Sorted[j] > Sorted[j + 1]) {
                        int temp = Sorted[j];
                        Sorted[j] = Sorted[j + 1];
                        Sorted[j + 1] = temp;
                }
            }
        }
        return Sorted[arr_num/2];
    }

    public void setSetID(int setID) {
        this.setID = setID;
    }
}