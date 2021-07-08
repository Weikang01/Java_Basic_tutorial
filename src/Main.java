import java.util.Random;
import java.util.Scanner;

public class Main
{
    static void PrintPrime()
    {
        long start = System.currentTimeMillis();
        int count = 0;

        Label:for (int i = 2; i < 100000; i++)
        {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0)
                    continue Label;
            }
            count ++;
        }
        System.out.println("\nCount: " + count + "\nTime: " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args)
    {
        PrintPrime();
    }
}

