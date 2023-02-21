package com.example.ver02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;


public class StepOneActivityBefore extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one);
        Button button = (Button) findViewById(R.id.button);


        Intent b_intent = getIntent();
        String ID = b_intent.getStringExtra("아이디");
        int Age = b_intent.getIntExtra("나이",0);
        String Gender = b_intent.getStringExtra("성별");
        int Hand = b_intent.getIntExtra("손",0);


        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), StepOneActivity.class);
                intent.putExtra("아이디", ID);
                intent.putExtra("나이", Age);
                intent.putExtra("성별", Gender);
                intent.putExtra("손", Hand);
                startActivity(intent);

                System.out.println(ID+Gender+Age+Hand);

            }
        });
    }

}

