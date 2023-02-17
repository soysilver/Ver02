package com.example.ver02;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button step1 = (Button)findViewById(R.id.step1);
        Button step2 = (Button)findViewById(R.id.step2);
        Button step3 = (Button)findViewById(R.id.step3);
        Button step4 = (Button)findViewById(R.id.step4);

        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StepOneActivityBefore.class);
                startActivity(intent);
            }
        });

        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StepTwoActivityBefore.class);
                startActivity(intent);
            }
        });

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StepThreeActivityBefore.class);
                startActivity(intent);
            }
        });

        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StepThreeActivityBefore.class);
                startActivity(intent);
            }
        });

    }

}