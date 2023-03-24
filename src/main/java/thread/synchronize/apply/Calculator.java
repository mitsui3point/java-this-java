package thread.synchronize.apply;

public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    /**
     * synchronized method
     *
     * - 기존,
     * User1Thread 가 먼저 실행되었을 경우
     * User1Thread 가 setMemory 를 실행하는 중에 User2Thread 가 setMemory 접근이 가능
     * - 마찬가지로
     * User2Thread 가 먼저 실행되었을 경우
     * User2Thread 가 setMemory 를 실행하는 중에 User1Thread 가 setMemory 접근이 가능
     *
     * - synchronize apply 이후
     * User1Thread 가 먼저 실행되었을 경우
     * User1Thread 가 setMemory 를 모두 실행한 이후에 User2Thread 가 setMemory 접근이 가능
     * => Calculator 객체에 Lock 이 걸려서 synchronize 가 붙은 method 가 Lock 이 걸리게 되어 동시접근 불가
     * => But, synchronize 가 붙지 않은 method 는 Lock 여부랑 상관없이 동시접근이 가능
     * 마찬가지로
     * User2Thread 가 먼저 실행되었을 경우
     * User2Thread 가 setMemory 를 모두 실행한 이후에 User1Thread 가 setMemory 접근이 가능
     * => Calculator 객체에 Lock 이 걸려서 synchronize 가 붙은 method 가 Lock 이 걸리게 되어 동시접근 불가
     * => But, synchronize 가 붙지 않은 method 는 Lock 여부랑 상관없이 동시접근이 가능
     */
    /**
     * 메서드 synchronized 잠금
     */
    public synchronized void setMemoryMethod(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);//User1Thread, User2Thread set 먼저 일어나고 나서 getMemory 하게끔
        } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + ": " + getMemory());
    }

    /**
     * 블록 synchronized 잠금
     */
    public void setMemoryBlock(int memory) {
        //...
        synchronized (this) {
            this.memory = memory;
            try {
                Thread.sleep(2000);//User1Thread, User2Thread set 먼저 일어나고 나서 getMemory 하게끔
            } catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + ": " + getMemory());
        }
        //...
    }
}
