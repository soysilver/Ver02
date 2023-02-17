package com.example.ver02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class StepTwoActivityEnd extends Activity {

    Intent b_intent = getIntent();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two_end);
        Button button = (Button) findViewById(R.id.menu_button);
        Button button2 = (Button) findViewById(R.id.return_btn);


      //


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                int loop = b_intent.getIntExtra("loop",200);

                Log.e("eLoop","int"+loop);
                Log.v("iLoop","_____in____"+loop);
                int factor = b_intent.getIntExtra("factor",100);

                Intent intent = new Intent(getApplicationContext(), StepTwoActivity.class);
                intent.putExtra("factor", factor);
                loop++;
                intent.putExtra("loop", loop);
                startActivity(intent);
            }
        });
    }

}

