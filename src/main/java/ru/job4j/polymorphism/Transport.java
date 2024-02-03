package ru.job4j.polymorphism;

public interface Transport {
    void drive();

    void capacity(int passenger);

    int refill(int fuel);
}
