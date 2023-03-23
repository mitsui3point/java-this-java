package thread.multithread.workerthread.anonymous.runnableinterface;

import java.awt.*;

public class BeepPrintExample {
    /**
     * add worker thread using anonymous implements Runnable interface(익명 구현 객체)
     */
    public static void main(String[] args) {
        //작업 1
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                taskBeep();
            }
        });
        thread.start();//thread1 thread task
        //작업 2 - main thread
        taskPrint();//main thread task
    }

    private static void taskPrint() {
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            delay(1000);
        }
    }

    private static void taskBeep() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            delay(1000);
        }
    }

    private static void delay(int millis) {
        try {Thread.sleep(millis);} catch (InterruptedException e) {}
    }
}
