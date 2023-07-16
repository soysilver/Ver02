package com.example.ver02;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class StepThreeActivityEnd extends Activity {
    int loop;
    int factor;

    protected void onCreate(Bundle savedInstanceState) {
        Intent b_intent = getIntent();
        loop = b_intent.getIntExtra("loop",200);
        factor = b_intent.getIntExtra("factor",100);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_three_end);
        Button button = (Button) findViewById(R.id.menu_button);
        Button button2 = (Button) findViewById(R.id.return_btn);
        Button button3 = (Button) findViewById(R.id.subtask_btn);
        if(((GlobalVar) getApplication() ).getBtn10()==1) {
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
                Intent intent = new Intent(getApplicationContext(), StepThreeActivity.class);
                //    intent.putExtra("factor", factor);
                loop++;
                System.out.println(factor);
                intent.putExtra("loop", loop);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ads();
                loop=0;
                Intent intent = new Intent(getApplicationContext(), StepThreeActivity.class);
                //loop++;

                if(((GlobalVar) getApplication() ).getBtn6()==0) {
                    ((GlobalVar) getApplication() ).setBtn6(1);
                    button3.setBackgroundColor(Color.RED);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(0, 1);
                    System.out.println(buffer);
                    intent.putExtra("factor", buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn6()!=0&&((GlobalVar) getApplication() ).getBtn7()==0){
                    ((GlobalVar) getApplication() ).setBtn7(1);
                    button3.setBackgroundColor(Color.YELLOW);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(1, 1);
                    System.out.println(buffer);
                    intent.putExtra("factor", buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn7()!=0&&((GlobalVar) getApplication() ).getBtn8()==0){
                    ((GlobalVar) getApplication() ).setBtn8(1);
                    button3.setBackgroundColor(Color.GREEN);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(2, 1);
                    System.out.println(buffer);
                    intent.putExtra("factor", buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn8()!=0&&((GlobalVar) getApplication() ).getBtn9()==0){
                    ((GlobalVar) getApplication() ).setBtn9(1);
                    button3.setBackgroundColor(Color.BLUE);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(3, 1);
                    System.out.println(buffer);
                    intent.putExtra("factor", buffer);
                }
                else if(((GlobalVar) getApplication() ).getBtn9()!=0&&((GlobalVar) getApplication() ).getBtn10()==0){
                    ((GlobalVar) getApplication() ).setBtn10(1);
                    button3.setBackgroundColor(Color.BLACK);
                    int buffer = ( (GlobalVar) getApplication() ).getMap(4, 1);
                    System.out.println(buffer);
                    intent.putExtra("factor", buffer);
                }else {
                    intent = new Intent(getApplicationContext(), MenuActivity.class);
                    ((GlobalVar) getApplication() ).setBtn6(0);
                    ((GlobalVar) getApplication() ).setBtn7(0);
                    ((GlobalVar) getApplication() ).setBtn8(0);
                    ((GlobalVar) getApplication() ).setBtn9(0);
                    ((GlobalVar) getApplication() ).setBtn10(0);
                    intent.putExtra("loop", loop);
                    startActivity(intent);
                }

                intent.putExtra("loop", loop);
                startActivity(intent);
            }
        });

    }

    public void ads(){

    }
}

