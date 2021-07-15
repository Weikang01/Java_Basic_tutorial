package annotation;

import java.lang.annotation.*;

public class meta_annotation_test {
    @MyAnnotation
    public void Test() {

    }
}

// Define an Annotation
// Target implies where we can put this annotation
@Target(value = {ElementType.METHOD, ElementType.TYPE})
// Retention implies where this annotation is valid
// RUNTIME>CLASS>SOURCE
@Retention(value = RetentionPolicy.RUNTIME)
// Documented implies whether this annotation will appear in the JAVAdoc
@Documented
// Inherited implies children can inherit this annotation from parent
@Inherited
@interface MyAnnotation {

}