package thread.join;

public class JoinExample {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();//main thread -> sum thread 에 join; main thread 가 sum thread 종료까지 thread 를 대기시킴
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("1-100 합: "+ sumThread.getSum());
    }
}
