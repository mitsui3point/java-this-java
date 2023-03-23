package thread.multithread.workerthread.reuse.threadclass;

public class PrintThread extends Thread {
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
