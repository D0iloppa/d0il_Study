package com.KwonKooLook.shop;

import android.os.Handler;
import android.os.Message;

public class IntroThread extends Thread {

    private android.os.Handler handler;

    public IntroThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        Message msg = new Message();

        try{
            Thread.sleep(3000);
            msg.what = 1;
            handler.sendEmptyMessage(msg.what);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
