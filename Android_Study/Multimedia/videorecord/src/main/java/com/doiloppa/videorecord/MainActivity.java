package com.doiloppa.videorecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.media.CamcorderProfile;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String filePath;
    SurfaceHolder surfaceHolder;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    String fileName;
    int fileIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.CAMERA}, 0);

        // 가로화면 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        filePath = Environment.getExternalStorageDirectory().getAbsolutePath();

        SurfaceView surfaceView = new SurfaceView(this);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        FrameLayout frameLayout = findViewById(R.id.layout);
        frameLayout.addView(surfaceView);


    }

    public void onRecStart(View view) {
        if(mediaRecorder==null) mediaRecorder = new MediaRecorder();

        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
//        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
//        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
//        mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);
//        mediaRecorder.setVideoEncodingBitRate(8*500000);
//        mediaRecorder.setVideoSize(1280,720);
//        mediaRecorder.setMaxDuration(60*1000);
//        mediaRecorder.setMaxFileSize(50000 * 1000);

        mediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_720P));

        fileName = filePath+ File.separator+"Recoding_Data_"+(fileIndex++)+".mp4";
        mediaRecorder.setOutputFile(fileName);
        mediaRecorder.setPreviewDisplay(surfaceHolder.getSurface());

        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onRecStop(View view) {
        if(mediaRecorder==null) return;
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
    }

    public void onPlay(View view) {
        if(mediaPlayer==null) {
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(fileName);
                mediaPlayer.setDisplay(surfaceHolder);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onPlayStop(View view) {
        if(mediaPlayer==null) return;
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}