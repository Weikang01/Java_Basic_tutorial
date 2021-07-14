package ThreadTut.lession08;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSleep2 {
    public static void CountDown() throws InterruptedException {
        int num = 10;

        while (num>=0)
        {
            Thread.sleep(1000);
            System.out.println(num--);
        }
    }

    public static void main(String[] args) {
        Date startTime;

        while (true)
        {
            try {
                Thread.sleep(1000);
                startTime = new Date(System.currentTimeMillis());
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
