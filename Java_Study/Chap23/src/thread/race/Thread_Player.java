package thread.race;

import com.doiloppa.lec.CalcThread;

public class Thread_Player extends Thread{
    public Thread_Player(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for(int i=0;i<20000;i++){ }
        System.out.println(getName() + " is arrived");
    }

}