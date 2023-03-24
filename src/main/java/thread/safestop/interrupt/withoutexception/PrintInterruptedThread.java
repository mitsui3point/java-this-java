package thread.safestop.interrupt.withoutexception;

public class PrintInterruptedThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("실행중...");
            if (this.isInterrupted()) {//Thread.interrupted(); 정적 메소드로도 가능
                System.out.println("isInterrupted() = " + isInterrupted());
                System.out.println("isInterrupted() 2 = " + isInterrupted());//변화 없음
                System.out.println("Thread.interrupted() = " + Thread.interrupted());//최초 호출시에는 interrupted 여부 반환(현재 true) -> 내부 상태값은 default(false) 값으로 변경
                System.out.println("Thread.interrupted() 2 = " + Thread.interrupted());//그후 출력 false
                break;
            }
        }
        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }
}
