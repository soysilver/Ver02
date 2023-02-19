package com.example.ver02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;


public class StepOneActivityEnd extends Activity {
    CountDownTimer countDownTimer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one_end);
        Button button = (Button) findViewById(R.id.menu_button);
        Button button2 = (Button) findViewById(R.id.return_btn);
        Button button3 = (Button) findViewById(R.id.Sum);
        Button button4 = (Button) findViewById(R.id.mean);
        Button button5 = (Button) findViewById(R.id.per);

        Intent b_intent = getIntent();
        String ID = b_intent.getStringExtra("아이디");
        int Age = b_intent.getIntExtra("나이",0);
        String Gender = b_intent.getStringExtra("성별");
        int Hand = b_intent.getIntExtra("손",0);
        int bpm = b_intent.getIntExtra("bpm",0);
        int sum = b_intent.getIntExtra("sum",0);
        int mean = b_intent.getIntExtra("mean",0);
        int per = b_intent.getIntExtra("per",0);

        int factor = b_intent.getIntExtra("factor",100);

        button3.setText(String.valueOf(sum));
        button4.setText(String.valueOf(mean));
        button5.setText(String.valueOf(per));

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int loop = b_intent.getIntExtra("loop",200);
                Intent intent = new Intent(getApplicationContext(), StepOneActivity.class);
                intent.putExtra("factor", factor);
                loop++;
                intent.putExtra("loop", loop);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                ( (GlobalVar) getApplication() ).setSum(sum);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                ( (GlobalVar) getApplication() ).setSum(mean);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ( (GlobalVar) getApplication() ).setSum(mean);
            }
        });

    }

}

