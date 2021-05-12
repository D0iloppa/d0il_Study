package com.doiloppa.lec;

import java.awt.*;


public class BeepPrint_Ex {
    public static void main(String[] args){

        BeepPrint beepThread = new BeepPrint("사운드 스레드");

//        Thread beepThread = new Thread(new BeepPrint()); // 스레드 안에는 runnable 객체가 들어가야한다.
        beepThread.start();

/*


        Thread thread= new Thread( new Runnable() { // Runnable 익명 내부 클래스
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit(); // 컴퓨터 시스템의 소리를 출력해주는 클래스
                System.out.println();


                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
*/


        Thread currentThread = Thread.currentThread();
        System.out.println("프로그램 시작 스레드 이름 : " + currentThread.getName());



        for(int i=0;i<5;i++){
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
