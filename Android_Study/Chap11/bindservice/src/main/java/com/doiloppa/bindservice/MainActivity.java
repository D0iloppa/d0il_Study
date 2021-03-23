package com.doiloppa.bindservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    MyService myService;
    boolean isService = false;
    
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder mBinder = (MyService.MyBinder) service;
            myService = mBinder.getService();
            isService = true;
            
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isService = false;
        }
    };
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_Start = findViewById(R.id.button1);
        Button btn_End = findViewById(R.id.button2);
        Button btn_Confrim = findViewById(R.id.button3);
        
        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MyService.class);
                bindService(intent,connection,BIND_AUTO_CREATE);        
                
            }
        });
        
        btn_End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isService){
                    unbindService(connection);
                    isService = false;
                } else {
                    Toast.makeText(getApplicationContext(), "연결된 서비스 없음", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        btn_Confrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isService) {
                    int num = myService.getRandom();
                    Toast.makeText(getApplicationContext(), "받아온 데이터 : "+num, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "서비스 중이 아닙니다. 데이터를 받을 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        
        
    }


}