package ThreadTut.lession04;

// Simulate the tortoise and the hare
public class Race implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            if (Thread.currentThread().getName().equals("hare") && i % 100 == 0)
            {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (gameOver(i))
                break;
            System.out.println(Thread.currentThread().getName() + " ran " + i + " steps.");
        }
    }

    private boolean gameOver(int steps)
    {
        if (winner != null)
            return true;
        if (steps >= 1000)
        {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "hare").start();
        new Thread(race, "tortoise").start();
    }
}
