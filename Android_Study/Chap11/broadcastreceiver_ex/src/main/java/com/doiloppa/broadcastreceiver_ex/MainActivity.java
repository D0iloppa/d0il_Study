package com.doiloppa.broadcastreceiver_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastReceiver = new MyReceiver(); // 브로드캐스트 리시버 인스턴스화
        IntentFilter filter = new IntentFilter(); // 필터 생성
        filter.addAction(MyReceiver.MY_ACTION);
        registerReceiver(broadcastReceiver,filter); // 리시버 등록
    }


    public void onSend(View view) {
        // 인텐트에 액션정보를 설정하고 보내준다.
        // 브로드캐스트 리시버도 인텐트로 수신함
        // 앱에서 방송을 송출함
        Intent intent = new Intent(MyReceiver.MY_ACTION);
        sendBroadcast(intent);
    }
}