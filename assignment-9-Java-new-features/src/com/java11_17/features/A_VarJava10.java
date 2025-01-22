package com.java11_17.features;

import java.util.Arrays;
import java.util.List;

public class A_VarJava10 {
    public static void main(String[] args) {
        var a=10;
        System.out.println(a);

        var list=List.of(1,2,3,4,5);
        System.out.println(list);

        var list2=new double[]{1,2,3.3,4,5.8};
        System.out.println(Arrays.toString(list2));
    }
}
