package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// customize_annotation
public class customize_annotation_test {
//    @MyAnnotation2
    @MyAnnotation2(name = "name")
    public void test() {
    }

    @MyAnnotation3("name")
    public void test2()
    {

    }
}


@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // parameter of annotation : DataType DataName();
    String name() default "";
    int age() default 0;
    int id() default -1; // not exists if id == -1

    String[] schools() default {"school name 1"};
}

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation3
{
    String value();
}