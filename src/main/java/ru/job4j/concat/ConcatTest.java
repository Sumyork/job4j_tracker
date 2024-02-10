package ru.job4j.concat;

public class ConcatTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String string = "Job4j";
        for (int index = 0; index < 9999; index++) {
            string = string + index;
        }
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));
    }
}
