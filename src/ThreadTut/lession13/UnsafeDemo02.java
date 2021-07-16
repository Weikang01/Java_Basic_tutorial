package ThreadTut.lession13;

public class UnsafeDemo02 {
    public static void main(String[] args) {
        Account account = new Account(100, "name1");
        Withdrawing withdraw1 = new Withdrawing(account, 10, account.name);
        Withdrawing withdraw2 = new Withdrawing(account, 100, "person 2");

        withdraw1.start();
        withdraw2.start();
    }
}


class Account
{
    int amount;
    String name;

    public Account(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }
}

class Withdrawing extends Thread
{
    Account account;
    int withdrawAmount;

    public Withdrawing(Account account, int withdrawAmount, String name)
    {
        super(name);
        this.account = account;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        if (account.amount < withdrawAmount)
        {
            System.out.println("insufficient balance");
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.amount -= withdrawAmount;
        System.out.println("account balance is " + account.amount);
    }
}

