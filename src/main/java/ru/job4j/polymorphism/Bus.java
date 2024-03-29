package ru.job4j.polymorphism;

public class Bus implements Transport {
    private static final int PRICE = 51;

    @Override
    public void drive() {
        System.out.println("Автобус начинает движение.");
    }

    @Override
    public void capacity(int passenger) {
        System.out.println("Автобус вмещает 50 человек.");
    }

    @Override
    public int refill(int fuel) {
        return PRICE * fuel;
    }
}
