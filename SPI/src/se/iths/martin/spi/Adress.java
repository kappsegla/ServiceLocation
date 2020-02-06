package se.iths.martin.spi;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // Make this annotation accessible at runtime via reflection.
@Target({ElementType.TYPE})       // This annotation can only be applied to class methods.
//@Repeatable(Adresses.class)
public @interface Adress {
    String value() default "/default";
}

//@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.TYPE})
//@interface Adresses{
//    Adress[] value();
//}