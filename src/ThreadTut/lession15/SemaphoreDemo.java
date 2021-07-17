package ThreadTut.lession15;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Stage stage = new Stage();
        new Actor(stage).start();
        new Audience(stage).start();
    }
}

class Actor extends Thread
{
    Stage stage;
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0)
            {
                this.stage.Perform("opera 1");
            }
            else {
                this.stage.Perform("opera 2");
            }
        }
    }

    public Actor(Stage stage) {
        this.stage = stage;
    }
}

class Audience extends Thread
{
    Stage stage;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            stage.Watch();
        }
    }

    public Audience(Stage stage) {
        this.stage = stage;
    }
}

class Stage
{
    String program;
    boolean flag = true;  // true if actors perform, false if audience watch

    // perform
    public synchronized void Perform(String program)
    {
        if (!flag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Actor performs " + program);
        // notify audience to watch
        this.notifyAll();
        this.program = program;
        this.flag = !this.flag;
    }

    public synchronized void Watch()
    {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("audience watches " + program);
        // notify actor to perform
        this.notifyAll();
        this.flag = !this.flag;
    }

}

