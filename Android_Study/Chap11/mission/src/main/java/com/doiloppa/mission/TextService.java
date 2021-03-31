package com.doiloppa.mission;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class TextService extends Service {
    public TextService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {



        String txt = intent.getStringExtra("sendTxt");
        // 메인 액티비티로부터 메시지를 받음
        Log.i("test","메인액티비티로부터 보낸 메시지를 서비스가 받음");

        intent = new Intent("android.action.MY_ACTION");
        intent.setAction("android.action.MY_ACTION");
        intent.putExtra("txt_From_Service", txt);




        sendBroadcast(intent);

        Log.i("test","서비스에서 리시버로 전송");

        return super.onStartCommand(intent, flags, startId);
    }
}