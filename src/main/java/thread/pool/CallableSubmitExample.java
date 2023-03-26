package thread.pool;

import java.util.concurrent.*;

public class CallableSubmitExample {
    public static void main(String[] args) {
        //ExecutorService 생성
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //계산 작업 생성 및 처리 요청
        submitCallableSum(executorService);

        //ExecuteService 종료
        executorService.shutdown();
    }

    private static void submitCallableSum(ExecutorService executorService) {
        for (int i = 1; i <= 100; i++) {
            final int idx = i;
            Future<Integer> future = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int j = 1; j <= idx; j++) {
                        sum += j;
                    }
                    Thread thread = Thread.currentThread();
                    System.out.println("[" + thread.getName() + "] 1~" + idx + " 합 계산");
                    return sum;
                }
            });
            try {
                Integer result = future.get();//작업 결과가 얻어질때 까지 BLOCKING 상태가 됨
                System.out.println("\t 리턴값 = " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
