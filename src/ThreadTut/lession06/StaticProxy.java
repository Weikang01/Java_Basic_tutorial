package ThreadTut.lession06;

// Static Proxy
// Real object and the proxy object implement same interface

public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();

        WeddingAgent agent = new WeddingAgent(you);
        agent.Do();
    }
}

interface Marry
{
    public void Do();
}

class You implements Marry
{
    @Override
    public void Do() {
        System.out.println("wedding...");
    }
}

class WeddingAgent implements Marry
{
    private Marry target;

    public WeddingAgent(Marry target) {
        this.target = target;
    }

    @Override
    public void Do() {
        before();
        target.Do();
        after();
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }
}

