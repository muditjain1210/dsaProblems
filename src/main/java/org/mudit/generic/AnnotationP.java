package org.mudit.generic;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String str();

    int val();
}

public class AnnotationP {
    private final String str;

    public AnnotationP(String args) {
        this.str = args;
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        Class<Annotation> cls = Annotation.class;
        Method m = cls.getMethod("dummyMethod", String.class);
        Annotation an = m.getAnnotation(MyAnnotation.class);
        System.out.println(an.annotationType().getName());
        System.out.println(an);
        // System.out.println(an.str() + " " + an.val());
    }

    @MyAnnotation(str = "mudit", val = 99)
    public void dummyMethod(String param) {
        System.out.println(param);
    }
}
