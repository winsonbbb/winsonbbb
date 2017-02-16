package com.match.sunnyside.sunnysidestaff;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    LinearLayout llScroll;
    Button btnOut;
    SQLiteDatabase db;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        btnOut = (Button)findViewById(R.id.btnOut);
        llScroll = (LinearLayout) findViewById(R.id.llScroll);
        db = SQLiteDatabase.openDatabase("/data/data/com.match.sunnyside.sunnysidestaff/database", null, SQLiteDatabase.CREATE_IF_NECESSARY);

        Cursor cursor = db.rawQuery("SELECT * FROM Question Order By questionID",null);

        while (cursor.moveToNext()) {
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT));
            TextView titleView = new TextView(this);
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT);
            final float scale = getResources().getDisplayMetrics().density;
            llp.weight =0.3f;
            int dp = (int) (30 * scale + 0.5f);
            titleView.setLayoutParams(llp);
            titleView.setTextSize(dp);
            titleView.setBackgroundResource(R.drawable.textbar);
            String ID = cursor.getString(cursor.getColumnIndex("questionID"));
            final String questionID = ID;
            String question = cursor.getString(cursor.getColumnIndex("questionQ"));
            titleView.setText(question);
            layout.addView(titleView);
            LinearLayout.LayoutParams llp2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT);
            ImageButton newButton = new ImageButton(this);
            llp2.weight = 0.7f;
            newButton.setLayoutParams(llp2);
            newButton.setBackgroundResource(R.drawable.delrecord);
            newButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which){
                                case DialogInterface.BUTTON_POSITIVE:

                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.match.sunnyside.sunnysidestaff/database", null, SQLiteDatabase.CREATE_IF_NECESSARY);
                                    String sql = "DELETE FROM Question WHERE questionID ='"+questionID+"';";
                                    db.execSQL(sql);
                                    Toast.makeText(context,"已經成功刪除",Toast.LENGTH_LONG).show();
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                    db.close();
                                    break;
                            }
                        }
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("你真的要刪除嗎?").setPositiveButton("No", dialogClickListener)
                            .setNegativeButton("Yes", dialogClickListener).show();

                }
            });

            layout.addView(newButton);
            llScroll.addView(layout);
        }
        db.close();
        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
