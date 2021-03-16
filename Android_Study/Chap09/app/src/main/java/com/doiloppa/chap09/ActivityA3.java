package com.doiloppa.chap09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityA3 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);
        textView = findViewById(R.id.txtA3);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("caller"));
    }

    public void onCallA3(View view) { // 자기 자신액티비티를 실행시킴
        Intent intent = new Intent(getApplicationContext(),ActivityA3.class);
        intent.putExtra("caller","A3에서 보냄");
        startActivity(intent);

    }
}