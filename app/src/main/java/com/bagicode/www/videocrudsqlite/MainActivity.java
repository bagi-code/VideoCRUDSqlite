package com.bagicode.www.videocrudsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnCreate (View v){
        Intent goCreate = new Intent(MainActivity.this, MainCreate.class);
        startActivity(goCreate);
    }

    public void btnRead (View v){
        Intent goRead = new Intent(MainActivity.this, MainRead.class);
        startActivity(goRead);
    }
}
