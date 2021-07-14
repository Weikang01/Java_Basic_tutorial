package ThreadTut.lession06;

public class LambdaDemo2 {

    static class Impl2 implements IInter
    {
        @Override
        public void Execute(int a) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        IInter inter1 = new Impl1();
        inter1.Execute(1);
        IInter inter2 = new Impl2();
        inter2.Execute(2);
    }


}

interface IInter
{
    public void Execute(int a);
}

class Impl1 implements IInter
{
    @Override
    public void Execute(int a) {
        System.out.println(a);
    }
}
