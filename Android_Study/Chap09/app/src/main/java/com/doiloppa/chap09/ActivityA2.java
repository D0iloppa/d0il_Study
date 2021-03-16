package com.doiloppa.chap09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityA2 extends AppCompatActivity {
        TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        textView = findViewById(R.id.txtA2);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("caller"));
    }

    public void onCallA3(View view) {
        Intent intent = new Intent(getApplicationContext(),ActivityA3.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        intent.putExtra("caller","A2에서 보냄");
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        textView.setText(intent.getStringExtra("caller"));

    }
}