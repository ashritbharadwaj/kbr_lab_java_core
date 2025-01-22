package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);
        System.out.println("------printing map------");

        System.out.println("1. print map using stream");
        map.entrySet().stream().forEach(System.out::println);
        System.out.println("2. print only that recrods that contain key contains raj");
        map.entrySet().stream().filter(e->e.getKey().contains("raj")).forEach(System.out::println);
        System.out.println("3. print map sorted by key");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("4. print map sorted by values");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        System.out.println("5. print map reverse sorted by the key");
        map.entrySet().stream().sorted((o1, o2)->
                o2.getKey().compareTo(o1.getKey())).forEach(System.out::println);

    }
}