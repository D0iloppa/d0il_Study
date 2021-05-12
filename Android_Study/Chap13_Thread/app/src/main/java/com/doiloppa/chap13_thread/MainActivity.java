package com.doiloppa.chap13_thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MyHandler handler = new MyHandler(); // 핸들러는 보통 전역적으로 사용한다.
    Handler handler2 = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        
        
    }

    public void onThread(View view) { //스레드 버튼의 온클릭 메소드
        MyThread thread = new MyThread(); // 스레드 인스턴스화
        thread.start(); // 스레드 시작
    }


    class MyThread extends Thread{
        public void run(){
            for(int i=0;i<100;i++){
                String str = "#" + i +" 호출됨";


                /*

                // 스레드에서 ui로 직접접근이 되지 않기 때문에 그냥쓰면 에러발생
                // 핸들러를 통해서 메세지를 주고받는 방식으로 접근해야한다.
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("data",str);
                message.setData(bundle); // 메세지에 번들을 넣어준다.
                handler.sendMessage(message); // 메세지를 우선, 메세지 큐로 보내준다.

                */

                /*
                // 이번 경우에는 단순하게 i의 값만 보내기 때문에
                // 번들형태로 복잡하게 만들어서 데이터를 전송할 필요 없이
                // 아래처럼 간단하게 전달가능
                handler.sendEmptyMessageDelayed(i,500);
                */

                handler2.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(str);
                    }
                });



                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                Log.d("MyThread",str); //로그는 정상적으로 찍힘


            }

        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            /*Bundle bundle = msg.getData();
            String str = bundle.getString("data");
            textView.setText(str);*/

            // 단순 int값만 전달받는 경우는 이렇게 간단하게 메세지 전달 가능하다.
            textView.setText("#"+msg.what+" 호출됨");
        }
    }


}