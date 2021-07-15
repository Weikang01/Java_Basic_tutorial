package annotation;

import java.lang.annotation.ElementType;

public class Reflection_class_example {
    public static void main(String[] args) {
        Class c1 = Object.class;      // class
        Class c2 = Comparable.class;  // interface
        Class c3 = String[].class;    // 1d array
        Class c4 = int[][].class;     // 2d array
        Class c5 = Override.class;    // annotation
        Class c6 = ElementType.class; // enum
        Class c7 = Integer.class;     // basic data type
        Class c8 = void.class;        // void
        Class c9 = Class.class;       // Class

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        int[] a = new int[10];
        int[] b = new int[2];

        System.out.println(a.getClass().hashCode());  // 793589513
        System.out.println(b.getClass().hashCode());  // 793589513
    }
}
