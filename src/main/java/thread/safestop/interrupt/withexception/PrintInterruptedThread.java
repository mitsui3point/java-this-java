package thread.safestop.interrupt.withexception;

public class PrintInterruptedThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("실행중...");
                Thread.sleep(1);//or .join(), .wait() 등 일시정지(WAITING)를 할 수 있는 Code 가 있다면 실행도중 InterruptedException 예외가 발생하면서 catch 를 할수 있으며, 실행대기(RUNNABLE) 상태로 전환할 수 있다.
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }
}
