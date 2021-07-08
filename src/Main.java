import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

class Record
{
    int balance;
    int amount;
    String comment;

    public Record(int balance, int amount, String comment)
    {
        this.balance = balance;
        this.amount = amount;
        this.comment = comment;
    }
}

public class Main
{
    static int balance = 1000;
    static boolean shouldExit = false;
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Record> records = new ArrayList<>();

    private static int ReadNumber() {
        String txt;
        int value;
        while (true)
        {
            txt = scan.next();
            try
            {
                value = parseInt(txt);
            }catch (NumberFormatException e)
            {
                System.out.println("Invalid input, please input an integer.");
                continue;
            }
            return value;
        }
    }

    static void Run()
    {
        while (!shouldExit)
        {
            MainMenu();
        }
    }

    private static void MainMenu() {
        System.out.println("---Family Income Balance---");
        System.out.println("1. Balance Record");
        System.out.println("2. Upload Income");
        System.out.println("3. Upload expenditure");
        System.out.println("4. Exit");
        System.out.print("\nPlease choose <1-4>:");

        int op = scan.nextInt();
        switch (op) {
            case 1 -> BalanceRecord();
            case 2 -> UploadIncome();
            case 3 -> UploadExpend();
            case 4 -> shouldExit = true;
            default -> System.out.println("Invalid input!");
        }
    }

    private static void UploadExpend() {
        System.out.println("Input the amount: ");
        int amount = ReadNumber();
        System.out.println("Input comment: ");
        records.add(new Record(balance - amount, -amount, scan.next()));
        balance -= amount;
    }

    private static void UploadIncome() {
        System.out.println("Input the amount: ");
        int amount = ReadNumber();
        System.out.println("Input comment: ");
        records.add(new Record(balance + amount, amount, scan.next()));
        balance += amount;
    }

    private static void BalanceRecord() {
        System.out.println("---Current Balance Record---");
        System.out.println("Income/Expend\tAccount Balance\tAmount\tComment");
        if (!records.isEmpty())
        for (Record record :
                records) {
            System.out.println((record.amount > 0 ? "Income" : "Expend") + "\t"+ record.balance + "\t"+ record.amount + "\t"+ record.comment);
        }
    }

    public static void main(String[] args)
    {
        Run();
    }
}

