package com.example.ver02;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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
        Button button3 = (Button) findViewById(R.id.subtask_btn);
        if(((GlobalVar) getApplication() ).getBtn5()==1) {
            button3.setText("완료");
        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StepTwoActivity.class);
                intent.putExtra("factor", factor);
                loop++;
                intent.putExtra("loop", loop);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

//                Log.e("eLoop","int"+loop);
  //              Log.v("iLoop","_____in____"+loop);

                Intent intent = new Intent(getApplicationContext(), StepTwoActivity.class);
                intent.putExtra("factor", factor);
               // loop++;
//                Log.v("iLoop","_____in____"+loop);

                if(((GlobalVar) getApplication() ).getBtn1()==0) {
                    ((GlobalVar) getApplication() ).setBtn1(1);
                    button3.setBackgroundColor(Color.RED);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(0, 1);
                    System.out.println(buffer);
                    intent.putExtra("factor", buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn1()!=0&&((GlobalVar) getApplication() ).getBtn2()==0){
                    ((GlobalVar) getApplication() ).setBtn2(1);
                    button3.setBackgroundColor(Color.YELLOW);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(1, 1);
                    System.out.println(buffer);
                    intent.putExtra("factor", buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn2()!=0&&((GlobalVar) getApplication() ).getBtn3()==0){
                    ((GlobalVar) getApplication() ).setBtn3(1);
                    button3.setBackgroundColor(Color.GREEN);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(2, 1);
                    System.out.println(buffer);
                    intent.putExtra("factor", buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn3()!=0&&((GlobalVar) getApplication() ).getBtn4()==0){
                    ((GlobalVar) getApplication() ).setBtn4(1);
                    button3.setBackgroundColor(Color.BLUE);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(3, 1);
                    System.out.println(buffer);
                    intent.putExtra("factor", buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn4()!=0&&((GlobalVar) getApplication() ).getBtn5()==0){
                    ((GlobalVar) getApplication() ).setBtn5(1);
                    button3.setBackgroundColor(Color.BLACK);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(4, 1);
                    System.out.println(buffer);
                    intent.putExtra("factor", buffer);
                }else {
                    intent = new Intent(getApplicationContext(), MenuActivity.class);
                    ((GlobalVar) getApplication() ).setBtn1(0);
                    ((GlobalVar) getApplication() ).setBtn2(0);
                    ((GlobalVar) getApplication() ).setBtn3(0);
                    ((GlobalVar) getApplication() ).setBtn4(0);
                    ((GlobalVar) getApplication() ).setBtn5(0);
                    intent.putExtra("loop", loop);
                    startActivity(intent);
                }

                intent.putExtra("loop", loop);
                startActivity(intent);
            }
        });

    }

}

