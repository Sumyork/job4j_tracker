package ru.job4j.wrapper;

import java.util.ArrayList;
import java.util.List;

public class Box {
    public static void num(Integer x) {
        System.out.println("Значение типа Integer: " + x);
    }

    public static void num(int x) {
        System.out.println("Значение типа int: " + x);
    }

    public static void main(String[] args) {
        int a = 1;
        Integer b;
        b = a;
        System.out.println("Integer b = " + b);
        num(a);
        Integer m = 3;
        int n = m;
        System.out.println("int n = " + n);
        Integer k = 5;
        Integer l = 6;
        System.out.println(k * l);
        Integer g = 250;
        Integer h = 250;
        System.out.println(g == h);
        Integer v = 127;
        Integer w = 127;
        System.out.println(v == w);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }
}
