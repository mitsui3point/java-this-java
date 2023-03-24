package thread.synchronize.method;

public class WorkObject {
    public synchronized void methodA() {
        String currThreadName = Thread.currentThread().getName();
        System.out.println("["+currThreadName+"] WorkObject.methodA execute!");
        notify();//다른 쓰레드를 실행 대기 상태로 만듦(다른 쓰레드 RUNNABLE)
        try {
            wait();//자신의 쓰레드를 일시 정지 상태로 만듦(자신 쓰레드 WAITING)
        } catch (InterruptedException e) {}
    }
    public synchronized void methodB() {
        String currThreadName = Thread.currentThread().getName();
        System.out.println("["+currThreadName+"] WorkObject.methodB execute!");
        notify();//다른 쓰레드를 실행 대기 상태로 만듦(다른 쓰레드 RUNNABLE)
        try {
            wait();//자신의 쓰레드를 일시 정지 상태로 만듦(자신 쓰레드 WAITING)
        } catch (InterruptedException e) {}
    }
}
