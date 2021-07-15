package annotation;

public class Reflection_class_test {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("This person is a " + person.name);

        // Get class from object
        Class c1 = person.getClass();

        // Get class from forName
        Class c2 = Class.forName("annotation.Student");

        // Get class from class name
        Class c3 = Student.class;

        // Get class from type property (only work for basic data types
        Class c4 = Integer.TYPE;

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        // Get super class
        Class superclass = c1.getSuperclass();


    }
}

class Person
{
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person
{
    public Student() {
        this.name = "student";
    }
}

class Teacher extends Person
{
    public Teacher() {
        this.name = "teacher";
    }
}
