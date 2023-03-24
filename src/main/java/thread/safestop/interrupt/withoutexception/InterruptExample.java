package thread.safestop.interrupt.withoutexception;

/**
 * interrupt()
 *  - Thread 가 일시정지(WAITING) 상태일 때
 *      (ex. -> sleep(), join(), wait() 로 Thread 를 일시정지상태를 만들었을 때),
 *    예외발생({@link InterruptedException} 시키는 역할을 한다.
 */
public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new PrintInterruptedThread();
        thread.start();

        thread.interrupt();
    }
}
