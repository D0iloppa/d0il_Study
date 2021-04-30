package com.doiloppa.lec;

import java.awt.*;

public class BeepPrint extends Thread{
//public class BeepPrint implements Runnable{

    public BeepPrint(String s) { setName(s); }

    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // 컴퓨터 시스템의 소리를 출력해주는 클레스
        for(int i=0;i<5;i++){
            toolkit.beep();
            System.out.println(getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
