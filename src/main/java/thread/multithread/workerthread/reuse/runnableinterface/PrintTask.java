package thread.multithread.workerthread.reuse.runnableinterface;

import java.awt.*;

public class PrintTask implements Runnable{
    @Override
    public void run() {
        taskPrint();
    }


    private void taskPrint() {
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            delay(1000);
        }
    }

    private void delay(int millis) {
        try {Thread.sleep(millis);} catch (InterruptedException e) {}
    }
}
