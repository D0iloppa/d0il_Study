package com.doiloppa.timerthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();
    MyThread thread = new MyThread(); // 스레드 인스턴스화
    Boolean thread_Run = false;
    TextView textView;
    int timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.main_textView);

    }


    class MyThread extends Thread{

        public void run(){
            for(int i=10;i>=0;i--){
                timer = i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(timer>0?timer +"":"Finish!!");

                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }



    public void startView(View view) {
        thread_Run = true;
        thread.start();
    }

    public void pauseView(View view) throws InterruptedException {
        thread.interrupt();
    }
}