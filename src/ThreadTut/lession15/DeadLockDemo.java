package ThreadTut.lession15;

public class DeadLockDemo {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1(0);
        Thread1 thread2 = new Thread1(1);

        thread1.start();
        thread2.start();

    }
}


class Class1
{

}

class Class2
{

}

class Thread1 extends Thread
{
    static final Class1 class1 = new Class1();
    static final Class2 class2 = new Class2();

    int opt;

    Thread1(int opt)
    {
        this.opt = opt;
    }

    @Override
    public void run() {
        try {
            Func1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void Func1() throws InterruptedException {
        if (opt == 0)
        {
            synchronized (class1)  // gen a lock for class1
            {
                System.out.println("class1");
                Thread.sleep(1000);
//                synchronized (class2)
//                {
//                    System.out.println("class2");
//                }
            }
            synchronized (class2)
            {
                System.out.println("class2");
            }
        } else {
            synchronized (class2)  // gen a lock for class1
            {
                System.out.println("class2");
                Thread.sleep(1500);
//                synchronized (class1)
//                {
//                    System.out.println("class1");
//                }
            }
            synchronized (class1)
            {
                System.out.println("class1");
            }
        }
    }
}


