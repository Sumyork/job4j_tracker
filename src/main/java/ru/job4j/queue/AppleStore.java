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
        for (int index = 0; index < queue.size(); index++) {
            if (index < count - 1) {
                queue.poll();
            }
        }
        return queue.peek().name();
    }

    public String getFirstUpsetCustomer() {
        String firstUpsetCustomer = null;
        int queueSize = queue.size();
        for (int index = 0; index <= queueSize; index++) {
            if (index == count) {
                firstUpsetCustomer = queue.peek().name();
                break;
            } else {
                queue.poll();
            }
        }
        return firstUpsetCustomer;
    }
}