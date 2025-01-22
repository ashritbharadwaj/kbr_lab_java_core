package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Map<Student, Integer> map=new HashMap<>();
        map.put(new Student(109, "raj", 95), 95);
        map.put(new Student(61, "keta", 78), 78);
        map.put(new Student(11, "gunika", 98), 98);
        map.put(new Student(19, "keshav", 97), 97);

        System.out.println("Print all records as per id of the student:");
        map.entrySet().stream().sorted((o1, o2) ->
                o1.getKey().compareTo(o2.getKey())).forEach(System.out::println);

        System.out.println(" Print all records sorted as per name of the student:");
        map.entrySet().stream().sorted((o1, o2) ->
                o1.getKey().getName().compareTo(o2.getKey().getName())).forEach(System.out::println);
    }
}