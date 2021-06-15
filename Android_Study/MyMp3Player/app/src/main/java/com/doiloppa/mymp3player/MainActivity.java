package com.doiloppa.mymp3player;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.Time;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> list;


    Button btn_Play, btn_Pause, btn_Stop;
    TextView tv_Title, tv_Time;
    SeekBar seekBar;
    String sdPath;
    String uri;

    MediaPlayer mediaPlayer;
    boolean isPlayin = false;
    int list_num = -1;
    int pos = 0; // 음악의 현재 위치

    public String getPlayTime(int sec) {
        int m, s;
        s = sec % 60;
        m = sec / 60;
        return String.format("%02d:%02d", m, s);

    }

    // 음악 재생을 위한 스레드
    class PlayThread extends Thread {
        @Override
        public void run() {
            tv_Title.setText("실행중인 음악 : " + list.get(list_num));


            while (isPlayin) {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                tv_Time.setText("진행 시간 : " + getPlayTime(seekBar.getProgress() / 1000));
            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{
                "android.permission.WRITE_EXTERNAL_STORAGE",
                "android.permission.READ_EXTERNAL_STORAGE"
        }, 0);

        listView = findViewById(R.id.music_list);
        list = new ArrayList<>();
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_single_choice, list);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem;
                selectedItem = list.get(position);
                list_num = position;
                uri = sdPath + "/" + selectedItem;
            }
        });


        //////////////////////////////
        // SD카드 파일 불러오기

        String externalStorageState = Environment.getExternalStorageState();

        if (externalStorageState.equals(Environment.MEDIA_MOUNTED))
            sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        else sdPath = Environment.MEDIA_UNMOUNTED;

        try {
            File sdFile = new File(sdPath);

            String[] filenames = sdFile.list(null);

            for (int i = 0; i < filenames.length; i++) {
                String filename = filenames[i];
                // mp3로 끝나는 파일만 가져와서 리스트에 추가
                if (filename.toLowerCase().endsWith("mp3")) {
                    String mp3File = filename;
                    list.add(mp3File);
                }
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "파일 리스트 불러오기 실패", Toast.LENGTH_SHORT).show();

        }

        // 뷰 가져오기
        btn_Play = findViewById(R.id.btn_Start);
        btn_Play.setOnClickListener(this);
        btn_Pause = findViewById(R.id.btn_Pause);
        btn_Pause.setOnClickListener(this);
        btn_Stop = findViewById(R.id.btn_Stop);
        btn_Stop.setOnClickListener(this);

        tv_Title = findViewById(R.id.txt_title);
        tv_Time = findViewById(R.id.txt_time);


        // seekbar
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.getMax() == progress) {
                    // 프로그레스가 가득 찼을 경우
                    isPlayin = false;
                    mediaPlayer.stop();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isPlayin = false;
                mediaPlayer.pause();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                isPlayin = true;
                int target = seekBar.getProgress();
                mediaPlayer.seekTo(target);
                mediaPlayer.start();
                new PlayThread().start();

            }
        });


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_Start: // 재생버튼
                play();
                break;
            case R.id.btn_Pause: // 일시정지 버튼
                pause();
                break;
            case R.id.btn_Stop: // 중지 버튼
                stop();
                break;
        }

    }


    private void play() {
        if (list_num == -1) {
            // 아직 리스트가 체크되지 않았으므로 재생시키지 않는다.
            Toast.makeText(getApplicationContext(), "먼저 파일을 선택해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isPlayin) { // 재생중이 아닐때만 작동되도록한다. 재생중에 또 재생 누르면 아무 반응x
            if (mediaPlayer == null) {
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(uri);
                    mediaPlayer.prepare();
                    mediaPlayer.start();

                    int music_Length = mediaPlayer.getDuration(); // 노래의 길이
                    seekBar.setMax(music_Length);// seekbar의 최대크기를 노래의 길이로 지정
                    PlayThread playThread = new PlayThread(); //
                    playThread.start();
                    isPlayin = true;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                mediaPlayer.seekTo(pos);
                mediaPlayer.start();
                isPlayin = true;
                new PlayThread().start();
            }
        }

    }

    private void pause() {
        if (mediaPlayer == null) return;

        pos = mediaPlayer.getCurrentPosition();
        mediaPlayer.pause();
        isPlayin = false;
    }

    private void stop() {
        if (mediaPlayer == null) return;

        isPlayin = false;
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;

        // 초기화
        seekBar.setProgress(0);
        pos = 0;

        tv_Title.setText("실행중인 음악 :");
        tv_Time.setText("진행 시간 :");
    }


}