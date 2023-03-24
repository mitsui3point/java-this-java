package thread.synchronize.prevapply;

public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);//User1Thread, User2Thread set 먼저 일어나고 나서 getMemory 하게끔
        } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + ": " + getMemory());
    }
}
