package ThreadTut.lession03;



public class ThreadByRunnable implements Runnable{

    @Override
    public void run() {
        // thread body
        for (int i = 0; i < 20; i++) {
            System.out.println("thread:"+i);
        }
    }

    public static void main(String[] args) {
        // main thread
        ThreadByRunnable runnable = new ThreadByRunnable();
        new Thread(runnable).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main: "+i);
        }
    }
}
