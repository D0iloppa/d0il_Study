package com.doiloppa.multimedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_Record,btn_RecStop,btn_Play,btn_Stop;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위험권한
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.RECORD_AUDIO},0);

        btn_Record = findViewById(R.id.button);
        btn_Record.setOnClickListener(this);

        btn_RecStop = findViewById(R.id.button2);
        btn_RecStop.setOnClickListener(this);

        btn_Play = findViewById(R.id.button3);
        btn_Play.setOnClickListener(this);

        btn_Stop = findViewById(R.id.button4);
        btn_Stop.setOnClickListener(this);

        filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+
                "/Download/recordData.mp3";



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                if(mediaRecorder!=null){
                    mediaRecorder.stop();
                    mediaRecorder.release();
                    mediaRecorder = null;
                }else {
                    mediaRecorder = new MediaRecorder();
                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                    mediaRecorder.setOutputFile(filePath);

                    Toast.makeText(getApplicationContext(), "녹음을 시작합니다.", Toast.LENGTH_SHORT).show();
                    
                    try {
                        mediaRecorder.prepare();
                        mediaRecorder.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                
                break;
            case R.id.button2:
                if(mediaRecorder==null) return;
                else{
                    mediaRecorder.stop();
                    mediaRecorder.release();
                    mediaRecorder = null;
                    Toast.makeText(getApplicationContext(), "녹음을 중지합니다.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button3:
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }else{
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(filePath);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                        Toast.makeText(getApplicationContext(), "재생을 시작합니다.", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.button4:
                if(mediaPlayer ==null) return;
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                Toast.makeText(getApplicationContext(), "재생을 중지합니다.", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}