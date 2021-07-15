package ThreadTut.lession12;

public class ThreadDaemon {
    public static void main(String[] args) {
        Daemon daemon = new Daemon();
        Target target = new Target();

        Thread thread = new Thread(daemon);
        thread.setDaemon(true); // false by default
        // JVM will not wait until the daemon thread finished
        thread.start();

        new Thread(target).start();
    }
}

class Daemon implements Runnable
{
    @Override
    public void run() {
        while (true)
        {
            System.out.println("daemon is running");
        }
    }
}

class Target implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        System.out.println("Terminated");
    }
}
