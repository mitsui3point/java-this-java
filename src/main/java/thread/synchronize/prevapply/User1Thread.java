package thread.synchronize.prevapply;

public class User1Thread extends Thread {

    private Calculator calculator;

    public User1Thread() {
        setName("User1Thread");
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(100);
    }
}
