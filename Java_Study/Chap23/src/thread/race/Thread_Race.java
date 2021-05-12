package thread.race;

import com.doiloppa.lec.CalcThread;

public class Thread_Race {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread_Player("Thread 경기마 " + (i<10? i: "Cheeta"));
            if (i < 10)
                thread.setPriority(Thread.MIN_PRIORITY);
            else
                thread.setPriority(Thread.MAX_PRIORITY);

            thread.start();

        }
    }

}


