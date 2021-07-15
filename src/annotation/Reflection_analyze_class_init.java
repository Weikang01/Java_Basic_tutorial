package annotation;

public class Reflection_analyze_class_init {

    static {
        System.out.println("main class is loading...");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. active reference
        // Child child = new Child();  // main->parent->child

        // 2. reflective reference
        // Class<?> aClass = Class.forName("annotation.Child");  // main->parent->child

        // 3. ways that will not cause reference of class
        // System.out.println(Child.b);  // main->parent

        // 4. array will only allocate the memory
        // Child[] children = new Child[5];  // main

        // 5.
        System.out.println(Child.M);  // main

    }
}

class Parent
{
    static int b = 2;
    String name = "";

    public Parent() {
    }

    public Parent(String name) {
        this.name = name;
    }

    public static int getB() {
        return b;
    }

    public static void setB(int b) {
        Parent.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static {
        System.out.println("parent class is loading...");
    }
}

class Child extends Parent
{
    static {
        System.out.println("child class is loading...");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}



