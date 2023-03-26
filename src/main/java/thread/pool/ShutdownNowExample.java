package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutdownNowExample {
    public static void main(String[] args) {
        //create thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //create task & execute
        for (int i = 0; i < 20; i++) {
            executeTask(executorService);
        }
        //thread pool shutdown, returns not submitted queue list
        System.out.println("not submitted queue list = " + executorService.shutdownNow());

        System.out.println("isShutdown = " + executorService.isShutdown());
        System.out.println("isTerminated = " + executorService.isTerminated());
    }

    private static void executeTask(ExecutorService executorService) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (long l = 0; l < 2_500_000_000L; l++) ;
            }
        });
    }

}
