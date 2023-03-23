package thread.multithread.workerthread.anonymous.threadclass;

import java.awt.*;

public class BeepPrintExample {
    /**
     * add worker thread using extends anonymous child Thread Object(익명 자식 객체)
     */
    public static void main(String[] args) {
        //작업 1
        Thread thread = new Thread() {
            @Override
            public void run() {
                taskBeep();
            }
        };
        thread.start();//thread1 thread task
        //작업 2
        taskPrint();//main thread task
    }

    private static void taskBeep() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            delay(1000);
        }
    }

    private static void taskPrint() {
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            delay(1000);
        }
    }

    private static void delay(int millis) {
        try {Thread.sleep(millis);} catch (InterruptedException e) {}
    }
}
