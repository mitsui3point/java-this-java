package thread.multithread.workerthread.reuse.threadclass;

import java.awt.*;

public class BeepThread extends Thread {
    @Override
    public void run() {
        taskBeep();
    }

    private void taskBeep() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            delay(1000);
        }
    }
    private void delay(int millis) {
        try {Thread.sleep(millis);} catch (InterruptedException e) {}
    }
}
