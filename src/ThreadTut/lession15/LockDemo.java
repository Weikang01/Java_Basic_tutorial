package ThreadTut.lession15;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        Lock1 lock1 = new Lock1();

        new Thread(lock1).start();
        new Thread(lock1).start();
        new Thread(lock1).start();

    }
}

class Lock1 implements Runnable
{
    int num = 10;

    // define a lock
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (num > 0)
        {
            try {
                lock.lock();  // lock
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num--);
            }finally {
                lock.unlock();
            }
        }
    }
}





