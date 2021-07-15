package annotation;

public class Reflection_class_loader {
    public static void main(String[] args) throws ClassNotFoundException {
        // get system class loader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);  // jdk.internal.loader.ClassLoaders$AppClassLoader

        // get extended class loader (parent of system class loader)
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);  // jdk.internal.loader.ClassLoaders$PlatformClassLoader

        // get root loader (C/C++) ( parent of extended class loader)
        ClassLoader parentParent = parent.getParent();
        System.out.println(parentParent);  // null

        // test class loader of current class
        ClassLoader classLoader = Class.forName("annotation.Parent").getClassLoader();
        System.out.println(classLoader);  // jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d

        // test JDK internal class (root loader)
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);  // null

        //
        System.out.println(System.getProperty("java.class.path"));
        /*
        ...\Java_Basic_tutorial\out\production\Java_Basic_tutorial;
        ...\Java_Basic_tutorial\src\lib\commons-io-2.10.0.jar
         */

    }
}
