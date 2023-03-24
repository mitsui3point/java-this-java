package thread.synchronize.apply;

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
//        calculator.setMemoryMethod(100);
        calculator.setMemoryBlock(100);
    }
}
