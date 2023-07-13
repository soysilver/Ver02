package com.example.ver02;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;


public class StepTwoActivityBefore extends Activity {
    CountDownTimer countDownTimer;
    int flag = 0;
    int loop = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Button button1 = (Button) findViewById(R.id.button);
//        Button button2 = (Button) findViewById(R.id.button2);
//        Button button3 = (Button) findViewById(R.id.button3);
//        Button button4 = (Button) findViewById(R.id.button4);
//        Button button5 = (Button) findViewById(R.id.button5);
  //      TextView T = (TextView) findViewById(R.id.textView2);

        Button Sum = (Button) findViewById(R.id.Sum);
        Button Mean = (Button) findViewById(R.id.mean);
        Button Per = (Button) findViewById(R.id.per);

//        button1.setText(( (GlobalVar) getApplication() ).getMap(0, 2) + "%");
//        button2.setText(( (GlobalVar) getApplication() ).getMap(1,2) + "%");
//        button3.setText(( (GlobalVar) getApplication() ).getMap(2, 2) + "%");
//        button4.setText(( (GlobalVar) getApplication() ).getMap(3, 2) + "%");
//        button5.setText(( (GlobalVar) getApplication() ).getMap(4, 2) + "%");

//        if(((GlobalVar) getApplication() ).getBtn1()!=0) {
//            button1.setBackgroundColor(Color.BLUE);
//        }
//        if(((GlobalVar) getApplication() ).getBtn2()!=0) {
//            button2.setBackgroundColor(Color.BLUE);
//        }
//        if(((GlobalVar) getApplication() ).getBtn3()!=0) {
//            button3.setBackgroundColor(Color.BLUE);
//        }
//        if(((GlobalVar) getApplication() ).getBtn4()!=0) {
//            button4.setBackgroundColor(Color.BLUE);
//        }
//        if(((GlobalVar) getApplication() ).getBtn5()!=0) {
//            button5.setBackgroundColor(Color.BLUE);
//        }

        if(((GlobalVar) getApplication() ).getBtn5()!=0) {
            button1.setText("메뉴로 돌아가기");
        }

        Intent b_intent = getIntent();
        loop = b_intent.getIntExtra("loop",loop);

        int sum =  ( (GlobalVar) getApplication() ).getSum();
        int mean =  ( (GlobalVar) getApplication() ).getMean();
        int per = ( (GlobalVar) getApplication() ).getPer();

        Sum.setText(String.valueOf(sum));
        Mean.setText(String.valueOf(mean));
        Per.setText(String.valueOf(per));
        countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int num = (int) (millisUntilFinished / 1000);
      //          T.setText(Integer.toString(num + 1));

            }

            @Override
            public void onFinish() {
                startIntent(flag);
            }
        };


        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(((GlobalVar) getApplication() ).getBtn1()==0) {
                    ((GlobalVar) getApplication() ).setBtn1(1);
                    button1.setBackgroundColor(Color.RED);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(0, 1);
                    setFlag(buffer);
                    System.out.println(flag);
                    //     setFlag(80);
                    startIntent(flag);
                }
                else if(((GlobalVar) getApplication() ).getBtn1()!=0&&((GlobalVar) getApplication() ).getBtn2()==0){
                    ((GlobalVar) getApplication() ).setBtn2(1);
                    button1.setBackgroundColor(Color.YELLOW);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(1, 1);
                    setFlag(buffer);
                    System.out.println(flag);
                    startIntent(flag);
                }
                else if(((GlobalVar) getApplication() ).getBtn2()!=0&&((GlobalVar) getApplication() ).getBtn3()==0){
                    ((GlobalVar) getApplication() ).setBtn3(1);
                    button1.setBackgroundColor(Color.GREEN);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(2, 1);
                    setFlag(buffer);
                    System.out.println(flag);
                    startIntent(flag);
                }
                else if(((GlobalVar) getApplication() ).getBtn3()!=0&&((GlobalVar) getApplication() ).getBtn4()==0){
                    ((GlobalVar) getApplication() ).setBtn4(1);
                    button1.setBackgroundColor(Color.BLUE);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(3, 1);
                    setFlag(buffer);
                    System.out.println(flag);
                    startIntent(flag);
                }
                else if(((GlobalVar) getApplication() ).getBtn4()!=0&&((GlobalVar) getApplication() ).getBtn5()==0){
                    ((GlobalVar) getApplication() ).setBtn5(1);
                    button1.setBackgroundColor(Color.BLACK);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(4, 1);
                    button1.setText("완료");
                    setFlag(buffer);
                    System.out.println(flag);
                    startIntent(flag);
                }
                else lastIntent();


            }
        });

//
//
//        button1.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//                ((GlobalVar) getApplication() ).setBtn1(1);
//                button1.setBackgroundColor(Color.BLUE);
//                int buffer = ( (GlobalVar) getApplication() ).getMap(0, 1);
//                setFlag(buffer);
//           //     setFlag(80);
//                startIntent(flag);
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                ((GlobalVar) getApplication() ).setBtn2(1);
//                button2.setBackgroundColor(Color.BLUE);
//                int buffer = ( (GlobalVar) getApplication() ).getMap(1, 1);
//                setFlag(buffer);
//                startIntent(flag);
//            }
//        });
//        button3.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                ((GlobalVar) getApplication() ).setBtn3(1);
//                button3.setBackgroundColor(Color.BLUE);
//                int buffer = ( (GlobalVar) getApplication() ).getMap(2, 1);
//                setFlag(buffer);
//                startIntent(flag);
//            }
//        });
//        button4.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                ((GlobalVar) getApplication() ).setBtn4(1);
//                button4.setBackgroundColor(Color.BLUE);
//                int buffer = ( (GlobalVar) getApplication() ).getMap(3, 1);
//                setFlag(buffer);
//                startIntent(flag);
//            }
//        });
//        button5.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                ((GlobalVar) getApplication() ).setBtn5(1);
//                button5.setBackgroundColor(Color.BLUE);
//                int buffer = ( (GlobalVar) getApplication() ).getMap(4, 1);
//                setFlag(buffer);
//                startIntent(flag);
//            }
//        });
        Sum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Sum.setBackgroundColor(Color.BLUE);
                Mean.setBackgroundColor(Color.TRANSPARENT);
                Per.setBackgroundColor(Color.TRANSPARENT);
                ( (GlobalVar) getApplication() ).setTempo(sum);
            }
        });

        Mean.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Sum.setBackgroundColor(Color.TRANSPARENT);
                Mean.setBackgroundColor(Color.BLUE);
                Per.setBackgroundColor(Color.TRANSPARENT);
                ( (GlobalVar) getApplication() ).setTempo(mean);
            }
        });

        Per.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Sum.setBackgroundColor(Color.TRANSPARENT);
                Mean.setBackgroundColor(Color.TRANSPARENT);
                Per.setBackgroundColor(Color.BLUE);
                ( (GlobalVar) getApplication() ).setTempo(per);
            }
        });
    }

    public void setFlag(int flag){
        this.flag = flag;
    }

    public void startIntent(int a){
        Intent intent = new Intent(getApplicationContext(), StepTwoActivity.class);
        intent.putExtra("factor", a);
        intent.putExtra("loop", loop);
        startActivity(intent);
    }

    public void lastIntent(){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        ((GlobalVar) getApplication() ).setBtn1(0);
        ((GlobalVar) getApplication() ).setBtn2(0);
        ((GlobalVar) getApplication() ).setBtn3(0);
        ((GlobalVar) getApplication() ).setBtn4(0);
        ((GlobalVar) getApplication() ).setBtn5(0);

        intent.putExtra("loop", loop);
        startActivity(intent);
    }


}

