import java.util.Random;
import java.util.Scanner;

public class Main
{
    static int lowerBound = 0;
    static int upperBound = 15;

    public static void main(String[] args)
    {
        int val = getRandomNumber();
        System.out.println("Guess the random number. The number is around " + lowerBound + " to " + (upperBound + 1) + ": ");
        int in;
        while (true)
        {
            in = getInput();
            if (in == val)
                break;
            System.out.println("The number is not correct!");
        }
        System.out.println("You found the correct number!");
    }


    private static int getRandomNumber() {
        Random rand = new Random();
        int res = rand.nextInt(upperBound - lowerBound);
        res += lowerBound;
        return res;
    }

    private static int getInput() {
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.next());
    }
}

