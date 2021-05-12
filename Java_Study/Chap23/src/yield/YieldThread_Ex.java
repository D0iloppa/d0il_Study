package yield;

public class YieldThread_Ex {
    public static void main(String[] args) {
        Thread_A threadA = new Thread_A();
        Thread_B threadB = new Thread_B();

        threadA.start();
        threadB.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadA.work=false;
        threadB.work=true;


        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadA.work=true;
        threadB.work=false;

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadA.stop=true;
        threadB.stop=true;


    }
}
