package thread.daemon;

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread thread = new AutoSaveThread();
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("메인 스레드 종료");
    }
}
