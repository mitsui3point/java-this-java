package thread.join;

public class SumThread extends Thread {

    private long sum;

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            sum += i;
            for (long x = 0; x < 25_000_000L; x++);//지연, main thread, sum thread 의 경합상황을 위해 추가
        }
    }
}
