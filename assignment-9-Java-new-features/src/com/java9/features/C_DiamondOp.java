package com.java9.features;
import com.pojo.Book;

import java.sql.Array;
import  java.util.*;
class A{
        void foo(){
            System.out.println("foo of class A");
        }
}
class B extends  A{
    void foo(){
        System.out.println("foo of class B override");
    }
}
public class C_DiamondOp {
    public static void main(String[] args) {
        B b=new B();
        b.foo();
        A a=new B();
        a.foo();
    }
}
