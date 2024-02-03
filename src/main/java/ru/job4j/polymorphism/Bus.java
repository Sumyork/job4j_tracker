package ru.job4j.polymorphism;

public class Bus implements Transport {
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
        int price = 51;
        return price * fuel;
    }
}
