package ThreadTut.lession04;

public class DemoThread implements Runnable {
    private int num = 10;

    @Override
    public void run() {
        while (num > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + num--);
        }
    }

    public static void main(String[] args) {
        DemoThread thread = new DemoThread();
        new Thread(thread, "Tom").start();
        new Thread(thread, "Jack").start();
        new Thread(thread, "Henry").start();
    }
}
