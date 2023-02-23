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
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
  //      TextView T = (TextView) findViewById(R.id.textView2);

        Button Sum = (Button) findViewById(R.id.Sum);
        Button Mean = (Button) findViewById(R.id.mean);
        Button Per = (Button) findViewById(R.id.per);

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
                button1.setBackgroundColor(Color.BLUE);
                setFlag(80);
                startIntent(flag);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button2.setBackgroundColor(Color.BLUE);
                setFlag(90);
                startIntent(flag);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button3.setBackgroundColor(Color.BLUE);
                setFlag(100);
                startIntent(flag);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button4.setBackgroundColor(Color.BLUE);
                setFlag(110);
                startIntent(flag);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button5.setBackgroundColor(Color.BLUE);
                button5.setBackgroundColor(Color.BLUE);
                setFlag(120);
                startIntent(flag);
            }
        });
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



}

