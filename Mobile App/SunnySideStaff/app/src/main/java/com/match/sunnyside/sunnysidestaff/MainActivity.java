package com.match.sunnyside.sunnysidestaff;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnsStart;
    Button btnEdit;
    SQLiteDatabase db;

    protected void setView() {
        btnsStart = (Button) findViewById(R.id.btnStart);
        btnEdit = (Button) findViewById(R.id.btnEdit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }

    public void edit(View view) {
        Intent intent = new Intent(this, Edit.class);
        startActivity(intent);

    }

    public void start(View view) {
        Intent intent = new Intent(this, Start.class);
        startActivity(intent);
    }

}
