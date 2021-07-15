package annotation;

public class Reflection_class_loading {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.a);
    }
}

class A{
    static {
        System.out.println("static code block of class A initialization");
        a = 20;
    }

    static int a = 10;

    static {
        a = 22;
    }

    public A() {
        System.out.println("constructor of class A initialization");
    }
}
