package com.doiloppa.notification_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // notification을 사용하려면 매니저와 빌더가 필요하다.
    NotificationManager manager;
    NotificationCompat.Builder builder;


    // 알림과 관련있는 버튼 7개 있음
    Button basic_Btn, bigPicture_Btn, bigText_Btn, inbox_Btn, progress_Btn, headsUp_Btn, message_Btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼들 각 xml 요소들과 연결
        basic_Btn = findViewById(R.id.lab2_basic);
        bigPicture_Btn = findViewById(R.id.lab2_bigpicture);
        bigText_Btn = findViewById(R.id.lab2_bigtext);
        inbox_Btn = findViewById(R.id.lab2_inbox);
        progress_Btn = findViewById(R.id.lab2_progress);
        headsUp_Btn = findViewById(R.id.lab2_headsup);
        message_Btn = findViewById(R.id.lab2_message);


        // 버튼이 많기에 View.OnClickListener을 구현하는 onClick메소드로 뺐다.
        basic_Btn.setOnClickListener(this);
        bigPicture_Btn.setOnClickListener(this);
        bigText_Btn.setOnClickListener(this);
        inbox_Btn.setOnClickListener(this);
        progress_Btn.setOnClickListener(this);
        headsUp_Btn.setOnClickListener(this);
        message_Btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // 오레오 버전 이상
            String channelId = "one-channel";
            String channelName = "My Channel";
            String channelDescription = "My Channel One Description";

            NotificationChannel channel;
            channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelDescription);
            manager.createNotificationChannel(channel);
            builder = new NotificationCompat.Builder(this, channelId);

        } else // 오레오 버전 이하
               // 오레오 버전 이하에서는 채널을 모른다.
            builder = new NotificationCompat.Builder(this);


        builder.setSmallIcon(android.R.drawable.ic_notification_overlay); // 스몰아이콘 설정
        builder.setContentTitle("도일맨"); // 알림 타이틀 설정
        builder.setContentText("짱짱!"); // 알림에 들어갈 내용 설정
        builder.setDefaults(Notification.DEFAULT_ALL|Notification.DEFAULT_LIGHTS|Notification.DEFAULT_SOUND);
        builder.setAutoCancel(true);

        manager.notify(1000,builder.build());; //리퀘스트코드


    }
}