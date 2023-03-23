package thread.multithread.mainonly;

import java.awt.*;

public class BeepPrintExample {
    /**
     * main thread only
     */
    public static void main(String[] args) {
        //작업 1
        taskBeep();
        //작업 2
        taskPrint();
    }

    private static void taskPrint() {
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            delay(500);
        }
    }

    private static void taskBeep() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            delay(500);
        }
    }

    private static void delay(int millis) {
        try {Thread.sleep(millis);} catch (InterruptedException e) {}
    }
}
