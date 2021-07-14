package ThreadTut.lession01;

public class TestThread extends Thread {
    @Override
    public void run() {
        // thread body
        for (int i = 0; i < 20; i++) {
            System.out.println("thread:"+i);
        }
    }

    public static void main(String[] args) {
        // main thread
        TestThread thread = new TestThread();
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main: "+i);
        }
    }
}
