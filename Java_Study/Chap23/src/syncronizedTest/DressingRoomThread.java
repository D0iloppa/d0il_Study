package syncronizedTest;

public class DressingRoomThread implements Runnable{


    @Override
    public void run() {
        dressing();
    }

    public synchronized void dressing(){
        synchronized (this){
            for(int time_Count = 5 ; time_Count>0;time_Count--){
                try {
                    System.out.print(Thread.currentThread().getName());
                    System.out.println(" dressing 종료 " + time_Count*10 + "초 전...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " dressing 완료");


        }

    }
}
