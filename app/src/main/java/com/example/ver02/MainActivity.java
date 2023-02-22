package com.example.ver02;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String ID;
    int Age;
    String Gender;
    int Hand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enter = (Button)findViewById(R.id.info_btn);
        Button step1 = (Button)findViewById(R.id.next_btn);



        TextView PID_text = (TextView)findViewById (R.id.PID_text);
        String[] PID = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        Spinner spinnerP = (Spinner) findViewById(R.id.PIDS);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, PID
        );
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinnerP.setAdapter(adapter4);
        // 스피너에서 선택 했을 경우 이벤트 처리
        spinnerP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ( (GlobalVar) getApplication() ).setID(PID[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                PID_text.setText("다시 선택 : ");
            }
        });


        TextView Age_text = (TextView)findViewById(R.id.Age_text);
        String[] Age = { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","51","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100"};
        Spinner spinnerAge = (Spinner) findViewById(R.id.AgeS);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, Age
        );

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinnerAge.setAdapter(adapter2);

        // 스피너에서 선택 했을 경우 이벤트 처리
        spinnerAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ( (GlobalVar) getApplication() ).setAge(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Age_text.setText("다시 선택 : ");
            }
        });




        TextView Gender_text = (TextView)findViewById(R.id.Gender_text);
        String[] Gender = {"male", "Female", "other"};
        Spinner spinnerG = (Spinner) findViewById(R.id.GenderS);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, Gender
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinnerG.setAdapter(adapter);

        // 스피너에서 선택 했을 경우 이벤트 처리
        spinnerG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ( (GlobalVar) getApplication() ).setGender(Gender[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Gender_text.setText("다시 선택 : ");
            }
        });




        TextView Hand_text = (TextView)findViewById(R.id.Hand_text);
        String[] Hand = {"right", "left"};
        Spinner spinnerH = (Spinner) findViewById(R.id.HandS);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, Hand
        );

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinnerH.setAdapter(adapter3);

        // 스피너에서 선택 했을 경우 이벤트 처리
        spinnerH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(Hand[position]=="left"){
                    ( (GlobalVar) getApplication() ).setHand(0);
                }
                else if(Hand[position]=="right"){
                    ( (GlobalVar) getApplication() ).setHand(1);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Hand_text.setText("다시 선택 : ");
            }
        });


        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("아이디", ID);
                intent.putExtra("나이", Age);
                intent.putExtra("성별", Gender);
                intent.putExtra("손", Hand);

                startActivity(intent);
            }
        });

    }

}