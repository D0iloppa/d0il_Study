package yield;

public class Thread_A extends Thread{
    boolean stop = false;
    boolean work = true;
    int count = 0;

    // 어노테이션을 생략하더라도 작동은 가능
    // Override 어노테이션은 컴파일러에게 명시해주는 부분인거다.
    public void run() {
      while(!stop){
          if(work){
              count++;
              System.out.println("Thread_A is working [" + count+"]");
          }
          else Thread.yield();
      }
      System.out.println("Thread_A is terminated");
    }
}

