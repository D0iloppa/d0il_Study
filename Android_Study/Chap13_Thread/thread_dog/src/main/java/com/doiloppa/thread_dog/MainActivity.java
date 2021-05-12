package com.doiloppa.thread_dog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ImageView dog1,dog2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        dog1 = findViewById(R.id.imageView);
        dog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new MoveImg(dog1)).start();
            }
        });

        dog2 = findViewById(R.id.imageView2);
        dog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new MoveImg(dog2)).start();
            }
        });


    }

    class MoveImg implements Runnable{

        ImageView img;

        public MoveImg(ImageView img) {
            this.img = img;
        }

        @Override
        public void run() {
            android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
            for(int i=0;i<20;i++){
                try {
                    Thread.sleep(10);
                    final int finalI = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            RelativeLayout.LayoutParams params =
                                    (RelativeLayout.LayoutParams) img.getLayoutParams();
                            switch (img.getId()){
                                case R.id.imageView:
                                    params.leftMargin = (finalI<10?finalI*85:-85*finalI+1615);
                                    img.setLayoutParams(params);
                                    break;
                                case R.id.imageView2:
                                    params.topMargin = (finalI<10?finalI*85:-85*finalI+1615);
                                    img.setLayoutParams(params);
                                    break;

                            }


                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }

}