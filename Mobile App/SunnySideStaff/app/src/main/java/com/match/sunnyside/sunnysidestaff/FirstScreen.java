package com.match.sunnyside.sunnysidestaff;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FirstScreen extends AppCompatActivity {
    Intent intent;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(5 * 1000);

                    // After 5 seconds redirect to another intent

                    intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };
        try {
            db = SQLiteDatabase.openDatabase("/data/data/com.match.sunnyside.sunnysidestaff/database", null, SQLiteDatabase.CREATE_IF_NECESSARY);

            //sql = "DROP TABLE TEACHER;";
            //db.execSQL(sql);
            //	Toast.makeText(this, "Table Dropped.", 1).show();

            String sql = "CREATE TABLE IF NOT EXISTS Question("
                    + "questionID text PRIMARY KEY,"
                    + "questionQ text NOT NULL,"
                    + "questionVideo text NOT NULL,"
                    + "questionTrue text NOT NULL,"
                    + "questionWrong text NOT NULL);";
            db.execSQL(sql);

            //Toast.makeText(Video.this, uriPath, Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "trading created.", 1).show();
            //db.execSQL("INSERT INTO Question VALUES"
              //      + "('1', '他是誰', '"+videoPath+"', '"+rightPath+"','"+wrongPath+"');");
            //Toast.makeText(this, "TRADING data inserted.", 1).show(); */

            db.close();
        } catch (SQLiteException e) {
            //Toast.makeText(this, e.getMessage(),  1).show();
        }

        // startgame thread
        background.start();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}
