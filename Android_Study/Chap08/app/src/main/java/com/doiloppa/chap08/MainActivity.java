package com.doiloppa.chap08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Lifecycle","onCreate 호출됨");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NewActivity.class)); //일회용을 쓴다. 다른 클래스 이기때문에 this X
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("Lifecycle","onConfigurationChanged 호출됨");
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Lifecycle","onRestart 호출됨");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Lifecycle","onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Lifecycle","onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecycle","onDestroy 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Lifecycle","onPause 호출됨");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecycle","onResume 호출됨");

    }

}