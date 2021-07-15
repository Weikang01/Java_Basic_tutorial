package ThreadTut.lession11;

// Observe and test states of thread
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("num: " + i);
            }
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (thread.getState() != Thread.State.TERMINATED)
        {
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }
        System.out.println(state);

    }
}
