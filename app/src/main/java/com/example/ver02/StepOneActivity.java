package com.example.ver02;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import java.sql.Timestamp;

public class StepOneActivity extends Activity {

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    Action right = new Action("right");

    int setID = 0;
    int disp_num = 0;
    SoundPool mSoundPool;
    int mSoundId;


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one_ing);


        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        Button button = (Button)findViewById(R.id.musicOn);
        Button button2 = (Button)findViewById(R.id.menu);
        TextView count = (TextView)findViewById(R.id.count);
        TextView loop = (TextView)findViewById(R.id.loop);
        TextView ctd = (TextView)findViewById(R.id.textView4);

        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                int num = (int) (millisUntilFinished / 1000);
                ctd.setText(Integer.toString(num + 1));

            }

            @Override
            public void onFinish() {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                ctd.setVisibility(View.INVISIBLE);
                int time_r2 = (int)System.currentTimeMillis();
                right.setTime2(time_r2);

            }
        };

        countDownTimer.start();

        String ID = ( (GlobalVar) getApplication() ).getID();
        int Age = ( (GlobalVar) getApplication() ).getAge();
        String Gender = ( (GlobalVar) getApplication() ).getGender();
        int Hand = ( (GlobalVar) getApplication() ).getHand();

        Intent b_intent = getIntent();
        setID = b_intent.getIntExtra("loop",setID);
        right.setSetID(setID);
        loop.setText(String.valueOf(setID));

        right.setIdentify(ID, Age, Gender, Hand,1, setID, 0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .build();
        } else {
            mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        }
        mSoundId = mSoundPool.load(getApplicationContext(), R.raw.sound, 1);

        right.Init( ( (GlobalVar) getApplication() ).getTitle());



        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                right.initArr();
                disp_num=right.getArrNum();
                setID++;
                right.setSetID(setID);
                count.setText(String.valueOf(disp_num));
                loop.setText(String.valueOf(setID));
                int time_r2 = (int)System.currentTimeMillis();
                right.setTime2(time_r2);

                return false;
            }
        });


        View view1 = (View)findViewById(R.id.view1);
        ImageView imgView = (ImageView) findViewById(R.id.imageView);
        imgView.setOnTouchListener(new View.OnTouchListener() {
            @Override

            public boolean onTouch(View view, MotionEvent event) {
                float curX = event.getX();
                right.setX(curX);
                float curY = event.getY();
                right.setY(curY);
                right.setabX(curX);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        mSoundPool.play(mSoundId, 1, 1, 1, 0, 1);
                        int time_r1 = (int)System.currentTimeMillis();
                        right.setTime1(time_r1);
                        System.out.println(right.getTime());
                        right.putArray();
                        right.putSound(time_r1);
                        right.setStatus("touch");
                        right.writeFile1(( (GlobalVar) getApplication() ).getTitle());
                        disp_num++;// right.getArrNum()%20;
                        count.setText(Integer.toString(disp_num));

                        if (disp_num >= 20) {
                            disp_num = 0;
                            loop.setText(String.valueOf(setID));
                            ((GlobalVar) getApplication()).setTempo(right.getSum());
                            Intent intent = new Intent(getApplicationContext(), StepOneActivityEnd.class);
                            intent.putExtra("loop", setID);
                            intent.putExtra("sum", right.getSum());
                            ((GlobalVar) getApplication()).setTempo(right.getSum());
                            ((GlobalVar) getApplication()).setSum(right.getSum());
                            intent.putExtra("mean", right.getMean());
                            ((GlobalVar) getApplication()).setMean(right.getMean());
                            ((GlobalVar) getApplication()).setPer(right.getSortedSum());
                            intent.putExtra("per", right.getSortedSum());
                            startActivity(intent);
                        }
                    }
                    case MotionEvent.ACTION_UP: {
                        right.changeTime();
                        return false;
                    }

                }
                return false;
            }
        });

        view1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
              //  mSoundPool.stop(mSoundId);

                float curX = event.getX();
                right.setX(curX);
                float curY = event.getY();
                right.setY(curY);
                right.setabX(curX);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        mSoundPool.play(mSoundId, 1, 1, 1, 0, 1);
                        int time_r1 = (int)System.currentTimeMillis();
                        right.setTime1(time_r1);
                        System.out.println(right.getTime());
                        right.putArray();
                        right.putSound(time_r1);
                        right.setStatus("touch");
                        right.writeFile1(( (GlobalVar) getApplication() ).getTitle());
                        disp_num++;// right.getArrNum()%20;
                        count.setText(Integer.toString(disp_num));

                        if (disp_num >= 20){
                            disp_num=0;
                            loop.setText(String.valueOf(setID));
                            ( (GlobalVar) getApplication() ).setTempo(right.getSum());
                            Intent intent = new Intent(getApplicationContext(), StepOneActivityEnd.class);
                            intent.putExtra("loop", setID);
                            intent.putExtra("sum", right.getSum());
                            ( (GlobalVar) getApplication() ).setTempo(right.getSum());
                            ( (GlobalVar) getApplication() ).setSum(right.getSum());
                            intent.putExtra("mean", right.getMean());
                            ( (GlobalVar) getApplication() ).setMean(right.getMean());
                            ( (GlobalVar) getApplication() ).setPer(right.getSortedSum());
                            intent.putExtra("per", right.getSortedSum());
                            startActivity(intent);
                        }

                     //   return true;
                    }
                    case MotionEvent.ACTION_UP: {
                        right.changeTime();
                        return false;
                    }

                    default:
                        return false;
                }


            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });


    }

}
