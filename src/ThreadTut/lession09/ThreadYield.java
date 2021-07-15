package ThreadTut.lession09;

public class ThreadYield {
    public static void main(String[] args) {
        YieldBody body = new YieldBody();
        new Thread(body, "first").start();
        new Thread(body, "second").start();
    }
}

class YieldBody implements Runnable
{

    @Override
    public void run() {
        System.out.println("Execute " + Thread.currentThread().getName());
        Thread.yield();
        System.out.println("Execute " + Thread.currentThread().getName() + " finished");
    }
}
