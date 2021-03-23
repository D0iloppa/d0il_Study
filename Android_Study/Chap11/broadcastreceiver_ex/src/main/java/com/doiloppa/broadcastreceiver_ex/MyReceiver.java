package com.doiloppa.broadcastreceiver_ex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public static String MY_ACTION = "action.ACTION_MY_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(MY_ACTION.equals(intent.getAction())){
            Toast.makeText(context, "브로드캐스트 수신됨", Toast.LENGTH_SHORT).show();
            // 방송을 수신후 그에 맞는 이벤트 처리를 해준다.

            abortBroadcast(); // 그 후 방송을 종료
        }
    }
}