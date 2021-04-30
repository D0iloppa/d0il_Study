package com.doiloppa.lec;

public class ThreadSample extends Thread {
    int n = 0;

    public static void main(String[] args) {
        ThreadSample sample = new ThreadSample();
//        sample.run();

        Runnable r = new ThreadSample();
        Thread t = new Thread(r);
        t.start();
    }

    public void run() {
        System.out.println("1초마다 진행된 초 시간을 출력하는 스레드 작동 시작");
        while (true){
            System.out.println(n);
            n++;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
