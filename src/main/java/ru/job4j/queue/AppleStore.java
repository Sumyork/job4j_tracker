package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Consumer> queue;

    private final int count;

    public AppleStore(Queue<Consumer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String lastHappyCustomer = null;
        for (int index = 0; index < count; index++) {
            lastHappyCustomer = queue.poll().name();
        }
        return lastHappyCustomer;
    }

    public String getFirstUpsetCustomer() {
        String firstUpsetCustomer = null;
        for (int index = 0; index <= count; index++) {
            firstUpsetCustomer = queue.poll().name();
        }
        return firstUpsetCustomer;
    }
}