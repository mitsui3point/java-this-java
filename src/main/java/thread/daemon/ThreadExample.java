package thread.daemon;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new AutoSaveThread();

        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("메인 스레드 종료");
    }
}
