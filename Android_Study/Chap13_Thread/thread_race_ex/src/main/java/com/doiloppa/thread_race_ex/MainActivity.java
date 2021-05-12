package com.doiloppa.thread_race_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView img1,img2,img3,img4,img5,img6,img7,img8;
    int rank=1;
    int money=10000;

    TextView moneyTxt;

    Button btn;
    ListView listView;

    ValueHandler handler;
    ArrayList<String> rankList;
    ArrayAdapter<String> rankList_Adapter;
    static Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new ValueHandler();

        listView = findViewById(R.id.rank_list);
        rankList = new ArrayList<>();
        rankList_Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rankList);
        listView.setAdapter(rankList_Adapter);

        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView1);
        img3 = findViewById(R.id.imageView2);
        img4 = findViewById(R.id.imageView3);
        img5 = findViewById(R.id.imageView4);
        img6 = findViewById(R.id.imageView5);
        img7 = findViewById(R.id.imageView6);
        img8 = findViewById(R.id.imageView7);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rank = 1;
                rankList_Adapter.clear();
                new Thread(new MoveImg(img1,random.nextInt(90)+10)).start();
                new Thread(new MoveImg(img2,random.nextInt(90)+10)).start();
                new Thread(new MoveImg(img3,random.nextInt(90)+10)).start();
                new Thread(new MoveImg(img4,random.nextInt(90)+10)).start();
                new Thread(new MoveImg(img5,random.nextInt(90)+10)).start();
                new Thread(new MoveImg(img6,random.nextInt(90)+10)).start();
                new Thread(new MoveImg(img7,random.nextInt(90)+10)).start();
                new Thread(new MoveImg(img8,random.nextInt(90)+10)).start();
            }
        });

    }

    class MoveImg implements Runnable{

        ImageView img;
        int v; // 속도

        Handler oneHandler;

        public MoveImg(ImageView img, int v) {
            this.img = img;
            this.v = v;
        }


        @Override
        public void run() {
            Looper.prepare();
            android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
            for(int i=0;i<20;i++){
                try {
                    Thread.sleep(v);
                    final int finalI = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            RelativeLayout.LayoutParams params =
                                    (RelativeLayout.LayoutParams) img.getLayoutParams();
                            params.leftMargin = (finalI<10?finalI*120:-120*finalI+2280);
                            img.setLayoutParams(params);

                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String id = "";
            switch (img.getId()){
                case R.id.imageView:
                    id = "1번마";
                    break;
                case R.id.imageView1:
                    id = "2번마";
                    break;
                case R.id.imageView2:
                    id = "3번마";
                    break;
                case R.id.imageView3:
                    id = "4번마";
                    break;
                case R.id.imageView4:
                    id = "5번마";
                    break;
                case R.id.imageView5:
                    id = "6번마";
                    break;
                case R.id.imageView6:
                    id = "7번마";
                    break;
                case R.id.imageView7:
                    id = "8번마";
                    break;
            }

            String rank_str = (rank++) + "등 : " + id;

            Message message = handler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putString("value",rank_str);
            message.setData(bundle);
            handler.sendMessage(message);

            Looper.loop();



        }
    }

    class ValueHandler extends Handler {


        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            String value = bundle.getString("value");
            rankList_Adapter.add(value);
            rankList_Adapter.notifyDataSetChanged();
        }
    }
}