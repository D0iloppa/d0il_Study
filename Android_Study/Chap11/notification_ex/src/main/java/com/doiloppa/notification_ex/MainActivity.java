package com.doiloppa.notification_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // notification을 사용하려면 매니저와 빌더가 필요하다.
    NotificationManager manager;
    NotificationCompat.Builder builder;


    // 알림을 확인할 수 있는 확인용 버튼 7개 만들었다.
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
            String channelId = "one-channel"; // 채널 아이디
            String channelName = "My Channel"; // 채널 이름
            String channelDescription = "My Channel One Description"; // 채널 설명
            NotificationChannel channel = null;
            if(v==headsUp_Btn) // 중요한 내용은 헤즈업으로 띄워준다. (중요도를 HIGH로 줌)
                channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
            else // 이를 제외하고는 디폴트값
                channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);

            channel.setDescription(channelDescription);
            manager.createNotificationChannel(channel); // 매니저와 채널 연결
            builder = new NotificationCompat.Builder(this, channelId); // 빌더 생성

        } else // 오레오 버전 이하
               // 오레오 버전 이하에서는 채널개념이 없다.
            builder = new NotificationCompat.Builder(this);


        builder.setSmallIcon(android.R.drawable.ic_notification_overlay); // 스몰아이콘 설정
        builder.setContentTitle("알림 타이틀 !!"); // 알림 타이틀 설정
        builder.setContentText("도일맨 짱짱!"); // 알림에 들어갈 내용 설정
        builder.setDefaults(Notification.DEFAULT_ALL|Notification.DEFAULT_LIGHTS|Notification.DEFAULT_SOUND);
        builder.setAutoCancel(true);

        // 펜딩인텐트
        Intent intent = new Intent(this,AnotherActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,10,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);


        // 알림 하단에 액션을 추가 (리시버로 받아줄 수 있다.)
        PendingIntent addActionIntent = PendingIntent.getActivity(this,20,new Intent(this,MyReceiver.class),PendingIntent.FLAG_UPDATE_CURRENT);
        builder.addAction(new NotificationCompat.Action.Builder(android.R.drawable.ic_menu_share,"알림 액션",addActionIntent).build());

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),R.drawable.noti_large);
        builder.setLargeIcon(largeIcon);



        if(v==bigPicture_Btn){ // 빅픽쳐 스타일 알림 기본용법
            Bitmap bigPicture = BitmapFactory.decodeResource(getResources(),R.drawable.noti_big);
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle(builder);
            bigPictureStyle.bigPicture(bigPicture);
            builder.setStyle(bigPictureStyle);
        }else if(v==bigText_Btn){ // 빅텍스트 스타일
            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            bigTextStyle.setSummaryText("빅텍스트 요약");
            bigTextStyle.setBigContentTitle("타이틀입니다");
            bigTextStyle.bigText("출력문구 가나다라마바사아자차카타파하");
            builder.setStyle(bigTextStyle);
        }else if(v==inbox_Btn){ // 인박스 스타일
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            inboxStyle.addLine("도일");
            inboxStyle.addLine("Doil");
            inboxStyle.addLine("맨");
            inboxStyle.addLine("Strong");
            inboxStyle.setSummaryText("요약");
            builder.setStyle(inboxStyle);
        }else if(v==progress_Btn){
            // 스레드를 돌리기 위해서는 Runnable 객체를 생성해야한다.
            // 스레드는 독립적인 실행 객체를 만들어준다.
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for(int i=1 ; i<=10; i++){
                        builder.setAutoCancel(true);
                        builder.setOngoing(true);
                        builder.setProgress(10,i,false);
                        manager.notify(300,builder.build());
                        if(i>=10) manager.cancel(100);
                        SystemClock.sleep(1000);
                    }
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
        }else if(v==headsUp_Btn){ // 헤즈업 스타일
            builder.setFullScreenIntent(pendingIntent,true);
        }else if(v==message_Btn){ // 메시지 알림 스타일
            Person sender1 = new Person.Builder()
                    .setName("Kwon")
                    .setIcon(IconCompat.createWithResource(this,R.drawable.person1))
                    .build();
            Person sender2 = new Person.Builder()
                    .setName("Doil")
                    .setIcon(IconCompat.createWithResource(this,R.drawable.person2))
                    .build();

            // 메시지를 만들어서 나중에 스타일에 추가할 수도 있고
            NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message("Hello World",System.currentTimeMillis(),sender2);

            // 바로 원하는 메시지를 스타일에 만들어 줄 수도 있다.

            NotificationCompat.MessagingStyle style = new NotificationCompat.MessagingStyle(sender1)
                    .addMessage("Good!",SystemClock.currentThreadTimeMillis(),sender1)
                    .addMessage(message);

            builder.setStyle(style);
        }



        manager.notify(1000,builder.build());; //리퀘스트코드, 빌드 요청 => 알림


    }
}