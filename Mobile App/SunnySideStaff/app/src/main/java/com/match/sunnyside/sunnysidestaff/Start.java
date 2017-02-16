package com.match.sunnyside.sunnysidestaff;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class Start extends AppCompatActivity {
    final Context context = this;
    Button startGame;
    TextView tvCountdown;
    EditText etTime;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_start);
        startGame = (Button) findViewById(R.id.startGame);
        tvCountdown = (TextView) findViewById(R.id.tvCountdown);
        etTime = (EditText) findViewById(R.id.etTime);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.match.sunnyside.sunnysidestaff/database", null, SQLiteDatabase.CREATE_IF_NECESSARY);
                Cursor cursor = db.rawQuery("SELECT * FROM Question", null);
                int count = cursor.getCount();
                if (count < Integer.valueOf(etTime.getText().toString())) {
                    Toast.makeText(context, "不夠問題可供遊玩 請重新選擇", Toast.LENGTH_SHORT).show();
                } else {
                    tvCountdown.setVisibility(View.VISIBLE);
                    final String times = etTime.getText().toString();
                    final MediaPlayer mp = MediaPlayer.create(context, R.raw.beep);
                    countDown(tvCountdown, 3, mp);
                    Thread background = new Thread() {
                        public void run() {

                            try {
                                // Thread will sleep for 5 seconds
                                sleep(3 * 1000);
                                sleep(700);
                                // After 5 seconds redirect to another intent
                                ArrayList<String> playList = new ArrayList<String>();
                                ArrayList<String> randomList = new ArrayList<String>();
                                intent = new Intent(getBaseContext(), Gaming.class);
                                intent.putExtra("times", times);
                                intent.putExtra("playList", playList);
                                startActivity(intent);
                                finish();

                            } catch (Exception e) {

                            }
                        }
                    };
                    background.start();
                }
            }
        });
    }
    private void countDown(final TextView tv, final int count,final MediaPlayer mp) {
        if (count == 0) {
            tv.setText("開始"); //Note: the TextView will be visible again here.
            return;
        }
        tv.setText(String.valueOf(count));
        AlphaAnimation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(1000);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mp.start();
            }

            public void onAnimationEnd(Animation anim) {

                countDown(tv, count - 1,mp);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
        tv.startAnimation(animation);
    }

    @Override
    public void onResume() {
        super.onResume();
        tvCountdown.setVisibility(View.GONE);
    }
}
