package ThreadTut.lession07;

//
public class ThreadStop implements Runnable {

    // 1. set a flag
    boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag)
        {
            System.out.println("thread " + i++);
        }
    }

    // 2. set a public method to stop the thread
    public void Stop()
    {
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStop thread = new ThreadStop();
        new Thread(thread).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main " + i);
            if (i == 900) {
                thread.Stop();
                System.out.println("Thread stopped.");
            }
        }
    }
}
