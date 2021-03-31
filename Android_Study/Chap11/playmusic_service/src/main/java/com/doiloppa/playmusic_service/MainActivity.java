package com.doiloppa.playmusic_service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView playBtn, stopBtn; // 이미지버튼
    ProgressBar progressBar;
    TextView musicName; // 재생중인 파일 이름 표시
    String filePath; // 파일주소




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = findViewById(R.id.lab1_play);
        stopBtn = findViewById(R.id.lab1_stop);
        musicName = findViewById(R.id.lab1_title);
        progressBar = findViewById(R.id.lab1_progress);

        playBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        stopBtn.setEnabled(true);





    }

    @Override
    public void onClick(View v) {

    }
}