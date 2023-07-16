package com.example.ver02;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Application;

import androidx.core.app.ActivityCompat;

import java.sql.Timestamp;

public class StepTwoActivity extends Activity implements Runnable {

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    Action right = new Action("right");
    GestureDetector detector;
    int loop_num = 0;
    int disp_num = 0;
    int sound_num = 0;
    SoundPool mSoundPool;
    int mSoundId;
   int mSoundId2;
    int duration;
    int factor = 100;

    float vol = 0;
    int flag2 = 0;
    int only20 = 0;
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
        Intent b_intent = getIntent();
        loop_num = b_intent.getIntExtra("loop",loop_num);
        factor = b_intent.getIntExtra("factor",100);

        duration = 600*factor/( (GlobalVar) getApplication() ).getTempo();
        right.setBpm(duration);


        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        ImageView view1 = (ImageView) findViewById(R.id.imageView);
        // View view1 = (View)findViewById(R.id.view1);
        Button button = (Button)findViewById(R.id.musicOn);
        Button button2 = (Button)findViewById(R.id.menu);
   //     TextView count = (TextView)findViewById(R.id.count);
        TextView loop = (TextView)findViewById(R.id.loop);
        loop.setText(String.valueOf(loop_num));
        TextView ctd = (TextView)findViewById(R.id.textView4);

        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                int num = (int) (millisUntilFinished / 1000);
                //ctd.setText(Integer.toString(num + 1));
                ctd.setText("준비되었을 때 시작하세요");
            }

            @Override
            public void onFinish() {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                ctd.setVisibility(View.INVISIBLE);
                int time_r2 = (int)System.currentTimeMillis();
                right.setTime2(time_r2);
                flag2 = 2;
           //     vol = 1;
            }
        };

        countDownTimer.start();

        String ID = ( (GlobalVar) getApplication() ).getID();
        int Age = ( (GlobalVar) getApplication() ).getAge();
        String Gender = ( (GlobalVar) getApplication() ).getGender();
        int Hand = ( (GlobalVar) getApplication() ).getHand();

        right.setIdentify(ID, Age, Gender, Hand, 2, loop_num, factor);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .build();
        } else {
            mSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 1);
        }
        mSoundId = mSoundPool.load(getApplicationContext(), R.raw.sound, 1);
        mSoundId2 = mSoundPool.load(getApplicationContext(), R.raw.beep, 5);


        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                right.initArr();
                disp_num=right.getArrNum();
                loop_num++;
                sound_num=0;
                right.initSoundNum();
                // count.setText(String.valueOf(disp_num));
                loop.setText(String.valueOf(loop_num));
                int time_r2 = (int)System.currentTimeMillis();
                right.setTime2(time_r2);
                flag=0;
                if (only20==1) only20 =0;
                else if (only20==0) only20=1;
                return false;
            }
        });

        view1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                //  mSoundPool.stop(mSoundId);

                if(disp_num == 0){
                }

                float curX = event.getX();
                right.setX(curX);
                float curY = event.getY();
                right.setY(curY);
                right.setabX(curX);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        flag2 = 2;
 //                       mSoundPool.play(mSoundId, vol, vol, 1, 0, 1);
                        if (flag2 == 2) {
                            int time_r1 = (int) System.currentTimeMillis();
                            right.setTime1(time_r1);
                      //      System.out.println(right.getTime());
                            right.setHand(1);
                            right.putArray();
                            right.setStatus("touch");
                            right.writeFile1(((GlobalVar) getApplication()).getTitle());
                            disp_num++;// right.getArrNum()%20;
                            //count.setText(Integer.toString(disp_num));
                            System.out.println(disp_num);

                      //      Log.v("test", "kkkkkk");
                            if (disp_num >= 40) {
                        //        Log.v("test", "innnnn");
                                disp_num = 0;
                                loop.setText(String.valueOf(loop_num));
                                flag = 1;
                                Intent intent = new Intent(getApplicationContext(), StepTwoActivityEnd.class);

                          //      Log.i("loop", "num__" + loop_num);
                          //      Log.i("intent____", "intent_" + intent);

                                intent.putExtra("loop", loop_num);
                                intent.putExtra("factor", factor);
                                startActivity(intent);
                            }
                        }

                      //  return true;
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
        Thread th = new Thread(StepTwoActivity.this);
        th.start();

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });
    }



    int flag = 0;
    protected void onStop() {
        super.onStop();
        flag = 1;
    }

    @Override
    public void run() {
        //right.putSound((int)System.currentTimeMillis(),duration);
        try {
            right.initSound((int)System.currentTimeMillis());
            while(true) {
                if (flag == 1) break;
                //nn
                if (flag2 == 2){
                    right.setStatus("sound");
                    right.putSound((int)System.currentTimeMillis());
                    right.writeSound((int)System.currentTimeMillis(), ( (GlobalVar) getApplication() ).getTitle());
                    sound_num++;
                }
                ( (GlobalVar) getApplication() ).goBeep(vol);
            //    mSoundPool.play(mSoundId2, vol, vol, 5, 0, 1);
                vol = 1;
                if (disp_num > 20 && only20==0) vol = 0;
                Thread.sleep(duration);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
