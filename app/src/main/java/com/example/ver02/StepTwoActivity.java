package com.example.ver02;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        Intent b_intent = getIntent();
        loop_num = b_intent.getIntExtra("loop",loop_num);
        factor = b_intent.getIntExtra("factor",100);

        duration = 600*factor/( (GlobalVar) getApplication() ).getSum();

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        View view1 = (View)findViewById(R.id.view1);
        Button button = (Button)findViewById(R.id.musicOn);
        TextView count = (TextView)findViewById(R.id.count);
        TextView loop = (TextView)findViewById(R.id.loop);
        loop.setText(String.valueOf(loop_num));

        String ID = ( (GlobalVar) getApplication() ).getID();
        int Age = ( (GlobalVar) getApplication() ).getAge();
        String Gender = ( (GlobalVar) getApplication() ).getGender();
        int Hand = ( (GlobalVar) getApplication() ).getHand();

        right.setIdentify(ID, Age, Gender, Hand, 2, loop_num, factor);
        int time_r2 = (int)System.currentTimeMillis();
        right.setTime2(time_r2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .build();
        } else {
            mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        }
        mSoundId = mSoundPool.load(getApplicationContext(), R.raw.sound, 1);
        mSoundId2 = mSoundPool.load(getApplicationContext(), R.raw.beep, 5);


        Thread th = new Thread(StepTwoActivity.this);
        th.start();

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                right.initArr();
                disp_num=right.getArrNum();
                loop_num++;
                sound_num=0;
                count.setText(String.valueOf(disp_num));
                loop.setText(String.valueOf(loop_num));
                int time_r2 = (int)System.currentTimeMillis();
                right.setTime2(time_r2);
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
                        mSoundPool.play(mSoundId, 1, 1, 1, 0, 1);
                        int time_r1 = (int)System.currentTimeMillis();
                        right.setTime1(time_r1);
                        System.out.println(right.getTime());
                        right.setHand(1);
                        right.putArray();
                        right.setStatus("touch");
                        right.writeFile1();
                        disp_num++;// right.getArrNum()%20;
                        count.setText(Integer.toString(disp_num));

                        Log.v("test","kkkkkk");
                        if (disp_num >= 20){
                            Log.v("test","innnnn");
                            disp_num=0;
                            loop.setText(String.valueOf(loop_num));
                            flag = 1;
                            Intent intent = new Intent(getApplicationContext(), StepTwoActivityEnd.class);

                            Log.i("loop","num__"+loop_num);
                            Log.i("intent____","intent_"+intent);

                            intent.putExtra("loop", loop_num);
                            intent.putExtra("factor", factor);
                            startActivity(intent);
                        }

                        return true;
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


    }

    int flag = 0;
    protected void onStop() {
        super.onStop();
        flag = 1;
    }

    @Override
    public void run() {
        right.putSound((int)System.currentTimeMillis(),duration);
        try {
            while(true) {
                right.setStatus("sound");
                right.incSound();
                mSoundPool.play(mSoundId2, 1, 1, 5, 0, 1);
                right.writeSound((int)System.currentTimeMillis());
                Thread.sleep(duration);
                sound_num++;
                if (flag == 1) break;

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
