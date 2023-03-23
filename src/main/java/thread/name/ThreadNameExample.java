package thread.name;

public class ThreadNameExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + "실행");

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    System.out.println(getName() + "실행");
                }
            };
            thread.start();
        }

        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + "실행");
            }
        };
        chatThread.setName("chat-thread");//thread start 이전에 name 을 set
        chatThread.start();
    }
}
