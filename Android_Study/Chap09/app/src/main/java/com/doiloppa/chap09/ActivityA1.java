package com.doiloppa.chap09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityA1 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        textView = findViewById(R.id.txtA1);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("caller"));
    }

    public void onCallA2(View view) {
        Intent intent = new Intent(getApplicationContext(),ActivityA2.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        intent.putExtra("caller","A1에서 보냄");
        startActivity(intent);

    }
}