package ThreadTut.lession13;

import java.util.ArrayList;
import java.util.List;

public class UnsafeDemo03 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                strings.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(strings.size());
    }
}
