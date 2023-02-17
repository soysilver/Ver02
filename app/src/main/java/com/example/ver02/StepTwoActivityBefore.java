package com.example.ver02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StepTwoActivityBefore extends Activity {
    CountDownTimer countDownTimer;
    int flag = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        TextView T = (TextView) findViewById(R.id.textView2);


        countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int num = (int) (millisUntilFinished / 1000);
                T.setText(Integer.toString(num + 1));

            }

            @Override
            public void onFinish() {
                startIntent(flag);
            }
        };


        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                setFlag(80);
                countDownTimer.start();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setFlag(90);
                countDownTimer.start();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setFlag(100);
                countDownTimer.start();

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setFlag(110);
                countDownTimer.start();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setFlag(120);
                countDownTimer.start();
            }
        });
    }

    public void setFlag(int flag){
        this.flag = flag;
    }

    public void startIntent(int a){
        Intent intent = new Intent(getApplicationContext(), StepTwoActivity.class);
        intent.putExtra("factor", a);
        startActivity(intent);
    }

}
