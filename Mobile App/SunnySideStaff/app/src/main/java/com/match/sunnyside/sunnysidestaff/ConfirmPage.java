package com.match.sunnyside.sunnysidestaff;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class ConfirmPage extends AppCompatActivity {
    VideoView videoView;
    Button btnConfirm, btnCancel;
    String type ="";
    String path ="";
    MediaController mc;
    final Context context =this;
    private static int RESULT_END = 2;
    private static int RESULT_RESET = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_page);
        type = getIntent().getStringExtra("type");
        path = getIntent().getStringExtra("path");
        String videoPath = path;
        videoView = (VideoView) findViewById(R.id.confirmVideo);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(cancelVideo);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(confirmVideo);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) videoView.getLayoutParams();
        params.width = metrics.widthPixels;
        params.height = metrics.heightPixels;
        videoView.setLayoutParams(params);
        mc = new MediaController(this);
        videoView.setMediaController(mc);
        //Toast.makeText(Video.this, uriPath, Toast.LENGTH_SHORT).show();
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }

    View.OnClickListener confirmVideo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            btnConfirm.setClickable(false);
            Log.d("**********","  ");
            if(type.equals("choose")) {
                try {
                    File a = new File(path);
                    String newPath = getIntent().getStringExtra("newPath");
                    File b = new File(newPath);
                    copy(a, b);
                    Intent intent = new Intent(context,AddSecond.class);
                    intent.putExtra("Path",newPath);
                    startActivityForResult(intent,2);
                    finish();
                }catch(IOException e){
                    Log.d("**********",e.toString());
                }
            }else if(type.equals("new")){
                Intent intent = new Intent(context,AddSecond.class);
                intent.putExtra("Path",path);
                startActivityForResult(intent,2);
            }
        }
    };

    View.OnClickListener cancelVideo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            btnCancel.setClickable(false);
            if(type.equals("new")){
                File file =new File(path);
                file.delete();
                finish();
            }else{
                finish();
            }
        }
    };

    public void onPause() {
        super.onPause();  // Always call the superclass method first

        // Release the Camera because we don't need it when paused
        // and other activities might need to use it.
    }

    @Override
    public void onResume() {
        super.onResume();
        // put your code here...
        videoView.requestFocus();
        videoView.start();

    }
    public void copy(File src, File dst) throws IOException {
        FileInputStream inStream = new FileInputStream(src);
        FileOutputStream outStream = new FileOutputStream(dst);
        FileChannel inChannel = inStream.getChannel();
        FileChannel outChannel = outStream.getChannel();
        inChannel.transferTo(0, inChannel.size(), outChannel);
        inStream.close();
        outStream.close();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == RESULT_END) {
            setResult(RESULT_END);
            finish();

            }else if (resultCode == RESULT_RESET) {
                setResult(RESULT_RESET);
                finish();
            }

    }
}
