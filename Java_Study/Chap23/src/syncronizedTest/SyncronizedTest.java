package syncronizedTest;

import thread.race.Thread_Player;

public class SyncronizedTest {
    public static void main(String[] args) {

        DressingRoomThread dr = new DressingRoomThread();

        Thread t1 = new Thread(dr,"첫 번째 손님");
        Thread t2 = new Thread(dr,"두 번째 손님");
        t1.start();
        t2.start();

    }
}
