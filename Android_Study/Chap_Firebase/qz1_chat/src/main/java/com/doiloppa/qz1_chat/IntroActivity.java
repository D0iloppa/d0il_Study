package com.doiloppa.qz1_chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Handler handler = new Handler();
        // 2초간 액티비티를 보여준다.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 2초 후 다음 액티비티로 이동
                startActivity(new Intent(getApplicationContext(),InputNameActivity.class));
                finish();
            }
        },2000);
              

    }
}