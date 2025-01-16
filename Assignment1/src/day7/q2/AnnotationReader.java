package day7.q2;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationReader {

    public static void readAnnotation(AnnotatedElement element) {
        Annotation[] annotations = element.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                Author author = (Author) annotation;
                System.out.println("Author: " + author.name());
            } else if (annotation instanceof Version) {
                Version version = (Version) annotation;
                System.out.println("Version: " + version.number());
            }
        }
    }

    public static void main(String[] args) throws Exception {

        readAnnotation(AnnotatedClass.class);

        Method method1 = AnnotatedClass.class.getMethod("annotatedMethod1");
        readAnnotation(method1);

        Method method2 = AnnotatedClass.class.getMethod("annotatedMethod2");
        readAnnotation(method2);

        Constructor<?> constructor = AnnotatedClass.class.getConstructor();
        readAnnotation(constructor);
    }
}