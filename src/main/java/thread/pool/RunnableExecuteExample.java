package thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 스레드 풀
 * - 병렬 작업 처리가 많아지면 스레드의 개수가 폭증하여 CPU 가 바빠지고 메모리 사용량이 늘어난다.
 * - 이에 따라 애플리케이션의 성능 또한 급격히 저하된다.
 * - 이렇게 병렬 작업 증가로 인한 스레드의 폭증을 막으려면 ThreadPool 을 사용하는 것이 좋다,
 * - 스레드풀은 작업 처리에 사용되는 스레드를 제한된 갯수만큼 정해놓고 작업 큐(Queue)에 들어오는 작업들을 스레드가 하나씩 맡아 처리하는 방식이다.
 * - 작업 처리가 끝난 스레드는 다시 작업 큐에서 새로운 작업을 가져와 처리한다.
 * - 이렇게 하면 작업량이 증가해도 스레드의 개수가 늘어나지 않아 애플리케이션의 성능이 급격히 저하되지 않는다.
 * <p>
 * 스레드 풀 애플리케이션 작업처리 과정
 * 1. 스레드풀에 작업 처리 요청
 * -> 2. 스레드풀에 작업 전달 -> 2-1. 스레드풀 내 작업 큐에 작업 전달
 * -> 3. 스레드 풀 내 스레드가 작업 큐에 가장 먼저 들어왔던 작업을 처리
 * -> 4. 스레드 풀 내 스레드가 결과를 전달
 * <p>
 * 작업 생성과 처리 요청
 * - 하나의 작업은 {@link Runnable}, {@link Callable} 구현 클래스로 표현한다.
 * - Runnable 과 Callable 의 차이점은 작업 처리 후 리턴 값이 있느냐 없느냐이다.
 * <p>
 * 작업 생성
 * - 하나의 작업은 {@link Runnable}, {@link Callable} 구현 클래스로 표현한다.
 * - {@link Runnable}, {@link Callable}: 쓰레드가 실행할수 있는 보다는.. 작업 내용을 갖고 있는 객체
 * - 쓰레드가 처리해야 할 작업을 어떤 객체로 만들어야 하는가? - Runnable(return 이 없는 작업), Callable(return 이 있는 작업) 을 구현한 객체
 * - {@link Runnable}: {@link ExecutorService#execute(Runnable)}
 * : Runnable 을 작업 큐에 저장, 작업 처리 결과를 저장하지 않음
 * - {@link Callable}: {@link ExecutorService#submit(Callable)}
 * : Callable 을 작업 큐에 저장, 작업 처리 결과를 {@link Future} 에 저장
 * <p>
 * 처리 요청
 * - 생성된 작업들을 Thread Pool 의 Queue(FIFO) 에 넣는 행위
 * - Thread pool 의 Queue 의 작업들의 처리 담당 Thread 는 Thread pool 이 결정한다.
 */
public class RunnableExecuteExample {
    public static void main(String[] args) {
        //1000개의 메일 생성
        String[][] mails = generateMails();

        //ExecutorService 생성
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //이메일을 보내는 작업 생성 및 처리 요청
        sendMails(mails, executorService);

        //ExecuteService 종료
        executorService.shutdown();
    }

    private static void sendMails(String[][] mails, ExecutorService executorService) {
        for (int i = 0; i < 1000; i++) {
            final int idx = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();//현재 쓰레드 참조
                    String from = mails[idx][0];
                    String to = mails[idx][1];
                    String content = mails[idx][2];
                    System.out.println(
                            "[" + thread.getName() + "]" +
                            from + " ==> " +
                            to + ": " +
                            content);
                }
            });
        }
    }

    private static String[][] generateMails() {
        String[][] mails = new String[1000][3];
        for (int i = 0; i < mails.length; i++) {
            mails[i][0] = "admin@my.com";
            mails[i][1] = "member" + i + "@my.com";
            mails[i][2] = "신상품 입고";
        }
        return mails;
    }
}
