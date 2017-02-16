package com.match.sunnyside.sunnysidestaff;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


public class AddThird extends AppCompatActivity {
    VideoView videoViewfinal;
    ImageView finalImgTrue, finalImgWrong;
    TextView tvReview;
    MediaController mc;
    Button btnFinalConfirm,btnResetAll;
    SQLiteDatabase db;
    Context context = this;
    private static int RESULT_END = 2;
    private static int RESULT_RESET = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_third);
        final String videoPath = getIntent().getStringExtra("videoPath");
        final String picTruePath = getIntent().getStringExtra("picTruePath");
        final String picWrongPath = getIntent().getStringExtra("picWrongPath");
        final String question = getIntent().getStringExtra("question");
        tvReview = (TextView) findViewById(R.id.tvReview);
        btnFinalConfirm = (Button)findViewById(R.id.btnFinalConfirm);
        btnResetAll = (Button)findViewById(R.id.btnResetAll);
        btnFinalConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db = SQLiteDatabase.openDatabase("/data/data/com.match.sunnyside.sunnysidestaff/database", null, SQLiteDatabase.CREATE_IF_NECESSARY);

                    //Toast.makeText(this, "trading created.", 1).show();
                    Cursor cursor = db.rawQuery("SELECT * FROM Question ORDER BY questionID DESC LIMIT 1", null);
                    int last = 0;
                    while (cursor.moveToNext()) {
                        last = Integer.parseInt(cursor.getString(cursor.getColumnIndex("questionID")));
                    }
                    last = last+1;
                    db.execSQL("INSERT INTO Question VALUES"
                            + "('"+last+"', '"+question+"', '"+videoPath+"', '"+picTruePath+"','"+picWrongPath+"');");
                    Toast.makeText(context, "Question inserted.", Toast.LENGTH_LONG).show();
                    db.close();

                } catch (SQLiteException e) {
                    //Toast.makeText(this, e.getMessage(),  1).show();
                }
                setResult(RESULT_END);
                finish();
            }
        });
        btnResetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_RESET);
                finish();
            }
        });
        tvReview.setText(question);
        finalImgTrue = (ImageView) findViewById(R.id.finalImgTrue);
        finalImgWrong = (ImageView) findViewById(R.id.finalImgWrong);
        finalImgTrue.setImageURI(Uri.parse(picTruePath));
        finalImgWrong.setImageURI(Uri.parse(picWrongPath));
        videoViewfinal = (VideoView) findViewById(R.id.videoViewfinal);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) videoViewfinal.getLayoutParams();
        params.width = metrics.widthPixels;
        params.height = metrics.heightPixels;
        videoViewfinal.setLayoutParams(params);
        mc = new MediaController(this);
        videoViewfinal.setMediaController(mc);
        //Toast.makeText(Video.this, uriPath, Toast.LENGTH_SHORT).show();
        Uri uri = Uri.parse(videoPath);
        videoViewfinal.setVideoURI(uri);
        videoViewfinal.requestFocus();
        videoViewfinal.start();
    }
}
