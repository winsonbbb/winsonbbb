package com.match.sunnyside.sunnysidestaff;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Random;

public class Gaming extends AppCompatActivity {
    VideoView videoViewGaming ;
    ImageButton btnLeft,btnRight;
    TextView tvQuestion;
    SQLiteDatabase db;
    ArrayList<String> playList;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);
        videoViewGaming = (VideoView) findViewById(R.id.videoViewGaming);
        btnLeft = (ImageButton) findViewById(R.id.btnLeft);
        btnRight = (ImageButton) findViewById(R.id.btnRight);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        int times = Integer.parseInt(getIntent().getStringExtra("times"));
        playList = (ArrayList<String>) getIntent().getSerializableExtra("playList");
        db = SQLiteDatabase.openDatabase("/data/data/com.match.sunnyside.sunnysidestaff/database", null, SQLiteDatabase.CREATE_IF_NECESSARY);

        Cursor cursor;
        String sql="";
        for (int i = 0; i < playList.size(); i++) {
            if(i==playList.size()-1) {
                sql += "'" + playList.get(i).toString() + "'";
            }else{
                sql += "'" + playList.get(i).toString() + "',";
            }
        }
            cursor = null;
            cursor = db.rawQuery("SELECT * FROM Question WHERE questionID NOT IN ("+sql+") ORDER BY RANDOM() LIMIT 1", null);
        while (cursor.moveToNext()) {
            String ran = cursor.getString(cursor.getColumnIndex("questionID"));
            final String id = ran;
            String questionQ = cursor.getString(cursor.getColumnIndex("questionQ"));
            String questionVideo =cursor.getString(cursor.getColumnIndex("questionVideo"));
            String questionTrue =cursor.getString(cursor.getColumnIndex("questionTrue"));
            String questionWrong =cursor.getString(cursor.getColumnIndex("questionWrong"));
            tvQuestion.setText(questionQ);
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) videoViewGaming.getLayoutParams();
            params.width = metrics.widthPixels;
            params.height = metrics.heightPixels;
            videoViewGaming.setLayoutParams(params);
            MediaController mc = new MediaController(this);
            videoViewGaming.setMediaController(mc);
            //Toast.makeText(Video.this, uriPath, Toast.LENGTH_SHORT).show();
            Uri uri = Uri.parse(questionVideo);
            videoViewGaming.setVideoURI(uri);
            videoViewGaming.requestFocus();
            videoViewGaming.start();
            videoViewGaming.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    videoViewGaming.start();
                }
            });
            final int newTimes = times-1;
            final String remainder = Integer.toString(newTimes);
            playList.add(id);
            final ArrayList<String> newPlayList = playList;
            Random r = new Random();
            int random = r.nextInt(1 + 1);
            if(random==0) {
                btnLeft.setImageURI(Uri.parse(questionTrue));
                btnLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btnLeft.setClickable(false);
                        final MediaPlayer mpRight  = MediaPlayer.create(context, R.raw.clap);
                        mpRight.start();
                        mpRight.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                if(newTimes==0){
                                    Intent intent = new Intent(context,YouWin.class);
                                    mpRight.release();
                                    startActivity(intent);
                                    finish();
                                }else {
                                    Intent intent = new Intent(context, Gaming.class);
                                    intent.putExtra("times", remainder);
                                    intent.putExtra("playList", newPlayList);
                                    mpRight.release();
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }
                });

                btnRight.setImageURI(Uri.parse(questionWrong));
                btnRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btnRight.setClickable(false);
                        MediaPlayer mpRight  = MediaPlayer.create(context, R.raw.ooooh);
                        mpRight.start();
                        mpRight.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                btnRight.setClickable(true);
                            }
                        });
                    }
                });
                videoViewGaming.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        btnLeft.setVisibility(View.VISIBLE);
                        btnRight.setVisibility(View.VISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable(){
                            @Override
                            public void run(){
                                final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
                                animation.setDuration(500); // duration - half a second
                                animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
                                animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
                                animation.setRepeatMode(Animation.REVERSE);
                                btnLeft.startAnimation(animation);
                            }
                        }, 8000);
                    }
                });
            }else{
                btnLeft.setImageURI(Uri.parse(questionWrong));
                btnLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btnLeft.setClickable(false);
                        MediaPlayer mpRight  = MediaPlayer.create(context, R.raw.ooooh);
                        mpRight.start();
                        mpRight.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                btnLeft.setClickable(true);
                            }
                        });
                    }
                });
                btnRight.setImageURI(Uri.parse(questionTrue));
                btnRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btnRight.setClickable(false);
                        MediaPlayer mpRight  = MediaPlayer.create(context, R.raw.clap);
                        mpRight.start();
                        mpRight.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                if(newTimes==0){
                                    Intent intent = new Intent(context,YouWin.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    Intent intent = new Intent(context, Gaming.class);
                                    intent.putExtra("times", remainder);
                                    intent.putExtra("playList", newPlayList);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
                    }
                });
                videoViewGaming.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        btnLeft.setVisibility(View.VISIBLE);
                        btnRight.setVisibility(View.VISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable(){
                            @Override
                            public void run(){
                                final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
                                animation.setDuration(500); // duration - half a second
                                animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
                                animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
                                animation.setRepeatMode(Animation.REVERSE);
                                btnRight.startAnimation(animation);
                            }
                        }, 8000);
                    }
                });
            }
        }

        db.close();
    }
}
