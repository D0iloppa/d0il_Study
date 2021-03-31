package com.doiloppa.playmusic_service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class PlayService extends Service implements MediaPlayer.OnCompletionListener {

    String filePath;
    MediaPlayer player;

    public PlayService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // 서비스를 생성할 때 한번만 수행
    @Override
    public void onCreate() {
        super.onCreate();
        // 리시버 등록
        registerReceiver(receiver,new IntentFilter("com.doiloppa.PLAY_TO_SERVICE"));
    }

    // 서비스가 시작될 때마다 수행
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 파일주소를 가져옴
        filePath = intent.getStringExtra("filePath");

        return super.onStartCommand(intent, flags, startId);
    }

    // 서비스 안에 브로드캐스트 리시버를 만들어 놓음
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mode = intent.getStringExtra("mode");
            if(mode!=null){
                if(mode.equals("start")){
                    try {
                        if(player!=null&&player.isPlaying()){ // 이미 재생중인 경우에 플레이 버튼을 또 누른 경우
                            // 일단 재생을 멈추고 다시 실행시켜주는 이벤트 작성
                            player.stop();
                            player.release(); // 미디어플레이어를 리셋
                            player = null; // 미디어플레이어를 죽임
                        }
                        player = new MediaPlayer(); // 인스턴스화
                        player.setDataSource(filePath); // 미디어플레이어에 연동
                        player.prepare();
                        player.start();

                        Intent intent2 = new Intent("com.doiloppa.PLAY_TO_ACTIVITY");
                        intent2.putExtra("mode","start");
                        intent2.putExtra("duration",player.getDuration()); // 파일의 길이를 넣어줌
                        sendBroadcast(intent2); // 방송 송출


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if(mode.equals("stop")){
                    if(player!=null&&player.isPlaying()) { // 이미 재생중인 경우에 플레이 버튼을 또 눌름
                        player.stop();
                        player.release(); // 미디어플레이어를 리셋
                        player = null; // 미디어플레이어를 죽임
                    }
                }

            }

        }
    };


    @Override
    public void onCompletion(MediaPlayer mp) {
        // 재생이 끝난 경우의 처리
        // 끝났으므로 stop메시지를 송신하여 재생을 정지시켜줌
        Intent intent = new Intent("com.doiloppa.PLAY_TO_ACTIVITY");
        intent.putExtra("mode","stop");
        sendBroadcast(intent);
        stopSelf(); // 미디어플레이어 종료 메소드

    }


    @Override
    public void onDestroy() { // 서비스 종료시 리시버 등록해제
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}

