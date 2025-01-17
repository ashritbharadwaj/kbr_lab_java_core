package day7.q2;

import java.lang.annotation.*;

@Target({ ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Version {
    double number();
}
