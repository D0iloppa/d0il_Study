package com.doiloppa.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Random;

public class MyService extends Service {

    private  final  IBinder mBinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {

        return mBinder;
    }

    class MyBinder extends Binder {
        MyService getService(){
            return MyService.this;
        }

    }
    
    int getRandom(){
        return  new Random().nextInt(100);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Service End", Toast.LENGTH_SHORT).show();
    }
}