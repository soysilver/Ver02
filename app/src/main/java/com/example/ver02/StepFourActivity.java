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
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;


public class StepFourActivity extends Activity  implements Runnable {

    Action right = new Action("right");

    int loop_num = 0;
    int disp_num = 0;
    int sound_num = 0;
    SoundPool mSoundPool;
    int mSoundId;
    int mSoundId2;
    int duration;
    int factor = 100;
    int Hand=0;
    int flag2 = 0;
    float vol= 0;
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
        setContentView(R.layout.activity_step_three_ing);

        Intent b_intent = getIntent();
        factor = b_intent.getIntExtra("factor",100);
        loop_num = b_intent.getIntExtra("loop",loop_num);

        duration = 600*factor/( (GlobalVar) getApplication() ).getTempo();
        right.setBpm(duration);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        View view1 = (View)findViewById(R.id.view1);
        View view2 = (View)findViewById(R.id.view2);
        Button button = (Button)findViewById(R.id.musicOn);
        Button button2 = (Button)findViewById(R.id.menu);
        TextView count = (TextView)findViewById(R.id.count);
        TextView loop = (TextView)findViewById(R.id.loop);
        loop.setText(String.valueOf(loop_num));
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
        Hand = ( (GlobalVar) getApplication() ).getHand();

        right.setIdentify(ID, Age, Gender, Hand, 4, loop_num, factor);
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

        Thread th = new Thread(StepFourActivity.this);
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

                float curX = event.getX();
                right.setX(curX);
                float curY = event.getY();
                right.setY(curY);
                right.setabX(curX);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(flag2 == 2) {
//                            view1.setBackgroundColor(Color.LTGRAY);
                            //    mSoundPool.play(mSoundId, 1, 1, 1, 0, 1);
                            int time_r1 = (int) System.currentTimeMillis();
                            right.setTime1(time_r1);
                            System.out.println(right.getTime());
                            right.putArray();
                            right.setStatus("touchRight");
                            right.writeFile1(((GlobalVar) getApplication()).getTitle());
                            disp_num++;// right.getArrNum()%20;
                            count.setText(Integer.toString(disp_num));

                            if (disp_num >= 20) {
                                disp_num = 0;
                                loop.setText(String.valueOf(loop_num));
                                flag = 1;
                                Intent intent = new Intent(getApplicationContext(), StepFourActivityEnd.class);
                                intent.putExtra("loop", loop_num);
                                intent.putExtra("factor", factor);
                                startActivity(intent);
                            }
                        }
                        flag2 = 2;
                        return true;
                    }
                    case MotionEvent.ACTION_UP: {
//                        view1.setBackgroundColor(Color.TRANSPARENT);
                        right.changeTime();
                        return false;
                    }

                    default:
                        return false;
                }


            }

        });


        view2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                //  mSoundPool.stop(mSoundId);

                float curX = event.getX();
                right.setX(curX);
                float curY = event.getY();
                right.setY(curY);
                right.setabX(curX);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
 //                       view2.setBackgroundColor(Color.LTGRAY);
                        if (flag2 ==2) {
                            //   mSoundPool.play(mSoundId, 1, 1, 1, 0, 1);
                            int time_r1 = (int) System.currentTimeMillis();
                            right.setTime1(time_r1);
                            System.out.println(right.getTime());
                            right.putArray();
                            right.setStatus("touchLeft");
                            right.writeFile1(((GlobalVar) getApplication()).getTitle());
                            disp_num++;// right.getArrNum()%20;
                            count.setText(Integer.toString(disp_num));

                            if (disp_num >= 20) {
                                disp_num = 0;
                                loop.setText(String.valueOf(loop_num));
                                flag = 1;
                                Intent intent = new Intent(getApplicationContext(), StepFourActivityEnd.class);
                                intent.putExtra("loop", loop_num);
                                intent.putExtra("factor", factor);
                                startActivity(intent);
                            }
                        }
                        flag2 = 2;
                        return true;
                    }
                    case MotionEvent.ACTION_UP: {
 //                       view2.setBackgroundColor(Color.TRANSPARENT);
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



    int flag = 0;
    protected void onStop() {
        super.onStop();
        flag = 1;
    }

    @Override
    public void run() {
        try {
                while(true) {
                if (flag == 1) break;
                if (flag2 == 2) {
                    right.setStatus("sound");
                    right.putSound((int) System.currentTimeMillis());
                    sound_num++;
                    right.writeSound((int) System.currentTimeMillis(), ( (GlobalVar) getApplication() ).getTitle());
                }
                mSoundPool.play(mSoundId2, vol, vol, 5, 0, 1);
                vol = 1;
                Thread.sleep(duration);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
