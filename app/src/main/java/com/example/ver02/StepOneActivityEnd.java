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

        Intent b_intent = getIntent();
        String ID = b_intent.getStringExtra("아이디");
        int Age = b_intent.getIntExtra("나이",0);
        String Gender = b_intent.getStringExtra("성별");
        int Hand = b_intent.getIntExtra("손",0);
        int bpm = b_intent.getIntExtra("bpm",0);

        int factor = b_intent.getIntExtra("factor",100);



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

    }

}

