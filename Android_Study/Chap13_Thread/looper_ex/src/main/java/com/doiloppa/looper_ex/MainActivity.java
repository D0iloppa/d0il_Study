package com.doiloppa.looper_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText,editText2;
    MainHandler mainHandler = new MainHandler();
    NewThread newThread = new NewThread();
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Message message = Message.obtain();
                message.obj = str;
                newThread.newHandler.handleMessage(message);

            }
        });

        newThread.start();
    }

    class NewThread extends Thread{

        NewHandler newHandler = new NewHandler(); // 스레드 안에 들어있는 핸들러
        public void run(){
            Looper.prepare();
            Looper.loop();

        }
    }

    class NewHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {

            Message message = Message.obtain();
            message.obj = (String) msg.obj+"Android"; // 메시지를 받아와서 뒤에 Android 문구를 삽입하고 새로운 메시지로 만듬

            handler.post(new Runnable() {
                @Override
                public void run() {
                    editText2.setText((String)msg.obj);
                }
            });
        }
    }

    class MainHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {

        }
    }


}