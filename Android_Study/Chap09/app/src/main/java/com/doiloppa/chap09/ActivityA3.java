package com.doiloppa.chap09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        Log.i("LifeCycle","onCreate 호출");
    }

    public void onCallA2(View view) { // A2로 이동
        Intent intent = new Intent(getApplicationContext(),ActivityA2.class);
        intent.putExtra("caller","A3에서 보냄(A2 액티비티를 다시 호출)");
        startActivity(intent);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        textView.setText(intent.getStringExtra("caller"));
        Log.i("LifeCycle","onNewIntent 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle","onStart 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle","onStop 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle","onDestroy 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle","onResume 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle","onPause 호출");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeCycle","onRestart 호출");
    }
}