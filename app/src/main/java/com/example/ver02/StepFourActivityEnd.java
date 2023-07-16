package com.example.ver02;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class StepFourActivityEnd extends Activity {
    int loop;
    int buffer;

    protected void onCreate(Bundle savedInstanceState) {
        Intent b_intent = getIntent();
        loop = b_intent.getIntExtra("loop",200);
        buffer = b_intent.getIntExtra("factor",100);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_four_end);
        Button button = (Button) findViewById(R.id.menu_button);
        Button button2 = (Button) findViewById(R.id.return_btn);
        Button button3 = (Button) findViewById(R.id.subtask_btn);

        if(((GlobalVar) getApplication() ).getBtn15()==1) {
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
                ads();
                Intent intent = new Intent(getApplicationContext(), StepFourActivity.class);
                //    intent.putExtra("factor", factor);
                loop++;
                System.out.println(buffer);
                intent.putExtra("loop", loop);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ads();
                Intent intent = new Intent(getApplicationContext(), StepFourActivity.class);
            //   loop++;
                if(((GlobalVar) getApplication() ).getBtn11()==0) {
                    ((GlobalVar) getApplication() ).setBtn11(1);
                    button3.setBackgroundColor(Color.RED);
                    buffer = ( (GlobalVar) getApplication() ).getMap(0, 1);
                    System.out.println(buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn11()!=0&&((GlobalVar) getApplication() ).getBtn12()==0){
                    ((GlobalVar) getApplication() ).setBtn12(1);
                    button3.setBackgroundColor(Color.YELLOW);
                    buffer = ( (GlobalVar) getApplication() ).getMap(1, 1);
                    System.out.println(buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn12()!=0&&((GlobalVar) getApplication() ).getBtn13()==0){
                    ((GlobalVar) getApplication() ).setBtn3(1);
                    button3.setBackgroundColor(Color.GREEN);
                    buffer = ( (GlobalVar) getApplication() ).getMap(2, 1);
                    System.out.println(buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn3()!=0&&((GlobalVar) getApplication() ).getBtn4()==0){
                    ((GlobalVar) getApplication() ).setBtn4(1);
                    button3.setBackgroundColor(Color.BLUE);
                    buffer = ( (GlobalVar) getApplication() ).getMap(3, 1);
                    System.out.println(buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn4()!=0&&((GlobalVar) getApplication() ).getBtn5()==0){
                    ((GlobalVar) getApplication() ).setBtn5(1);
                    button3.setBackgroundColor(Color.BLACK);
                    buffer = ( (GlobalVar) getApplication() ).getMap(4, 1);
                    System.out.println(buffer);
                }
                else {
                    intent = new Intent(getApplicationContext(), MenuActivity.class);
                    ((GlobalVar) getApplication() ).setBtn11(0);
                    ((GlobalVar) getApplication() ).setBtn12(0);
                    ((GlobalVar) getApplication() ).setBtn13(0);
                    ((GlobalVar) getApplication() ).setBtn14(0);
                    ((GlobalVar) getApplication() ).setBtn15(0);
                    intent.putExtra("loop", loop);
                    startActivity(intent);

                }
                intent.putExtra("factor", buffer);
                intent.putExtra("loop", loop);
                startActivity(intent);
            }
        });

    }

    public void ads(){

    }
}

