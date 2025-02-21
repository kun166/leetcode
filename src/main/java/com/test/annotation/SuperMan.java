package com.test.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

@Person(role = "artist")
@Person(role = "coder")
@Person(role = "PM")
public class SuperMan {

    public static void main(String[] args) {
        methodSecond();
    }

    /**
     * 这个会输出"Persons"
     */
    public static void methodFirst() {
        for (Annotation annotation : SuperMan.class.getAnnotations()) {
            System.out.println(annotation.annotationType().getSimpleName());
        }
    }

    /**
     * 这个会输出
     * artist
     * coder
     * PM
     */
    public static void methodSecond() {
        Persons persons = SuperMan.class.getAnnotation(Persons.class);
        for (Person person : persons.value()) {
            System.out.println(person.role());
        }
    }

    @SafeVarargs // Not actually safe!
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }
}
