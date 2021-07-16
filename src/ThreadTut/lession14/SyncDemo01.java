package ThreadTut.lession14;

public class SyncDemo01 {
    public static void main(String[] args) {
        Func func = new Func();
        new Thread(func).start();
        new Thread(func).start();
        new Thread(func).start();
    }
}

class Func implements Runnable
{
    private int num = 10;

    private void Calculate()
    {
        num = num <=0 ? 0:num-1;
    }

    @Override
    // Synchronized method, lock "this"
    public synchronized void run() {
        while (num > 0)
        {
            System.out.println("num: " + num);
            Calculate();
        }
    }
}
