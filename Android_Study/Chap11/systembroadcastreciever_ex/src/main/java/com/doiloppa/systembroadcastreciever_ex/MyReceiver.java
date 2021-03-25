package com.doiloppa.systembroadcastreciever_ex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        // 인텐트 필터에 따른 이벤트 처리를 다르게 함
        if(action.equals("android.intent.action.NEW_OUTGOING_CALL")){ // 발신
            String phone_Number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Intent intent2dialog = new Intent(context,DialogActivity.class);
            intent2dialog.putExtra("number",phone_Number);
            intent2dialog.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent2dialog);
        }else if(action.equals("android.intent.action.PHONE_STATE")){ // 전화 수신
            // PHONE_STATE
            // 우선, 번들형태로 가져와야함
            Bundle bundle = intent.getExtras();
            // 폰의 상태
            String state = bundle.getString(TelephonyManager.EXTRA_STATE);
            // 수신자 번호
            String phone_Number = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING) && phone_Number!=null){
                // ( 전화가 울리는 중이고 && 수신자의 번호도 나오는 경우 ) = 전화가 옴
                // 다이얼로그 액티비티로 정보를 넘기기 위한 인텐트 생성
                Intent intent2dialog = new Intent(context,DialogActivity.class);
                // 전화번호 인텐트에 추가
                intent2dialog.putExtra("number",phone_Number);
                // NEW_TASK로 플래그 설정
                intent2dialog.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                // 액티비티 실행
                context.startActivity(intent2dialog);
            }

        }

    }
}