package com.match.sunnyside.sunnysidestaff;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class YouWin extends AppCompatActivity {
    TextView textView;
    MediaPlayer mpRight;
    Button playAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_win);
        textView = (TextView)findViewById(R.id.tvWin);
        mpRight  = MediaPlayer.create(this, R.raw.clap);
        mpRight.start();
        mpRight  = MediaPlayer.create(this, R.raw.fireworks);
        mpRight.start();
        mpRight.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                finish();
            }
        });
        playAgain = (Button)findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mpRight.stop();
                finish();
            }
        });
    }
    @Override
    protected void onDestroy(){ //真正作用區
        super.onDestroy();
        //Kill myself
        mpRight.stop();
    }

}
