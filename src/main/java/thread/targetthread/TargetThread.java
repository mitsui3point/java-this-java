package thread.targetthread;

public class TargetThread extends Thread {
    @Override
    public void run() {
        for (long i = 0; i < 1_000_000_000; i++) {}//RUNNABLE 상태 유지

        try {Thread.sleep(1500);} catch (InterruptedException e) {}//TIMED_WAITING 상태 변경

        for (long i = 0; i < 1_000_000_000; i++) {}//RUNNABLE 상태 유지
    }
}
