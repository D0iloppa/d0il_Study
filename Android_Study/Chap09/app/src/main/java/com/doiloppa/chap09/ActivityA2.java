package com.doiloppa.chap09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityA2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);
    }

    public void onCallA3(View view) {
        Intent intent = new Intent(getApplicationContext(),ActivityA3.class);
        startActivity(intent);
    }
}