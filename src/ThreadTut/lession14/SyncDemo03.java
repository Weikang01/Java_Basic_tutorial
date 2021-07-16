package ThreadTut.lession14;

import java.util.ArrayList;
import java.util.List;

public class SyncDemo03 {
    public static void main(String[] args) throws InterruptedException {
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (strings){
                    strings.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(strings.size());
    }

}
