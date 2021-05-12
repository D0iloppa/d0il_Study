package com.doiloppa.asynctask_oddeven;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.OneShotPreDrawListener;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static Random random = new Random();

    ListView lv1,lv2;
    ArrayList<String> list_Odd = new ArrayList<>();
    ArrayList<String> list_Even = new ArrayList<>();
    ArrayAdapter adapter_Odd,adapter_Even;
    Handler handler;
    OneThread oneThread;
    TwoThread twoThread;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = findViewById(R.id.list_Odd); // 홀수 리스트뷰
        lv2 = findViewById(R.id.list_Even); // 짝수 리스트뷰

        adapter_Odd = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list_Odd);
        adapter_Even = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list_Even);
        lv1.setAdapter(adapter_Odd);
        lv2.setAdapter(adapter_Even);

        handler = new Handler();

        oneThread = new OneThread();
        oneThread.start();

        twoThread = new TwoThread();
        twoThread.start();



    }

    public class OneThread extends Thread{
        Handler oneHandler;

        @Override
        public void run() {
            Looper.prepare();
            oneHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    SystemClock.sleep(1000);
                    final int data=msg.arg1;

                    if(msg.what==0){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                list_Even.add("even:"+data);
                                adapter_Even.notifyDataSetChanged();
                            }
                        });
                    }else if(msg.what==1){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                list_Odd.add("odd:"+data);
                                adapter_Odd.notifyDataSetChanged();
                            }
                        });
                    }
                }
            };

            Looper.loop();
        }

    }

    public class TwoThread extends Thread{

        @Override
        public void run() {
            super.run();
            for(int i=0;i<10;i++){
                SystemClock.sleep(1000);
                int data = random.nextInt(10);
                Message message=new Message();
                if(data % 2 == 0){
                    message.what=0;
                }else {
                    message.what=1;
                }
                message.arg1=data;
                message.arg2=i;
                oneThread.oneHandler.sendMessage(message);
            }

        }
    }




}