package com.doiloppa.playmusic_service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView playBtn, stopBtn; // 이미지버튼
    ProgressBar progressBar;
    TextView musicName; // 재생중인 파일 이름 표시
    String filePath; // 파일주소
    boolean runThread = false;




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
        stopBtn.setEnabled(false);  // 버튼이 안눌리도록 설정 ( 음악 재생중 아니면 잠금)

        filePath = "/data/data/com.doiloppa.playmusic_service/sample.mp3";

        // 위험권한이 허용되지 않았을 경우 허용 요청하는 창 뜨도록 함
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
        }

        // 서비스 실행시킬 인텐트
        Intent intent = new Intent(getApplicationContext(),PlayService.class);
        intent.putExtra("filePath",filePath);
        startService(intent);

        // 리시버 등록
        registerReceiver(receiver,new IntentFilter("com.doiloppa.PLAY_TO_ACTIVITY"));


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent("com.doiloppa.PLAY_TO_SERVICE");
        if(v==playBtn){
            intent.putExtra("mode","start");
            sendBroadcast(intent); //방송 송출
            runThread = true;

            // 프로그레스바 스레드 실행시킴
            ProgressThread progressThread = new ProgressThread();
            progressThread.start();
            playBtn.setEnabled(false); //
            stopBtn.setEnabled(true);
        }else{
            intent.putExtra("mode","stop");
            sendBroadcast(intent);
            runThread = false;
            progressBar.setProgress(0);
            playBtn.setEnabled(true);
            stopBtn.setEnabled(false);
        }
    }


    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mode = intent.getStringExtra("mode");
            if(mode!=null){
                if(mode.equals("start")){
                    int duration = intent.getIntExtra("duration",0);
                    progressBar.setMax(duration);
                    progressBar.setProgress(0);
                }else if(mode.equals("stop")){
                    progressBar.setProgress(0); // 프로그레스바를 0으로 만들어줌
                    runThread = false; // 스레드를 멈춤
                }
            }
        }
    };

    @Override
    protected void onDestroy() { // 프로그램 종료시 서비스 종료, 리시버 등록해제
        super.onDestroy();
        Intent intent = new Intent(getApplicationContext(),PlayService.class);
        stopService(intent); // 서비스 종료

        unregisterReceiver(receiver);
    }

    class ProgressThread extends Thread{ // 프로그레스바의 진행을 위한 쓰레드 생성
        @Override
        public void run() {
            while(runThread){
                progressBar.incrementProgressBy(1000);
                SystemClock.sleep(1000);
                if(progressBar.getProgress()==progressBar.getMax()){ // 프로그레스바가 꽉참
                    progressBar.setProgress(0); // 프로그레스바를 0으로 만들어줌
                    runThread = false;
                }
            }

        }
    }


}