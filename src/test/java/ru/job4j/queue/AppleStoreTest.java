package ru.job4j.queue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

class AppleStoreTest {
    @Test
    void whenGetLast() {
        Queue<Consumer> customers = new LinkedList<>();
        customers.add(new Consumer("Petr", 1000));
        customers.add(new Consumer("Stas", 1500));
        customers.add(new Consumer("Andrey", 850));
        customers.add(new Consumer("Alexei", 900));
        customers.add(new Consumer("Iryna", 1250));
        customers.add(new Consumer("Elena", 750));
        customers.add(new Consumer("Rail", 950));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getLastHappyCustomer();
        assertThat(customer).isEqualTo("Alexei");
    }

    @Test
    void whenGetFirst() {
        Queue<Consumer> customers = new LinkedList<>();
        customers.add(new Consumer("Petr", 1000));
        customers.add(new Consumer("Stas", 1500));
        customers.add(new Consumer("Andrey", 850));
        customers.add(new Consumer("Alexei", 900));
        customers.add(new Consumer("Iryna", 1250));
        customers.add(new Consumer("Elena", 750));
        customers.add(new Consumer("Rail", 950));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getFirstUpsetCustomer();
        assertThat(customer).isEqualTo("Iryna");
    }
}