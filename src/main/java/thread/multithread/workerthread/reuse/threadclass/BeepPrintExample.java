package thread.multithread.workerthread.reuse.threadclass;

import java.awt.*;

public class BeepPrintExample {
    /**
     * add worker thread using extends child Thread Object(외부 자식 객체)
     */
    public static void main(String[] args) {
        //작업 1
        BeepThread beepThread = new BeepThread();
        beepThread.start();
        //작업 2
        PrintThread printThread = new PrintThread();
        printThread.start();
    }
}
