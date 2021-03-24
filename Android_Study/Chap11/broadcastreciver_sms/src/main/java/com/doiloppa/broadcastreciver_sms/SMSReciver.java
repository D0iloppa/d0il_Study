package com.doiloppa.broadcastreciver_sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SMSReciver extends BroadcastReceiver {

    // 시간이 표시되는 포맷정의 (디폴트는 미국식이라서 헷갈릴 수 있기때문에 보기 편한 형태로 정의해줌)
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public void onReceive(Context context, Intent intent) {
        // 문자메시지를 받았을 때 처리하는 이벤트
        Bundle bundle = intent.getExtras();
        SmsMessage[] message = parseSMSMessage(bundle);


        // 제일 최근 메시지의 데이터들을 각각 변수에 담아서 intent에 put해준다.

        String sender = message[0].getOriginatingAddress(); // 발신번호 확인
        String content = message[0].getMessageBody(); // 발신 메시지 확인
        Date receiveDate = new Date(message[0].getTimestampMillis()); // 수신시간 확인

        intent = new Intent(context, SmsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("sender", sender);
        intent.putExtra("contents", content);
        intent.putExtra("receiveDate", dateFormat.format(receiveDate)); // 시간을 포맷에 맞게 변환시키고 추가
        // 여기까지 백엔드에서 처리되는 부분

        // 액티비티를 실행시켜준다.
        context.startActivity(intent);

    }

    private SmsMessage[] parseSMSMessage(Bundle bundle) {
        // sms 데이터를 처리하는 SMTP가 있는데
        // 그 안에 pdus라는 이름의 sms 정보들이 들어있음
        // 실제 메시지는 pdus를 object[]로 변환해야 함
        Object[] objects = (Object[]) bundle.get("pdus");
        // sms를 받아올 SMS Message 배열을 만듬
        SmsMessage[] messages = new SmsMessage[objects.length];
        for (int i = 0; i < objects.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // 각 메시지를 추출하기 위해 사용( Pdu 포맷으로 되어있는 메시지를 복원
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objects[i], format);
            } else
                messages[i] = SmsMessage.createFromPdu((byte[]) objects[i]);
        }

        return messages;
    }

}

