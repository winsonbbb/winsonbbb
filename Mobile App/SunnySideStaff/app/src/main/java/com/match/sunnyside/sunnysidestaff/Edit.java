package com.match.sunnyside.sunnysidestaff;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Edit extends AppCompatActivity {
    private static int RESULT_END = 2;
    Button add, delete,btnOutEdit;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        add = (Button) findViewById(R.id.add);
        delete = (Button) findViewById(R.id.delete);
        btnOutEdit =  (Button) findViewById(R.id.btnOutEdit);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddFirst.class);
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Delete.class);
                startActivity(intent);
            }
        });
        btnOutEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            if (resultCode == RESULT_END) {
                finish();

            }

        }
    }
}