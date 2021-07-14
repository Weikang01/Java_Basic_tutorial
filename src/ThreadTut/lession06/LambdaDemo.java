package ThreadTut.lession06;

public class LambdaDemo {

    // 3. static inner proxy
    static class Impl2 implements Demo
    {

        @Override
        public void Lambda() {
            System.out.println("Impl of demo2");
        }
    }

    public static void main(String[] args) {
        Demo demo1 = new Impl();
        demo1.Lambda();

        Demo demo2 = new Impl2();
        demo2.Lambda();

        // 4. local inner class

        class Impl3 implements Demo
        {

            @Override
            public void Lambda() {
                System.out.println("Impl of demo3");
            }
        }

        Demo demo3 = new Impl3();
        demo3.Lambda();

        // 5. anonymous inner class
        Demo demo4 = new Demo() {
            @Override
            public void Lambda() {
                System.out.println("Impl of demo4");
            }
        };
        demo4.Lambda();

        Demo demo5 = ()->{
            System.out.println("Impl of demo5");
        };
        demo5.Lambda();

    }
}

// 1. Define a functional interface
interface Demo
{
    void Lambda();
}

// 2. Impl class

class Impl implements Demo
{

    @Override
    public void Lambda() {
        System.out.println("Impl of demo");
    }
}
