package thread.mainthread;

public class MainThreadExample {
    public static void main(String[] args) {

        System.out.println("시작");

//        Thread currThread = null;//Exception in thread "main"
        Thread currThread = Thread.currentThread();
        System.out.println("currThread.getName() = " + currThread.getName());


        System.out.println("종료");
    }
}
