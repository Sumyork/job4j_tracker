package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        BiConsumer<Integer, String> biConsumer = map::put;
        int index = 1;
        for (String string : list) {
            biConsumer.accept(index++, string);
        }
        BiPredicate<Integer, String> biPredicate = (number, string) -> number % 2 == 0 || string.length() == 4;
        for (Integer key : map.keySet()) {
            if (biPredicate.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }
        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();
        Consumer<String> consumer = System.out::println;
        Function<String, String> function = String::toUpperCase;
        for (String string : strings) {
            consumer.accept(function.apply(string));
        }
    }
}
