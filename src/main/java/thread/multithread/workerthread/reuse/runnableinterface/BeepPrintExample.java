package thread.multithread.workerthread.reuse.runnableinterface;

import java.awt.*;

public class BeepPrintExample {
    /**
     * add worker thread using implements Runnable interface(외부 구현 객체)
     */
    public static void main(String[] args) {
        //작업 1
        Thread thread1 = new Thread(new BeepTask());
        thread1.start();
        //작업 2
        Thread thread2 = new Thread(new PrintTask());
        thread2.start();
    }
}
