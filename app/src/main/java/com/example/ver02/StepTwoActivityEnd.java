package com.example.ver02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class StepTwoActivityEnd extends Activity {
    int loop;
    int factor;

    protected void onCreate(Bundle savedInstanceState) {
        Intent b_intent = getIntent();
        loop = b_intent.getIntExtra("loop",200);
        factor = b_intent.getIntExtra("factor",100);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two_end);
        Button button = (Button) findViewById(R.id.menu_button);
        Button button2 = (Button) findViewById(R.id.return_btn);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ads();
                Log.e("eLoop","int"+loop);
                Log.v("iLoop","_____in____"+loop);

                Intent intent = new Intent(getApplicationContext(), StepTwoActivityBefore.class);
                intent.putExtra("factor", factor);
                loop++;
                Log.v("iLoop","_____in____"+loop);
                intent.putExtra("loop", loop);
                startActivity(intent);
            }
        });

    }

    public void ads(){

    }
}

