package ru.job4j.cast;

public class Transport {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[]{bus, airplane, train};
        for (Vehicle object : vehicles) {
            object.move();
        }
    }
}
