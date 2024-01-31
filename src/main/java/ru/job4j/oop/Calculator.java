package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int q) {
        return q / x;
    }

    public int sumAllOperation(int p) {
        return sum(p) + minus(p) + multiply(p) + divide(p);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sum = sum(5);
        int minus = minus(2);
        int multiply = calculator.multiply(3);
        int divide = calculator.divide(35);
        int sumAll = calculator.sumAllOperation(3);
        System.out.println(sum);
        System.out.println(minus);
        System.out.println(multiply);
        System.out.println(divide);
        System.out.println(sumAll);
    }
}
