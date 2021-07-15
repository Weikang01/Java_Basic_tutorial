package annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection_class_struct {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> parent = Class.forName("annotation.Parent");


        // get class name
        System.out.println(parent.getName());  // annotation.Parent  (package_name.class_name)
        System.out.println(parent.getSimpleName());  // Parent

        // get class properties
        Field[] fields = parent.getFields();  // get public props

        fields = parent.getDeclaredFields();  // get all props
        for (Field field:fields)
        {
            System.out.println(field);  // static int annotation.Parent.b
        }

        // get specific field value
        Field value_b = parent.getDeclaredField("b");
        System.out.println(value_b);

        // get class methods
        Method[] methods = parent.getMethods();  // get public methods declared in this class and its parents
        for (Method method :
                methods) {
            System.out.println(method);
        }
        methods = parent.getDeclaredMethods();  // get all methods declared in this class
        for (Method method :
                methods) {
            System.out.println(method);
        }

        Method getName = parent.getMethod("getName");
        Method setName = parent.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        // get specific constructor
        System.out.println("----------------------------------------");
        Constructor<?>[] constructors = parent.getConstructors();
        constructors = parent.getDeclaredConstructors();

        Constructor<?> constructor = parent.getConstructor(String.class);
    }
}
