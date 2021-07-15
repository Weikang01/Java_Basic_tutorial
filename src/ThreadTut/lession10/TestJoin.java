package ThreadTut.lession10;

public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("num: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        // main thread
        for (int i = 0; i < 100; i++) {
            if (i == 20)
            {
                thread.join();
            }
            System.out.println("main: " + i);
        }
    }
}


